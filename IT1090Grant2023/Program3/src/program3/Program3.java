
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
        int min = 1, max = 100, inputNum, guessCount = 0, totalGuesses, randomNum; // total guesses measures the remaining guesses, guess count measures how many time the user has guessed
        String score = "DEFAULT";
        //get guess
        randomNum = GetRandomNumber(min, max); // generates random number
        boolean done = false; // determines if game is active
        System.out.printf("You have 10 tries to guess a number between 1 and 100%n"); //opening message
        while (!done)
        {
            do
            {
                inputNum = inputGuess(min, max, guessCount); //returns user input
                guessCount += 1; // updates guess count
                totalGuesses = 10 - guessCount; // total guesses = remaining guesses
                //process guess
                if (inputNum == randomNum) // GUESS IS CORRECT
                {
                    if (guessCount == 1) // STATEMENT CHANGES IF ONLY ONE TRY USED
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
                    done = true; //ends game
                }
                else if ((inputNum != randomNum) && (guessCount == 10)) // OUT OF GUESSES
                {
                    System.out.printf("Sorry, you did not guess the number in 10 tries.%nThe number was %d.%n", randomNum);
                    done = true; // ends game
                }
                else if (inputNum > randomNum)  //GUESS IS TOO HIGH
                {
                    if (guessCount == 9)  //STATEMENT CHANGES IF ONE TRY LEFT
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
                    if (guessCount == 9)
                    {
                        System.out.printf("Your guess is too low. You have %d try left.%n", totalGuesses);
                    }
                    else
                    {
                        System.out.printf("Your guess is too low. You have %d tries left.%n", totalGuesses);
                    }    
                }
            } while (false);
        }
    }

    public static int GetRandomNumber(int min, int max)
    {
        return (int)(Math.random() * (max - min + 1)) + min; // generates random btwn 1 and 100
    }
    public static int inputGuess(int min, int max, int guessCount)
    {
        while (true)
        {
            System.out.printf("Guess number %d: ", guessCount + 1); // since initially guess count is 0, 1 is added
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
}
