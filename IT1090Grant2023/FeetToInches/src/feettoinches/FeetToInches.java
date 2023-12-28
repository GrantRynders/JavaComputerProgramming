/*
 * 
 */
package feettoinches;

import java.util.Scanner;
/**
 *
 * @author grant rynders
 */


public class FeetToInches 
{
    public static void main(String[] args) 
    {   
        // hook up the Scanner to the keyboard (System.in)
        Scanner input = new Scanner(System.in);
        // variable declaration section
        // We are declaring two integer variables to
        // hold the number of feet and the number of inches.
        int feet;
        int inches;
        
        // input section
        // In this section we are prompting the user for input.
        System.out.print("How many feet?");
        feet = input.nextInt();  // use the Scanner to get the next integer
        
        // process section
        // We perform the math and other operations in this section.
        inches = feet * 12;  // there are 12 inches in one foot
        
        // output section
        // In this section we print our results.
        // formatted output string
        System.out.printf("There are %d inches in %d feet%n",  inches, feet);
    }
}
