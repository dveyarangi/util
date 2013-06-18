package yarangi.math;

import java.util.Comparator;

public class LexicographicComparator implements Comparator <IVector2D>
{
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compare(IVector2D v1, IVector2D v2)
	{
		if(v1.x() < v2.x())
			return -1;
		if(v1.x() > v2.x())
			return 1;
		
		// xes are equal:
		if(v1.y() < v2.y())
			return -1;
		if(v1.y() > v2.y())
			return 1;
		
		  // yes are equal:
		return 0;
	}
	
}