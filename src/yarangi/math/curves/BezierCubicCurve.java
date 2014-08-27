package yarangi.math.curves;

import yarangi.math.Vector2D;


public class BezierCubicCurve implements ParametricCurve
{
	private final Vector2D p1, p2, p3, p4;

	private final Vector2D at1 = Vector2D.ZERO();
	private final Vector2D at2 = Vector2D.ZERO();
	private final Vector2D at3 = Vector2D.ZERO();
	private final Vector2D at4 = Vector2D.ZERO();

	public BezierCubicCurve(final Vector2D p1, final Vector2D p2, final Vector2D p3, final Vector2D p4)
	{
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.p4 = p4;
	}

	@Override
	public Vector2D at(final Vector2D target, final float t)
	{
		float f = 1 - t;

		target.set( at1.set(p1).mul(f*f*f).add(
			   at2.set(p2).mul(3*f*f*t)).add(
			   at3.set(p3).mul(3*f*t*t)).add(
			   at4.set(p4).mul(t*t*t)) );

		return target;
	}

	public Vector2D p1() { return p1; }
	public Vector2D p2() { return p2; }
	public Vector2D p3() { return p3; }
	public Vector2D p4() { return p4; }
}
