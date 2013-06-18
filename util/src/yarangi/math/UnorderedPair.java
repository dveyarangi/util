package yarangi.math;

/**
 * Unordered (regarding the hashcode and comparison) pair of elements
 * @author dveyarangi
 *
 * @param <M>
 */
public class UnorderedPair <M>
{
	private M m1;
	private M m2;
	
	public UnorderedPair(M m1, M m2)
	{
		this.m1 = m1;
		this.m2 = m2;
	}
	
	public M getFirst() { return m1; }
	public M getSecond() { return m2; }
	
	@Override
	public int hashCode() { return m1.hashCode() ^ m2.hashCode(); }
	
	@Override
	public boolean equals(Object o)
	{
		if(o == null)
			return false;
		if(o == this)
			return true;
		if(!(o instanceof UnorderedPair))
			return false;
					
		UnorderedPair <M> that = (UnorderedPair<M>) o;
		
		if(this.m1.equals( that.m1 ) && this.m2.equals( that.m2 ))
			return true;
		
		if(this.m1.equals( that.m2 ) && this.m2.equals( that.m1 ))
			return true;
		
		return false;
	}
	
	@Override
	public String toString()
	{
		return new StringBuilder()
			.append(m1).append( ";" ).append(m2)
			.toString();
	}
}