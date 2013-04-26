package yarangi.math;

public class Histogram
{
	public static double x2(double [] h1, double [] h2)
	{
		double sum = 0;
		for(int i = 0; i < h1.length; i ++)
			if(h1[i] != 0)
				sum += FastMath.powOf2((h1[i]-h2[i]))/h1[i];
		
		return sum;
	}
	
	public static float x2(float [] h1, float [] h2)
	{
		float sum = 0;
		for(int i = 0; i < h1.length; i ++)
			if(h1[i] != 0)
				sum += FastMath.powOf2((h1[i]-h2[i]))/h1[i];
			
		return sum;
	}
	public static float x2(int [] h1, int [] h2)
	{
		float sum = 0;
		for(int i = 0; i < h1.length; i ++)
			if(h1[i] != 0)
				sum += FastMath.powOf2((float)((h1[i]-h2[i]))/(float)h1[i]);
		
		return sum;
	}
}
