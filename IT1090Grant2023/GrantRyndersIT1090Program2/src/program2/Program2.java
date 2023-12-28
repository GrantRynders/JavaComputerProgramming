
package program2;

/**
 *
 * @author grant rynders
 */
import java.text.NumberFormat;
import java.util.Scanner;

public class Program2 
{
    public static void main(String[] args) 
    {
       //declaration
       Scanner in = new Scanner(System.in); // user input
       NumberFormat currency = NumberFormat.getCurrencyInstance(); //automatically formats to U.S. dollar
       NumberFormat percentage = NumberFormat.getPercentInstance(); // formats to percentage
       double orderCost = 0, couponValue = 0, finalCost = 0; // I set all these values to zero, since the console would give an error saying the couponValue had not been initialized prior to line 48
       //input
       System.out.print("Please enter the cost of your groceries: ");
       orderCost = in.nextDouble();
       //calculations
       if (orderCost >= 0 && orderCost < 10) //between $0 and $10
       {
           couponValue = 0.00 * orderCost; // 0%
       }
       else if (orderCost >= 10 && orderCost < 50) //between $10 and $50
       {
           couponValue = 0.05 * orderCost; // 5%
       } 
       else if (orderCost >= 50 && orderCost < 75) //between $50 and $75
       {
           couponValue = 0.10 * orderCost; // 10%
       } 
       else if (orderCost >= 75 && orderCost < 125) //between $75 and $125
       {
           couponValue = 0.15 * orderCost; // 15%
       }
       else if (orderCost >= 125 && orderCost < 200) //between $125 and $200
       {
           couponValue = 0.18 * orderCost; // 18%
       }
       else if (orderCost >= 200) //greater than or equal to $200
       {
           couponValue = 0.20 * orderCost; // 20&
       }
       finalCost = orderCost - couponValue;
       //output
       System.out.printf("You earned a discount coupon of %s (%s of your purchase)%n", currency.format(couponValue), percentage.format(couponValue / orderCost));
       System.out.printf("Please pay %s. Thank you for shopping with us!", currency.format(finalCost));
    }
    
}
