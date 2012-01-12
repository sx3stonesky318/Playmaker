package com.playmaker.football.gui;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;

public abstract class AbstractToolbarButton extends View
{
	protected Context context;
	protected int border;
	protected int stroke;
	protected Paint paint;
	
	
	private int backgroundColor;
	private boolean selected = false;

	public AbstractToolbarButton(Context context, int border, int stroke)
	{
		super(context);
		
		this.context = context;
		this.border = border;
		this.stroke = stroke;
		
		initialize();
	}
	
	private void initialize()
	{
		this.setPadding(border, border, border, border);
		
		paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		paint.setStrokeWidth(stroke);
		
		backgroundColor = context.getResources().getColor(android.R.color.black);
		this.setBackgroundColor(backgroundColor);
		
		LayoutParams lps = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 1f);
		this.setLayoutParams(lps);
		
		this.invalidate();
	}
	
	public void setBorder(int border)
	{
		this.border = border;
	}
	
	public void setStroke(int stroke)
	{
		this.stroke = stroke;
	}
	
	public int getBorder()
	{
		return border;
	}
	
	public int getStroke()
	{
		return stroke;
	}
	
	public void setSelected(boolean selected)
	{
		this.selected = selected;

		if(selected)
			this.setBackgroundResource(com.playmaker.football.R.drawable.timepicker_input_selected);
		else
			this.setBackgroundColor(backgroundColor);
		
		this.invalidate();
	}
	
	public boolean isSelected()
	{
		return selected;
	}
	
	public int getBackgroundColor()
	{
		return backgroundColor;
	}
}
