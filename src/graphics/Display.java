package graphics;

import java.awt.Graphics2D;

import javax.swing.JFrame;

import rectMaze.Maze;

public class Display extends JFrame
{
	private final int MAX_WIDTH = 1920;
	private final int MAX_HEIGHT = 1080;

	public Display(int x, int y, Maze m)
	{
		this.setTitle("Some title");
		
		int tempX, tempY;
		if(x>MAX_WIDTH)
			tempX = MAX_WIDTH;
		else
			tempX = x;
		if(y>MAX_HEIGHT)
			tempY = MAX_HEIGHT;
		else
			tempY = y;
		
		this.setSize(x,y);
		this.setDefaultCloseOperation(Windows.EXIT_ON_CLOSE);
		
		Graphics2D g2d = (Graphics2D) this.getGraphics();
		m.draw(g2d, 10);
		this.paint( g2d );
		
		this.setVisible(true);
	}
}
