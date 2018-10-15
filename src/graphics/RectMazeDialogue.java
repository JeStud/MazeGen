package graphics;

import java.awt.Button;
import java.awt.CardLayout;

import javax.swing.JFrame;

public class RectMazeDialogue extends JFrame
{
	private Button something = new Button("something");
	private CardLayout myLayout = new CardLayout();
	
	public RectMazeDialogue()
	{
		this.setTitle("Some title");
		this.setSize(384,216);

		this.add(something);
		this.setDefaultCloseOperation(Windows.EXIT_ON_CLOSE);
		
		this.setVisible(true);
	}
}
