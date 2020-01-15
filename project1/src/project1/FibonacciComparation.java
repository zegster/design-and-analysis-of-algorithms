/* ====================================================================================================
# Author: Duc Ngo
# Course: CS3130-001 - Design and Analysis of Algorithms
# File Name: FibonacciComparation.java
# Purpose:
	Write a program that will compare running time of the recursive and iterative
	functions for calculating Fibonacci numbers. Call each function for the same size of input N (the
	index of a Fibonacci number to be calculated) and find their running times.
	
	Write an analysis of two algorithms of calculating Fibonacci numbers: recursive (part A) 
	and iterative (part B). Show the theoretical order of growth of the running time for both 
	algorithms.
==================================================================================================== */
package project1;
import java.io.*;
import java.util.Scanner;

public class FibonacciComparation 
{
	public static void main(String[] args) 
	{
		/* Time Variable */
		long start;
        long end;
        long elapsedTime;
        double seconds;
		
        
        /* PART C */
        Scanner inputScan = new Scanner(System.in);
        System.out.println("Enter the n terms");
        System.out.print("==>: ");
        int userInput;
        userInput = inputScan.nextInt();
        
        start = System.nanoTime();
        IterativeFibonacci.F(userInput);
        end = System.nanoTime();
        elapsedTime = end - start;
        seconds =  elapsedTime / 1000000000.0;
        System.out.println("Iterative Time: " + seconds + " sec");

        start = System.nanoTime();
        RecursiveFibonacci.F(userInput);
        end = System.nanoTime();
        elapsedTime = end - start;
        seconds =  elapsedTime / 1000000000.0;
        System.out.println("Recursive Time: " + seconds + " sec");
        System.out.println();
        
        
        /* PART E */
		//Iterative
        try
        (
            FileWriter txt = new FileWriter("@time-result-iterative.txt");
        )
        {
            for(int n = 0; n <= 50; n++)
            {
                txt.write("n = " + n + "\n");
                System.out.println("n = " + n);
                for(int i = 0; i < 3; i++)
                {
                    start = System.nanoTime();
                    IterativeFibonacci.F(n);
                    end = System.nanoTime();
                    elapsedTime = end - start;
                    seconds =  elapsedTime / 1000000000.0;
                    txt.write(seconds + "\n");
                    System.out.println("Iterative Time: " + seconds);
                }
                System.out.println();
                txt.write("\n");
                txt.flush();
            }
        }
        catch(FileNotFoundException e)
        {
            
        }
        catch(IOException e)
        {
            
        }
        
        //Recursive
        try
        (
            FileWriter txt = new FileWriter("@time-result-recursive.txt");
        )
        {
            for(int n = 0; n <= 50; n++)
            {
                txt.write("n = " + n + "\n");
                System.out.println("n = " + n);
                for(int i = 0; i < 3; i++)
                {
                    start = System.nanoTime();
                    RecursiveFibonacci.F(n);
                    end = System.nanoTime();
                    elapsedTime = end - start;
                    seconds =  elapsedTime / 1000000000.0;
                    txt.write(seconds + "\n");
                    System.out.println("Recursive Time: " + seconds);
                }
                System.out.println();
                txt.write("\n");
                txt.flush();
            }
        }
        catch(FileNotFoundException e)
        {
            
        }
        catch(IOException e)
        {
            
        }
    }
}
