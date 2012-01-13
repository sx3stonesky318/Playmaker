package com.playmaker.football.gui;

import android.content.Context;
import android.graphics.Canvas;

public class PlayerButton extends AbstractToolbarButton
{

	public PlayerButton(Context context, int border, int stroke)
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
		
		int radius = (this.getWidth() < this.getHeight() ? this.getWidth():this.getHeight())/2 - border;
		int centerX = this.getWidth()/2;
		int centerY = this.getHeight()/2;
		
		paint.setARGB(127, 255, 255, 255);
		c.drawCircle(centerX, centerY, radius, paint);
		
		paint.setColor(this.getBackgroundColor());
		c.drawCircle(centerX, centerY, radius-stroke, paint);
	}

}
