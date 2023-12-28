
package poundsandstones;
import java.util.Scanner;

/**
 *
 * @author grant rynders
 */
public class PoundsAndStones 
{
    public static void main(String[] args) 
    {
        //declaration
        Scanner input = new Scanner(System.in);
        final double STONE_PER_POUND = 0.0714;    // 1 lb = 0.0714 stones
        final double KILO_PER_POUND = 0.4536;       // 1 lb = 0.454 kg
        double weightLbs, weightKg, weightStones;
        //input
        System.out.print("How much do you weigh in pounds? ");
        weightLbs = input.nextDouble();
        //process
        weightKg = weightLbs * KILO_PER_POUND;
        weightStones = weightLbs * STONE_PER_POUND;
        //output
         System.out.println(weightLbs + " pounds is " + weightKg + " kilograms");
        System.out.println(weightLbs + " pounds is " + weightStones + " stones");
    }
    
}
