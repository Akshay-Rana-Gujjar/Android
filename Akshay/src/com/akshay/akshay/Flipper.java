package com.akshay.akshay;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import android.widget.ViewFlipper;



public class Flipper extends Activity implements OnClickListener, OnCheckedChangeListener {

	
	Window w;
	ActionBar action;
	ViewFlipper flippy;
	Switch switch1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.flipper);
		setStatusBarAndActionBarColor("#D20015", "#F70019");	
		
		
		switch1 = (Switch)findViewById(R.id.switch1);
		flippy= (ViewFlipper)findViewById(R.id.viewFlipper);
		flippy.setOnClickListener(this);
		switch1.setOnCheckedChangeListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		flippy.showNext();
	}
	
public void setStatusBarAndActionBarColor(String StatusColor,String ActionColor){
		
		//to change the color of status bar and navigation bar color
				if(android.os.Build.VERSION.SDK_INT >= 21){
				 w = this.getWindow();
				w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
				w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
				w.setStatusBarColor(Color.parseColor(StatusColor));				
				w.setNavigationBarColor(Color.parseColor(StatusColor));
				
				getActionBar().setElevation(20);
				}
				
				//to change the color of action bar
				
				action = getActionBar();
				action.setBackgroundDrawable(new ColorDrawable(Color.parseColor(ActionColor)));		
				action.setDisplayHomeAsUpEnabled(true);
				//to enable above button we must declare parent activity in manifest file
		
	}

@Override
public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
	// TODO Auto-generated method stub
	if(isChecked){
		flippy.setFlipInterval(5000);
		flippy.startFlipping();
		
	}else{flippy.stopFlipping();}
		
	
}
}
