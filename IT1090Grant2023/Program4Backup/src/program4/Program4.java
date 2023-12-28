
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
        return (int) (Math.random() * (randomCharacters.length));
    }
    // This function takes a character and returns it as an encrypted 4-character string
    public static String EncryptCharacter(char character)
    {
        String hexCharacter = Integer.toHexString(character); //converts single character to 2 digit hexi
        char[] hexCharacters = hexCharacter.toCharArray(); //converts hexi to char array
        // I was receiving a lot of errors with the provided random generator, so I made a giant char list
        char[] randomCharacters = {'a', ';', 'B', 'C', '?', '<', 'd', 'e', '0', '1', '%', '$', '@', 'f', 'G', '*', '!', 'h', '2', '3', 'I', 'J', '4', '5', 'K', 'l', '6', '7', 'm', '8', '9', 'n', 'O', 'P', 'Q', 'r', 's', 'T', 'U', 'v', 'w', 'X', 'Y', 'z'};
        char Char1 = randomCharacters[GetRandomNumber(randomCharacters)]; // selects from randomposition in randomCharacters[]
        char Char2 = hexCharacters[0]; // first digit of hexi
        char Char3 = randomCharacters[GetRandomNumber(randomCharacters)];
        char Char4 = hexCharacters[1]; // second digit of hexi
        char[] encryptedChars = {Char1, Char2, Char3, Char4}; // creates char[] with all 4 chars in correct order
        String encryptedCharacter = String.valueOf(encryptedChars); // converts this array to a string
System.out.println("     encryptchar " + encryptedCharacter);
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
        String encryptedText = "";
        char[] plainChars = plainText.toCharArray();
        for (char character : plainChars)
        {
System.out.println("     for loop activate");
            String encryptedCharacter = EncryptCharacter(character);
            encryptedText = (encryptedText + encryptedCharacter);
            plainText = encryptedText;
System.out.println("     encryptText" + encryptedText);
System.out.println("     plain text " + plainText);
        }
        return plainText;
    }
    // This function takes an encrypted message and returns it as a decrypted message.
    //PLEASE READ, I removed the random numbers first. This removes them all at once so that they don't need to be deleted for every 4 char set
    public static String DecryptMessage(String encryptedText)
    {
        String decryptedText = ""; // initialized decryptedText
        String encryptedCharacter = ""; //initialize encryptedCharacter
        char[] encryptedChars = encryptedText.toCharArray(); // converts encrypted message to char array
        char[] hexiChars = new  char[encryptedChars.length / 2]; //this array will only contain hexi chars
System.out.println("     hexiarray length " + hexiChars.length);
        for (int i = 0; i < hexiChars.length; i++) // adds every other char in the encrypted array to the hexi array
        {
            hexiChars[i] = encryptedChars[(i * 2)+1]; //hexis are every other
System.out.println("     hexiChars  " + hexiChars[i]);
        }

        
        for (int x = 0; x < hexiChars.length; x+=2)
        {
           encryptedCharacter = (String.valueOf(hexiChars[x]) + String.valueOf(hexiChars[x+1]));
System.out.println("     encryptChar " + encryptedCharacter);
           char decryptedCharacter = DecryptCharacter(encryptedCharacter);
           decryptedText = (decryptedText + decryptedCharacter);
        }
        return decryptedText;
    }
}
