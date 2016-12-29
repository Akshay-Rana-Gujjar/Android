package com.akshay.akshay;

import android.R.color;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.view.View;

public class MyClass extends View {
	
	Bitmap magicball;
	float changeY;
	Typeface font;
	

	public MyClass(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		
		magicball = BitmapFactory.decodeResource(getResources(), R.drawable.magic);
		changeY=0;
		font = Typeface.createFromAsset(context.getAssets(), "font1.TTF");
		
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		canvas.drawColor(color.darker_gray);
		Paint textpaint = new Paint();
		textpaint.setARGB(100, 0, 255, 209);
		textpaint.setTextAlign(Align.CENTER);
		textpaint.setTextSize(40);
		textpaint.setTypeface(font);
		
		
		
		canvas.drawBitmap(magicball, (canvas.getWidth()/2), changeY, null);
		SharedPreferences speed = PreferenceManager.getDefaultSharedPreferences(getContext());
		String spd0 = (String)speed.getString("list1", "1");
		int spd =Integer.parseInt(spd0);
		if(changeY < canvas.getHeight()){
			changeY += spd*5;
		}else{changeY=0;}
		
		Rect rectangle = new Rect();
		rectangle.set(0, 400, canvas.getWidth(), 450);
		Paint myred = new Paint();
		myred.setColor(Color.BLACK);
		canvas.drawRect(rectangle, myred);
		canvas.drawText("Akshay Rana GuJJar", canvas.getWidth()/2, 440, textpaint);
		invalidate();
		
	}
}
