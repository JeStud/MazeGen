package frames;

import java.awt.Button;
import java.awt.FlowLayout;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;

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
		JFormattedTextField cellField = rectMazeListener.getCellField();
		JFormattedTextField widthField = rectMazeListener.getWidthField();
		JFormattedTextField heightField = rectMazeListener.getHeightField();
		JFormattedTextField backgroundColorField = rectMazeListener.getBackgroundColorField();
		JFormattedTextField foregroundColorField = rectMazeListener.getForegroundColorField();
		JFormattedTextField pathField = rectMazeListener.getPathField();

		this.setTitle("Some title");
		this.setSize(600, 200);
		this.setLayout(flow);

		this.add(cellField);
		cellField.setValue(5);
		cellField.setColumns(5);
		this.add(widthField);
		widthField.setValue(10);
		widthField.setColumns(5);
		this.add(heightField);
		heightField.setValue(10);
		heightField.setColumns(5);

		this.add(backgroundColorField);
		backgroundColorField.setColumns(5);
		this.add(foregroundColorField);
		foregroundColorField.setColumns(5);
		this.add(pathField);
		pathField.setColumns(50);

		this.add(send);
		send.addActionListener( rectMazeListener );
		this.add(exit);
		exit.addActionListener( exitListener );

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setVisible(true);
	}
}
