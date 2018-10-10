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
	private class Node
	{
		HashSet<Direction> connections;
		Boolean unvisited = true;
		
		private Node()
		{
			connections = new HashSet<Direction>();
		}
		
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
		Node tempNode, lastNode;
		
		int y, x;
		
		//set a start point
		y = rand.nextInt(height);
		x = rand.nextInt(width);
		lastNode = maze.getNode(x, y);
		
		//main generation loop: takes a step and ends when there are no more steps possible
		do
		{
			//reset directions set
			availableDirections = new Stack<Direction>();
			availableDirections.addAll(defaultDirections);
			//shuffle the directions so that they are in a random order
			Collections.shuffle(availableDirections);
			
			//directions loop: tries random directions until it finds one (and then repeats) or ends, where a step will be popped
			do
			{
				//try to go to a random node
				tempDirection = availableDirections.pop();
				tempNode = maze.getNode(x+tempDirection.getX(), y+tempDirection.getY());
				//if the node works
				if( tempNode != null && tempNode.isUnvisited() )
				{
					//add the connection to the maze
					lastNode.addDirection(tempDirection);

					//remember the direction we went
					steps.push(tempDirection);
					
					//change all the local variables for the next iteration
					lastNode = tempNode;
					y = y + tempDirection.getY();
					x = x + tempDirection.getX();
					
					//reset directions set
					availableDirections = new Stack<Direction>();
					availableDirections.addAll(defaultDirections);
				}
			} while( !availableDirections.empty());
			
			//pop the last step taken, and step out
			try
			{
				tempDirection = steps.pop();
				x = x - tempDirection.getX();
				y = y - tempDirection.getY();
				lastNode = maze.getNode(x, y);
			}
			//in case of emergency, run around screaming
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
		try
		{
			return this.mazetrix[y][x];
		}
		catch (RuntimeException EmptyStackException)
		{
			return null;
		}
	}
	
	public int getHeight()
	{
		return this.height;
	}
	public int getWidth()
	{
		return this.width;
	}
}
