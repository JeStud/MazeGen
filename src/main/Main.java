package main;

import java.awt.Color;

import rectMaze.Maze;
import graphics.Graphics;

public class Main {

	public static void main(String[] args) {
		Maze maze = Maze.depthFirstGen(20, 20, true);
		//maze.display();
		Graphics.export(maze, "D:\\Data\\WinFolders\\Desktop\\pic.png", 10, Color.decode("#ff90e3"), Color.decode("#90ffc6"));
	}
}
