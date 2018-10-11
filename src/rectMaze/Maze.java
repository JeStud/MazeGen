package rectMaze;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Stack;

import javax.imageio.ImageIO;

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
	    UP(-1,0,"^"), RIGHT(0,1,">"), DOWN(1,0,"v"), LEFT(0,-1,"<");
	    private int y,x;
	    private String pointer;

	    private Direction(int y, int x, String pointer) {
	            this.y = y;
	            this.x = x;
	            this.pointer = pointer;
	    }
	    
	    private int getX()
	    {
	    	return this.x;
	    }
	    private int getY()
	    {
	    	return this.y;
	    }
	    private String getPointer()
	    {
	    	return this.pointer;
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
	public static Maze depthFirstGen(int height, int width, boolean randStart)
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
		if(randStart)
		{
			y = rand.nextInt(height);
			x = rand.nextInt(width);
		}
		else
		{
			y = 0;
			x = 0;
		}
		lastNode = maze.getNode(y, x);
		lastNode.setUnvisited(false);
		
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
				tempNode = maze.getNode(y+tempDirection.getY(), x+tempDirection.getX());
				//if the node works
				if( tempNode != null && tempNode.isUnvisited() )
				{
					//add the connection to the maze
					lastNode.addDirection(tempDirection);

					//remember the direction we went
					steps.push(tempDirection);
					
					//change all the local variables for the next iteration
					lastNode = tempNode;
					lastNode.setUnvisited(false);
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
				lastNode = maze.getNode(y, x);
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

	//DISPLAY
	public void display()
	{
		for(int y=0;y<height;y++)
		{
			for(int x=0;x<width;x++)
			{
				Node tempNode = this.getNode(y, x);
				System.out.print("[");
				for(Direction direction : tempNode.connections)
				{
					System.out.print( direction.getPointer() );
				}
				System.out.print("] ");
				
				System.out.print(x+","+y+"(");
				
				if(tempNode.isUnvisited())
				{
					System.out.print("iU)");
				}
				else
				{
					System.out.print("iV)");
				}
			}
			System.out.print("\n");
		}
	}
	
	public void export(String path, int cellSize)
	{
		BufferedImage pic = new BufferedImage( (2*this.width+1)*cellSize, (2*this.height+1)*cellSize, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = (Graphics2D) pic.getGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, (2*this.width+1)*cellSize, (2*this.height+1)*cellSize);
		g.setColor(Color.WHITE);
		
		for(int y=0;y<height;y++)
		{
			for(int x=0;x<width;x++)
			{
				Node tempNode = this.getNode(y, x);
				g.fillRect((2*x+1)*cellSize, (2*y+1)*cellSize, cellSize, cellSize);
				
				for(Direction direction : tempNode.connections)
				{
					g.fillRect( ((2*x+1) + direction.getX())*cellSize, ((2*y+1) + direction.getY())*cellSize, cellSize, cellSize);
				}
			}
		}
		
		try {
			ImageIO.write(pic, "PNG", new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//GETTERS
	public Node getNode(int y,int x)
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
