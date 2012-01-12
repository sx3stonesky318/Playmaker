package com.playmaker.football.gui;

import android.content.Context;
import android.graphics.Canvas;

public class RouteButton extends AbstractToolbarButton
{
	public RouteButton(Context context, int border, int stroke)
	{
		super(context, border, stroke);
		initialize();
	}
	
	private void initialize()
	{
		
	}
	
	public void draw(Canvas c)
	{
		super.draw(c);

		paint.setARGB(127, 255, 255, 255);
		c.translate(this.getWidth()/2, this.getHeight()-border);
		c.drawLine(0, 0, 0, -this.getHeight()/2, paint);
	}
}
