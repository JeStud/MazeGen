package frames;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import graphics.MazePanel;
import rectMaze.Maze;

public class Display extends JFrame
{
	private final int MAX_WIDTH = 1900;
	private final int MAX_HEIGHT = 1000;
	private final int MIN_WIDTH = 200;
	private final int MIN_HEIGHT = 150;
	
	private Maze maze;
	private int cellSize;

	private class MazesPanel extends JPanel
	{			
		public void paint(Graphics g)
		{
			maze.draw(g, cellSize);
		}
	}
	
	public Display(int x, int y, int cellSize, Maze maze)
	{
		this.maze = maze;
		this.cellSize = cellSize;
		
		int tempX = (2*x+1)*cellSize;
		int tempY = (2*y+1)*cellSize;
		if(tempX<MIN_WIDTH)
			tempX = MIN_WIDTH;
		if(tempY<MIN_HEIGHT)
			tempY = MIN_HEIGHT;
		if(tempX>MAX_WIDTH)
			tempX = MAX_WIDTH;
		if(tempY>MAX_HEIGHT)
			tempY = MAX_HEIGHT;

		this.setTitle("Display Maze");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		MazesPanel panel = new MazesPanel();
		this.setContentPane(panel);
		panel.setPreferredSize(new Dimension(tempX, tempY));
		panel.setOpaque(true);
		this.pack();
		
		Graphics g = this.getGraphics();
	}
}