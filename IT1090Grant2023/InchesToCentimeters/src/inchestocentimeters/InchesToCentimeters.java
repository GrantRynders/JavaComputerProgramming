
package inchestocentimeters;
import java.util.Scanner;
/**
 *
 * @author grant rynders
 */
public class InchesToCentimeters 
{
    public static void main(String[] args) 
    {
      //declaration
      Scanner input = new Scanner(System.in);
      final double CentimetersPerInch = 2.54;
      double numInches;
      double numCentimeters;
      //input
      System.out.print("Number of inches? ");
      numInches = input.nextDouble();
      //process
      numCentimeters = numInches * CentimetersPerInch;
      //output
      System.out.printf("In %.3f inches there are %.4f centimers%n", numInches, numCentimeters);
    }
    
}
