
package lousypay;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 *
 * @author grant rynders
 */
public class LousyPay 
{
    public static void main(String[] args) 
    {
       //declaration
       Scanner in = new Scanner(System.in);
       NumberFormat money = NumberFormat.getCurrencyInstance();
       String employeeName;
       double hoursWorked, payRate, weeklyPay, overtimeHours;
       //input
       System.out.print("Employee name: ");
       employeeName = in.nextLine();
       System.out.print("Enter hours worked: ");
       hoursWorked = in.nextDouble();
       System.out.print("Enter hourly pay rate: ");
       payRate = in.nextDouble();
       //computation
       if (hoursWorked > 40)
       {
            overtimeHours = hoursWorked - 40;
            System.out.printf("Thank you for working %.2f extra hours.%n", overtimeHours);
            System.out.println("We appreciate your dedication, but please note that we do not pay for overtime.");
            hoursWorked = 40;
       }
       weeklyPay = hoursWorked * payRate;
       //output
       System.out.println();
       System.out.printf("%s, thank you for submitting your hours.%n", employeeName);
       System.out.printf("You will be paid for %.2f hours this week.%n", hoursWorked);
       System.out.printf("Your pay this week is %s%n", money.format(weeklyPay));
       
    }
    
}
