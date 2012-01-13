package com.playmaker.football.gui;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class Toolbar extends LinearLayout
{
	private int divisionColor;
	
	public Toolbar(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		initialize();
	}
	
	public Toolbar(Context context)
	{
		super(context);
		initialize();
	}
	
	private void initialize()
	{
		divisionColor = Color.GRAY;
	}
	
	public void addView(View v)
	{
		if(this.getChildCount() > 0)
			super.addView(new LineDivision(this.getContext()));
		
		LinearLayout.LayoutParams lps = new LinearLayout.LayoutParams(v.getLayoutParams());
		lps.width = LayoutParams.MATCH_PARENT;
		lps.height = LayoutParams.MATCH_PARENT;
		lps.weight = 1f;
		
		super.addView(v, lps);
	}
	
	private class LineDivision extends LinearLayout
	{
		public LineDivision(Context context)
		{
			super(context);
			
			ViewGroup.LayoutParams lps = new LayoutParams(LayoutParams.MATCH_PARENT, 1);
			this.setLayoutParams(lps);
			
			this.setBackgroundColor(divisionColor);
		}
	}
}
