package graphics;

import java.awt.Button;
import java.awt.CardLayout;

import javax.swing.JFrame;

public class Windows extends JFrame
{
	
	/*
	private Button death = new Button("death");
	private Button life = new Button("life");
	private Button useless = new Button("-_-");
	*/
	private Button something = new Button("something");
	private CardLayout myLayout = new CardLayout();
	
	public Windows()
	{
		this.setTitle("Some title");
		this.setSize(384,216);
		/*
		this.setLayout(myLayout);
		this.add(death);
		this.add(life);
		this.add(useless);
		*/
		/*
		this.add(death, BorderLayout.EAST);
		this.add(life, BorderLayout.WEST);
		this.add(useless, BorderLayout.CENTER);
		*/
		this.add(something);
		this.setDefaultCloseOperation(Windows.EXIT_ON_CLOSE);
		
		/*
		ActionListener dListen = new DeathListener();
		death.addActionListener(dListen);
		ActionListener lListen = new LifeListener();
		life.addActionListener(lListen);
		*/

		this.setVisible(true);
	}
}
