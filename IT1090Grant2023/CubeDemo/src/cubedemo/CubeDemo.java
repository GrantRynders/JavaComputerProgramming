
package cubedemo;

/**
 *
 * @author grant rynders
 */
public class CubeDemo 
{
    public static void main(String[] args) 
    {
        //declaration
        double result1 = cubeVolume(2);  // 2 is an argument
        double result2 = cubeVolume(10.34); // 10.34 is an argument
        //output
        System.out.println("A cube with side length 2 has a volume of " + String.format("%.2f", 
result1));
        System.out.println("A cube with side length 10.34 has a volume of " + String.format("%.2f", 
result2));
    }
    private static double cubeVolume(double sideLength)  // sideLength is a parameter
    {
        // sideLength is a local variable. It is not known
        // outside of the function
        double volume = Math.pow(sideLength, 3);
        return volume;
    } 
}
