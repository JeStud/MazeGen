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
	private final int cellSize = 10;
	private final String path = "D:\\Data\\WinFolders\\Desktop\\pic.png";
	
	private JFormattedTextField widthField = new JFormattedTextField(NumberFormat.getNumberInstance());
	private JFormattedTextField heightField = new JFormattedTextField(NumberFormat.getNumberInstance());
	private JFormattedTextField backgroundColorField = new JFormattedTextField("000000"); //TODO needs the # added on to the front
	private JFormattedTextField foregroundColorField = new JFormattedTextField("FFFFFF"); //TODO needs the # added on to the front
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int x, y;
		Color bkClr, frClr;
		//get field values and generate maze
		//check if the width/height is an int and save as x and y
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
		
		Maze maze = Maze.depthFirstGen(y, x, true);
		Display d = new Display(x, y, cellSize, maze);
		Drawing.export(maze, path, cellSize, bkClr, frClr);
		
		//call a function that opens a window with the maze
		//call a function that opens a window with an export option and then returns
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
}
