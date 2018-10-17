package helperClasses;

import java.util.HashSet;

import helperClasses.Direction;

public class RectNode
{
	public HashSet<Direction> connections;
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
