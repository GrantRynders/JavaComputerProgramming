
package statistics;

/**
 *
 * @author grant rynders
 */
public class Statistics
{
    private double[] data;
    private double min, max, sum = 0, sumsq = 0;
    private double mean, median, range, standardDeviation, variance;
    int count;

    public Statistics(double[] DataArray)
    {
        data = DataArray;
        ComputeStatistics();
    }

    private void ComputeStatistics()
    {
        count = data.length;
        min = data[0];
        max = data[0];
        for (int i = 0; i < count; i++)
        {
            sum += data[i];
            sumsq += Math.pow(data[i],2);
            if (data[i] < min)
                min = data[i];
            if (data[i] > max)
                max = data[i];
        }
        mean = sum/count;
        if (count % 2 == 0)
            median = (data[count/2]+data[count/2-1])/2;
        else
            median = data[count/2];
        range = max - min;
        variance = (sumsq-count*Math.pow(mean,2))/(count - 1);
        standardDeviation = Math.sqrt(variance);
    }

    public double[] getData()
    {
        return data;
    }

    public double getMin()
    {
        return min;
    }

    public double getMax()
    {
        return max;
    }

    public double getSum()
    {
        return sum;
    }

    public double getMean()
    {
        return mean;
    }

    public double getMedian()
    {
        return median;
    }

    public double getStandardDeviation()
    {
        return standardDeviation;
    }

    public double getVariance()
    {
        return variance;
    }
    public double getSumsq()
    {
        return sumsq;
    }

    public double getRange()
    {
        return range;
    }

    public int getCount()
    {
        return count;
    }
}





