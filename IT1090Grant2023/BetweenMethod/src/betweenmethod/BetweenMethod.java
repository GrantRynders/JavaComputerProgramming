
package betweenmethod;

/**
 *
 * @author grant rynders
 */
import java.util.Scanner;

public class BetweenMethod 
{
    public static void main(String[] args) 
    {
        //declaration
        Scanner input = new Scanner(System.in);
        int min, max, number;
        boolean isBetween;
        //input
        System.out.print("Enter the minimum number: ");
        min = input.nextInt();
        System.out.print("Enter the maximum number: ");
        max = input.nextInt();
        System.out.print("Enter your number: ");
        number = input.nextInt();
        //calculation
        isBetween = Between(number,min,max);
        //ouput
        if (isBetween)
        {
            System.out.printf("Your number is between %d and %d%n",
                    min,max);
        }
        else
        {
            System.out.printf("Your number is not between %d and %d%n",
                    min,max);
        }
    }
    private static boolean Between(int number,int low, int high)
    {
        return (number >= low && number <= high);
    } 
}
