package graphics;

import java.awt.Button;
import java.awt.CardLayout;

import javax.swing.JFrame;

public class Windows extends JFrame
{
	private Button something = new Button("something");
	private CardLayout myLayout = new CardLayout();
	
	public Windows()
	{
		this.setTitle("Some title");
		this.setSize(384,216);

		this.add(something);
		this.setDefaultCloseOperation(Windows.EXIT_ON_CLOSE);
		
		this.setVisible(true);
	}
}