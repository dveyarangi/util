package yarangi.spatial;

/**
 * Sensor that picks a single object from the indexer.
 * @param <K> indexer ojbects type
 */
public class PickingSensor <K extends ISpatialObject> implements ISpatialSensor <K> 
{
	
	/**
	 * Object filter
	 */
	private ISpatialFilter <K> filter;
	
	/**
	 * Object picked during last indexer query.
	 */
	private K object;
	
	private double x, y;
	
	private double minDist = Double.MAX_VALUE;
	
	public PickingSensor(double x, double y)
	{
		this(x, y, null);
	}
	
	public PickingSensor(double x, double y, ISpatialFilter <K> filter)
	{
		this.x = x;
		this.y = y;
		this.filter = filter;
	}

	@Override
	public boolean objectFound(K object) 
	{
		if(filter == null || filter.accept( object ))
		{
			if(object.getArea().contains(x, y)) {
				this.object = object;
				return true;
			}
//			double dist = (object.getArea().getAnchor().x() - x) * (object.getArea().getAnchor().x() - x) +
//						  (object.getArea().getAnchor().y() - y) * (object.getArea().getAnchor().y() - y);
//			if(minDist > dist) {
//				this.minDist = dist;
//			}
//			return false; // terminating query
		}
		
		return false;
	}
	
	/**
	 * @return Object picked in last indexer query with this sensor. 
	 */
	public K getObject() { return object; }

	@Override
	public void clear()
	{
		object = null;
		minDist = Double.MAX_VALUE;
	}

}
