package com.playmaker.football.data;

public class Point implements Cloneable
{
	private int xLocation;
	private int yLocation;
	
	public Point(int x, int y)
	{
		this.xLocation = x;
		this.yLocation = y;
	}
	
	public Point()
	{
		this.xLocation = 0;
		this.yLocation = 0;
	}
	
	public void setLocation(Integer x, Integer y)
	{
		this.xLocation = x;
		this.yLocation = y;
	}
	
	public void setX(Integer x)
	{
		this.xLocation = x;
	}
	
	public void setY(Integer y)
	{
		this.yLocation = y;
	}
	
	public Integer getX()
	{
		return xLocation;
	}
	
	public Integer getY()
	{
		return yLocation;
	}
	
	public Point clone()
	{
		Point clone = new Point(new Integer(xLocation), new Integer(yLocation));
		return clone;
	}
}
