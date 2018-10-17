package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import rectMaze.Maze;

public class Drawing
{
	public static BufferedImage draw(Maze m, int cellSize, Color backCol, Color foreCol)
	{
		BufferedImage pic = new BufferedImage( (2*m.getWidth()+1)*cellSize, (2*m.getHeight()+1)*cellSize, BufferedImage.TYPE_INT_ARGB);
		Graphics g = pic.getGraphics();
		
		m.draw(g, backCol, foreCol, cellSize);
		
		return pic;
	}
	
	public static void export(Maze m, String path, int cellSize, Color backCol, Color foreCol)
	{		
		try {
			ImageIO.write( draw(m, cellSize, backCol, foreCol), "PNG", new File(path) );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
