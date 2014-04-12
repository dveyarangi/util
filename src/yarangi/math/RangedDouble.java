package yarangi.math;

public class RangedDouble 
{
	private double min;
	private double max;
	private double curr;
	
	public RangedDouble(double min, double curr, double max)
	{
		if ( min > max )
			throw new IllegalArgumentException("Range limits are not consistent (min: " + min + ", max: " + max + ").");
		
		this.min = min;
		this.max = max;
		
		this.curr = curr;
	}
	
	public RangedDouble(double min, double max)
	{
		this(min, (max-min)/2+min, max);
	}
	
	public void setDouble(double curr) 
	{
		this.curr = curr;
		if (curr < min)
			curr = min;
		else if(curr > max)
			curr = max;
	}
	
	public double getDouble() { return curr; }

	
	public double getMin() { return min; }
	public void setMin(double min) { this.min = min; }
	public double getMax() { return max; }
	public void setMax(double max) { this.max = max; }
	
	@Override
	public String toString()
	{
		return new StringBuilder()
			.append("value: ").append(curr)
			.append(" range: [").append(min).append("-").append(max).append("]")
			.toString();
	}
}