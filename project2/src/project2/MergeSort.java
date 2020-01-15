/* ====================================================================================================
# Author: Duc Ngo
# Course: CS3130-001 - Design and Analysis of Algorithms
# File Name: MergeSort.java
# Purpose:
	The purpose of the programming assignment is to perform empirical analysis of the
	following sorting algorithms on integer arrays: merge sort
==================================================================================================== */
package project2;
import java.util.*;

public class MergeSort 
{
	public static void main(String[] args) 
    {  
        int arr[] ={18, 5, 1, 12, 8, 20, 25, 19, 10, 15, 23};  
        System.out.println("Array Before Merge Sort:");  
        System.out.println(Arrays.toString(arr));
        System.out.println();
          
        long start = System.nanoTime();
        sort(arr, 0, arr.length - 1);
        long end = System.nanoTime();
        long elapsedTime = end - start;
        double seconds =  elapsedTime / 1000000000.0;
        
        System.out.println("Array After Merge Sort:");  
        System.out.println(Arrays.toString(arr));
        System.out.println();
        System.out.println("Sorting Time: " + seconds + " sec"); 
    }

    static void sort(int arr[], int l, int r) 
    {  
        if (l < r) 
        { 
            int m = (l + r)/2;      //Find the middle point 
            sort(arr, l, m);        //Sort first halves 
            sort(arr , m + 1, r);   //Sort second halves 
            merge(arr, l, m, r);    //Merge the sorted halves 
        } 
    }

    static void merge(int arr[], int l, int m, int r)
    {
        //Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 

        //Create temp arrays
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 

        //Copy data to temp arrays
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 

        //Initial indexes of first and second subarrays 
        int i = 0, j = 0; 

        //Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 

        //Copy remaining elements of L[] if any
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 

        //Copy remaining elements of R[] if any
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    }
}
