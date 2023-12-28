
package stringfunctions;
import java.util.Scanner;
/**
 *
 * @author grant rynders
 */
public class StringFunctions 
{
    public static void main(String[] args) 
    {
        //declaration
        Scanner input = new Scanner(System.in);
        String name;
        //input
        System.out.print("What is your first and last name? ");
        name = input.nextLine();
        //output
        System.out.printf("You name is %s%n", name);
        System.out.printf("Including spaces, there are %d characters in your name%n", name.length());
        System.out.printf("You name in all caps is %s%n", name.toUpperCase());
        System.out.printf("You name in all lower case is %s%n", name.toLowerCase());
        System.out.printf("The first character of your name is %s%n", name.charAt(0));
        System.out.printf("The 3rd character of your name is %s%n", name.charAt(2));
        System.out.printf("There is a space in your name at position %d%n", name.indexOf(" "));
        System.out.printf("The first 3 characters of your name are %s%n", name.substring(0, 3));
        String firstName = name.substring(0, name.indexOf(" "));
        System.out.printf("Your first name is %s and has %d characters%n", firstName,firstName.length());
        String lastName = name.substring(name.indexOf(" ")+1);
        System.out.printf("Your last name is %s and has %d characters%n", lastName,lastName.length());
        String filingName = lastName + ", " + firstName;
        System.out.printf("Your filing name is %s%n", filingName);
        String firstString = name.toUpperCase();
        String secondString = name.toLowerCase();
        if (firstString.equals(secondString))
        {
            System.out.printf("%s is the same as %s%n", firstString,secondString);
        }
        else
        {
            System.out.printf("%s is not the same as %s%n", firstString,secondString);
        }
         if (firstString.equalsIgnoreCase(secondString))
        {
            System.out.printf("%s is the same as %s if you ignore case%n", firstString,secondString);
        }
        else
        {
            System.out.printf("%s is not the same as %s%n", firstString,secondString);
        }        
    } 
}
