/* ====================================================================================================
# Author: Duc Ngo
# Course: CS3130-001 - Design and Analysis of Algorithms
# File Name: SortingAlgorithm.java
# Purpose:
	The purpose of the programming assignment is to perform empirical analysis of the
	following sorting algorithms on integer arrays: selection sort, insertion sort, bubble sort (no swap),
	bubble sort (with swap), quick sort, and merge sort
==================================================================================================== */
package project2;
import java.util.*;
import java.io.*;

public class SortingAlgorithm 
{
	public static void main(String[] args)
    {
		/* User prompt */
        Scanner inputScan = new Scanner(System.in);
        System.out.println("Choose an algorithm <1. selection sort, 2. insertion sort, 3. bubble sort (no swap), "
        		+ "4. bubble sort (with swap), 5. quick sort, 6. merge sort>");
        System.out.print("==>: ");
        int userInput;
        userInput = inputScan.nextInt();
		
		
		/* Time Variable */
		long start;
        long end;
        long elapsedTime;
        double seconds;

        
        /* -------------------------------------------------- */
        /* Generating random number of size: 1000, 10000 and 100000 integers */
        final int SIZE = 10;
        String arraySize = Integer.toString(SIZE);
        int[] randomArray = new int[SIZE];
        int[] sortedArray = new int[SIZE];
        int[] almostSortedArray = new int[SIZE];
        int[] arr = new int[SIZE];
        final long SEED = 363366622308613L;
        Random random = new Random(SEED);
        final int MIN = 1;
        final int MAX = 10000;
        
        //Generating random number and save it to a random array
        for(int i = 0; i < randomArray.length; i++)
        {
        	randomArray[i] = random.nextInt((MAX - MIN) + 1) + MIN;
        }
        
        //Sort the random array and save it to a sorted array
        sortedArray = randomArray.clone();
        QuickSort.sort(sortedArray, 0, sortedArray.length - 1);
        
        //Generate almost sorted array and save it to a almost sorted array
        almostSortedArray = sortedArray.clone();
        for(int i = 0; i < almostSortedArray.length; i++)
        {
        	if(i != 0 || i % 10 == 0)
        		almostSortedArray[i] = random.nextInt((MAX - MIN) + 1) + MIN;
        }
        
        
        /* -------------------------------------------------- */
        /* DEBUG */
        /*
        for(int x : randomArray)
        {
        	System.out.println(x);
        }
        System.out.println();
        
        for(int x : sortedArray)
        {
        	System.out.println(x);
        }
        System.out.println();
        
        for(int x : almostSortedArray)
        {
        	System.out.println(x);
        }
        System.out.println();
        */
        
        
        /* -------------------------------------------------- */
        /* Sorting Algorithm */
		try
        (
            FileWriter outputFile = new FileWriter("@sorting-algorithm-time-" + arraySize + ".outputFile");
        )
        {
			/* -------------------------------------------------- */
            //Testing 5 times: random
            outputFile.write(">>> Random Array <<<\n");
			for(int i = 0; i < 5; i++)
			{
                arr = randomArray.clone();
                start = System.nanoTime();
                switch(userInput)
                {
                	case 1:
                        SelectionSort.sort(arr);
                		break;
                		
                	case 2:
                		InsertionSort.sort(arr);
                		break;
                		
                	case 3:
                		BubbleSortA.sort(arr);
                		break;
                		
                	case 4:
                		BubbleSortB.sort(arr);
                		break;
                		
                	case 5:
                		QuickSort.sort(arr, 0, arr.length - 1);
                		break;
                		
                	case 6:
                		MergeSort.sort(arr, 0, arr.length - 1);
                		break;
                }
                end = System.nanoTime();
                elapsedTime = end - start;
                seconds =  elapsedTime / 1000000000.0;
                System.out.println("Random Sorting Time: " + seconds);
                outputFile.write(seconds + "\n");
            }
            outputFile.write("\n");
            outputFile.flush();
            System.out.println();

            
            /* -------------------------------------------------- */
            //Testing 5 times: sorted
            outputFile.write(">>> Sorted Array <<<\n");
			for(int i = 0; i < 5; i++)
			{
                arr = sortedArray.clone();
                start = System.nanoTime();
                switch(userInput)
                {
                	case 1:
                        SelectionSort.sort(arr);
                		break;
                		
                	case 2:
                		InsertionSort.sort(arr);
                		break;
                		
                	case 3:
                		BubbleSortA.sort(arr);
                		break;
                		
                	case 4:
                		BubbleSortB.sort(arr);
                		break;
                		
                	case 5:
                		QuickSort.sort(arr, 0, arr.length - 1);
                		break;
                		
                	case 6:
                		MergeSort.sort(arr, 0, arr.length - 1);
                		break;
                }
                end = System.nanoTime();
                elapsedTime = end - start;
                seconds =  elapsedTime / 1000000000.0;
                System.out.println("Sorted Sorting Time: " + seconds);
                outputFile.write(seconds + "\n");
            }
            outputFile.write("\n");
            outputFile.flush();
			System.out.println();

			
			/* -------------------------------------------------- */
            //Testing 5 times: almost sorted
            outputFile.write(">>> Almost Sorted Array <<<\n");
			for(int i = 0; i < 5; i++)
			{
                arr = almostSortedArray.clone();
                start = System.nanoTime();
                switch(userInput)
                {
                	case 1:
                        SelectionSort.sort(arr);
                		break;
                		
                	case 2:
                		InsertionSort.sort(arr);
                		break;
                		
                	case 3:
                		BubbleSortA.sort(arr);
                		break;
                		
                	case 4:
                		BubbleSortB.sort(arr);
                		break;
                		
                	case 5:
                		QuickSort.sort(arr, 0, arr.length - 1);
                		break;
                		
                	case 6:
                		MergeSort.sort(arr, 0, arr.length - 1);
                		break;
                }
                end = System.nanoTime();
                elapsedTime = end - start;
                seconds =  elapsedTime / 1000000000.0;
                System.out.println("Almost Sorted Sorting Time: " + seconds);
                outputFile.write(seconds + "\n");
            }
            outputFile.write("\n");
            outputFile.flush();
            System.out.println();
        }
        catch(FileNotFoundException e)
        {
            
        }
        catch(IOException e)
        {
            
        }
		
		inputScan.close();
        System.out.println("\nDONE");
    } 
}
