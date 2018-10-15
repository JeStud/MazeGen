package graphics;

import javax.swing.JFrame;

public class Display extends JFrame
{
	private final int MAX_WIDTH = 1920;
	private final int MAX_HEIGHT = 1080;

	public Display(int x, int y)
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
		
		this.setVisible(true);
	}
}
