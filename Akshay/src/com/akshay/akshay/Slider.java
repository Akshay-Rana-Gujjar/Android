package com.akshay.akshay;

import java.io.IOException;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.net.rtp.AudioStream;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.SlidingDrawer;
import android.widget.SlidingDrawer.OnDrawerCloseListener;
import android.widget.SlidingDrawer.OnDrawerOpenListener;
import android.widget.TextView;
import android.widget.Toast;

@SuppressWarnings("deprecation")
public class Slider extends Activity implements OnDrawerOpenListener, OnDrawerCloseListener, OnClickListener {
	
	SlidingDrawer sd;
	TextView tv;
	ActionBar action;
	Window window;
	Button a,b,c,d;
	MediaPlayer mp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slider);
		
		
		if(android.os.Build.VERSION.SDK_INT >= 21){
			window = this.getWindow();
			 getWindow().setNavigationBarColor(getResources().getColor(R.color.slide_defaultDark));
			window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			window.setStatusBarColor(this.getResources().getColor(R.color.slide_defaultDark));
			getActionBar().setElevation(50);
			}
		action = getActionBar();
		action.setBackgroundDrawable(new ColorDrawable(this.getResources().getColor(R.color.slide_default)));
		action.setDisplayHomeAsUpEnabled(true);	
				
		tv = (TextView)findViewById(R.id.handle);
		sd = (SlidingDrawer) findViewById(R.id.slidingDrawer);
		sd.setOnDrawerOpenListener(this);
		sd.setOnDrawerCloseListener(this);
		a = (Button)findViewById(R.id.slidebutton1);
		b = (Button)findViewById(R.id.slidebutton2);
		c = (Button)findViewById(R.id.slidebutton3);
		d = (Button)findViewById(R.id.slidebutton4);
		a.setOnClickListener(this);
		b.setOnClickListener(this);
		c.setOnClickListener(this);
		d.setOnClickListener(this);
		
	}
	@Override
	public void onDrawerOpened() {
		// TODO Auto-generated method stub
		if(android.os.Build.VERSION.SDK_INT >= 21){
			 window = this.getWindow();
			 getWindow().setNavigationBarColor(getResources().getColor(R.color.slide_defaultDark1));
			window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			window.setStatusBarColor(this.getResources().getColor(R.color.slide_defaultDark1));
			}
		
		action.setBackgroundDrawable(new ColorDrawable(this.getResources().getColor(R.color.slide_default1)));
		tv.setText("Slide Down");
		tv.setBackgroundColor(this.getResources().getColor(R.color.slide_default1));
		tv.setTextColor(Color.WHITE);
		
	}
	@Override
	public void onDrawerClosed() {
		// TODO Auto-generated method stub
		if(android.os.Build.VERSION.SDK_INT >= 21){
			 window = this.getWindow();
			 getWindow().setNavigationBarColor(getResources().getColor(R.color.slide_defaultDark));
			window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			window.setStatusBarColor(this.getResources().getColor(R.color.slide_defaultDark));
			}
		
		action.setBackgroundDrawable(new ColorDrawable(this.getResources().getColor(R.color.slide_default)));
		
		tv.setText("Slide Up");
		tv.setBackgroundColor(Color.WHITE);
		tv.setTextColor(this.getResources().getColor(R.color.textbg));
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch(v.getId())
		{
		case R.id.slidebutton1:
			mp = MediaPlayer.create(this,Uri.parse(Environment.getExternalStorageDirectory().getPath()+ "/Music/music.mp3"));
			mp.start();
			break;
		case R.id.slidebutton2:
			mp = new MediaPlayer();
			try {
				mp.setDataSource("/mnt/sdcard/Music/music.mp3");
				mp.prepare();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			mp.start();
			break;
		case R.id.slidebutton3:
			String PATH_TO_FILE = "/sdcard/Music/music.mp3";
			mp = new MediaPlayer();
			
			try {
				mp.setDataSource(PATH_TO_FILE);
				mp.prepare();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mp.start();
			break;
		case R.id.slidebutton4:
			Toast.makeText(getApplicationContext(), "start", Toast.LENGTH_LONG);
			mp = new MediaPlayer();
			String path = "/music.mp3";
			//mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
			Uri uri = Uri.parse(Environment.getExternalStorageDirectory().getPath()+path);
			try {
				mp.setDataSource(getApplicationContext(), uri);
				Toast.makeText(getApplicationContext(), "before", Toast.LENGTH_LONG);
				mp.prepare();
				Toast.makeText(getApplicationContext(), "after", Toast.LENGTH_LONG);
				mp.start();
				Toast.makeText(getApplicationContext(), "start", Toast.LENGTH_LONG);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;		
		}
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		if(mp.isPlaying())
			mp.release();
	}

	
}
