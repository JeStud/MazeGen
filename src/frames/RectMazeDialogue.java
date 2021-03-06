package frames;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import eavesdropper.ExitListener;
import eavesdropper.RectMazeListener;

//main frame, contains all fields and drives everything
public class RectMazeDialogue extends JFrame
{
	//generation and quit JButtons
	private JButton send = new JButton("generate new maze");
	private JButton exit = new JButton("exit program");
	
	//niceness things for the layout
	private static final int HORIZONTAL_GAP = 10;
    private static final int VERTICAL_GAP = 10;
	private static FlowLayout flow = new FlowLayout(FlowLayout.CENTER, HORIZONTAL_GAP, VERTICAL_GAP);
	
	//listeners for the generate and quit JButtons
	private RectMazeListener rectMazeListener = new RectMazeListener();
	private ExitListener exitListener = new ExitListener();
	
	public RectMazeDialogue()
	{
		//get the panels that we need to display
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
		this.setResizable(false);
		this.setVisible(true);
	}
}
