package com.playmaker.football.gui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;

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
		
		this.setBackgroundDrawable(context.getResources().getDrawable(com.playmaker.football.R.drawable.arrow));

		/*
		paint.setARGB(127, 255, 255, 255);
		
		int circleRadius = (this.getWidth() > this.getHeight()/2 ? this.getHeight()/2 : this.getWidth())/2 - border;
		int centerX = this.getWidth()/2;
		int centerY = this.getHeight()*3/4;
		int hStroke = stroke/2;
		
		//  Draw route
		Path path = new Path();
		path.moveTo(centerX, centerY);
		path.lineTo(centerX-hStroke, centerY);
		path.lineTo(centerX-hStroke, this.getHeight()/4);
		path.lineTo(centerX-hStroke-hStroke, this.getHeight()/4);
		path.lineTo(centerX, this.getHeight()/4-2*stroke);
		path.lineTo(centerX+hStroke+hStroke, this.getHeight()/4);
		path.lineTo(centerX+hStroke, this.getHeight()/4);
		path.lineTo(centerX+hStroke, centerY);
		path.close();
		
		c.drawPath(path, paint);
		
		//  Draw Player
		c.drawCircle(centerX, centerY, circleRadius, paint);
		
		paint.setColor(Color.BLACK);
		c.drawCircle(centerX, centerY, circleRadius-stroke, paint);
		*/
	}
}
