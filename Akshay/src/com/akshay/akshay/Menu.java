package com.akshay.akshay;

import android.app.ActionBar;
import android.app.ListActivity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Menu extends ListActivity{
	String classes[]={"MainActivity","GFX", "MySound","Slider","MusicPlayer","Tabs","Browser","Flipper","SaveAndLoadData",
			"ListView"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, classes));
		
		if(android.os.Build.VERSION.SDK_INT >= 21){
			Window window = this.getWindow();
			getWindow().setNavigationBarColor(getResources().getColor(R.color.main_dark));
			window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			window.setStatusBarColor(this.getResources().getColor(R.color.main_dark));
			
		
			getActionBar().setElevation(20);
			}
		
		ActionBar action =getActionBar();
		action.setBackgroundDrawable(new ColorDrawable(this.getResources().getColor(R.color.main_color)));
		
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		try {
			Class clas =  Class.forName("com.akshay.akshay."+classes[position]);
			Intent i = new Intent(this , clas);
			startActivity(i);
			Toast.makeText(this, classes[position], Toast.LENGTH_SHORT).show();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}

	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// TODO Auto-generated method stub
		 super.onCreateOptionsMenu(menu);
		 MenuInflater mi = getMenuInflater();
		 mi.inflate(R.menu.main, menu);		 
		 return true;
		
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
		case R.id.aboutus:
			Intent i = new Intent(this,About_us.class);
			startActivity(i);
			break;
		case R.id.preference:
			Intent i1 = new Intent(this, Prefs.class);
			startActivity(i1);
			break;
		case R.id.exit:
			finish();
			break;
		case R.id.restart:
			finish();
			Intent restart = new Intent(this ,Check.class);
			startActivity(restart);		
			
			break;		
		}
		
		
		return false;
	}


}
