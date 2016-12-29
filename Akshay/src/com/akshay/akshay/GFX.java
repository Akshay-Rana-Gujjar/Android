package com.akshay.akshay;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;

public class GFX extends Activity {
	
	MyClass myview;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		myview = new MyClass(this); 
		setContentView(myview);
		ActionBar action = getActionBar();
		action.setDisplayHomeAsUpEnabled(true);
	}
	
	

}
