
package averagewhileloop;

/**
 *
 * @author grant rynders
 */
import java.util.Scanner;

public class AverageWhileLoop 
{
    public static void main(String[] args) 
    {
        //declaration
        Scanner sc = new Scanner(System.in);
        int numScores = 0; //initialize counter
        double score, average;
        double total = 0.0; // initialize accumulator
        String input;
        //input
        System.out.print("Enter score. (Type quit to stop): ");
        input = sc.nextLine();
        //loop
        while (!input.equalsIgnoreCase("quit"))
        {
            // convert the score string into a double
            score = Double.parseDouble(input);
            numScores = numScores + 1; // count scores
            total = total + score;  // accumulate scores
            System.out.print("Enter score. (Type quit to stop): ");
            input = sc.nextLine();
        }
        //output
        average = total / numScores;
        System.out.printf("The average of the %d scores is %.2f%n ", numScores, average);
    }
    
}
