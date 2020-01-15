/* ====================================================================================================
# Author: Duc Ngo
# Course: CS3130-001 - Design and Analysis of Algorithms
# File Name: RecursiveFibonacci.java
# Purpose:
	Write a recursive function that will calculate Fibonacci numbers using a recursive
	definition. Write a short program to test it. The input of this program must be a positive integer
	N; the output is the corresponding Fibonacci number F(N).
==================================================================================================== */
package project1;
import java.util.*;

public class RecursiveFibonacci
{
    public static void main(String[] args) 
	{
        Scanner inputScan = new Scanner(System.in);
        System.out.println("Enter the n terms");
        System.out.print("==>: ");
        int userInput;
        userInput = inputScan.nextInt();

        long start = System.nanoTime();
        System.out.println(F(userInput));
        long end = System.nanoTime();
        long elapsedTime = end - start;
        double seconds =  elapsedTime / 1000000000.0;
        System.out.println("Time: " + seconds + " sec");
        inputScan.close();
    }
    
    public static long F(int n) 
    {
        if(n == 0) 
        {
            return 0;
        }
        else if(n == 1) 
        {
            return 1;
        }
        else
        {
            return F(n-1) + F(n-2);
        }
    }
}
