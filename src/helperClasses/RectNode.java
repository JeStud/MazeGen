package helperClasses;

import java.util.HashSet;

import helperClasses.Direction;

//nodes or cells in a maze
public class RectNode
{
	//directions to connected nodes
	public HashSet<Direction> connections;
	//whether the node is part of the maze yet
	public Boolean unvisited = true;
	
	public RectNode()
	{
		connections = new HashSet<Direction>();
	}
	
	public Boolean isUnvisited()
	{
		return this.unvisited;
	}
	public void setUnvisited(Boolean v)
	{
		this.unvisited = v;
	}
	
	public void addDirection(Direction newDirection)
	{
		connections.add(newDirection);
	}
	public void removeDirection(Direction delDirection)
	{
		connections.remove(delDirection);
	}
	public void clearDirections()
	{
		connections = new HashSet<Direction>();
	}
}
