package yarangi.math;


public class Geometry
{

	public static void main(final String [] args)
	{
//		System.out.println(pointInTriangleSameSide( new Vector2D(2,1), new Vector2D(0,0), new Vector2D(0,1), new Vector2D(2,1) ));
//		System.out.println(calcDistanceToLine(Vector2D.ZERO(), Vector2D.R(-1, 1), Vector2D.R(5, 0)));
		System.out.println(pointInCircumCirle( new Vector2D(-0.5,0.5), new Vector2D(-2,0), new Vector2D(0,2), new Vector2D(2,0) ));
	}


	/**
	 * Calculates distance value square.
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static double calcHypotSquare(final IVector2D v1, final IVector2D v2)
	{
		return calcHypotSquare(v1.x(), v1.y(), v2.x(), v2.y());
	}

	public static double calcHypotSquare(final double x1, final double y1, final double x2, final double y2)
	{
		double dx = x2 - x1;
		double dy = y2 - y1;
		return dx*dx + dy*dy;
	}

	public static double calcHypot(final IVector2D v1, final IVector2D v2)
	{
		return calcHypot(v1.x(), v1.y(), v2.x(), v2.y());
	}

	public static double calcHypot(final double x1, final double y1, final double x2, final double y2)
	{

		return Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
	}

	/**
	 *
	 *
	 * @param p point
	 * @param la line anchor
	 * @param d line direction
	 * @return
	 */
	public static double calcDistanceToLine(final IVector2D P, final IVector2D Q, final IVector2D v)
	{
		return P.minus(Q).abs() / v.left().abs();
	}

	public static double calcTriangleArea(final double x1, final double y1, final double x2, final double y2, final double x3, final double y3)
	{
		return (x1*y2-x2*y1 + x2*y3-x3*y2 - x3*y1-x1*y3) / 2;
	}

	public static boolean isLeft(final double px, final double py, final double x1, final double y1, final double x2, final double y2)
	{
		return calcTriangleArea(x1, y1, x2, y2, px, py) > 0;
	}

	/**
	 * A, B, and C must be ordered clockwise.
	 * @param p
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public static boolean pointInCircumCirle(final IVector2D p, final IVector2D a, final IVector2D b, final IVector2D c )
	{
		return pointInCircumCirle( p.x(), p.y(), a.x(), a.y(), b.x(), b.y(), c.x(), c.y() );
	}
	public static boolean pointInCircumCirle(final double px, final double py, final double x1, final double y1, final double x2, final double y2, final double x3, final double y3)
	{
		double d1 = x1*x1+y1*y1;
		double d2 = x2*x2+y2*y2;
		double d3 = x3*x3+y3*y3;
		double pd = px*px+py*py;
		return determinant(x2, y2, d2, x3, y3, d3, px, py, pd)
		     - determinant(x1, y1, d1, x3, y3, d3, px, py, pd)
		     + determinant(x1, y1, d1, x2, y2, d2, px, py, pd)
		     - determinant(x1, y1, d1, x2, y2, d2, x3, y3, d3) < 0;
	}

	public static double determinant(final double x1, final double y1, final double x2, final double y2)
	{
		return x1*y2 - x2*y1;
	}

	public static double determinant(final double x1, final double y1, final double z1, final double x2, final double y2, final double z2, final double x3, final double y3, final double z3)
	{
		return x1 * (y2*z3 - y3*z2) - x2 * (y1*z3 - y3*z1) + x3 * (y1*z2 - y2*z1);
	}

	/**
	 * Calculates the intersection point from P + s * u = Q + t * v
	 *
	 * @param P - first line anchor point.
	 * @param u - first line direction vector.
	 * @param Q - second line anchor point.
	 * @param v - second line direction vector.
	 * @return intersection point vector, null if parallel
	 * TODO: watch for failures
	 */
	public static Vector2D calcIntersection(final Vector2D P, final Vector2D u, final Vector2D Q, final Vector2D v)
	{
		Vector2D w = P.minus(Q);
		double perp = v.x() * u.y() - v.y() * u.x();
		if(perp == 0)
			return null;

		double s = (v.y() * w.x() - v.x() * w.y()) / perp;

		return Vector2D.R(P.x() + u.x() * s, P.y() + u.y() * s);
	}

	/**
	 * Calculates the intersection coefficients s and t, such as  P + s * u = Q + t * v
	 * @param P - first line anchor point.
	 * @param u - first line direction vector.
	 * @param Q - second line anchor point.
	 * @param v - second line direction vector.
	 * @return Vector2D object, whose x element is equal to s and y equal to t; null if parallel
	 */
	public static Vector2D calcIntersectionParams(final Vector2D P, final Vector2D u, final Vector2D Q, final Vector2D v)
	{
		Vector2D w = P.minus(Q);
		double perp = v.x() * u.y() - v.y() * u.x();
		if(perp == 0)
			return null;
		// TODO: sort out math:
		double s = (v.y() * w.x() - v.x() * w.y()) / perp;
		double t = (u.y() * w.x() - u.x() * w.y()) / (u.x() * v.y() - u.y() * v.x());

		return Vector2D.R(s, t);
	}

	@Deprecated
	public static boolean pointInTriangle(final IVector2D p, final IVector2D a, final IVector2D b, final IVector2D c)
	{
		return Triangles.pointInTriangle(p, a, b, c);
	}


}
