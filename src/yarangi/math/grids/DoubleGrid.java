package yarangi.math.grids;





public class DoubleGrid
{

	/**
	 */
	protected double [] grid;

	/**
	 *
	 */
	protected int dim;

	public DoubleGrid(final int dim)
	{
		if(dim <= 0) throw new IllegalArgumentException("Size must be positive");
		this.dim = dim;


		grid = new double[dim*dim];
	}

	public void put(final int x, final int y, final double value)
	{
		grid[index(x,y)] = value;
	}
	public void put( final GridIndex cell, final double value )
	{
		put(cell.x(), cell.y(), value);
	}

	public double at(final int x, final int y)
	{
		return grid[index(x,y)];
	}
	public double at(final GridIndex cell)
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

	public final boolean isInvalidIndex( final int x, final int y )
	{
		return x < 0 || x >= dim || y < 0 || y >= dim;
	}

	public class DCell implements GridIndex
	{
		int x = -1, y = 0;

		public double next()
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

		public double value() { return at( x, y ); }
		@Override
		public int x() { return x; }
		@Override
		public int y() { return y; }
	}


	public DCell iterator()
	{
		return new DCell();
	}


}