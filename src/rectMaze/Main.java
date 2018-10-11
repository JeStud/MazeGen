package rectMaze;

public class Main {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		Maze maze = Maze.depthFirstGen(5000, 5000, true);
		long endTime = System.nanoTime();

		long duration = (endTime - startTime);
		System.out.println(duration);
	}

}
