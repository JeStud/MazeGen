package graphics;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;

import eavesdropper.RectMazeListener;

public class RectMazeDialogue extends JFrame
{
	private Button send = new Button("enter");
	
	private static final int HORIZONTAL_GAP = 10;
    private static final int VERTICAL_GAP = 10;
	private static FlowLayout flow = new FlowLayout(FlowLayout.CENTER, HORIZONTAL_GAP, VERTICAL_GAP);
	
	private RectMazeListener rectMazeListener = new RectMazeListener();
	
	public RectMazeDialogue()
	{
		JFormattedTextField widthField = rectMazeListener.getWidthField();
		JFormattedTextField heightField = rectMazeListener.getHeightField();
		JFormattedTextField backgroundColorField = rectMazeListener.getBackgroundColorField();
		JFormattedTextField foregroundColorField = rectMazeListener.getForegroundColorField();
		
		this.setTitle("Some title");
		this.setSize(384,216);
		this.setLayout(flow);

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
		
		this.add(send);
		send.addActionListener( rectMazeListener );
		
		this.setDefaultCloseOperation(Windows.EXIT_ON_CLOSE);
		
		this.setVisible(true);
	}
}
