package com.playmaker.football.data;

public class RelativePath
{
	private RelativePoint[] points;
	private int lastIndex;
	
	public RelativePath(RelativePoint[] points)
	{
		this.points = points;
		this.lastIndex = points.length;
	}
	
	public RelativePath(int size)
	{
		this.lastIndex = 0;
		this.points = new RelativePoint[size];
	}
	
	public RelativePath()
	{
		points = null;
		lastIndex = 0;
	}
	
	public void addPoint(RelativePoint point)
	{
		if(points == null || lastIndex == points.length)
			System.exit(0);
		
		points[lastIndex] = (RelativePoint)point;
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
	
	public void setPoints(RelativePoint[] points)
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
	
	public RelativePoint[] getPoints()
	{
		return points.clone();
	}
	
	public boolean isFull()
	{
		return (lastIndex == points.length);
	}
}
