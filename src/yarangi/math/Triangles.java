/**
 *
 */
package yarangi.math;


/**
 * @author dveyarangi
 *
 */
public class Triangles
{
	/**
	 * Calculates the missing third vertex of triangle, one which is located clockwise from a->b vector.
	 *
	 * @param a vertex of triangle
	 * @param A length of edge opposite to vertex a
	 * @param b vertex of triangle
	 * @param B length of edge opposite to vertex b
	 * @param target result
	 * @return target
	 */
/*	public static Vector2 calcFromVertices(final Vector2 a, final float A, final Vector2 b, final float B, final Vector2 target, final boolean cw)
	{
		// vector from a to b
		Vector2 c = Vector2.tmp.set( b ).sub( a );
		float C = c.len();

		// normalizing
		c.div( C );
		Vector2 cr = cw ? Vector2.tmp2.set( -c.y, c.x ) : Vector2.tmp2.set( c.y, -c.x );

		// length of projection of B on c
		float proj = (B*B + C*C - A*A) / (2*C);

		target.set( a )
			.add( c.mul( proj ) )
			.add( cr.mul( (float)Math.sqrt( B*B - proj*proj ) ) );

		return target;
	}

	public static boolean ccwFrom(final Vector2 a, final Vector2 b, final Vector2 p)
	{
		return Vector2D.crossZComponent( b.x - a.x, b.y - a.y, p.x - a.x, p.y - a.y ) > 0;
	}

	public static boolean cwFrom(final Vector2 a, final Vector2 b, final Vector2 p)
	{
		return Vector2D.crossZComponent( b.x - a.x, b.y - a.y, p.x - a.x, p.y - a.y ) < 0;
	}*/

	public static boolean pointInTriangle(final IVector2D p, final IVector2D a, final IVector2D b, final IVector2D c)
	{
		return pointInTriangleSameSide(p, a, b, c);
	}


	/**
	 * Checking that cross products between following vectors pairs have the same sign:
	 * <li> vertex(n+1) - vertex(n)
	 * <li> point - vertex(n)
	 *
	 * (basically, angle between the pair of vectors have similar clockwise offset direction)
	 *
	 * @param p - tested point
	 * @param a - triangle vertex A
	 * @param b - triangle vertex B
	 * @param c - triangle vertex C
	 * @return
	 */
	private static boolean pointInTriangleSameSide(final IVector2D p, final IVector2D a, final IVector2D b, final IVector2D c)
	{
		double cross1 = (b.x() - a.x()) * (p.y() - a.y()) - (b.y() - a.y()) * (p.x() - a.x());
		double cross2 = (c.x() - b.x()) * (p.y() - b.y()) - (c.y() - b.y()) * (p.x() - b.x());
		double cross3 = (a.x() - c.x()) * (p.y() - c.y()) - (a.y() - c.y()) * (p.x() - c.x());

		return cross1 <= 0 && cross2 <= 0 && cross3 <= 0
			|| cross1 >= 0 && cross2 >= 0 && cross3 >= 0;
	}

/*	private static Vector2 calcCirrcumcentre(final Vector2 result, final Vector2 v1, final Vector2 v2, final Vector2 v3)
	{
		float Ax = v2.x - v1.x;
		float Ay = v2.y - v1.y;
		float Bx = v3.x - v1.x;
		float By = v3.y - v1.y;
		float Cx = v3.x - v1.x;
		float Cy = v3.y - v1.y;

		float a = (Cx*Cx+Cy*Cy) * (Ax*Bx+Ay*By) /
				  (2 * )
		return this.x * y - this.y * x;


		result.set( v1 ).add( x, y )
	}*/


/*	public static void main(final String ... args)
	{
		Vector2 target = new Vector2();
		calcFromVertices( new Vector2(0, 0), 4.24f, new Vector2(6, 0), 4.24f, target, true );
		System.out.println(target);
	}*/
}
