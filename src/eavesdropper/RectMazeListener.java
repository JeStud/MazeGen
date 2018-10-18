package eavesdropper;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

import frames.Display;
import graphics.Drawing;
import rectMaze.Maze;

public class RectMazeListener implements ActionListener
{
	private JFormattedTextField  cellField = new JFormattedTextField ("5");
	private JFormattedTextField  widthField = new JFormattedTextField ("10");
	private JFormattedTextField  heightField = new JFormattedTextField ("10");
	private JFormattedTextField  backgroundColorField = new JFormattedTextField ("000000");
	private JFormattedTextField  foregroundColorField = new JFormattedTextField ("FFFFFF");
	private JFormattedTextField  pathField = new JFormattedTextField ("D:\\Data\\WinFolders\\Desktop\\pic.png");
	
	JLabel cellLabel = new JLabel("Cell Size");
	JLabel widthLabel = new JLabel("Maze Width");
	JLabel heightLabel = new JLabel("Maze Height");
	JLabel backgroundLabel = new JLabel("Background Color");
	JLabel foregroundLabel = new JLabel("Foreground Color");
	JLabel pathLabel = new JLabel("System Path (+file name)");
	
	private JPanel cellPanel = new JPanel();
	private JPanel widthPanel = new JPanel();
	private JPanel heightPanel = new JPanel();
	private JPanel backgroundPanel = new JPanel();
	private JPanel foregroundPanel = new JPanel();
	private JPanel pathPanel = new JPanel();

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
	
	public JPanel getCell()
	{
		cellPanel.setLayout(new BorderLayout());
		cellPanel.add(cellLabel, BorderLayout.NORTH);
		cellPanel.add(cellField, BorderLayout.SOUTH);
		return this.cellPanel;
	}
	public JPanel getWidth()
	{
		widthPanel.setLayout(new BorderLayout());
		widthPanel.add(widthLabel, BorderLayout.NORTH);
		widthPanel.add(widthField, BorderLayout.SOUTH);
		return this.widthPanel;
	}
	public JPanel getHeight()
	{
		heightPanel.setLayout(new BorderLayout());
		heightPanel.add(heightLabel, BorderLayout.NORTH);
		heightPanel.add(heightField, BorderLayout.SOUTH);
		return this.heightPanel;
	}
	public JPanel getBackgroundColor()
	{
		backgroundPanel.setLayout(new BorderLayout());
		backgroundPanel.add(backgroundLabel, BorderLayout.NORTH);
		backgroundPanel.add(backgroundColorField, BorderLayout.SOUTH);
		return this.backgroundPanel;
	}
	public JPanel getForegroundColor()
	{
		foregroundPanel.setLayout(new BorderLayout());
		foregroundPanel.add(foregroundLabel, BorderLayout.NORTH);
		foregroundPanel.add(foregroundColorField, BorderLayout.SOUTH);
		return this.foregroundPanel;
	}
	public JPanel getPath()
	{
		pathPanel.setLayout(new BorderLayout());
		pathField.setColumns(50);
		pathPanel.add(pathLabel, BorderLayout.NORTH);
		pathPanel.add(pathField, BorderLayout.SOUTH);
		return this.pathPanel;
	}
}
