package com.playmaker.football.data;

public class Path implements Cloneable
{
	private Point[] points;
	private int lastIndex;
	
	public Path(Point[] points)
	{
		this.points = points;
		this.lastIndex = points.length;
	}
	
	public Path(int size)
	{
		this.lastIndex = 0;
		this.points = new Point[size];
	}
	
	public Path()
	{
		points = null;
		lastIndex = 0;
	}
	
	public void addPoint(Point point)
	{
		if(points == null || lastIndex == points.length)
			System.exit(0);
		
		points[lastIndex] = point;
		lastIndex++;
	}
	
	public void clear()
	{
		for(int i = 0; i < points.length; i++)
		{
			points[i] = null;
		}
		
		this.lastIndex = 0;
	}
	
	public void setPoints(Point[] points)
	{
		int i;
		
		if(this.points.length == points.length)
		{
			this.points = points;
		}
		else if(this.points.length > points.length)
		{
			for(i = 0; i < points.length; i++)
				this.points[i] = points[i];
			
			//  null the remaining cells in this.points
			for(; i < this.points.length; i++)
				this.points[i] = null;
		}
		else
		{
			for(i = 0; i < this.points.length; i++)
				this.points[i] = points[i];
		}
		
		//  set the lastIndex variable
		lastIndex = -1;
		
		for(i = 0; i < points.length; i++)
		{
			if(points[i] == null)
				lastIndex = i;
		}
		
		if(lastIndex == -1)
			lastIndex = points.length;
	}
	
	public Point[] getPoints()
	{
		return points;
	}
	
	public boolean isFull()
	{
		return (lastIndex == points.length);
	}
	
	public Path clone()
	{	
		Path clone = new Path();
		Point[] clonePoints = new Point[points.length];
		
		for(int i = 0; i < points.length; i++)
			clonePoints[i] = points[i].clone();
		
		clone.setPoints(clonePoints);
		
		return clone;
	}
}
