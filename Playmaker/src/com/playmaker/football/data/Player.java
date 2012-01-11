package com.playmaker.football.data;


public class Player 
{
	private int color;
	private Point location;
	private Route route;
	
	public Player(int color, Point location, Route route)
	{
		this.color = color;
		this.location = location;
		this.route = route;
	}
	
	public Player()
	{
		color = -1;
		location = null;
		route = null;
	}
	
	public void setColor(int c)
	{
		this.color = c;
	}
	
	/**
	 * The (x, y) location of the player on screen
	 * @param p
	 */
	public void setLocation(Point p)
	{
		this.location = p;
	}
	
	public void setRoute(Route r)
	{
		this.route = r;
	}
	
	public int getColor()
	{
		return color;
	}
	
	public Point getLocation()
	{
		return location;
	}
	
	public Route getRoute()
	{
		return route;
	}
	
	public String toString()
	{
		return "Color:  " + color + " :: Location:  " + location.getX() + ", " + location.getY() + " :: Route:  " + route;
	}
}
