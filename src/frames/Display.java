package frames;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import rectMaze.Maze;

public class Display extends JFrame
{
	private final int MAX_WIDTH = 1900;
	private final int MAX_HEIGHT = 1000;
	
	private Maze maze;
	private int cellSize;
	Color bkCol, frCol;

	private class MazePanel extends JPanel
	{
		public void paint(Graphics g)
		{
			maze.draw(g, bkCol, frCol, cellSize);
		}
	}
	
	public Display(int x, int y, Color bkCol, Color frCol, int cellSize, Maze maze)
	{
		this.maze = maze;
		this.cellSize = cellSize;
		this.bkCol = bkCol;
		this.frCol = frCol;
		
		int tempX = (2*x+1)*cellSize;
		int tempY = (2*y+1)*cellSize;
		if(tempX>MAX_WIDTH)
			tempX = MAX_WIDTH;
		if(tempY>MAX_HEIGHT)
			tempY = MAX_HEIGHT;

		this.setTitle("Display Maze");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		MazePanel panel = new MazePanel();
		this.setContentPane(panel);
		panel.setPreferredSize(new Dimension(tempX, tempY));
		panel.setOpaque(true);
		this.pack();
	}
}