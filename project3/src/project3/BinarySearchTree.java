/* ====================================================================================================
# Author: Duc Ngo
# Course: CS3130-001 - Design and Analysis of Algorithms
# File Name: BinarySearchTree.java
# Purpose:
	Write a program implementing some operations on binary search trees
==================================================================================================== */
package project3;
import java.util.*;

public class BinarySearchTree 
{
	Node root;

	public void insert(int key) 
	{
		Node newNode = new Node(key);		
		if(root == null) 
		{
			root = newNode;
		} 
		else 
		{
			Node focusNode = root;	
			Node parent;
			while(true) 
			{
				parent = focusNode;
				if(key < focusNode.key) 
				{
					focusNode = focusNode.leftChild;
					if(focusNode == null)
					{
						parent.leftChild = newNode;
						return;
					}
				} 
				else 
				{ 
					focusNode = focusNode.rightChild;
					if(focusNode == null) 
					{
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}

	public void inorderTraversal(Node focusNode) 
	{
		if(focusNode != null) 
		{
			inorderTraversal(focusNode.leftChild);
			System.out.print(focusNode + " ");
			inorderTraversal(focusNode.rightChild);
		}
	}

	public void preorderTraversal(Node focusNode) 
	{
		if(focusNode != null) 
		{
			System.out.print(focusNode + " ");
			preorderTraversal(focusNode.leftChild);
			preorderTraversal(focusNode.rightChild);
		}
	}

	public void postorderTraversal(Node focusNode) 
	{
		if(focusNode != null) 
		{
			postorderTraversal(focusNode.leftChild);
			postorderTraversal(focusNode.rightChild);
			System.out.print(focusNode + " ");
		}
	}

	public boolean find(int key) 
	{
		Node focusNode = root;
		while(focusNode.key != key) 
		{
			if(key < focusNode.key) 
			{
				focusNode = focusNode.leftChild;
			} 
			else 
			{
				focusNode = focusNode.rightChild;
			}
			if(focusNode == null)
			{
				return false;
			}
		}
		return true;
	}

	public boolean remove(int key) 
	{
		Node focusNode = root;
		Node parent = root;
		boolean isItALeftChild = true;
		while(focusNode.key != key) 
		{
			parent = focusNode;
			if(key < focusNode.key) 
			{
				isItALeftChild = true;
				focusNode = focusNode.leftChild;
			} 
			else 
			{
				isItALeftChild = false;
				focusNode = focusNode.rightChild;
			}
			if(focusNode == null)
				return false;
		}

		if(focusNode.leftChild == null && focusNode.rightChild == null) 
		{
			if(focusNode == root)
				root = null;
			else if(isItALeftChild)
				parent.leftChild = null;
			else
				parent.rightChild = null;
		}
		else if(focusNode.rightChild == null) 
		{
			if(focusNode == root)
				root = focusNode.leftChild;
			else if(isItALeftChild)
				parent.leftChild = focusNode.leftChild;
			else
				parent.rightChild = focusNode.leftChild;
		}
		else if(focusNode.leftChild == null) 
		{
			if(focusNode == root)
				root = focusNode.rightChild;
			else if (isItALeftChild)
				parent.leftChild = focusNode.rightChild;
			else
				parent.rightChild = focusNode.rightChild;
		}
		else 
		{
			Node replacement = getReplacementNode(focusNode);
			if(focusNode == root)
				root = replacement;
			else if(isItALeftChild)
				parent.leftChild = replacement;
			else
				parent.rightChild = replacement;
			replacement.leftChild = focusNode.leftChild;
		}

		return true;
	}

	public Node getReplacementNode(Node replacedNode) 
	{
		Node replacementParent = replacedNode;
		Node replacement = replacedNode;
		Node focusNode = replacedNode.rightChild;
		
		while(focusNode != null) 
		{
			replacementParent = replacement;
			replacement = focusNode;
			focusNode = focusNode.leftChild;
		}
		
		if(replacement != replacedNode.rightChild) 
		{
			replacementParent.leftChild = replacement.rightChild;
			replacement.rightChild = replacedNode.rightChild;
		}

		return replacement;
	}
	
	public int getHeight(Node node)  
    { 
        if(node == null) 
            return -1; 
        else 
        { 
            int lDepth = getHeight(node.leftChild); 
            int rDepth = getHeight(node.rightChild); 
           
            if(lDepth > rDepth) 
                return (lDepth + 1); 
            else 
                return (rDepth + 1); 
        } 
    } 

	public static void main(String[] args) 
	{ 
		Scanner inputScan = new Scanner(System.in);
		boolean isSystemRunning = true;
		boolean isMismatchInput = true;
		String userInput = "";

		do	
		{
			BinarySearchTree theTree = new BinarySearchTree();
			int arrA[] = {30, 10, 45, 38, 20, 50, 25, 33, 8, 12};
			for(int x : arrA)
			{
				theTree.insert(x);
			}
			System.out.print("\u2022 AN ARRAY OF INTEGER: ");
			System.out.println(Arrays.toString(arrA));

			boolean isCommandPromptRunning = true;
			do	
			{
				System.out.println("NOTICE: Please enter a command.");
				System.out.print("==>: ");
				userInput = inputScan.nextLine();

				switch(userInput)
				{
					case "/inorder":
						System.out.print("\u2022 IN ORDER: ");
						theTree.inorderTraversal(theTree.root); System.out.println(); System.out.println();
						break;
					
					case "/preorder":
						System.out.print("\u2022 PRE ORDER: ");
						theTree.preorderTraversal(theTree.root); System.out.println(); System.out.println();
						break;

					case "/postorder":
						System.out.print("\u2022 POST ORDER: ");
						theTree.postorderTraversal(theTree.root); System.out.println(); System.out.println();
						break;
					
					case "/height":
						System.out.print("\u2022 Height of binary tree: ");
						System.out.println(theTree.getHeight(theTree.root)); System.out.println();
						break;
					
					case "/find":
						System.out.println("NOTICE: Please enter the number you are trying to find.");
						System.out.print("==>: ");
						int targetFind = inputScan.nextInt();
						inputScan.nextLine();
						System.out.print("\u2022 " + targetFind + " is in the binary tree: ");
						System.out.println(theTree.find(targetFind)); System.out.println();
						break;

					case "/delete":
						System.out.println("NOTICE: Please enter the number you are trying to delete.");
						System.out.print("==>: ");
						int targetDelete = inputScan.nextInt();
						inputScan.nextLine();
						System.out.println("\u2022 Removing node with key " + targetDelete + ".");
						theTree.remove(targetDelete);
						System.out.print("\u2022 " + targetDelete + " is in the binary tree: ");
						System.out.println(theTree.find(targetDelete)); System.out.println();
						break;

					case "/quit":
						System.out.println("NOTICE: Exiting..."); System.out.println();
						isCommandPromptRunning = false;
						break;

					default:
						System.out.println("NOTICE: No such command exists."); System.out.println();
				}
			}
			while(isCommandPromptRunning);

			do	
			{
				System.out.println("\u2022 Do you want to try again?");
				System.out.print("==>(Y/N): ");
				char tryAgainChoice = ' ';
				tryAgainChoice = inputScan.next().charAt(0);
				tryAgainChoice = Character.toUpperCase(tryAgainChoice);
				inputScan.nextLine();

				switch(tryAgainChoice)
				{
					case 'Y':
						isMismatchInput = false;
						isSystemRunning = true;
						break;
					
					case 'N':
						isMismatchInput = false;
						isSystemRunning = false;
						break;
					
					default:
						System.out.println("NOTICE: INVALID CHOICE!");
				}
			}
			while(isMismatchInput);
			isMismatchInput = true;
			System.out.println();
		}
		while(isSystemRunning);

		System.out.println("NOTICE: Program Terminated...");
		inputScan.close();
		System.exit(0);
	}
}

class Node 
{
	int key;
	Node leftChild;
	Node rightChild;

	Node(int key) 
	{
		this.key = key;
	}

	public String toString() 
	{
		return "" + key;
	}
}
