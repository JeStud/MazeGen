package main;

import java.awt.Color;
import java.awt.Frame;

import rectMaze.Maze;
import graphics.Graphics;
import graphics.Windows;

public class Main {

	public static void main(String[] args) {
		Frame f = new Windows();
		
		Maze maze = Maze.depthFirstGen(20, 20, true);

		Graphics.export(maze, "D:\\Data\\WinFolders\\Desktop\\pic.png", 10, Color.decode("#ff90e3"), Color.decode("#90ffc6"));
	}
}
