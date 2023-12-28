
package calculatepay;
import java.text.NumberFormat;
import java.util.Scanner;
/**
 *
 * @author grant rynders
 */
public class CalculatePay 
{
    public static void main(String[] args) 
    {
        //declaration
        Scanner in = new Scanner(System.in);
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        double regularPay, totalPay, hoursWorked, payRate;
        double overTimeHours = 0.0;
        double overTimePay = 0.0;
        //input
        System.out.print("Enter pay rate: ");
        payRate = in.nextDouble();
        System.out.print("Enter hours worked this week: ");
        hoursWorked = in.nextDouble();
        //calculations
        if (hoursWorked > 40) // worked overtime
        {
            regularPay = 40 * payRate;
            overTimeHours = hoursWorked - 40;
            overTimePay = overTimeHours * payRate * 1.5;
        }
        else // did not work overtime
        {
            regularPay = hoursWorked * payRate;
            //overTimeHours = 0;
            //overTimePay = 0.0;
        }
        totalPay = regularPay + overTimePay;
        //output
        System.out.println();
        System.out.printf("%-15s%10s%n", "Regular pay:", currency.format(regularPay));
        System.out.printf("%-15s%10.2f%n", "Overtime hours:", overTimeHours);
        System.out.printf("%-15s%10s%n", "Overtime pay:", currency.format(overTimePay));
        System.out.printf("%-15s%10s%n", "Total pay:", currency.format(totalPay));
    }
    
}
