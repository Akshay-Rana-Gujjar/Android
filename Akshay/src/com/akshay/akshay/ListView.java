package com.akshay.akshay;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ListView extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview);
		ArrayList<String> al = new ArrayList<String>();
		al.add("fuck");
		al.add("fuck1");
		al.add("fuck2");
		al.add("fuck3");
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.list_item_style,R.id.listItem, al);
				/*{

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				View view = super.getView(position, convertView, parent);
				TextView tv = (TextView)findViewById(android.R.id.text1);
				tv.setTextColor(Color.BLACK);
				return view;
			}};       */
		android.widget.ListView lv = (android.widget.ListView)findViewById(R.id.listView_listview);
		lv.setAdapter(adapter);
	}

	
	
}
