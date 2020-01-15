/* ====================================================================================================
# Author: Duc Ngo
# Course: CS3130-001 - Design and Analysis of Algorithms
# File Name: IterativeFibonacci.java
# Purpose:
	Write an iterative function to calculate Fibonacci numbers. Write a test driver for it.
	The input of this program must be a positive integer N; the output is the corresponding Fibonacci
	number F(N).
==================================================================================================== */
package project1;
import java.util.*;

public class IterativeFibonacci 
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
        if (n == 0) return 0;
        if (n == 1) return 1;
            
        long prevPrev = 0;
        long prev = 1;
        long result = 0;
            
        for (int i = 2; i <= n; i++)
        {
            result = prev + prevPrev;
            prevPrev = prev;
            prev = result;
        }
        return result;
    }
}
