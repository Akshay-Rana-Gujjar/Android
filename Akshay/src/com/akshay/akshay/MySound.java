package com.akshay.akshay;

import android.app.ActionBar;
import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;

public class MySound extends Activity implements OnClickListener, OnLongClickListener {
	MediaPlayer mp;
	SoundPool sp;
	int a=0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		View v =new View(this);
		v.setOnClickListener(this);
		setContentView(v);
		ActionBar action = getActionBar();
		action.setDisplayHomeAsUpEnabled(true);
		sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
		a = sp.load(getApplicationContext(), R.raw.mysound, 1);
		v.setOnLongClickListener(this);
		mp = MediaPlayer.create(getApplicationContext(), R.raw.animal);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		sp.play(a, 1, 1, 0, 0, 0);
		
	}

	@Override
	public boolean onLongClick(View v) {
		// TODO Auto-generated method stub
		mp.start();
		return false;
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub		
		mp.release();
		super.onPause();
	}
	
	
	
	
}
