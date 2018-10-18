package frames;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Error extends JFrame {
	
	public Error(String problem)
	{
		JPanel content = new JPanel();
		this.setContentPane(content);
		content.setOpaque(true);
		
		JLabel err = new JLabel(problem);
		content.add(err);
		err.setFont(new Font("Serif", Font.BOLD, 48));
		err.setForeground(Color.RED);
		
		this.pack();

		this.setTitle("Error");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
}
