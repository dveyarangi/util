package yarangi.spatial;

import java.util.HashSet;

public class SetSensor <K extends ISpatialObject> extends HashSet <K> implements ISpatialSensor <K> 
{

	private static final long serialVersionUID = 9025712177585233445L;

	@Override
	public boolean objectFound(K object) 
	{
		add(object);
		
		return false;
	}

}
