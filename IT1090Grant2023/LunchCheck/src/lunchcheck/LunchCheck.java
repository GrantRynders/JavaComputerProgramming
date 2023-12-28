
package lunchcheck;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
/**
 *
 * @author grant rynders
 */
public class LunchCheck 
{   
    public static void main(String[] args) 
    {
        //declaration
        Scanner input = new Scanner(System.in);
        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);
        double sandwichCost, drinkCost, totalCost;
        String name;
        //input
        System.out.print("What is your name?");
        name = input.nextLine();
        System.out.print("How much is your sandwich?");
        sandwichCost = input.nextDouble();
        System.out.print("How much is your drink?");
        drinkCost = input.nextDouble();
        //output
        totalCost = sandwichCost + drinkCost;
        System.out.printf("%s, your lunch costs %s%n", name, currency.format(totalCost));
    }  
}
