
package lunchdelivery;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 *
 * @author grant rynders
 */
public class LunchDelivery 
{
    public static void main(String[] args) 
    {
        //declaration
        Scanner input = new Scanner(System.in);
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        final double DELIVERY_CHARGE = 9.50;
        final double TAX_RATE = 0.075;
        double sandwichCost, drinkCost, totalSandwichCost, totalDrinkCost, totalOrderCost, tax;
        int numSandwiches, numDrinks;
        String company;
        //Input
        System.out.print("Thank you for calling Pizza Hut! What is your company: ");
        company = input.nextLine();
        System.out.print("How many sandwiches do you want? ");
        numSandwiches = input.nextInt();
        System.out.print("How much is each sandwich? ");
        sandwichCost = input.nextDouble();
        totalSandwichCost = numSandwiches * sandwichCost;
        System.out.print("How many drinks do you want? ");
        numDrinks = input.nextInt();
        System.out.print("How much is each drink? ");
        drinkCost = input.nextDouble();
        totalDrinkCost = numDrinks * drinkCost;
        tax = (totalSandwichCost + totalDrinkCost) * TAX_RATE;
        totalOrderCost = totalSandwichCost + totalDrinkCost + DELIVERY_CHARGE + tax;
        //output
        System.out.println();
        System.out.printf("%-22s %s%n","Deliver to:", company);
        System.out.printf("%-22s %7s%n","Total for sandwiches:", 
currency.format(totalSandwichCost));
        System.out.printf("%-22s %7s%n","Total for drinks:", currency.format(totalDrinkCost));
        System.out.printf("%-22s %7s%n","Delivery charge:", 
currency.format(DELIVERY_CHARGE));
        System.out.printf("%-22s %7s%n","Tax:", currency.format(tax));
        System.out.printf("%-22s %7s%n","Total order cost:", currency.format(totalOrderCost));
    }
    
}
