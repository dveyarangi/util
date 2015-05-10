package yarangi.numbers;

import java.util.Random;

public class RandomUtil
{

	private static Random random = new Random();

	public static int N(final int n)
	{
		return random.nextInt(n) ;
	}

	public static double getRandomDouble(final double d) {
		return d*random.nextDouble();
	}
	public static float getRandomFloat(final float d) {
		return d*random.nextFloat();
	}

	/**
	 * Normal distribution around mean
	 * @param mean
	 * @param sigma
	 * @return
	 */
	public static float STD(final float mean, final float sigma)
	{
		return mean + sigma * (float)random.nextGaussian();
	}
	/**
	 * Normal distribution around mean
	 * @param mean
	 * @param sigma
	 * @return
	 */	public static float ASTD(final float mean, final float sigma)
	{
		return mean + (float)Math.abs(sigma * random.nextGaussian());
	}	/**
	 * Normal distribution around mean
	 * @param mean
	 * @param sigma
	 * @return
	 */	public static double STD(final double mean, final double sigma)
	{
		return mean + sigma * random.nextGaussian();
	}
	/**
	 * Uniform distribution around mean
	 * @param mean
	 * @param span
	 * @return
	 */
	public static double U(final double mean, final double span)
	{
		return mean + random.nextDouble()*2*span - span;
	}

	/**
	 * 1/num probability of true
	 * @param num
	 * @return
	 */
	public static boolean oneOf(final int num)
	{
		return N(num) == 0;
	}

	/**
	 * Uniform random number from 0 to p
	 * @param p
	 * @return
	 */
	public static boolean P(final float p) {
		assert p >= 0 && p <= 1;
		return random.nextFloat() <= p;
	}

	public static float R(final float d)
	{
		return d*random.nextFloat();
	}

	public static int sign()
	{
		return RandomUtil.oneOf( 2 ) ? 1 : -1;
	}
}
