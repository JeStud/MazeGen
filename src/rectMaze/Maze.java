package rectMaze;

import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Stack;

public class Maze
{
	private int height, width;
	private Node[][] mazetrix;
	
	//INNER CLASSES
	public class Node
	{
		HashSet<Direction> connections;
		Boolean unvisited = true;
		
		private Node()
		{
			connections = new HashSet<Direction>();
		}

		public void draw(){}
		
		private Boolean isUnvisited()
		{
			return this.unvisited;
		}
		private void setUnvisited(Boolean v)
		{
			this.unvisited = v;
		}
		
		private void addDirection(Direction newDirection)
		{
			connections.add(newDirection);
		}
		private void removeDirection(Direction delDirection)
		{
			connections.remove(delDirection);
		}
		private void clearDirections()
		{
			connections = new HashSet<Direction>();
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
				this.mazetrix[y][x] = new Node();
			}
		}
	}

	//GENERATION
	public static Maze depthFirstGen(int height, int width)
	{
		//definitions
		Maze maze = new Maze(height, width);
		Stack<Direction> steps = new Stack<Direction>();
		Random rand = new Random();
		
		Stack<Direction> defaultDirections = new Stack<Direction>();
			defaultDirections.add(Direction.UP);
			defaultDirections.add(Direction.RIGHT);
			defaultDirections.add(Direction.DOWN);
			defaultDirections.add(Direction.LEFT);
		Stack<Direction> availableDirections;
		Direction tempDirection;
		Node tempNode;
		
		int y, x;
		
		//TODO: Generate a maze
		//set a start point
		y = rand.nextInt(height);
		x = rand.nextInt(width);
		
		//create loop (do while steps not empty?)
		do
		{
			//reset directions set
			availableDirections = new Stack<Direction>();
			availableDirections.addAll(defaultDirections);
			Collections.shuffle(availableDirections);
			
			do
			{
				//choose a random direction
				tempDirection = availableDirections.pop();
				tempNode = maze.getNode(x+tempDirection.getX(), y+tempDirection.getY());
				//if works
				if( tempNode.isUnvisited() )
				{
					tempNode.addDirection(tempDirection);
					steps.push(tempDirection);
					y = y + tempDirection.getY();
					x = x + tempDirection.getX();
				}
			} while( !availableDirections.empty() );
			try
			{
				tempDirection = steps.pop();
				x = x+tempDirection.getX();
				y = y+tempDirection.getY();
			}
			catch (RuntimeException EmptyStackException)
			{
				System.err.println("No steps in the stack");
				//let the program just die
			}
			
		} while( steps.size()>0 );
		
		return maze;
	}
	
	//GETTERS
	public Node getNode(int x,int y)
	{
		return this.mazetrix[y][x];
	}
	
	public int getHeight()
	{
		return this.height;
	}
	public int getWidth()
	{
		return this.width;
	}
	
	//SETTERS
	private void setNode(Node n, int x, int y)
	{
		this.mazetrix[y][x] = n;
	}
}
