package yarangi.math;

/**
 * Abstract for immutable bi-dimensional vector
 * 
 * @author Dve Yarangi
 */
public interface IVector2D
{
	/**
	 * @return Abscissa value.
	 */
	public abstract double x();
	
	/**
	 * @return Ordinate value
	 */
	public abstract double y();

	public Vector2D minus(IVector2D vec);

	public abstract Vector2D left();

	public abstract double abs();
	
	public double crossZComponent(IVector2D v);
	public double crossZComponent(double x, double y);

}
