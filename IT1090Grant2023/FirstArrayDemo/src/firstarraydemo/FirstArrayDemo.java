
package firstarraydemo;

/**
 *
 * @author grant rynders
 */
import java.util.Scanner;

public class FirstArrayDemo
{
    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) 
    {
        int[] juniorScores = new int[5];
        System.out.println("Initial Array");
        PrintArray(juniorScores);
        for (int i = 0; i < juniorScores.length; i++)
        {
            System.out.print("Enter score " + i + ": ");
            juniorScores[i] = input.nextInt();
        }
        System.out.println("Junior Scores Array");
        PrintArray(juniorScores);
        int result;
        result = juniorScores[3] + juniorScores[4];
        System.out.println("Score 3 + 4 = " + result);
        juniorScores[1] = 25;
        juniorScores[3] = 75;
        System.out.println("Junior Array after assignments");
        PrintArray(juniorScores);
        int[] seniorScores;
        seniorScores = GetScores(8);
        System.out.println("Senior Scores Array");
        PrintArray(seniorScores);
    }
    private static void PrintArray(int[] scores)
    {
        for (int i = 0; i < scores.length; i++)
            System.out.printf("Slot: %d   Score: %d%n",
                    i, scores[i]);
    }
    private static int[] GetScores(int n)
    {
        int[] values = new int[n];
        for (int i = 0; i < n; i++)
        {
            System.out.print("Enter score " + i + ": ");
            values[i] = input.nextInt();
        }
        return values;
    }
}
