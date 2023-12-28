/**
 *
 * @author grant rynders
 */
import java.text.NumberFormat;
import java.util.Scanner;

public class program1 
{
    public static void main(String[] args) 
    {
        //declaration of variables imports
        Scanner input = new Scanner(System.in);
        NumberFormat currency = NumberFormat.getCurrencyInstance(); // defaults to U.S. dollar
        final double DELIVERY_CHARGE = 2; //$2 per book 
        final double TAX_RATE = 0.075; // 7.5%
        double booksCost, taxCost, deliveryCost, totalCost;
        int numBooks;
        //prompts and user input
        System.out.print("Total price of books: ");
        booksCost = input.nextDouble();
        System.out.print("Number of books: ");
        numBooks = input.nextInt();
        //calculations
        deliveryCost = numBooks * DELIVERY_CHARGE;
        taxCost = booksCost * TAX_RATE;
        totalCost = booksCost + taxCost + deliveryCost;
        //system print output
        
        //print blank line btwn input statements and output statements 
        System.out.printf("%n");
        // print booksCost
        System.out.printf("%-22s %7s%n","Total price:", 
currency.format(booksCost));
        //print taxCost
        System.out.printf("%-22s %7s%n","Tax:", 
currency.format(taxCost));
        // print deliveryCost
        System.out.printf("%-22s %7s%n","Shipping:", 
currency.format(deliveryCost));
        //print totalCost
        System.out.printf("%-22s %7s%n","Amount due:", 
currency.format(totalCost));
    }
    
}
