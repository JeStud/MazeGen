package main;

import java.awt.Color;

import rectMaze.Maze;

public class Main {

	public static void main(String[] args) {
		Maze maze = Maze.depthFirstGen(2000, 1100, true, 4);
		//maze.display();
		maze.export("D:\\Data\\WinFolders\\Desktop\\pic.png", 4, Color.decode("#ff90e3"), Color.decode("#90ffc6"));
	}
}
