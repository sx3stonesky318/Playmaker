package com.playmaker.football.data;

public class Play 
{
	private Player[] players;
	private int lastIndex;
	
	private float lineOfScrimmage;
	
	public Play(int numOfPlayers, float lineOfScrimmage)
	{
		this.players = new Player[numOfPlayers];
		this.lineOfScrimmage = lineOfScrimmage;
		lastIndex = players.length;
	}
	
	public Play(int numOfPlayers)
	{
		this.players = new Player[numOfPlayers];
		this.lineOfScrimmage = 0.5f;
		lastIndex = 0;
	}
	
	public Play()
	{
		this.players = new Player[7];
		lastIndex = 0;
		this.lineOfScrimmage = 0.4f;
	}
	
	public void addPlayer(Player p)
	{
		if(players == null || lastIndex == players.length)
			System.exit(0);
		
		players[lastIndex] = p;
		lastIndex++;
	}
	
	public void removePlayer(Player p)
	{
		for(int i = 0; i < players.length; i++)
		{
			if(players[i] == p)
			{
				players[i] = null;
				shiftPlayers();
				break;
			}
		}
	}
	
	private void shiftPlayers()
	{
		int lastNullIndex = -1;
		
		for(int i = 0; i < players.length; i++)
		{
			if(players[i] == null)
				lastNullIndex = i;
			else if(lastNullIndex > -1)
			{
				players[lastNullIndex] = players[i];
				players[i] = null;
				lastNullIndex = i;
			}
		}
	}
	
	public void setLineOfScrimmage(float lineOfScrimmage)
	{
		this.lineOfScrimmage = lineOfScrimmage;
	}
	
	public Player[] getPlayers()
	{
		return players;
	}
	
	public float getLineOfScrimmage()
	{
		return lineOfScrimmage;
	}
}
