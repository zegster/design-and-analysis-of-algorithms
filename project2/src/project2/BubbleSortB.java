/* ====================================================================================================
# Author: Duc Ngo
# Course: CS3130-001 - Design and Analysis of Algorithms
# File Name: BubbleSortB.java
# Purpose:
	The purpose of the programming assignment is to perform empirical analysis of the
	following sorting algorithms on integer arrays: bubble sort (with swaps)
==================================================================================================== */
package project2;
import java.util.*;

public class BubbleSortB 
{
	public static void main(String[] args) 
    {  
        int arr[] ={18, 5, 1, 12, 8, 20, 25, 19, 10, 15, 23};  
        System.out.println("Array Before Bubble Sort (with swap counting):");  
        System.out.println(Arrays.toString(arr));
        System.out.println();
          
        long start = System.nanoTime();
        sort(arr);
        long end = System.nanoTime();
        long elapsedTime = end - start;
        double seconds =  elapsedTime / 1000000000.0;
        
        System.out.println("Array After Bubble Sort (with swap counting):");  
        System.out.println(Arrays.toString(arr));
        System.out.println();
        System.out.println("Sorting Time: " + seconds + " sec");  
    }

    static void sort(int[] array) 
    {  
        int n = array.length;  
        int temp = 0;
        boolean swap = false;  
        for(int i = 0; i < n; i++)
        {  
            swap = false;
            for(int j = 1; j < (n - i); j++)
            {  
                if(array[j - 1] > array[j])
                {  
                    temp = array[j - 1];  
                    array[j - 1] = array[j];  
                    array[j] = temp;  
                    swap = true;
                }   
            } 
            if(swap == false)
                break;
        } 
    }
}
