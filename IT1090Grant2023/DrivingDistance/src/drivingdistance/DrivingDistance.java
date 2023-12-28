
package drivingdistance;

/**
 *
 * @author grant rynders
 */
import java.util.Scanner;
public class DrivingDistance 
{
    public static void main(String[] args) 
    {
      Scanner input = new Scanner(System.in);
        int[][] distances = {
                {0, 983, 787, 714, 1375, 967, 1087},
                {983, 0, 214, 1102, 1763, 1723, 1842},
                {787, 214, 0, 888, 1549, 1548, 1627},
                {714, 1102, 888, 0, 661, 781, 810},
                {1375, 1763, 1549, 661, 0, 1426, 1187},
                {967, 1723, 1548, 781, 1426, 0, 239},
                {1087, 1842, 1627, 810, 1187, 239, 0}
        };
        String startCity, endCity;
        int startIndex, endIndex;
        int distance;
        // prompt for starting and destination cities
        System.out.print("Starting City: ");
        startCity = input.nextLine();
        System.out.print("Destination City: ");
        endCity = input.nextLine();
        //     get the array indices for the cities
       //     startIndex = GetCityIndex(startCity);
      //      endIndex = GetCityIndex(endCity);
        startIndex = CityIndex(startCity);
        endIndex = CityIndex(endCity);
        // look up distance and print result
        distance = distances[startIndex][endIndex];
        System.out.printf("The distance between %s and %s is %d miles%n",
                startCity, endCity, distance);  
    }
    static private int GetCityIndex(String city)
    {
        int index = -1;
        switch (city.toUpperCase())
        {
            case "CHICAGO":
                index = 0;
                break;
            case "BOSTON":
                index = 1;
                break;
            case "NEW YORK":
                index = 2;
                break;
            case "ATLANTA":
                index = 3;
                break;
            case "MIAMI":
                index = 4;
                break;
            case "DALLAS":
                index = 5;
                break;
            case "HOUSTON":
                index = 6;
                break;
        }
        return index;
    }
    //This function returns the row or column index of a city
    // It returns -1 if the city is not found.
    // It uses a newer switch expression to find the city index
    static private int CityIndex(String city)
    {
        int index = -1;
        switch (city.toUpperCase())
        {
            case "CHICAGO" -> index = 0;
            case "BOSTON" -> index = 1;
            case "NEW YORK" -> index = 2;
            case "ATLANTA" -> index = 3;
            case "MIAMI" -> index = 4;
            case "DALLAS" -> index = 5;
            case "HOUSTON" -> index = 6;
        }
        return index;
    }    
}
