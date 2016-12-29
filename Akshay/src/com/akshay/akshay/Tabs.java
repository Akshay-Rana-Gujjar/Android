package com.akshay.akshay;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class Tabs extends Activity implements OnClickListener {
	TabHost th;
	Button start, stop;
	TextView tv;
	long startTime, stopTime;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabs);
		th = (TabHost) findViewById(R.id.tabhost);
		th.setup();
		TabSpec specs = th.newTabSpec("tag1");
		specs.setContent(R.id.tab1);
		specs.setIndicator("stopwatch");
		th.addTab(specs);
		specs = th.newTabSpec("tag2");
		specs.setContent(R.id.tab2);
		specs.setIndicator("Tab 2");
		th.addTab(specs);
		specs = th.newTabSpec("tag3");
		specs.setContent(R.id.tab3);
		specs.setIndicator("Tab 3");
		th.addTab(specs);
		start = (Button) findViewById(R.id.startTab);
		stop = (Button) findViewById(R.id.stopTab);
		tv = (TextView) findViewById(R.id.textviewTab);
		start.setOnClickListener(this);
		stop.setOnClickListener(this);
		startTime = 0;

	}

	public void AddTab(View v) {
		TabSpec ourSpec = th.newTabSpec("tag 1");
		ourSpec.setContent(new TabHost.TabContentFactory() {

			@Override
			public View createTabContent(String tag) {
				// TODO Auto-generated method stub

				TextView text = new TextView(Tabs.this);
				text.setText("yo we created madafuckin tab!");
				return text;
			}
		});
		ourSpec.setIndicator("New Tab");
		th.addTab(ourSpec);

		// });

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.startTab:
			startTime = System.currentTimeMillis();

			break;
		case R.id.stopTab:
			stopTime = System.currentTimeMillis();

			if (startTime != 0) {
				long result = stopTime - startTime;
				tv.setText(Long.toString(result));

			}

			break;

		}

	}

}
