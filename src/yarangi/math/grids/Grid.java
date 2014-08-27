package yarangi.math.grids;




public abstract class Grid <E>
{

	/**
	 */
	protected E [] grid;

	/**
	 *
	 */
	protected int dim;

	public Grid(final int dim)
	{
		if(dim <= 0) throw new IllegalArgumentException("Size must be positive");
		this.dim = dim;


		grid = createGrid( dim );
	}

	protected abstract E [] createGrid( int dim );

	public void put(final int x, final int y, final E value)
	{
		grid[index(x,y)] = value;
	}
	public void put( final GridIndex cell, final E value )
	{
		put(cell.x(), cell.y(), value);
	}

	public E at(final int x, final int y)
	{
		return grid[index(x,y)];
	}
	public E at(final GridIndex cell)
	{
		return grid[index(cell.x(), cell.y())];
	}
	/**
	 * Create grid index from x-y array index
	 * @param x
	 * @param y
	 * @return
	 */
	protected int index(final int x, final int y)
	{
		return x + y * dim;
	}

	protected final boolean isInvalidIndex( final int x, final int y )
	{
		return x < 0 || x >= dim || y < 0 || y >= dim;
	}

	public class Cell implements GridIndex
	{
		int x = -1, y = 0;

		public E next()
		{
			x ++;
			if(x >= dim)
			{
				x = 0;
				y ++;
			}

			return at( x, y );
		}

		public boolean hasNext() { return !isInvalidIndex( x+1, y ); }

		public E value() { return at( x, y ); }
		@Override
		public int x() { return x; }
		@Override
		public int y() { return y; }
	}


	public Cell iterator()
	{
		return new Cell();
	}

	public int dim() { return dim; }
}