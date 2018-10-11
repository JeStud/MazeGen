package rectMaze;

public class Main {

	public static void main(String[] args) {
		Maze maze = Maze.depthFirstGen(3, 3, true);
		maze.displayMaze();
	}

}
