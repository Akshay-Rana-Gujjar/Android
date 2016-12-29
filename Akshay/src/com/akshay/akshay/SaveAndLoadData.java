package com.akshay.akshay;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SaveAndLoadData extends Activity implements OnClickListener {

	EditText editdata;
	TextView showdata;
	SharedPreferences sp;
	public static String filename = "myfile";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.save_and_load_data);

		editdata = (EditText) findViewById(R.id.editText_editdata);
		showdata = (TextView) findViewById(R.id.textView_showdata);
		Button savedata = (Button) findViewById(R.id.button_savedata), 
			   loaddata = (Button) findViewById(R.id.button_loadData);
		savedata.setOnClickListener(this);
		loaddata.setOnClickListener(this);
		sp = getSharedPreferences("myfile", MODE_PRIVATE);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.button_savedata:
			String fromEditText = editdata.getText().toString();
			SharedPreferences.Editor spEditor = sp.edit();
			spEditor.putString("ourData", fromEditText);
			spEditor.commit();			
			break;
		case R.id.button_loadData:
			sp = getSharedPreferences("myfile", MODE_PRIVATE);
			String getDataFrommyfile = sp.getString("ourData", "oh fuck!! there is problem to load");
			showdata.setText(getDataFrommyfile);
			
			break;

		}
	}

}
