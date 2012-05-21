package yarangi.spatial;


public final class Tile <O> implements ITile <O>
{
	
	/** 
	 * tile index 
	 */
	private int i, j;
	private double minx, miny;
	private double maxx, maxy ;
	
	private O content;

	public Tile(int i, int j, double x, double y, double width, double height)
	{
		this.i = i;
		this.j = j;
		this.minx = x;
		this.miny = y;
		this.maxx = x + width;
		this.maxy = y + height;
	}
	
	public int i() { return i; }
	public int j() { return j; }
	
/*	public Tile(O content, double x, double y)
	{
		
		this.x = x;
		this.y = y;
		
		this.content = content;
	}*/
	
	public boolean put(O content)
	{
		if(this.content != content) {
			this.content = content;
			return true;
		}
		
		return false;
	}
	public O get()
	{
		return content;
	}

	public double getX() { return minx; }

	public double getY() { return miny; }
//	
//	public int i() { return i; }
//	
//	public int j() { return j; }

	public <T extends ITile<O>> boolean query(ISpatialSensor<T, O> sensor, int queryId)
	{
		if(content != null)
			return sensor.objectFound( (T)this, content );
		return false;
	}
	@Override
	public boolean remove(O object)
	{
		if(this.content != null) 
		{
			content = null;
			return true;
		}
		
		return false;
	}
	
	public boolean overlaps(double xmin, double ymin, double xmax, double ymax)
	{
		return ( (xmax >= minx && xmax <= maxx) ||
			     (xmin >= minx && xmin <= maxx) ||
			     (xmin >= minx && xmax <= maxx) ||
			     (xmin <= minx && xmax >= maxx)    
			  ) && ( 
			     (ymax >= miny && ymax <= maxy) ||
			     (ymin >= miny && ymin <= maxy) ||
			     (ymin >= miny && ymax <= maxy) ||
			     (ymin <= miny && ymax >= maxy)    
			   );
	}

	public double getMinX() { return minx; }
	public double getMinY() { return miny; }
	public double getMaxX() { return maxx; }
	public double getMaxY() { return maxy; }

	@Override
	public Area getArea()
	{
		return null;
	}
	
	public String toString() {
		return new StringBuilder()
			.append("Tile [ idx: (").append( i ).append( "," ).append(j).append(")")
			.append(", minx: ").append(minx)
			.append(", miny: ").append(miny)
			.append(", maxx: ").append(maxx)
			.append(", maxy: ").append(maxy)
			.append("]").toString();
			
	}

}
