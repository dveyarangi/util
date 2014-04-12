package yarangi.math;

public class Pair <E>
{
	private E first;
	private E second;
	
	public Pair (E first, E second)
	{
		this.first = first;
		this.second = second;
	}
	
	public E first() { return first; }
	public E second() { return second; }
	
	@Override
	public String toString()
	{ 
		return new StringBuilder().append( "(" ).append(first).append("; ").append(second).append(")")
			.toString();
	}
	
	@Override
	public int hashCode()
	{
		return first.hashCode() ^ second.hashCode();
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(o == null)
			return false;
		if(o == this)
			return true;
		if( ! (o instanceof Pair))
			return false;
		
		Pair that = (Pair) o;
		return this.first.equals( that.first ) && this.second.equals( that.second );
	}
}
