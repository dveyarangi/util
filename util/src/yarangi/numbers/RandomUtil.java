package yarangi.numbers;

import java.util.Random;

public class RandomUtil 
{

	private static Random random = new Random();
	
	public static int getRandomInt(int n)
	{ 
		return random.nextInt(n) ;
	}

	public static double getRandomDouble(double d) {
		return d*random.nextDouble();
	}
	
	/**
	 * Normal distribution around mean
	 * @param mean
	 * @param sigma
	 * @return
	 */
	public static float N(float mean, float sigma)
	{
		return mean + sigma * (float)random.nextGaussian();
	} 
	public static double N(double mean, double sigma)
	{
		return mean + sigma * random.nextGaussian();
	} 
	/**
	 * Uniform distribution around mean
	 * @param mean
	 * @param span
	 * @return
	 */
	public static double U(double mean, double span)
	{
		return mean + random.nextDouble()*2*span - span;
	} 
	
	/**
	 * 1/num probability of true
	 * @param num
	 * @return
	 */
	public static boolean oneOf(int num)
	{
		return getRandomInt(num) == 0;
	}
	
	/**
	 * Uniform random number from 0 to p
	 * @param p
	 * @return
	 */
	public static boolean P(float p) {
		assert p >= 0 && p <= 1;
		return random.nextFloat() <= p;
	}

	public static float R(float d)
	{
		return d*random.nextFloat();
	}
}
