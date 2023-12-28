
package arithmeticproject;
import java.util.Scanner;
/**
 *
 * @author grant rynders
 */
public class ArithmeticProject 
{
    public static void main(String[] args) 
    {
        //delcaration
        Scanner input = new Scanner(System.in);
        int number1, number2, sum, difference, product, quotient, remainder;
        double quotient2, average;
        //input
        System.out.print("Enter first number: ");
        number1 = input.nextInt();
        System.out.print("Enter second number: ");
        number2 = input.nextInt();
        //process
        sum = number1 + number2;
        difference = number1 - number2;
        product = number1 * number2;
        quotient = number1 / number2;
        quotient2 = (double) number1 / number2;
        remainder = number1 % number2;
        average = (number1 + number2) / 2.0;
        //output
        System.out.printf("The sum of %d plus %d = %d%n", number1, number2, sum);
        System.out.printf("The difference of %d minus %d = %d%n", number1, number2, difference);
        System.out.printf("The product of %d times %d = %d%n", number1, number2, product);
        System.out.printf("The integer quotient of %d divided by %d = %d%n", number1, number2, 
quotient);
        System.out.printf("The floating point quotient of %d divided by %d = %f%n", number1, number2, 
quotient2);
        System.out.printf("The remainder of %d modulo %d = %d%n", number1, number2, remainder);
        System.out.printf("The average of %d and %d = %f%n", number1, number2, average);
        // use the Math library
        System.out.printf("The smaller number is %d%n", Math.min(number1, number2));
        System.out.printf("The larger number is %d%n", Math.max(number1, number2));
        // The Math library uses doubles. Integers are automatically converted.
        System.out.printf("The square root of  %d = %f%n", number1, Math.sqrt(number1));
        System.out.printf("4 raised to the 3rd power = %f%n", Math.pow(4, 3));
    }
    
}
