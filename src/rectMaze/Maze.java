package rectMaze;

public class Maze
{
	int height, width;
	Node[][] mazetrix;
	
	//INNER CLASSES
	public class Node
	{
		Direction[] connections;
		Boolean visited = false;
		
		private Node()
		{
			connections = new Direction[4];
		}
		/*
		private Node( Direction[] directions )
		{
			connections = new Direction[4];
			try {
				for(int i=0;i<directions.length;i++)
				{
					this.connections[i] = directions[i];
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Directions-Array too large");
			}
		}
		*/
		public void draw(){}
		
		private Boolean getVisited()
		{
			return this.visited;
		}
		private void setVisited(Boolean v)
		{
			this.visited = v;
		}
	}
	
	private enum Direction {
	    UP(1,0), RIGHT(0,1), DOWN(-1,0), LEFT(0,-1);
	    private int y,x;

	    private Direction(int y, int x) {
	            this.y = y;
	            this.x = x;
	    }
	    
	    private int getX()
	    {
	    	return this.x;
	    }
	    private int getY()
	    {
	    	return this.y;
	    }
	}
	
	//CREATION
	private Maze(int height, int width)
	{
		this.height = height;
		this.width = width;
		this.mazetrix = new Node[height][width];
		for(int y=0;y<height;y++)
		{
			for(int x=0;x<width;x++)
			{
				
			}
		}
	}
	
	public static Maze depthFirstGen(int height, int width)
	{
		Maze maze = new Maze(height, width);
		
		//TODO: Generate a maze
		return maze;
	}
	
	//GETTERS
	public Node getNode(int x,int y)
	{
		return this.mazetrix[y][x];
	}
	
	
	//SETTERS
	private void setNode(Node n, int x, int y)
	{
		this.mazetrix[y][x] = n;
	}
}
