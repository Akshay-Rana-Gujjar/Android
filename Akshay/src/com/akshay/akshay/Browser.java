package com.akshay.akshay;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;


public class Browser extends Activity implements OnClickListener {
	
	EditText url;
	WebView wv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.browser);
	
		wv = (WebView) findViewById(R.id.webView1);
		wv.getSettings().setJavaScriptEnabled(true);
		wv.getSettings().setLoadWithOverviewMode(true);
		wv.getSettings().setUseWideViewPort(true);
		wv.setWebViewClient(new MyClient());
		
		wv.loadUrl("https://m.facebook.com");
		url = (EditText)findViewById(R.id.edittext_url);
		Button go  =(Button)findViewById(R.id.button_go);
		Button back =(Button)findViewById(R.id.button_back);
		Button forward =(Button)findViewById(R.id.button_forward);
		Button refresh =(Button)findViewById(R.id.button_refresh);
		Button clear_history =(Button)findViewById(R.id.button_clear_history);
		go.setOnClickListener(this);
		back.setOnClickListener(this);
		forward.setOnClickListener(this);
		refresh.setOnClickListener(this);
		clear_history.setOnClickListener(this);
		
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		
		case R.id.button_go:
			String getUrl = url.getText().toString();
			wv.loadUrl(getUrl);
			
			//hiding keyboard after using edittext(url)
			InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(url.getWindowToken(), 0);
			
			break;
		case R.id.button_back:
			if(wv.canGoBack())
			wv.goBack();
			break;
		case R.id.button_forward:
			if(wv.canGoForward())
				wv.goForward();
			break;
		case R.id.button_refresh:
			wv.reload();
			break;
		case R.id.button_clear_history:
			wv.clearHistory();
			break;
		
		
		}
		
	}
}
class MyClient extends WebViewClient {

	@Override
	public boolean shouldOverrideUrlLoading(WebView v, String url) {
		// TODO Auto-generated method stub
		v.loadUrl(url);
		return super.shouldOverrideUrlLoading(v, url);
	}
	
		
}

