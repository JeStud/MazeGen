package rectMaze;

import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testMaze {

	Maze test;
	
	@BeforeEach
	void setUp()
	{
		test = Maze.depthFirstGen(3, 3, true);
	}
	
	@Test
	void testNodeCreation() {
		assertFalse(test.getNode(0, 0) == null);
	}
}
