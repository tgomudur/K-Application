package com.twotoasters.jazzylistview.sample;

import in.org.kurukshetra.app.R;

import java.io.IOException;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.RingtoneManager;
import android.net.Uri;

public class AlarmReceiver extends BroadcastReceiver {

	// NotificationManager nm;
	NotificationManager nm;

	private void playSound(Context alarmReceiver, Uri alert) {
		final MediaPlayer mMediaPlayer = new MediaPlayer();
		try {
			mMediaPlayer.setDataSource(alarmReceiver, alert);
			final AudioManager audioManager = (AudioManager) alarmReceiver
					.getSystemService(Context.AUDIO_SERVICE);
			if (audioManager.getStreamVolume(AudioManager.STREAM_ALARM) != 0) {
				mMediaPlayer.setAudioStreamType(AudioManager.STREAM_ALARM);
				mMediaPlayer.prepare();
				mMediaPlayer.start();

				mMediaPlayer
						.setOnCompletionListener(new OnCompletionListener() {
							@Override
							public void onCompletion(MediaPlayer mp) {
								mMediaPlayer.stop();
								mMediaPlayer.release();
							}
						});
			}
		} catch (IOException e) {
			System.out.println("OOPS");
		}
	}

	private Uri getAlarmUri() {
		Uri alert = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
		if (alert == null) {
			alert = RingtoneManager
					.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
			if (alert == null) {
				alert = RingtoneManager
						.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
			}
		}
		return alert;
	}

	@SuppressLint("NewApi")
	@Override
	public void onReceive(Context arg0, Intent arg1) {

		String alarmstr = arg1.getStringExtra("alarmrefer");

		// playSound(arg0, getAlarmUri());
		Uri sound = RingtoneManager
				.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
		nm = (NotificationManager) arg0
				.getSystemService(Context.NOTIFICATION_SERVICE);
		CharSequence from = alarmstr;
		CharSequence message = "The Event will start with in 15 Minutes";
		PendingIntent contentIntent = PendingIntent.getActivity(arg0, 0,
				new Intent(), 0);
		Notification notif = new Notification(R.drawable.alarmimg,
				"The Event will start with in 15 Minutes",
				System.currentTimeMillis());
		notif.setLatestEventInfo(arg0, from, message, contentIntent);
		notif.sound = sound;
		nm.notify(1, notif);

	}

}