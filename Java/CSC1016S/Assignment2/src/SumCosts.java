/**
 * Program that asks the user to input a series of rand amounts, sums them up and then prints the result
 * Rand values only
 *
 * @author: Yolisa Pingilili
 */


import  java.util.Scanner;

public class SumCosts{
   public static void main(String[] args){
      Currency rand = new Currency("R", "ZAR", 100);
      Money total = new Money("R0.00", rand);
      Scanner input = new Scanner(System.in);
      //
      
      System.out.println("Enter an amount or '[D]one' to print the sum and quit:");
      String amount = input.nextLine();
      //
      
      while(!(amount.equals("D") || amount.equals("Done"))){
         total = total.add(new Money(amount, rand));                                      //add the input amount to the current amount
         System.out.println("Enter an amount or '[D]one' to print the sum and quit:");
         amount = input.nextLine();
      }
      System.out.println("Total: " + total);
   } 
}
