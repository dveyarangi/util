/**
 * 
 */
package yarangi.math.curves;

import yarangi.math.Vector2D;


/**
 * @author dveyarangi
 *
 */
public interface ParametricCurve
{
	public Vector2D at(Vector2D target, float t);
}
