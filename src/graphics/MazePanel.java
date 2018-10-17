package graphics;

import javax.swing.JPanel;

import java.awt.Graphics2D;

public class MazePanel extends JPanel {
	public void paintComponent(Graphics2D g2d)
	{
		//draw on g here e.g.
		g2d.fillRect(20, 20, 100, 200);
	}
}
