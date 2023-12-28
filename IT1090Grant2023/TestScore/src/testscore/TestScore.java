
package testscore;
import java.util.Scanner;

/**
 *
 * @author grant rynders
 */
public class TestScore 
{
    public static void main(String[] args) 
    {
        //declaration
        Scanner sc = new Scanner(System.in);
        int testScore;
        //input
        System.out.print("Enter your test score: ");
        testScore = sc.nextInt();
        //output
        if (testScore >= 90 && testScore <= 100) 
        {
            System.out.println("Your test grade is an A");
            System.out.println("Excellent work! Take the weekend off.");
        }
        else if (testScore >= 80 && testScore <= 89) 
        {
            System.out.println("Your test grade is an B");
            System.out.println("Good work! Take Sunday off.");
        }
        else if (testScore >= 70 && testScore <= 79) 
        {
            System.out.println("Your test grade is an C");
            System.out.println("Average work. Consider studying on weekends.");
            System.out.println("Review the items you missed");
        }
        else if (testScore >= 60 && testScore <= 69) 
        {
            System.out.println("Your test grade is an D");
            System.out.println("Below average work. You need to study on weekends");
            System.out.println("Review the test with your instructor");
        }
        else if (testScore >= 0 && testScore <= 59) 
        {
            System.out.println("Your test grade is an F");
            System.out.println("Poor work. You need to study more on weekdays and weekends.");
            System.out.println("See your instructor.");
        }
        else // this branch is executed if none of the other branches are taken
        {
            System.out.println("You entered an invalid test score");
            System.out.println("Test scores should be between 0 and 100");
        }
    }
    
}
