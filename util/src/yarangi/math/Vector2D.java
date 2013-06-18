package yarangi.math;

import yarangi.java.InvokationMapper;

/**
 * Implementation of bi-dimensional vector.
 * TODO: compile vector math expressions?
 * TODO: vector pool

 * @author Dve Yarangi
 * 
 */
public class Vector2D implements IVector2D
{
	private static final long serialVersionUID = 3043592649139743124L;
	
	/**
	 *  x 
	 */
	private double x;
	
	/**
	 *  y 
	 */
	private double y;
	
	/**
	 * Vector counter. 
	 * TODO: instrumentate in debug mode instead
	 * TODO: overflow!
	 */
	private static int count = 0;
	
	private static InvokationMapper amap = new InvokationMapper();
	
	/**
	 * Creates a new zero vector.
	 * @return
	 */
	public static Vector2D ZERO() { return new Vector2D(0,0); }
	
	/**
	 * Constant for undefined vector.
	 */
	public static final Vector2D NOWHERE = new Vector2D(Double.NaN, Double.NaN);

	/**
	 * @return Total vectors created.
	 */
	public static int getCount() { return count; }
	
	/**
	 * Create a new vector with specified coordinate values.
	 * @param x
	 * @param y
	 */
	protected Vector2D(double x, double y) 
	{
//		amap.record();
		
		this.x = x;
		this.y = y;
		assert 0 <++ count;
	}
	
	public static Vector2D R(double x, double y)
	{
		return new Vector2D(x, y);
	}

	/**
	 * Creates a vector that originates at (x,y), has a length r and direction a.  
	 * @param ox - origin x
	 * @param oy - origin y
	 * @param r - length
	 * @param a - direction (radians
	 */
	public static Vector2D POLAR(double ox, double oy, double r, double a)
	{
		count ++;
		return new Vector2D(ox+r*Math.cos(a), oy+r*Math.sin(a));
	}
	
	/**
	 * Creates a vector
	 * @param a - x or r
	 * @param b - y or a
	 * @param radial if true, a and b a are considered radial coordinates.
	 */
	public static Vector2D POLAR(double r, double thet)
	{
		count ++;
		return new Vector2D(r*Math.cos(thet), r*Math.sin(thet));
	}
	
	/**
	 * Creates a vector
	 * @param a - x or r
	 * @param b - y or a
	 * @param radial if true, a and b a are considered radial coordinates.
	 */
	public static Vector2D UNIT(double thet)
	{
		count ++;
		return new Vector2D(Math.cos(thet), Math.sin(thet));
	}
	
	/**
	 * Copy the specified vector.
	 * @param x
	 * @param y
	 */
	public static Vector2D COPY(IVector2D v) 
	{
		count ++;
		return new Vector2D(v.x(), v.y());
	}

