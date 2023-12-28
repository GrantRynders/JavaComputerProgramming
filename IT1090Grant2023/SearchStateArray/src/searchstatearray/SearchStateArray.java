
package searchstatearray;

/**
 *
 * @author grant rynders
 */
import java.util.Arrays;
import java.util.Scanner;
public class SearchStateArray
{
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int numProbes;
        String state;
        int stateIndex;
        final String[] stateAbbreviations =
                { "AK", "AL", "AR", "AZ", "CA", "CO", "CT", "DC", "DE", "FL",
                        "GA", "GU", "HI", "IA", "ID", "IL", "IN", "KS", "KY", "LA",
                        "MA", "MD", "ME", "MH", "MI", "MN", "MO", "MS", "MT", "NC",
                        "ND", "NE", "NH", "NJ", "NM", "NV", "NY", "OH", "OK", "OR",
                        "PA", "PR", "PW", "RI", "SC", "SD", "TN", "TX", "UT", "VA",
                        "VI", "VT", "WA", "WI", "WV", "WY"
                };
        for (int i = 0; i < stateAbbreviations.length; i++)
        {
            System.out.printf("slot: %02d, state abbreviation: %s%n ",i,stateAbbreviations[i]);
        }
        // check to see if state abbreviation is valid using a sequential search.
        stateIndex = -1;  // state is not in state array
        numProbes = 0;
        System.out.println();
        System.out.println("Seach for state using a sequential search");
        System.out.println("There are " + stateAbbreviations.length + " state abbreviations in the array");
        System.out.println();
        System.out.print("Enter the state abbreviation for your home state: ");
        state = in.nextLine().toUpperCase();
        for (int i = 0; i < stateAbbreviations.length; i++)
        {
            numProbes++;
            if (stateAbbreviations[i].equals(state))
            {
                stateIndex = i;
                break;
            }
        }
        // print results of search
        if (stateIndex >= 0)
        {
            System.out.println("You entered a valid state abbreviation");
            System.out.println("Your state is in slot " + stateIndex + " of the states array");
            System.out.println("It took " + numProbes + " tries to find your state");
        }
        else
        {
            System.out.println("You entered an invalid state abbreviation.");
            System.out.println("You probed the state array " + numProbes + " times");
        }

        // check to see if state abbreviation is valid using a binary search.
        numProbes = 0;
        int low = 0;
        int high = stateAbbreviations.length - 1;
        int pos = 0;
        boolean found = false;
        stateIndex = -1;

        System.out.println();
        System.out.println("Seach for state using a user-defined binary search");
        System.out.print("Enter the state abbreviation for your home state: ");
        state = in.nextLine().toUpperCase();

        // hand-coded binary search
        while (low <= high && !found)
        {
            numProbes++;
            pos = (low + high) / 2; // midpoint of array
            System.out.println("Probe position: " + pos + " State: " +
                    stateAbbreviations[pos] );
            if (stateAbbreviations[pos].equals(state))
            {
                found = true;
                stateIndex = pos;
            }
            else if (stateAbbreviations[pos].compareTo(state) < 0)
            {
                low = pos + 1; // look in second half
            }
            else
            {
                high = pos - 1; // look in first half
            }

        }

        // print results of search
        if (stateIndex >= 0)
        {
            System.out.println("You entered a valid state abbreviation");
            System.out.println("Your state is in slot " + stateIndex + " of the states array");
            System.out.println("It took " + numProbes + " tries to find your state");
        }
        else
        {
            System.out.println("You entered an invalid state abbreviation.");
            System.out.println("You probed the state array " + numProbes + " times");
        }

        // searching with the binary search method of the Arrays class.
        // prompts repeatedly until valid state abbreviation is entered.
        System.out.println();
        System.out.println("Search for state using the built-in Arrays.binarySearch() method");
        do
        {
            System.out.print("Enter the state abbreviation for your home state: ");
            state = in.nextLine().toUpperCase();
            stateIndex = Arrays.binarySearch(stateAbbreviations, state);
            System.out.println("State Index: " + stateIndex);
            if (stateIndex >= 0)
            {
                System.out.println("You entered a valid state abbreviation");
            }
            else
            {
                System.out.println("You entered an invalid state abbreviation. Try again.");
            }
        } while (stateIndex < 0);
    }
    
}
