package rectMaze;

public class Main {

	public static void main(String[] args) {
		Maze maze = Maze.depthFirstGen(10, 10, true);
		maze.display();
		maze.export("D:\\Data\\WinFolders\\Desktop\\pic.png", 20);
	}

}
