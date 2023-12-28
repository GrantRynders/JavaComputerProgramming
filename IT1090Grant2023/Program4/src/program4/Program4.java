
package program4;
import java.util.Scanner;

/**
 *
 * @author grant rynders
 */
public class Program4 
{
    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) 
    {
        String plainText, encryptedText, decryptedText;
              
        System.out.print("Enter message: ");
        plainText = input.nextLine();
        
        System.out.println();
        System.out.println("Encrypted message");
        encryptedText = EncryptMessage(plainText);
        System.out.println(encryptedText);
        System.out.println();
        
        System.out.println("Decrypted message:");
        decryptedText = DecryptMessage(encryptedText);
        System.out.println(decryptedText);      
    }
    public static int GetRandomNumber(char[] randomCharacters)
    {
        return (int) (Math.random() * (randomCharacters.length)); // uses the array length so that it only gets slot numbers
    }
    // This function takes a character and returns it as an encrypted 4-character string
    public static String EncryptCharacter(char character)
    {
        String hexCharacter = Integer.toHexString(character); //converts single character to 2 digit hexi
        char[] hexCharacters = hexCharacter.toCharArray(); //converts hexi to char array
        // I was receiving some errors with the provided random generator, so I did this instead. A random char is chosen from a list by selecting a randomly numbered slot
        char[] randomCharacters = {'a', ';', 'B', 'C', '?', '<', 'd', 'e', '0', '1', '%', '$', '@', 'f', 'G', '*', '!', 'h', '2', '3', 'I', 'J', '4', '5', 'K', 'l', '6', '7', 'm', '8', '9', 'n', 'O', 'P', 'Q', 'r', 's', 'T', 'U', 'v', 'w', 'X', 'Y', 'z'};
        char char1 = randomCharacters[GetRandomNumber(randomCharacters)]; // selects from randomposition in randomCharacters[]
        char char2 = hexCharacters[0]; // first digit of hexi
        char char3 = randomCharacters[GetRandomNumber(randomCharacters)]; // selects a (generally) different random number
        char char4 = hexCharacters[1]; // second digit of hexi
        char[] encryptedChars = {char1, char2, char3, char4}; // creates char[] with all 4 chars in correct order
        String encryptedCharacter = String.valueOf(encryptedChars); // converts this array to a string
        return encryptedCharacter; // returns the original char as a 4 digit string
    }
    // This function takes an encrypted character string and returns a decrypted character
    public static char DecryptCharacter(String encryptedCharacter)
    {
        char decryptedCharacter;
        decryptedCharacter = (char) Integer.parseInt(encryptedCharacter,16);
        return decryptedCharacter;
    }
    // This function takes a plaintext message and returns the message as an encrypted string.
    public static String EncryptMessage(String plainText)
    {
        String encryptedText = ""; // initializes encryptedtext
        char[] plainChars = plainText.toCharArray(); //converts initial message to a character array
        for (char character : plainChars) // for each loop that goes through every character in the array
        {
            String encryptedCharacter = EncryptCharacter(character); //activates method to convert chars from plainText to 4 character strings
            encryptedText = (encryptedText + encryptedCharacter); // concatenates all the encrypted strings
        }
        return encryptedText;
    }
    // This function takes an encrypted message and returns it as a decrypted message.
    public static String DecryptMessage(String encryptedText)
    {
        String decryptedText = ""; // initialized decryptedText
        String encryptedCharacter = ""; //initialize encryptedCharacter
        char[] encryptedChars = encryptedText.toCharArray(); // converts encrypted message to char array
        
        for (int i = 0; i < encryptedChars.length; i+=4) 
        // selects group of 4, converts them to a encrypted string, translates, concatenates to the decrypted text string, then skips ahead 4 slots and repeats the process
        {
           char[] fourChars = new char[4]; // initializes list with 4 slots
           for (int x = 0; x < 4; x++)
           {
               fourChars[x] = encryptedChars[x + i]; //sets values of fourChars[]
           }
           encryptedCharacter = (String.valueOf(fourChars[1]) + String.valueOf(fourChars[3])); // uses these values to return a string
           char decryptedCharacter = DecryptCharacter(encryptedCharacter); // translates two char hexi string to a char
           decryptedText = (decryptedText + decryptedCharacter); // concatenates the decrypted characters together
        }
        return decryptedText; //returns the value once all elements in encryptedChars are dealt with
    }
}
