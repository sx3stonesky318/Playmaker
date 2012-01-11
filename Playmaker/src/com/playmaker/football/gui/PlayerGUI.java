package com.playmaker.football.gui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import com.playmaker.football.data.Player;

public class PlayerGUI extends View
{
	private Player p;
	private int radius;
	private int stroke;
	private int strokeColor;
	
	private Paint paint;
	
	public PlayerGUI(Context context, Player p, int radius, int stroke, int strokeColor)
	{
		super(context);
		
		this.p = p;
		this.radius = radius;
		this.stroke = stroke;
		this.strokeColor = strokeColor;
		
		paint = new Paint();
	}
	
	public void onDraw(Canvas c)
	{
		paint.setColor(strokeColor);
		c.drawCircle(p.getLocation().getX(), p.getLocation().getY(), radius, paint);
		
		paint.setColor(p.getColor());
		c.drawCircle(p.getLocation().getX(), p.getLocation().getY(), radius-stroke, paint);
	}
}
