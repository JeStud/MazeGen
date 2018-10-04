package rectMaze;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testMaze {

	Maze test;
	
	@BeforeEach
	void setUp()
	{
		test = Maze.depthFirstGen(3, 3);
	}
	
	@Test
	void testNodeCreation() {
		Maze.Node n = new test.Node();
	}
}
