/* ====================================================================================================
# Author: Duc Ngo
# Course: CS3130-001 - Design and Analysis of Algorithms
# File Name: QuickSort.java
# Purpose:
	The purpose of the programming assignment is to perform empirical analysis of the
	following sorting algorithms on integer arrays: quick sort
==================================================================================================== */
package project2;
import java.util.*;

public class QuickSort 
{
	public static void main(String[] args) 
    {  
        int arr[] ={18, 5, 1, 12, 8, 20, 25, 19, 10, 15, 23};  
        System.out.println("Array Before Quick Sort:");  
        System.out.println(Arrays.toString(arr));
        System.out.println();
          
        long start = System.nanoTime();
        sort(arr, 0, arr.length - 1);
        long end = System.nanoTime();
        long elapsedTime = end - start;
        double seconds =  elapsedTime / 1000000000.0;
        
        System.out.println("Array After Quick Sort:");  
        System.out.println(Arrays.toString(arr));
        System.out.println();
        System.out.println("Sorting Time: " + seconds + " sec"); 
    }

    static void sort(int[] array, int start, int end) 
    {  
        int partition = partition(array, start, end);
        if(partition - 1 > start) 
        {
            sort(array, start, partition - 1);
        }
        if(partition + 1 < end) 
        {
            sort(array, partition + 1, end);
        }
    }

    public static int partition(int[] arr, int start, int end)
    {
        int pivot = arr[end];
        for(int i = start; i < end; i++)
        {
            if(arr[i] < pivot)
            {
                int temp = arr[start];
                arr[start] = arr[i];
                arr[i] = temp;
                start++;
            }
        }
        int temp = arr[start];
        arr[start] = pivot;
        arr[end] = temp;
        return start;
    }
}
