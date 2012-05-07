package yarangi.spatial.grids;

import yarangi.spatial.GridMap;
import yarangi.spatial.Tile;

public class PolygonGridMap extends GridMap <Tile <TilePoly>, TilePoly>
{

	public PolygonGridMap(int cellSize, float width, float height)
	{
		super( cellSize, width, height );
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Tile<TilePoly> createEmptyCell(int idx, double x, double y)
	{
		return new Tile <TilePoly> (x, y, getCellSize(), getCellSize());
	}

	@Override
	protected Tile<TilePoly>[] createMap(int cellSize, int width, int height)
	{
		return (Tile <TilePoly> []) new Tile [width*height];
	}

	@Override
	protected final int indexAtTile(int i, int j)
	{
		return  i + getGridWidth() * j;
	}

}
