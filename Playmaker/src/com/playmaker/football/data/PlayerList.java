package com.playmaker.football.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PlayerList implements Comparator<Player>
{
	private ArrayList<Player> players;
	private int maxCapacity;
	
	public PlayerList(int number)
	{
		players = new ArrayList<Player>(number);
		this.maxCapacity = number;
	}
	
	public void add(Player p)
	{
		players.add(p);
	}
	
	public void sort()
	{
		Collections.sort(players, this);
	}
	
	public int maxCapacity()
	{
		return maxCapacity;
	}
	
	public boolean isFull()
	{
		return (players.size() == maxCapacity);
	}
	
	public Player findPlayer(int x, int y, int radius)
	{
		Point loc;
		
		for(Player p : players)
		{
			loc = p.getLocation();
			
			if(distance(loc.getX(), loc.getY(), x, y) <= radius)
			{
				return p;
			}
		}
		
		return null;
	}
	
	public int compare(Player p1, Player p2)
	{
		if(p1.getLocation().getX() < p2.getLocation().getX())
			return -1;
		else if(p1.getLocation().getX() > p2.getLocation().getX())
			return 1;
		
		return 0;
	}
	
	public int distance(int x1, int y1, int x2, int y2)
	{
		int xDistance = x2 - x1;
		int yDistance = y2 - y1;
		
		xDistance = xDistance * xDistance;
		yDistance = yDistance * yDistance;
		
		return (int)Math.sqrt(xDistance + yDistance);
	}
}
