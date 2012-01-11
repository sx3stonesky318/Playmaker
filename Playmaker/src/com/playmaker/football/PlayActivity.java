package com.playmaker.football;

import android.app.Activity;
import android.content.res.Resources;
import android.gesture.GestureOverlayView;
import android.gesture.GestureOverlayView.OnGestureListener;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;

import com.playmaker.football.data.Player;
import com.playmaker.football.data.PlayerList;
import com.playmaker.football.data.Point;
import com.playmaker.football.gui.AbstractToolbarButton;
import com.playmaker.football.gui.PlayerButton;
import com.playmaker.football.gui.PlayerGUI;
import com.playmaker.football.gui.RouteButton;
import com.playmaker.football.gui.SettingsButton;
import com.playmaker.football.gui.Toolbar;
import com.playmaker.football.gui.UndoButton;

public class PlayActivity extends Activity implements OnGestureListener
{
	private Resources res;
	
	private PlayerList players;
	private int radius = 25;
	private int stroke = 3;
	private int strokeColor;
	
	private RelativeLayout rl;
	
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_play_layout);
        
        res = this.getResources();
        strokeColor = res.getColor(android.R.color.black);
        
        players = new PlayerList(7);
        
        rl = (RelativeLayout)this.findViewById(R.id.fieldLayout);
        
        GestureOverlayView gov = (GestureOverlayView)this.findViewById(com.playmaker.football.R.id.gestureLayout);
        gov.addOnGestureListener(this);
        gov.setGestureVisible(false); 
        
        OnClickListener toolbarButtonOnClickListener = new ToolbarButtonOnClickListener();
        
        Toolbar buttons = (Toolbar)this.findViewById(com.playmaker.football.R.id.toolbarButtonLayout);
        
        AbstractToolbarButton button;
        
        button = new PlayerButton(this, 15, 10);
        button.setOnClickListener(toolbarButtonOnClickListener);
        buttons.addView(button);
        button.performClick();
        
        button = new RouteButton(this, 15, 10);
        button.setOnClickListener(toolbarButtonOnClickListener);
        buttons.addView(button);
        
        button = new UndoButton(this, 15, 10);
        button.setOnClickListener(toolbarButtonOnClickListener);
        buttons.addView(button);
        
        button = new SettingsButton(this, 15, 10);
        button.setOnClickListener(toolbarButtonOnClickListener);
        buttons.addView(button);
    }

	//================================================================================
	//  Listener for screen gestures
	//================================================================================
	private Player touchedPlayer = null;
	private Point touchedPlayerLocation = null;
	public void onGestureStarted(GestureOverlayView overlay, MotionEvent event) 
	{
		Log.i(getClass().getSimpleName(), "X:  " + event.getX() + " -- Y:  " + event.getY());
		
		if((touchedPlayer = players.findPlayer((int)event.getX(), (int)event.getY(), radius)) == null)
		{
			if(!players.isFull())
			{
				touchedPlayer = new Player(res.getColor(android.R.color.white), new Point((int)event.getX(), (int)event.getY()), null);
				players.add(touchedPlayer);
				
				rl.addView(new PlayerGUI(this, touchedPlayer, radius, stroke, strokeColor));
			}
		}
		
		Log.i(getClass().getSimpleName(), "Touched player:  " + touchedPlayer);
	}
	
	public void onGesture(GestureOverlayView overlay, MotionEvent event) 
	{
		if(touchedPlayer != null)
		{
			touchedPlayerLocation = touchedPlayer.getLocation();
			
			touchedPlayerLocation.setX((int)event.getX());
			touchedPlayerLocation.setY((int)event.getY());
			
			rl.invalidate();
		}
	}

	public void onGestureCancelled(GestureOverlayView overlay, MotionEvent event) {}
	public void onGestureEnded(GestureOverlayView overlay, MotionEvent event) {}
	
	//================================================================================
	//  Listener for Toolbar Buttons
	//================================================================================
	private AbstractToolbarButton currentTool;
	
	private class ToolbarButtonOnClickListener implements OnClickListener
	{
		public void onClick(View b)
		{	
			Log.i(getClass().getSimpleName(), "Button clicked...");
			
			if(currentTool != null)
				currentTool.setSelected(false);
		
			currentTool = (AbstractToolbarButton)b;
		
			currentTool.setSelected(true);
		}
	}
}