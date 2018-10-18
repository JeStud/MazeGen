package frames;

import java.awt.Button;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import eavesdropper.ExitListener;
import eavesdropper.RectMazeListener;

public class RectMazeDialogue extends JFrame
{
	private Button send = new Button("enter");
	private Button exit = new Button("exit");
	
	private static final int HORIZONTAL_GAP = 10;
    private static final int VERTICAL_GAP = 10;
	private static FlowLayout flow = new FlowLayout(FlowLayout.CENTER, HORIZONTAL_GAP, VERTICAL_GAP);
	
	private RectMazeListener rectMazeListener = new RectMazeListener();
	private ExitListener exitListener = new ExitListener();
	
	public RectMazeDialogue()
	{
		JPanel cellField = rectMazeListener.getCell();
		JPanel widthField = rectMazeListener.getWidth();
		JPanel heightField = rectMazeListener.getHeight();
		JPanel backgroundColorField = rectMazeListener.getBackgroundColor();
		JPanel foregroundColorField = rectMazeListener.getForegroundColor();
		JPanel pathField = rectMazeListener.getPath();

		this.setTitle("Some title");
		this.setSize(600, 200);
		this.setLayout(flow);

		this.add(cellField);
		this.add(widthField);
		this.add(heightField);
		this.add(backgroundColorField);
		this.add(foregroundColorField);
		this.add(pathField);

		this.add(send);
		send.addActionListener( rectMazeListener );
		this.add(exit);
		exit.addActionListener( exitListener );

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setVisible(true);
	}
}
