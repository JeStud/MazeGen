package eavesdropper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Simple class that simply closes the program
public class ExitListener implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}	
}
