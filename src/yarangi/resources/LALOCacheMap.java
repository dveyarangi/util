package yarangi.resources;

import java.util.LinkedHashMap;

public class LALOCacheMap <K, V> extends LinkedHashMap <K, V>
{
	public V get(Object key) 
	{
		V val = super.get(key);
		if(val == null)
			return null;
		
		super.put( (K)key, val );
		
		return val;
	}
}
