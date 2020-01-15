/* ====================================================================================================
# Author: Duc Ngo
# Course: CS3130-001 - Design and Analysis of Algorithms
# File Name: BinarySearchTreeHeightPair.java
# Purpose:
	Write a program implementing some operations on binary search trees
==================================================================================================== */
package project3;
import java.util.*;

public class BinarySearchTreeHeightPair 
{
	public static void main(String[] args) 
	{ 
		Scanner inputScan = new Scanner(System.in);
		long seed = System.nanoTime();
		Random generator = new Random(seed);

		long start;
        long end;
        long elapsedTime;
        double seconds;
		
        System.out.println("SYSTEM: Please enter number for N: ");
        System.out.print("==>: ");
        int n = 0;
        n = inputScan.nextInt();
        inputScan.nextLine();

        System.out.println("SYSTEM: Please enter number for T: ");
        System.out.print("==>: ");
        int t = 0;
        t = inputScan.nextInt();
        inputScan.nextLine();

        for(int i = 0; i < t; i++)
        {
			start = System.nanoTime();
            BinarySearchTree theTree = new BinarySearchTree();
            int[] arr = new int[n];
            for(int x = 0; x < arr.length; x++)
            {
                arr[x] = generator.nextInt(10000) + 1;
            }
            for(int x : arr)
            {
                theTree.insert(x);
            }
			end = System.nanoTime();
			elapsedTime = end - start;
			seconds =  elapsedTime / 1000000000.0;
			
			System.out.println("Time: " + seconds);
            System.out.println("\u2022 Order Pair (" + n +", " + (i + 1) + ")");
            System.out.print("\u2022 Height of binary tree: ");
			System.out.println(theTree.getHeight(theTree.root) + "\n");
        }
        
		System.out.println("DONE");
		inputScan.close();
		System.exit(0);
	}
}
