package yarangi.image;

public class ColorUtil
{

	public static int toARGB(final int a, final int r, final int g, final int b)
	{
		return (a << 24) + (r << 16) + (g << 8) + b;
	}
	public static int toRGBA8888(final int a, final int r, final int g, final int b)
	{
		return (r << 24) + (g << 16) + (b << 8) + a;
	}


}
