/* ====================================================================================================
# Author: Duc Ngo
# Course: CS3130-001 - Design and Analysis of Algorithms
# File Name: FibonacciFormula.java
# Purpose:
	Write a function that will implement each Fibonacci number with the help of an integer array of 
	size 100 (elements of this array will be digits of the Fibonacci number). When the function is 
	called to find F(N), it will calculate all Fibonacci numbers from F(2) to F(N) using the basic 
	formula F(N) = F(N - 1) + F(N - 2). To add two Fibonacci numbers, the function will add elements 
	of two arrays corresponding to F(N - 1) and F(N - 2) and store their sums in the array corresponding 
	to F(N). (You are NOT supposed to store ALL arrays.) Write a program that will calculate Fibonacci 
	numbers containing up to 100 digits. Display the biggest Fibonacci number that has less than 100 
	digits. Make sure that your program will display the error message when a Fibonacci number has 
	100 digits or more.
==================================================================================================== */
package project1;
import java.util.Scanner;

public class FibonacciFormula 
{
	public static void main(String[] args) 
	{
		//Initialize 2D array
        int[][] numArr = new int[3][100];
        for(int row = 0; row < numArr.length; row++)
        {
            for(int column = 0; column < numArr[row].length; column++)
            {
                numArr[row][column] = 0;
            }
        }
        
        //Starter two preceding
        numArr[0][99] = 0;  //F0
        numArr[1][99] = 1;  //F1

        //User prompt
        Scanner inputScan = new Scanner(System.in);
        System.out.println("Enter the n terms");
        System.out.print("==>: ");
        int userInput;
        userInput = inputScan.nextInt();

        //Calculation procedure
        int carry = 0;
        int counter = 2;
        for(int i = 2; i <= userInput; i++)
        {
            //Break if over 100 digits
            if((numArr[(i + 1) % 3][0] + numArr[(i + 2) % 3][0] + carry) >= 10)
            {
                System.out.println("ERROR! Over 100 digits...");
                break;
            }
            for(int digit = 99; digit >= 0; digit--)
            {
                int num = numArr[(i + 1) % 3][digit] + numArr[(i + 2) % 3][digit] + carry;
                numArr[(i + 3) % 3][digit] = num % 10;
                carry = num / 10;
            }
            counter++;
        }

        //Output result
        for(int column = 0; column < numArr[(counter - 1) % 3].length; column++)
        {
            System.out.print(numArr[(counter - 1 + 3) % 3][column]);
        }
        System.out.println();
        System.out.println("Number of times: " + (counter - 1));
        inputScan.close();
    }
}
