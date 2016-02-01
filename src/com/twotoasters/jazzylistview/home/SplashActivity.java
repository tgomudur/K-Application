package com.twotoasters.jazzylistview.home;

import com.twotoasters.jazzylistview.about.AboutUs;
import in.org.kurukshetra.app.R;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.widget.VideoView;

public class SplashActivity extends Activity implements OnCompletionListener {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		VideoView video = (VideoView) findViewById(R.id.videoView);
		video.setVideoPath("android.resource://" + getPackageName()
				+ "/raw/karthi");
		video.start();
		video.setOnCompletionListener(this);
	}

	@Override
	public void onCompletion(MediaPlayer mp) {
		Intent intent = new Intent(this, AboutUs.class);
		startActivity(intent);
		finish();
	}
}
