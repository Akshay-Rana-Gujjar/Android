package com.akshay.akshay;


import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.TaskDescription;
import android.os.Bundle;
import android.app.ActionBar;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	int a = 0;
	TextView tv,tv1,tvadd,tvreset; 
	Button button_add;
	Animation animation;
	//TaskDescription tskdcpt = Activity;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.activity_main);
		
		if(android.os.Build.VERSION.SDK_INT >= 21){
		Window window = this.getWindow();
		 getWindow().setNavigationBarColor(getResources().getColor(R.color.main_dark));
		window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
		window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
		window.setStatusBarColor(this.getResources().getColor(R.color.main_dark));
		getActionBar().setElevation(25);
		}
		ActionBar action = getActionBar();		
		action.setDisplayHomeAsUpEnabled(true);
		action.setBackgroundDrawable(new ColorDrawable(this.getResources().getColor(R.color.main_color)));
		
		button_add = (Button)findViewById(R.id.button1);
		
		
	}

	public void Addition(View view){
		
		tvadd = (TextView) findViewById(R.id.tvadd);
		tv = (TextView) findViewById(R.id.tvresult);
		animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.traslate_fade);
		animation.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				tvadd.setText("+1");
			}
			
			
			
			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				tvadd.setText("");
			}



			@Override
			public void onAnimationRepeat(Animation animation) {}
		});
		tvadd.startAnimation(animation);
		
		
		a++;		
		tv.setText("" + a);
		
		
	}

	public void Subtraction(View view) {
		
		tv = (TextView) findViewById(R.id.tvresult);
		tv1 = (TextView) findViewById(R.id.tvsub);
		animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.traslate_fade);
		animation.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				tv1.setText("-1");
			}
			
			
			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				tv1.setText("");
			}
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
		});
		 
		tv1.startAnimation(animation);
		
		a--;		
		tv.setText("" + a);
		
		// tv1.clearAnimation();
		//tv1.setText("");
			}
	

	public void Reset(View view) {
		tvreset = (TextView) findViewById(R.id.tvreset);
		tv = (TextView) findViewById(R.id.tvresult);
		animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.traslate_fade);

		animation.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				tvreset.setText("0");
			}
			
			
			
			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				tvreset.setText("");
			}
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
		});
		tvreset.startAnimation(animation);
		
		a=0;
		tv.setText("" + a);
	}

	
	

}
