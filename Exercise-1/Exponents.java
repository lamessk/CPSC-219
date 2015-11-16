/* This is a program that calcuates exponents
CPSC 219 Mini Assignment 1
Lamess Kharfan
Student Number: 10150607
Saturday,January 24, 2015
*/
import java.util.Arrays;
import java.util.Scanner;

public class Exponents
{
  public static void main(String[] args)
  {
      Scanner in = new Scanner(System.in);

//Prompts user to enter the amount of calculations that they would like
      //to do, within the range of 1-10 expoenent calculations
      System.out.print("Enter the number of exponents of calculate: ");
      int numExponents = in.nextInt();

      //If the user enters > 10 calculations, display error message and ask for
      //a number of calculations between 1-10
      if (numExponents > 10)
      {
          System.out.println("That was not between 1-10");
          System.out.println("Enter the number of exponents to calculate: ");
          numExponents = in.nextInt();
      }

      //Create an array that will hold the answers to the calculated exponents
      //Length of array is the number of calculations
      int[] expList = new int[numExponents];

      //Loop for prompting user for the same number of bases and exponents as the
      //number of calculations the user specified
      for(int i = 0; i < expList.length; i++)
      {
          System.out.print("Enter the base: ");
          int base = in.nextInt();

          System.out.print("Enter the exponent: ");
          int exp = in.nextInt();

          //Calculates the exponents using a loop
          int answer = 1;
          for(int number = 0; number <= exp; number++)
          {
              //If the base is raised to the 0th power, the answer will be 1
              //Adds a 1 to the answers array
              if (exp == 0)
              {
                  expList[i] = 1;
              }

              if (number >= 1)
              {
                  answer *= base;
                  expList[i] = answer;
              }
          }

      }

    //Display results, each on a seperate line
    System.out.println("The results to your a^n calculations are: ");
    for(int i = 0; i < expList.length; i++)
    {
    System.out.println(expList[i]);
     }
  }
}
