package frames;

import java.awt.Dimension;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import rectMaze.Maze;

public class Display extends JFrame
{
	private final int MAX_WIDTH = 1900;
	private final int MAX_HEIGHT = 1000;
	private final int MIN_WIDTH = 200;
	private final int MIN_HEIGHT = 150;

	public Display(int x, int y, int cellSize, Maze m)
	{
		int tempX = x*cellSize+2;
		int tempY = y*cellSize+21;
		if(tempX<MIN_WIDTH)
			tempX = MIN_WIDTH;
		if(tempY<MIN_HEIGHT)
			tempY = MIN_HEIGHT;
		if(tempX>MAX_WIDTH)
			tempX = MAX_WIDTH;
		if(tempY>MAX_HEIGHT)
			tempY = MAX_HEIGHT;

		this.setTitle("Display Maze");
		//this.setSize(tempX, tempY);
		
		JPanel panel = new JPanel();
		this.add(panel);
		panel.setPreferredSize(new Dimension(tempX, tempY));
		panel.setOpaque(true);
		this.pack();
		
		Graphics2D g2d = (Graphics2D) panel.getGraphics();
		m.draw(g2d, 10);
		//this.paint(g2d);
		this.repaint();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
