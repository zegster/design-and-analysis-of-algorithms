/* ====================================================================================================
# Author: Duc Ngo
# Course: CS3130-001 - Design and Analysis of Algorithms
# File Name: SelectionSort.java
# Purpose:
	The purpose of the programming assignment is to perform empirical analysis of the
	following sorting algorithms on integer arrays: selection sort
==================================================================================================== */
package project2;
import java.util.*;

public class SelectionSort 
{
	public static void main(String[] args)
    {  
        int arr[] ={18, 5, 1, 12, 8, 20, 25, 19, 10, 15, 23};  
        System.out.println("Array Before Selection Sort:");  
        System.out.println(Arrays.toString(arr));
        System.out.println();
          
        long start = System.nanoTime();
        sort(arr);
        long end = System.nanoTime();
        long elapsedTime = end - start;
        double seconds =  elapsedTime / 1000000000.0;
        
        System.out.println("Array After Selection Sort:");  
        System.out.println(Arrays.toString(arr));
        System.out.println();
        System.out.println("Sorting Time: " + seconds + " sec"); 
    } 

    public static void sort(int[] array)
    {  
        for(int i = 0; i < array.length - 1; i++)  
        {  
            int index = i;  
            for(int j = i + 1; j < array.length; j++)
            {  
                if(array[j] < array[index])
                {  
                    index = j; 
                }  
            }  
            int smallerNumber = array[index];   
            array[index] = array[i];  
            array[i] = smallerNumber;  
        }  
    }  
}
