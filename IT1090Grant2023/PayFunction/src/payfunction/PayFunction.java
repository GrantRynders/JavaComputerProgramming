
package payfunction;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 *
 * @author grant rynders
 */
public class PayFunction 
{
    public static void main(String[] args) 
    {
        //declaration
        Scanner in = new Scanner(System.in);
        NumberFormat money = NumberFormat.getCurrencyInstance();
        int numEmployees;
        double hours, rate, pay;
        String input,name;
        //input
        System.out.print("How many employees? ");
        numEmployees = Integer.parseInt(in.nextLine());
        for (int count = 1; count <= numEmployees; count++)
        {
            // get employee information
            System.out.print("Enter name: ");
            name = in.nextLine();
            // get hours worked
            System.out.printf("Hours worked for %s: ", name);
            input = in.nextLine();
            hours = Double.parseDouble(input);
            // get pay rate
            System.out.printf("Pay rate for %s: ", name);
            input = in.nextLine();
            rate = Double.parseDouble(input);
            // OUTPUT
            pay = ComputePay(hours,rate);
            System.out.printf("Weekly pay for %s is %s%n",name,money.format(pay));
            System.out.println();
        }
    }
    public static double ComputePay(double hoursWorked, double payRate)
    {
        double pay;
        if (hoursWorked > 40)
        {
            pay = (40 * payRate) + (hoursWorked - 40) * payRate * 1.5;
        }
        else
        {
            pay = hoursWorked * payRate;
        }
        return pay;
    }
}
