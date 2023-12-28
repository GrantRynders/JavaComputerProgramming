
package program3;

/**
 *
 * @author grant rynders
 */
import java.util.Scanner;

public class Program3 
{
    static Scanner input = new Scanner(System.in); // listed outside main w/ static in order to work in multiple methods
    
    public static void main(String[] args) 
    {
        int randomNum, min = 1, max = 100;
        boolean done = false;
        // calculate random number
        randomNum = (int)(Math.random() * (max - min + 1)) + min; // only used once per run so a new method is unneccessary
        System.out.printf("randomnum = %d%n", randomNum); //DEBUG STATEMENT
        System.out.printf("You have 10 tries to guess a number between 1 and 100%n"); //opening message
        while (!done)
        {
            ActiveGame();
        }
    }
    
    public static boolean ActiveGame()
    {
        do
        {
        //declaration
        int min = 1, max = 100, inputNum, guessCount = 1, totalGuesses = 10; // total guesses measures the remaining guesses, guess count measures how many time the user has guessed
        String score = "DEFAULT";
        //get guess
        inputNum = inputGuess(min, max, guessCount);
        UpdateCount(guessCount); //updates guessCount
        totalGuesses = 10 - guessCount;
        //process guess
        if (inputNum > randomNum)  //GUESS IS TOO HIGH
        {
            if (guessCount == 1)  //STATEMENT CHANGES IF GUESSCOUNT =1
            {
                System.out.printf("Your guess is too high. You have %d try left.%n", totalGuesses);
            }
            else
            {
                System.out.printf("Your guess is too high. You have %d tries left.%n", totalGuesses);
            }    
        }
        else if (inputNum < randomNum)  //GUESS IS TOO LOW
        {
            if (guessCount == 1)
            {
                System.out.printf("Your guess is too low. You have %d try left.%n", totalGuesses);
            }
            else
            {
                System.out.printf("Your guess is too low. You have %d tries left.%n", totalGuesses);
            }    
        }
        else if (inputNum == randomNum) // GUESS IS CORRECT
        {
            if (guessCount == 1)
            {
            System.out.printf("Congratulations! You correctly guessed the number in %d try%n", guessCount);
            }
            else
            {
               System.out.printf("Congratulations! You correctly guessed the number in %d tries%n", guessCount);     
            }
            //CALCULATE SCORE
            score = CalculateScore(score, guessCount); // calls calculate score method which sets score string based on guess count
            System.out.printf("%s!%n", score); //prints score string + "!"
            return false; // Have activegame return false and end program
        }
        if (guessCount == 10) // OUT OF GUESSES
        {
            System.out.printf("Sorry, you did not guess the number in 10 tries.%n The number was %d.%n", randomNum);
            return false; // Have activegame return false and end program
        }
        } while (ActiveGame());
        
        return true; // makes done boolean true
    }
    
    public static int inputGuess(int min, int max, int guessCount)
    {
        while (true)
        {
            System.out.printf("Guess number %d: ", guessCount);
            int inputNum = input.nextInt();
            if ((inputNum > max) || (inputNum < min))
            {
            System.out.printf("Guesses should be between %d and %d%n", min, max);
            }
            else
            {
                return inputNum;
            }
        }
    }
    
    public static String CalculateScore(String score, int guessCount)
    {
        if (guessCount >= 1 && guessCount <= 3)
        {
            score = "Excellent score";
        }
        else if (guessCount >= 4 && guessCount <= 6)
        {
            score = "Good score";
        }
        else if (guessCount >= 7 && guessCount <= 9)
        {
            score = "Average score";
        }
        else
        {
            score = "Lousy score";
        }
        return score;
    }
    public static int UpdateCount(int guessCount)
    {
        guessCount += 1;
        return guessCount;
    }
}
