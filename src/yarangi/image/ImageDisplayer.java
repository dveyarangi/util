package yarangi.image;

import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class ImageDisplayer
{
	JFrame frame = new JFrame();
	
	ImageIcon icon;
	
	BufferedImage image;
	
	BufferedImage atlas;
	Graphics2D graphics;
	
	int width, height;

	public ImageDisplayer(final BufferedImage img) throws IOException
	{
		this.image = img;
		this.width = img.getWidth();
		this.height = img.getHeight();
		
		atlas = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		
		graphics = atlas.createGraphics();
		
		getGraphics().drawImage(image, null, 0, 0);
	
		ImageIcon icon = new ImageIcon( atlas );
		frame.setLayout( new FlowLayout() );
//		frame.setSize( img.getWidth(), img.getHeight() );
		JLabel lbl = new JLabel( icon );

		frame.add( lbl );
		frame.validate();
		frame.pack();
		frame.setVisible( true );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	
	public int getWidth() { return image.getWidth(); }
	public int getHeight() { return image.getWidth(); }
	
	public Graphics2D getGraphics() {
		return graphics;
	}
	
	public void refresh() {
		frame.repaint();
	}
}
