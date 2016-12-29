package com.akshay.akshay;

import java.io.IOException;
import java.util.ArrayList;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ActivityManager.TaskDescription;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.SlidingDrawer;
import android.widget.SlidingDrawer.OnDrawerCloseListener;
import android.widget.SlidingDrawer.OnDrawerOpenListener;
import android.widget.TextView;
import android.widget.Toast;

@SuppressWarnings("deprecation")
public class MusicPlayer extends Activity implements OnDrawerOpenListener, OnDrawerCloseListener, OnItemClickListener {
	
	



	MediaPlayer mp;
	
	SlidingDrawer sd;
	ImageButton play;
	TextView tv;
	Window w;
	ActionBar action;	
	SeekBar seekBar;
	Handler handle;
	Runnable run;
	Thread thread1 ;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.music_player);
		
		StatusBarAndActionBar();
		
		try {
			Initialization();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



public void back(View view) {
	
	}
	
	
	public void play(View view) {
		
		if(mp.isPlaying()){
		    mp.pause();
		    Toast.makeText(getApplicationContext(), "Pause", Toast.LENGTH_SHORT).show();
		    play.setBackgroundResource(R.drawable.play);
		} else {
		    mp.start();
		    Toast.makeText(getApplicationContext(), "Play", Toast.LENGTH_SHORT).show();
		    play.setBackgroundResource(R.drawable.pause);
		}
	thread1 = new Thread(new updateSeekBar());
	thread1.start();
	
	
	
	}
	 
	
	
	

	public void next(View view) {

		
		Toast.makeText(getApplicationContext(), "Next", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onDrawerOpened() {
		// TODO Auto-generated method stub
		
		//to change the title color of a app in recent panel
				Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
				TaskDescription taskDesc = new TaskDescription("Music Player", bm,getResources().getColor(R.color.slide_default1));
				this.setTaskDescription(taskDesc);
				
		
		if(android.os.Build.VERSION.SDK_INT >= 21){
			 w = this.getWindow();
			 getWindow().setNavigationBarColor(getResources().getColor(R.color.slide_defaultDark1));
			w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			w.setStatusBarColor(this.getResources().getColor(R.color.slide_defaultDark1));
			}
		
		action.setBackgroundDrawable(new ColorDrawable(this.getResources().getColor(R.color.slide_default1)));
		
		tv.setBackgroundColor(this.getResources().getColor(R.color.slide_defaultDark1));
		tv.setTextColor(Color.WHITE);
		tv.setTextSize(20);
		
		tv.setText("Playlist");
		ViewGroup.LayoutParams layout =
				new ViewGroup.LayoutParams(android.view.ViewGroup.LayoutParams.MATCH_PARENT, android.view.ViewGroup.LayoutParams.WRAP_CONTENT);
		tv.setLayoutParams(layout);
		ArrayList<String> songlist = new ArrayList<String>();
		songlist.add("music 1");
		songlist.add("music 2");
		songlist.add("another");
		songlist.add("another");
		ArrayAdapter<String> addArraylist = new ArrayAdapter<String>(this,R.layout.list_item_style,R.id.listItem, songlist);
		ListView listView = (ListView)findViewById(R.id.listView_songList);
		listView.setAdapter(addArraylist);
		listView.setOnItemClickListener(this);
		
		
	}

	@Override
	public void onDrawerClosed() {
		// TODO Auto-generated method stub
		
		StatusBarAndActionBar();
		
		tv.setTextSize(16);
		tv.setTextColor(Color.GRAY);
		tv.setBackgroundColor(this.getResources().getColor(R.color.action));		
		tv.setText("Playlist");
		
	}

	

	
	public void StatusBarAndActionBar(){
		
		//to change the title color of a app in recent panel
		Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
		TaskDescription taskDesc = new TaskDescription("Music Player", bm,getResources().getColor(R.color.action));
		this.setTaskDescription(taskDesc);
		
		//to change the color of status bar and navigation bar color
				if(android.os.Build.VERSION.SDK_INT >= 21){
				 w = this.getWindow();
				w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
				w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
				w.setStatusBarColor(this.getResources().getColor(R.color.actionDark));
				
				getWindow().setNavigationBarColor(this.getResources().getColor(R.color.actionDark));
				
				getActionBar().setElevation(50);
				}
				
				//to change the color of action bar
				
				action = getActionBar();
				action.setBackgroundDrawable(new ColorDrawable(this.getResources().getColor(R.color.action)));		
				action.setDisplayHomeAsUpEnabled(true);
				//to enable above button we must declare parent activity in manifest file
		
	}
	
	/**
	 * @throws IOException 
	 * @throws IllegalStateException 
	 * @throws SecurityException 
	 * @throws Exception 
	 * 
	 */
	private void Initialization() {
		// TODO Auto-generated method stub
		Uri path = Uri.parse(Environment.getExternalStorageDirectory()+"");
		mp = new MediaPlayer();
		try {
			mp.setDataSource(path+"/music.mp3");
			mp.prepare();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			System.out.println("===========IllegalArgumentException=================");
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			System.out.println("================SecurityException===============");
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			System.out.println("=+++++++++++++++++++++IllegalStateException+++++++++++++++++++++");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("--------------------------------IOException--------------------------");
			e.printStackTrace();
		}
		
		play = (ImageButton)findViewById(R.id.play);
		tv = (TextView)findViewById(R.id.handle);
		seekBar = (SeekBar)findViewById(R.id.seekBar1);
		sd = (SlidingDrawer)findViewById(R.id.slide_list);
		sd.setOnDrawerOpenListener(this);
		sd.setOnDrawerCloseListener(this);		
		
		seekBar.setMax(mp.getDuration()/1000);
		while(mp.isPlaying())
		seekBar.setProgress(mp.getCurrentPosition()/1000);
		
		
	}



	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
		// TODO Auto-generated method stub
		
		
		
	}
	//private void songList() {ArrayList < String> songlist = new ArrayList<String>();}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		if(mp.isPlaying())
			mp.release();
		super.onPause();
	}

	class updateSeekBar implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}}

}
