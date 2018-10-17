package graphics;

import java.awt.Graphics;

import javax.swing.JPanel;

import rectMaze.Maze;

public class MazePanel extends JPanel {
	Maze maze;
	
	public void paint(Graphics g)
	{
		maze.draw(g, 10);
	}
}
