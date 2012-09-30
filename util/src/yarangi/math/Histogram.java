package yarangi.math;

public class Histogram
{
	public static double x2(double [] h1, double [] h2)
	{
		double sum = 0;
		for(int i = 0; i < h1.length; i ++)
			sum += FastMath.powOf2((h1[i]-h2[i]))/h1[i];
		
		return sum;
	}
}
