/**
 * 
 */
package yarangi.math.curves;

import yarangi.math.Vector2D;

/**
 * @author dveyarangi
 *
 */
public class ParametricLine implements ParametricCurve
{

	@Override
	public Vector2D at(Vector2D target, float t) {
		// TODO Auto-generated method stub
		return null;
	}
/*	private Vector2 dir = new Vector2();
	private Vector2 start = new Vector2();
	
	public ParametricLine()
	{
	}
	
	public ParametricLine(Vector2 start, Vector2 end)
	{
		set(start, end);
	}
	
	public void set(Vector2 start, Vector2 end)
	{
		
		this.start.set(start);
		
		dir.set(end).sub(start);
	}

	@Override
	public Vector2 at(Vector2 target, float t)
	{
		return target.set( dir ).mul( t ).add( start );
	}*/
	
}
