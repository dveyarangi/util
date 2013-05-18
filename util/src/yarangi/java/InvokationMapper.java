package yarangi.java;

import gnu.trove.iterator.TObjectIntIterator;
import gnu.trove.map.hash.TObjectIntHashMap;


/**
 * Helps to determine object allocation cause,
 * TODO: use by either javaagent or annotation
 */
public class InvokationMapper

{
	
	protected TObjectIntHashMap<String> rootsCount = new TObjectIntHashMap<String> (); 

	/**
	 * Marks object allocation event.
	 * @param depth - depth of method invoker to trace
	 */
	public boolean record(int depth)
	{
		if(rootsCount == null)
			rootsCount = new TObjectIntHashMap<String> ();
		String root = new Exception().getStackTrace()[depth].toString();
		if(rootsCount.contains( root ))
			rootsCount.adjustValue( root, 1 );
		else
			rootsCount.put( root, 1 );
		
		return true;
	}
	
	/**
	 * Prints allocation distribution.
	 */
	public void print()
	{
		TObjectIntIterator<String> it = rootsCount.iterator();
		while(it.hasNext())
		{
			it.advance();
			System.out.println(it.value() + " >>> " + it.key());
			
		}
	}
}
