package com.playmaker.football.data;

import android.graphics.Color;

public class Route
{
	private int color;
	private Path path;
	private Player player;
	
	public Route(int color, Path p, Player player)
	{
		this.color = color;
		this.path = p;
		this.player = player;
	}
	
	public Route(int color, Path p)
	{
		this.color = color;
		this.path = p;
	}
	
	public Route(int color, int numberOfPointsInPath)
	{
		this.color = color;
		path = new Path(numberOfPointsInPath);
	}
	
	public Route()
	{
		color = Color.BLACK;
		path = new Path();
	}
	
	public void setPlayer(Player player)
	{
		this.player = player;
	}
	
	public void setColor(int color)
	{
		this.color = color;
	}
	
	public void setPath(Path path)
	{
		this.path = path;
	}
	
	public void addPoint(Point point)
	{
		if(path.isFull())
		{
			Path newPath = new Path(path.getPoints().length + 1);
			newPath.setPoints(path.getPoints());
			
			path = newPath;
		}
		
		path.addPoint(point);
	}
	
	public int getColor()
	{
		return color;
	}
	
	public Path getPath()
	{
		return path.clone();
	}
	
	public Player getPlayer()
	{
		return player;
	}
}
