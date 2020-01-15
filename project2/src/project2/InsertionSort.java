/* ====================================================================================================
# Author: Duc Ngo
# Course: CS3130-001 - Design and Analysis of Algorithms
# File Name: InsertionSort.java
# Purpose:
	The purpose of the programming assignment is to perform empirical analysis of the
	following sorting algorithms on integer arrays: insertion sort
==================================================================================================== */
package project2;
import java.util.*;

public class InsertionSort 
{
	public static void main(String[] args)
    {    
        int arr[] ={18, 5, 1, 12, 8, 20, 25, 19, 10, 15, 23};  
        System.out.println("Array Before Insertion Sort:");  
        System.out.println(Arrays.toString(arr));
        System.out.println();
          
        long start = System.nanoTime();
        sort(arr);
        long end = System.nanoTime();
        long elapsedTime = end - start;
        double seconds =  elapsedTime / 1000000000.0;
        
        System.out.println("Array After Insertion Sort:");  
        System.out.println(Arrays.toString(arr));
        System.out.println();
        System.out.println("Sorting Time: " + seconds + " sec"); 
    }   

    public static void sort(int[] array) 
    {  
        int n = array.length;  
        for(int j = 1; j < n; j++) 
        {  
            int key = array[j];  
            int i = j-1;  
            while((i > -1) && (array[i] > key)) 
            {  
                array [i+1] = array [i];  
                i--;  
            }  
            array[i+1] = key;  
        }  
    }
}
