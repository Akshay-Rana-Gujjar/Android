package com.akshay.akshay;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class Check extends Activity {

	Intent i;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		boolean check = sp.getBoolean("checkbox", true);
		if(check==true){
			i= new Intent(this,Start_screen.class);
			startActivity(i);			
		}else{i= new Intent(this, Menu.class);
		startActivity(i);}
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
}