	/**
	 * {@inheritDoc}
	 */
	public double getCoord(int dim) {
		switch(dim)
		{
		case 0: return x;
		case 1: return y;
		default:
			throw new IllegalArgumentException("Coord dimension out of range.");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	final public double x() { return x; }

	/**
	 * {@inheritDoc}
	 */
	@Override
	final public double y() { return y; }
	
	final public void setx(double x) { this.x = x; }
	final public void sety(double y) { this.y = y; }
	final public Vector2D setxy(double x, double y)
	{
		setx(x); sety(y);
		return this;
	}
	final public Vector2D set(IVector2D from)
	{
		setx(from.x()); sety(from.y());
		return this;
	}
	/**
	 * Calculates vector length.
	 * @return
	 */
	@Override
	final public double abs() { return Math.sqrt(x*x+y*y); }

	final public double absSquare()
	{
		return x*x+y*y;
	}	
	/**
	 * @return Normalized vector.
	 */
	final public Vector2D normal()
	{
//		if(normalized) return;
		
		double l = this.abs();
		if(l == 0)
			return new Vector2D(0,0);
		return new Vector2D(x/l, y/l);
	}
	
	/**
	 * Normalizes this vector.
	 * <li>Note: this operation changes current vector
	 */
	final public Vector2D normalize()
	{
		double l = this.abs();
		if(l == 0)
			return this;
		this.x = x/l;
		this.y = y/l;
		
		return this;
	}
	
	/**
	 * Calculates dot product.
	 * @param v
	 * @return
	 */
	final public double dot(Vector2D v)
	{
		return x*v.x + y*v.y;
	}
	
	/**
	 * Calculates Z component of cross product of two extended (z=0) vectors
	 * @param v
	 * @return
	 */
	@Override
	final public double crossZComponent(IVector2D v)
	{
		return crossZComponent( v.x(), v.y() );
	}
	@Override
	final public double crossZComponent(double x, double y)
	{
		return crossZComponent(this.x, this.y, x, y);
	}
	final static public double crossZComponent(double x1, double y1, double x2, double y2)
	{
		return x1 * y2 - y1 * x2;
	}
	
	/**
	 * Calculates vector sum
	 * @param v
	 * @return
	 */
	final public Vector2D plus(Vector2D v)
	{
		return new Vector2D(x+v.x, y+v.y);
	}
	/**
	 * Calculates vector sum
	 * @param v
	 * @return
	 */
	final public Vector2D plus(double x, double y)
	{
		return new Vector2D(this.x+x, this.y+y);
	}
	
	/**
	 * Adds the values to this vector
	 * <li>Note: this operation changes current vector
	 * @param v
	 * @return
	 */
	final public Vector2D add(IVector2D v)
	{
		this.x += v.x();
		this.y += v.y();
		
		return this;
	}

	/**
	 * Adds the values to this vector
	 * <li>Note: this operation changes current vector
	 * @param v
	 * @return
	 */
	final public Vector2D add(double x, double y) {
		this.x += x;
		this.y += y;
		return this;
	}
	
	/**
	 * Calculates vector difference
	 * @param iVector2D
	 * @return
	 */
	@Override
	final public Vector2D minus(IVector2D vector2D)
	{
		return new Vector2D(x-vector2D.x(), y-vector2D.y());
	}
	/**
	 * Calculates vector difference
	 * @param v
	 * @return
	 */
	final public Vector2D minus(double x, double y)
	{
		return new Vector2D(this.x-x, this.y-y);
	}
	
	/**
	 * <li>Note: this operation changes current vector
	 * @param v
	 */
	final public Vector2D substract(IVector2D v)
	{
		this.x -= v.x();
		this.y -= v.y();
		
		return this;
	}
	
	/**
	 * <li>Note: this operation changes current vector
	 * @param v
	 */
	final public Vector2D substract(double x, double y)
	{
		this.x -= x;
		this.y -= y;
		
		return this;
	}
	
	/**
	 * Calculates vector negative.
	 * @return
	 */
	final public Vector2D minus() 
	{ 
		return new Vector2D(-x, -y); 
	}
	
	/**
	 * <li>Note: this operation changes current vector
	 */
	final public void inverse()
	{
		this.x = -x;
		this.y = -y;
	}
	
	/**
	 * Calculates vector multiplication product
	 * @param d
	 * @return
	 */
	final public Vector2D mul(double d)
	{
		return new Vector2D(d*x,d*y);
	}
	
	/**
	 * Multiplies self by specified value.
	 * <li>Note: this operation changes current vector
	 * @param d
	 */
	final public Vector2D multiply(double d)
	{
		this.x *= d;
		this.y *= d;
		return this;
	}
	
	/**
	 * Rotates vector by specified quantity of radians.
	 * @param a
	 * @return
	 */
	final public Vector2D rotate(double a)
	{
		double cosa = Math.cos(a);
		double sina = Math.sin(a);
		return new Vector2D(x*cosa - y*sina, x*sina + y*cosa );
	}

	/**
	 * @return New vector, rotated by 90 counter-clockwise
	 */
	@Override
	final public Vector2D left() { return new Vector2D(-y, x); }
	
	/**
	 * @return New vector, rotated by 90 clockwise
	 */
	final public Vector2D right() { return new Vector2D(y, -x); }
	
	/**
	 * Calculates vector angle (radians). 
	 * @return
	 */
	final public double getAngle() { return Math.atan2(y, x); }
	
	
	/**
	 * {@inheritDoc}
	 */
	public int size() { return 2; }
	
	@Override
	public boolean equals(Object o)
	{
		if(!(o instanceof IVector2D))
			return false;
		
		IVector2D vec = (IVector2D) o;
		return x == vec.x() && y == vec.y();
	}
	
	/**
	 * @return display string representation of this vector
	 */
	@Override
	public String toString() 
	{ 
		return new StringBuilder()
			.append("v(").append(this.x).append(",").append(this.y).append(")")
			.toString(); 
	}
	
	// TODO: make it faster
	@Override
	public int hashCode()
	{
		return new Double(x).hashCode() ^ new Double(y).hashCode();
	}

}