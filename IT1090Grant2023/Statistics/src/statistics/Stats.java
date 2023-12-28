
package statistics;

import java.util.Scanner;

/**
 *
 * @author grant rynders
 */
public class Stats
{
    public static void main(String[] args)
    {
        double dataSet[];
        Statistics stats;

        dataSet = getData();
        stats = new Statistics(dataSet);

        System.out.println();
        printStatistics(stats);
    }

    private static void printStatistics(Statistics stats)
    {
        System.out.printf("%-10s %s%n", "Count:",stats.getCount());
        System.out.printf("%-10s %.2f%n", "Sum:",stats.getSum());
        System.out.printf("%-10s %.2f%n", "Minimum:",stats.getMin());
        System.out.printf("%-10s %.2f%n", "Maximum:",stats.getMax());
        System.out.printf("%-10s %.2f%n", "Mean:",stats.getMean());
        System.out.printf("%-10s %.2f%n", "Median:",stats.getMedian());
        System.out.printf("%-10s %.2f%n", "Variance:",stats.getVariance());
        System.out.printf("%-10s %.2f%n", "Std Dev:",stats.getStandardDeviation());
        System.out.printf("%-10s %.2f%n", "Range:",stats.getRange());
    }

    private static double[] getData()
    {
        int n;
        double[] dataArray;
        Scanner sc = new Scanner(System.in);
        double value;

        System.out.print("How many data points? ");
        n = sc.nextInt();
        dataArray = new double[n];

        for (int i = 1; i <= n; i++)
        {
            System.out.print("Data point " + i +": ");
            dataArray[i-1] = sc.nextDouble();
        }
        return dataArray;
    }
}
