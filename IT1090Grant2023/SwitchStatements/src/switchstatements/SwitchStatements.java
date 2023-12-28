
package switchstatements;
import java.util.Scanner;

/**
 *
 * @author grant rynders
 */
public class SwitchStatements 
{
    public static void main(String[] args) 
    {
        //declaration
        Scanner in = new Scanner(System.in);
        int digit;
        String digitName = "";
        //input
        System.out.print("Enter a digit: ");
        digit = in.nextInt();
        //calculation
        digitName = switch (digit) 
        {
            case 0 -> "zero";
            case 1 -> "one";
            case 2 -> "two";
            case 3 -> "three";
            case 4 -> "four";
            case 5 -> "five";
            case 6 -> "six";
            case 7 -> "seven";
            case 8 -> "eight";
            case 9 -> "nine";
            default -> "Not a digit";
        };
        //output
        System.out.printf("The name for the digit you entered is: %s%n", digitName);
    }
    
}
