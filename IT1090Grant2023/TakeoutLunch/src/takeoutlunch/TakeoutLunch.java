
package takeoutlunch;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 *
 * @author grant rynders
 */
public class TakeoutLunch 
{
    public static void main(String[] args) 
    {
        //declaration
        Scanner in = new Scanner(System.in);
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        final double TIP_PERCENT = 0.18, SALES_TAX_RATE = 0.0575;
        double sandwichCost, drinkCost, mealCost, totalCost;
        double tipAmount = 0, taxAmount = 0;
        String addTip = "no";
        String takeout = "yes";
        //input and calculations
        System.out.print("How much is your sandwich? ");
        sandwichCost = in.nextDouble();
        System.out.print("How much is your drink? ");
        drinkCost = in.nextDouble();
        mealCost = sandwichCost + drinkCost;
        System.out.print("Is this takeout? ");
        takeout = in.next();
        if (takeout.equalsIgnoreCase("no"))
        {
            taxAmount = mealCost * SALES_TAX_RATE;
            System.out.print("Add a tip? ");
            addTip = in.next();
            if (addTip.equalsIgnoreCase("yes"))
            {
                tipAmount = mealCost * TIP_PERCENT;
            }
            else
            {
                System.out.print("cheapskate...");
            }
        }
        totalCost = sandwichCost + drinkCost + tipAmount + taxAmount;
        //output
        System.out.println(); // print a blank line
        System.out.println("Meal Receipt");
        System.out.printf("%-10s %6s%n","Sandwich", currency.format(sandwichCost));
        System.out.printf("%-10s %6s%n","Drink", currency.format(drinkCost));
        System.out.printf("%-10s %6s%n","Tax", currency.format(taxAmount));
        System.out.printf("%-10s %6s%n","Tip", currency.format(tipAmount));
        System.out.printf("%-10s %6s%n","Total", currency.format(totalCost));
    }
    
}
