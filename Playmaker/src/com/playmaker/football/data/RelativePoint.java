package com.playmaker.football.data;

public class RelativePoint implements Cloneable
{
	private float xLocation;
	private float yLocation;
	
	public RelativePoint(Float x, Float y)
	{
		this.xLocation = x;
		this.yLocation = y;
	}
	
	public RelativePoint()
	{
		this.xLocation = 0.0f;
		this.yLocation = 0.0f;
	}
	
	public void setLocation(Float x, Float y)
	{
		this.xLocation = x;
		this.yLocation = y;
	}
	
	public void setX(Float x)
	{
		this.xLocation = x;
	}
	
	public void setY(Float y)
	{
		this.yLocation = y;
	}
	
	public Float getX()
	{
		return xLocation;
	}
	
	public Float getY()
	{
		return yLocation;
	}
	
	public RelativePoint clone()
	{
		return new RelativePoint(new Float(xLocation), new Float(yLocation));
	}
}
