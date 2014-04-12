package yarangi.math.triangulation;

import java.util.List;

import yarangi.math.IVector2D;

public interface ITriangulator
{
	public TriangleStore triangulate(List <IVector2D> points);
}
