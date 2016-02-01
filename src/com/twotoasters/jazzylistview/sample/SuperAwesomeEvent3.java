package com.twotoasters.jazzylistview.sample;

import in.org.kurukshetra.app.R;
import java.io.IOException;
import java.util.Calendar;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

//import com.actionbarsherlock.app.SherlockFragment;

public class SuperAwesomeEvent3 extends Fragment implements
		View.OnClickListener {

	private static final String ARG_POSITION = "position";

	private int position, i;

	private Animation fromRight;
	ImageView remainderCheck;
	private int[] images = { R.drawable.kentrepreneur1, R.drawable.chaos1,
			R.drawable.kidol1 };
	String[] maindescription = new String[50];
	String[] quotedescription = new String[50];
	String name[] = new String[50];
	String mobnumber[] = new String[50];
	String putName[] = new String[50];
	String putNumber[] = new String[50];
	String QLinks[] = { "KENTREP", "chaos", "KIDOL" };
	String timings[] = { "Jan 30   2:00 PM to 4:30 PM ",
			"Jan 30   11:00 AM to 1:30 PM ", "Jan 31   10:30 AM to 1:30 PM " };
	String mapPlaces[] = { "   Venue : S N H Hall-201 to 210",
			"Venue : Red Building Hall-74 to 81",
			"Venue : Red Building Hall-74 to 81", "Venue : Tag Auditorium",
			"   Venue : Tag Auditorium", "Venue : Tag Auditorium",
			"Venue : Tag Auditorium", "Venue : Vivek Auditorium",
			"Venue : Ece Depart Ground Floor & Maxwell audi" };
	int checkBoxRefer[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0 };
	String myQuicklink = "#";
	String notificationNames[] = { "K Entrepreneur", "Chaos Theory", "K Idol",
			"Paper Presentation", "God Speed", "Energise", "Mega Structures",
			"Aero Modelling", "Simply Circuits" };
	int locateplace[] = { 2, 5, 5 };
	int Alarm_Day[] = { 30, 30, 31, 30 };
	int Alarm_Hour[] = { 13, 10, 10, 9, 21, 21 };
	int Alarm_Minute[] = { 45, 45, 15, 15, 45, 45 };
	int Unique_Id[] = { 16, 17, 18 };
	int alarmFlag1, alarmFlag2, alarmFlag3, alarmFlag4, alarmFlag5, alarmFlag6;
	int setpage;
	int starImage[] = { R.drawable.star_notpressed2, R.drawable.star_pressed2 };
	public int statPosition = 0;

	public void setPreference(int position) {
		switch (position) {
		case 0:
			SharedPreferences AlarmCatThreeEveOne = getActivity()
					.getSharedPreferences("AlarmCatThreeEveOne", 0);
			alarmFlag1 = AlarmCatThreeEveOne.getInt("AlarmCatThreeEveOneFlag",
					0);
			Editor edit1 = AlarmCatThreeEveOne.edit();
			if (alarmFlag1 == 0) {
				edit1.putInt("AlarmCatThreeEveOneFlag", 1);
				edit1.commit();
				statPosition = 1;
			} else {
				edit1.putInt("AlarmCatThreeEveOneFlag", 0);
				edit1.commit();
				statPosition = 0;
			}
			break;
		case 1:
			SharedPreferences AlarmCatThreeEveTwo = getActivity()
					.getSharedPreferences("AlarmCatThreeEveTwo", 0);
			alarmFlag2 = AlarmCatThreeEveTwo.getInt("AlarmCatThreeEveTwoFlag",
					0);
			Editor edit2 = AlarmCatThreeEveTwo.edit();
			if (alarmFlag2 == 0) {
				edit2.putInt("AlarmCatThreeEveTwoFlag", 1);
				edit2.commit();
				statPosition = 1;
			} else {
				edit2.putInt("AlarmCatThreeEveTwoFlag", 0);
				edit2.commit();
				statPosition = 0;
			}
			break;
		case 2:
			SharedPreferences AlarmCatThreeEveThree = getActivity()
					.getSharedPreferences("AlarmCatThreeEveThree", 0);
			alarmFlag3 = AlarmCatThreeEveThree.getInt(
					"AlarmCatThreeEveThreeFlag", 0);
			Editor edit3 = AlarmCatThreeEveThree.edit();
			if (alarmFlag3 == 0) {
				edit3.putInt("AlarmCatThreeEveThreeFlag", 1);
				edit3.commit();
				statPosition = 1;
			} else {
				edit3.putInt("AlarmCatThreeEveThreeFlag", 0);
				edit3.commit();
				statPosition = 0;
			}
			break;

		}
	}

	public void putSharedValue() {

		SharedPreferences AlarmCatThreeEveOne = getActivity()
				.getSharedPreferences("AlarmCatThreeEveOne", 0);
		alarmFlag1 = AlarmCatThreeEveOne.getInt("AlarmCatThreeEveOneFlag", 0);
		checkBoxRefer[1] = alarmFlag1;

		SharedPreferences AlarmCatThreeEveTwo = getActivity()
				.getSharedPreferences("AlarmCatThreeEveTwo", 0);
		alarmFlag2 = AlarmCatThreeEveTwo.getInt("AlarmCatThreeEveTwoFlag", 0);
		checkBoxRefer[2] = alarmFlag2;

		SharedPreferences AlarmCatThreeEveThree = getActivity()
				.getSharedPreferences("AlarmCatThreeEveThree", 0);
		alarmFlag3 = AlarmCatThreeEveThree.getInt("AlarmCatThreeEveThreeFlag",
				0);
		checkBoxRefer[3] = alarmFlag3;

	}

	// For Alarm Purpose

	public void setAlarm(int Event_Number) {
		Calendar calSet = Calendar.getInstance();
		Calendar calset = Calendar.getInstance();
		calSet.clear();
		calSet.set(Calendar.DATE, Alarm_Day[Event_Number]);
		calSet.set(Calendar.MONTH, Calendar.JANUARY); // first month is 0!!!
														// January is zero!!!
														// Hav To Update
		calSet.set(Calendar.YEAR, 2014);// year...
		calSet.set(Calendar.HOUR_OF_DAY, Alarm_Hour[Event_Number]);
		calSet.set(Calendar.MINUTE, Alarm_Minute[Event_Number]);
		calSet.set(Calendar.SECOND, 0);
		calSet.set(Calendar.MILLISECOND, 0);

		if (calset.compareTo(calSet)== 1) {
			// Today Set time passed, count to tomorrow
			Toast.makeText(getActivity(), "Event Finished Already...",
					Toast.LENGTH_LONG).show();
			// calSet.add(Calendar.DATE, 1);
		}
		else
		{
		Intent intent = new Intent(getActivity(), AlarmReceiver.class);
		intent.putExtra("alarmrefer", notificationNames[position]);
		AlarmManager alarmManager = (AlarmManager) getActivity()
				.getSystemService(Context.ALARM_SERVICE);
		PendingIntent pendingIntent = PendingIntent.getBroadcast(getActivity(),
				Unique_Id[Event_Number], intent, 0);
		alarmManager.set(AlarmManager.RTC_WAKEUP, calSet.getTimeInMillis(),
				pendingIntent);

		Toast.makeText(getActivity(), "Alarm is set@ " + calSet.getTime(),
				Toast.LENGTH_LONG).show();
		}
	}

	private void cancelAlarm(int data) {
		Intent intent = new Intent(getActivity(), AlarmReceiver.class);
		// intent.setData(Uri.parse("myalarms://" + data));
		PendingIntent pendingIntent = PendingIntent.getBroadcast(getActivity(),
				data, intent, PendingIntent.FLAG_CANCEL_CURRENT);
		AlarmManager alarmManager = (AlarmManager) getActivity()
				.getSystemService(Context.ALARM_SERVICE);
		alarmManager.cancel(pendingIntent);
		Toast.makeText(getActivity(), "Alarm and Notification Cancelled  ",
				Toast.LENGTH_LONG).show();

	}

	public void putvalue() {
		try {
			XmlResourceParser xpp = getResources().getXml(
					R.xml.eventdesciption3);

			xpp.next();
			int eventType = xpp.getEventType();
			int iter = 0;
			String elemtext = null;

			while (eventType != XmlPullParser.END_DOCUMENT) {

				if (eventType == XmlPullParser.START_TAG) {

					String elemName = xpp.getName();
					if (elemName.equals("article")) {
						iter = iter + 1;
					}

					if (elemName.equals("details")) {
						elemtext = "details";
					}
					if (elemName.equals("quotes")) {
						elemtext = "quotes";
					}
					if (elemName.equals("name")) {
						elemtext = "name";
					}
					if (elemName.equals("mobilenumber")) {
						elemtext = "mobilenumber";
					}

				}

				if (eventType == XmlPullParser.TEXT) {
					for (i = 0; i < 10; i++) {
						if (iter == i) {
							if (elemtext.equals("details")) {
								maindescription[i] = xpp.getText();
							}
							if (elemtext.equals("quotes")) {
								quotedescription[i] = xpp.getText();
							}
							if (elemtext.equals("name")) {
								name[i] = xpp.getText();
							}

							if (elemtext.equals("mobilenumber")) {
								mobnumber[i] = xpp.getText();
							}

						}

					}
				}
				eventType = xpp.next();
			}

		} catch (XmlPullParserException e) {
		} catch (IOException e) {
		}
	}

	public static SuperAwesomeEvent3 newInstance(int position) {
		SuperAwesomeEvent3 f = new SuperAwesomeEvent3();
		Bundle b = new Bundle();
		b.putInt(ARG_POSITION, position);
		f.setArguments(b);
		return f;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		position = getArguments().getInt(ARG_POSITION);
		putvalue();
		putSharedValue();
		fromRight = AnimationUtils.loadAnimation(getActivity(),

		R.anim.right);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View V = inflater.inflate(R.layout.singleevent, container, false);
		ImageView iv = (ImageView) V.findViewById(R.id.ivHeader);
		TextView Desctn = (TextView) V.findViewById(R.id.descri);
		TextView BriefDesctn = (TextView) V.findViewById(R.id.briefdescription);
		TextView artistName = (TextView) V.findViewById(R.id.artist);
		TextView timing = (TextView) V.findViewById(R.id.artist1);
		TextView places = (TextView) V.findViewById(R.id.title);
		// Desctn.setText("JSR KURUKSHETRA ! ! !");

		// Static Reference

		// Desctn.setText("It is better to create than to learn! Creating is the essence of life\n                         -Julius Caesar");
		Desctn.setText(quotedescription[position + 1]);
		BriefDesctn.setText(maindescription[position + 1]);
		// Static Reference
		// ImageView iv=(ImageView) getView().findViewById(R.id.ivHeader);
		// ImageView iv=(ImageView) inflater.inflate(R.layout.singleevent,
		// null);
		iv.setImageResource(images[position % 3]);
		putName = name[position + 1].split("\\*");
		putNumber = mobnumber[position + 1].split("\\*");
		artistName.setText(putName[0] + " : " + putNumber[0]);
		timing.setText(timings[position]);
		places.setText(mapPlaces[position]);
		return V;
		// return inflater.inflate(R.layout.singleevent, container, false);
		/*
		 * LayoutParams params = new LayoutParams( LayoutParams.MATCH_PARENT ,
		 * 100); LayoutParams p= new LayoutParams(200, 200, Gravity.CENTER);
		 * FrameLayout fl = new FrameLayout(getActivity());
		 * fl.setLayoutParams(params);
		 * 
		 * final int margin = (int)
		 * TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8,
		 * getResources() .getDisplayMetrics());
		 * 
		 * ImageView iv=new ImageView(getActivity()); params.setMargins(margin,
		 * margin, margin, margin); iv.setLayoutParams(params);
		 * iv.setImageResource(images[position%2]); fl.addView(iv);
		 * 
		 * TextView v = new TextView(getActivity()); params.setMargins(margin,
		 * margin, margin, margin); v.setLayoutParams(params);
		 * v.setLayoutParams(params); v.setGravity(Gravity.CENTER);
		 * v.setBackgroundResource(R.drawable.background_card);
		 * v.setText("Description " + (position + 1));
		 * 
		 * fl.addView(v); return fl;
		 */
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		// get the button view
		RelativeLayout rlContact = (RelativeLayout) getView().findViewById(
				R.id.rlcontact);
		RelativeLayout rlMaps = (RelativeLayout) getView().findViewById(
				R.id.rlmaps);
		RelativeLayout rlRemainder = (RelativeLayout) getView().findViewById(
				R.id.rlReminder);
		remainderCheck = (ImageView) getView().findViewById(R.id.checkBox1);
		RelativeLayout rlQuick = (RelativeLayout) getView().findViewById(
				R.id.rlQuick);
		// set a onclick listener for when the button gets clicked
		rlContact.setOnClickListener(this);
		rlMaps.setOnClickListener(this);
		rlRemainder.setOnClickListener(this);
		remainderCheck.setOnClickListener(this);
		rlQuick.setOnClickListener(this);
		remainderCheck
				.setBackgroundResource(starImage[checkBoxRefer[position + 1]]);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v.getId() == R.id.rlcontact) {
			/*
			 * Intent mainIntent = new Intent(Intent.ACTION_DIAL);
			 * mainIntent.setData(Uri.parse("tel:9445426880"));
			 * startActivity(mainIntent);
			 */
			QuickContact dialog = new QuickContact(name[position + 1],
					mobnumber[position + 1]);
			dialog.show(getFragmentManager(), "QuickContactFragment");
		} else if (v.getId() == R.id.rlmaps) {
			/*
			 * Intent myIntent = new Intent(this.getActivity(),
			 * NavigationView.class);
			 */
			Intent myMapIntent = new Intent(this.getActivity(), LocateMe.class);
			myMapIntent.putExtra("Eventname", mapPlaces[position]);
			myMapIntent.putExtra("locatethisplace", locateplace[position]);
			this.getActivity().startActivity(myMapIntent);
			/*
			 * Intent mainIntent = new Intent(Intent.ACTION_DIAL);
			 * mainIntent.setData(Uri.parse("tel:9445426880"));
			 * startActivity(mainIntent);
			 */
		} else if (v.getId() == R.id.rlReminder) {

		} else if (v.getId() == R.id.checkBox1) {

			final Dialog dialog = new Dialog(getActivity(), R.style.PauseDialog);
			dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
			dialog.setTitle("Notice ! ! !");
			dialog.getWindow().setBackgroundDrawable(
					new ColorDrawable(android.graphics.Color.TRANSPARENT));

			dialog.setCancelable(true);

			dialog.setContentView(R.layout.dialogue_clock);

			final Button okiebtn = (Button) dialog.findViewById(R.id.okie);
			TextView toastmsg = (TextView) dialog.findViewById(R.id.toastText);

			okiebtn.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View View3) {
					dialog.dismiss();

				}
			});

			// dialog.show();
			// okiebtn.startAnimation(fromRight);
			setPreference(position);
			remainderCheck.setBackgroundResource(starImage[statPosition]);
			if (statPosition == 1) {
				setAlarm(position);
				toastmsg.setText("Alarm And Notification Was Created");
			} else if (statPosition == 0) {
				cancelAlarm(Unique_Id[position]);
				toastmsg.setText("Alarm And Notification Was Cancelled");
			}
			dialog.show();
			okiebtn.startAnimation(fromRight);
		} else if (v.getId() == R.id.rlQuick) {
			myQuicklink = QLinks[position];
			Intent in = new Intent(Intent.ACTION_VIEW,
					Uri.parse("http://www.kurukshetra.org.in/events/"
							+ myQuicklink));
			startActivity(in);
		}

	}

}
