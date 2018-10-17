package eavesdropper;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JFormattedTextField;

import frames.Display;
import graphics.Drawing;
import rectMaze.Maze;

public class RectMazeListener implements ActionListener
{
	private JFormattedTextField cellField = new JFormattedTextField(NumberFormat.getNumberInstance());
	private JFormattedTextField widthField = new JFormattedTextField(NumberFormat.getNumberInstance());
	private JFormattedTextField heightField = new JFormattedTextField(NumberFormat.getNumberInstance());
	private JFormattedTextField backgroundColorField = new JFormattedTextField("000000");
	private JFormattedTextField foregroundColorField = new JFormattedTextField("FFFFFF");
	private JFormattedTextField pathField = new JFormattedTextField("D:\\Data\\WinFolders\\Desktop\\pic.png");

	@Override
	public void actionPerformed(ActionEvent e) {
		int x, y, cellSize;
		Color bkClr, frClr;
		String path;
		//get field values and generate maze
		//check if the cell/width/height is an int and save as cellSize, x and y
		try
			{ cellSize = Integer.parseInt( cellField.getText() ); }
		catch(NumberFormatException exceptX)
			{ cellSize = 10;/*TODO display an error pop up*/ }
		try
			{ x = Integer.parseInt( widthField.getText() ); }
		catch(NumberFormatException exceptX)
			{ x = 1;/*TODO display an error pop up*/ }
		try
			{ y = Integer.parseInt( heightField.getText() ); }
		catch(NumberFormatException exceptY)
			{ y = 1;/*TODO display an error pop up*/ }
		//check if the fore/background are Colors and save as bkClr and frClr
		try
			{ bkClr = Color.decode("#" + backgroundColorField.getText() ); }
		catch(NumberFormatException exceptBK)
			{ bkClr = Color.BLUE;/*TODO display an error pop up*/ }
		try
			{ frClr = Color.decode("#" + foregroundColorField.getText() ); }
		catch(NumberFormatException exceptFR)
			{ frClr = Color.RED;/*TODO display an error pop up*/ }
		try
			{ path = pathField.getText(); }
		catch(NumberFormatException exceptFR)
			{ path = "D:\\\\Data\\\\WinFolders\\\\Desktop\\\\pic.png";/*TODO display an error pop up*/ }
		
		Maze maze = Maze.depthFirstGen(y, x, true);
		Display d = new Display(x, y, bkClr, frClr, cellSize, maze);
		Drawing.export(maze, path, cellSize, bkClr, frClr);
		
		//call a function that opens a window with the maze
		//call a function that opens a window with an export option and then returns
	}
	
	public JFormattedTextField getCellField()
	{
		return this.cellField;
	}
	public JFormattedTextField getWidthField()
	{
		return this.widthField;
	}
	public JFormattedTextField getHeightField()
	{
		return this.heightField;
	}
	public JFormattedTextField getBackgroundColorField()
	{
		return this.backgroundColorField;
	}
	public JFormattedTextField getForegroundColorField()
	{
		return this.foregroundColorField;
	}
	public JFormattedTextField getPathField()
	{
		return this.pathField;
	}
}
