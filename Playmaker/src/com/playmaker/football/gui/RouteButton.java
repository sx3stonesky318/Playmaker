package com.playmaker.football.gui;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.playmaker.football.R;

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
	
	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) 
	{
		this.removeAllViews();
		
		RelativeLayout rl = new RelativeLayout(context);
		LayoutParams lps = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		rl.setLayoutParams(lps);
		
		View v = new View(context);
		
		int size = (this.getWidth() > this.getHeight() ? this.getHeight() : this.getWidth());
		Log.i("Route Button", this.getWidth() + " -- " + this.getHeight());
		
		RelativeLayout.LayoutParams rlps = new RelativeLayout.LayoutParams(size, size);
		rlps.addRule(RelativeLayout.CENTER_IN_PARENT);
		v.setBackgroundResource(R.drawable.arrow);
		v.setLayoutParams(rlps);
		
		rl.addView(v, rlps);
		
		this.addView(rl, lps);
		this.addView(new Button(context), lps);
	} 
}
