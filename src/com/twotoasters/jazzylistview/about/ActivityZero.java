package com.twotoasters.jazzylistview.about;

import com.twotoasters.jazzylistview.home.NoBoringHomeActivity;
import com.twotoasters.jazzylistview.home.SplashActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class ActivityZero extends Activity {

	SharedPreferences pref;
	SharedPreferences.Editor editor;
	Intent mIntent;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Here is the main layout
		pref = getSharedPreferences("testapp", MODE_PRIVATE);
		editor = pref.edit();
		String getStatus = pref.getString("register", "nil");
		ActivityZero.this.finish();
		if (getStatus.equals("true"))
			mIntent = new Intent(ActivityZero.this, NoBoringHomeActivity.class);
		else {
			mIntent = new Intent(ActivityZero.this, SplashActivity.class);
			editor.putString("register", "true");
			editor.commit();
		}

		ActivityZero.this.startActivity(mIntent);
	}
}
