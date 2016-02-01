package com.twotoasters.jazzylistview.sample;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import in.org.kurukshetra.app.R;

public class SimpleGridActivity extends Activity {

	ImageView iv, iv2;
	Handler handler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		/*
		 * iv = (ImageView) findViewById(R.id.imageView1);
		 * iv.setOnClickListener(new OnClickListener() {
		 * 
		 * @Override public void onClick(View v) {
		 * 
		 * startActivity(new Intent(SimpleGridActivity.this, MainHome.class)); }
		 * });
		 * 
		 * Runnable runnable = new Runnable() { int i = 0;
		 * 
		 * @Override public void run() {
		 * 
		 * /*iv.setImageResource(imageArray3[i]); i++;
		 * 
		 * if (i > imageArray3.length - 1) { i = 0; }
		 * 
		 * handler.postDelayed(this, 50); // for interval...
		 * 
		 * }
		 * 
		 * //};
		 * 
		 * //handler.postDelayed(runnable, 50);
		 */

	}

}
