
package averageforloop2;

/**
 *
 * @author grant rynders
 */
import java.util.Scanner;

public class AverageForLoop2 
{
    public static void main(String[] args) 
    {
       //declaration
       Scanner input = new Scanner(System.in);
       int numScores;
       double score, average;
       double total = 0.0; // initialize the accumulator
       //input
       System.out.print("How many scores? ");
       numScores = input.nextInt();
       //calculation
       for (int i=1; i <= numScores; i++)
       {
            System.out.print("Enter score " + i + ": ");
            score = input.nextDouble();
            total = total + score;
       }
       System.out.println();
       average = total/numScores;
       //output
       System.out.printf("The average of the %d scores is %.3f%n",
                numScores,average);
    }
    
}
