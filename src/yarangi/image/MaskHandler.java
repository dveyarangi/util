package yarangi.image;

public interface MaskHandler
{
	public void apply(Mask source, int sx, int sy, Mask target, int tx, int ty);
}
