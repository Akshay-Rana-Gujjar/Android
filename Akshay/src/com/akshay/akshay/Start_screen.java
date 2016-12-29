package com.akshay.akshay;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

public class Start_screen extends Activity {
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//fullscreen
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.trans);
		RelativeLayout rl = (RelativeLayout)findViewById(R.id.RelativeLayout);
		
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		String values = sp.getString("list", "1");
		if(values.contentEquals("1")){
		rl.setBackgroundColor(Color.rgb(66,133,244));
		}else if(values.contentEquals("2")){
			rl = (RelativeLayout)findViewById(R.id.RelativeLayout);
			rl.setBackgroundColor(Color.rgb(249, 80, 97));
		
		}else if(values.contentEquals("3")){
			rl.setBackgroundColor(Color.rgb(98, 104, 100));
		
		}else{rl.setBackgroundColor(Color.rgb(246, 247, 104));}
		
		
		
		Thread timer = new Thread(){

			@Override
			public void run() {
				
				try {
					sleep(8000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					Intent i = new Intent(Start_screen.this, Menu.class);
					startActivity(i);
				}
				
			}
			
			
			
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	

}
