
package averagedoloop;

/**
 *
 * @author grant rynders
 */
import java.util.Scanner;

public class AverageDoLoop 
{
    public static void main(String[] args) 
    {
        //declaration
        Scanner sc = new Scanner(System.in);
        int numScores = 0;
        double score, average;
        double total = 0.0;
        //input and loop
        do 
        {
            // get the score
            System.out.print("Enter score. (Type 0 to stop): ");
            score = sc.nextDouble();
            if (score != 0) 
            {
                // count the score
                numScores += 1;
                // keep a running total
                total += score;
            }
            // continue as long as the input does not equal 0
        } while (score != 0);
        // print score count and average
        if (numScores == 0)
            System.out.println("No scores were entered.");
        else 
        {
            average = total / numScores;
            System.out.println();
            System.out.printf("You entered %d scores%n", numScores);
            System.out.printf("The total for all scores is %.3f%n", total);
            System.out.printf("The average of the %d scores is %.3f%n",
                    numScores, average);
        }
    }
    
}
