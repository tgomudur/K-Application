package com.twotoasters.jazzylistview.sample;

import in.org.kurukshetra.app.R;
import java.io.IOException;
import java.util.Calendar;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.annotation.SuppressLint;
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
import android.view.Menu;
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

public class SuperAwesomeEvent1 extends Fragment implements
		View.OnClickListener {

	private static final String ARG_POSITION = "position";

	private int position, i, myPosition;

	private Animation fromRight;
	String putName[] = new String[10];
	String putNumber[] = new String[10];
	String QLinks[] = { "OSPC", "OSDEBUG", "HEPTA", "WOF", "softcoding",
			"hackathon" };
	String myQuicklink = "#";

	private int[] images = { R.drawable.onsite, R.drawable.debug1,
			R.drawable.hepthatalon1, R.drawable.foss1, R.drawable.soft1,
			R.drawable.hackathon1 };
	String[] maindescription = new String[50];
	String[] quotedescription = new String[50];
	String name[] = new String[50];
	String mobnumber[] = new String[50];
	String timings[] = { "Jan 30   12 PM to 1 PM ",
			"Jan 30   1:30 PM to 3:30 PM ", "Jan 31   2:30 PM to 4:30 PM ",
			"Feb 1   9:30 AM to 11:30 AM ", "Event Finished Already",
			"Jan 31   10 PM to 5 AM " };
	String mapPlaces[] = { "   Venue : Vivek Auditorium",
			"Venue : S N H Hall-201 to 218", "Venue : S N H Hall-200 to 212",
			"Venue : CSE Department", "   Venue : Vivek Auditorium",
			"Venue : Event Finished Already" };
	String parseRefer = "If coding is your religion and Ritchie and Ada are your gods, then Kurukshetra's OSPC is designed to set your grey cells in action. So pull up your sleeves and get ready to tackle fellow coding gurus and code yourway to the top. Flaunt your real skills in cracking mind boggling programming questions and walk away with the top honours.";
	String parserefer1 = "If coding is your religion and Ritchie and Ada are your gods, then Kurukshetra's OSPC is designed to set your grey cells in action.So pull up your sleeves and get ready to tackle fellow coding gurus and code yourway to the top. Flaunt your real skills in cracking mind boggling programming questions and walk away with the top honours.";
	String notificationNames[] = { "Onsite Programming", "Onsite Debugging",
			"Heptathlon", "Wizards Of Foss", "Microsoft's SoftCoding",
			"Paypal's Hackathon" };
	int locateplace[] = { 0, 2, 2, 3, 0, 0, 0, 0, 0 };
	int checkBoxRefer[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0 };
	int checkInc = 1;

	// For Alarm Purpose
	int Alarm_Day[] = { 30, 30, 31, 1, 30, 31, 30, 30 };
	int Alarm_Hour[] = { 11, 13, 14, 9, 21, 21 };
	int Alarm_Minute[] = { 45, 15, 15, 15, 45, 45 };
	int Unique_Id[] = { 1, 2, 3, 4, 5, 6 };
	int alarmFlag1, alarmFlag2, alarmFlag3, alarmFlag4, alarmFlag5, alarmFlag6;
	int setpage;
	int starImage[] = { R.drawable.star_notpressed2, R.drawable.star_pressed2 };
	public int statPosition = 0;
	ImageView remainderCheck;

	public void setPreference(int position) {
		switch (position) {
		case 0:
			SharedPreferences AlarmCatOneEveOne = getActivity()
					.getSharedPreferences("AlarmCatOneEveOne", 0);
			alarmFlag1 = AlarmCatOneEveOne.getInt("AlarmCatOneEveOneFlag", 0);
			Editor edit1 = AlarmCatOneEveOne.edit();
			if (alarmFlag1 == 0) {
				edit1.putInt("AlarmCatOneEveOneFlag", 1);
				edit1.commit();
				statPosition = 1;
			} else {
				edit1.putInt("AlarmCatOneEveOneFlag", 0);
				edit1.commit();
				statPosition = 0;
			}
			break;
		case 1:
			SharedPreferences AlarmCatOneEveTwo = getActivity()
					.getSharedPreferences("AlarmCatOneEveTwo", 0);
			alarmFlag2 = AlarmCatOneEveTwo.getInt("AlarmCatOneEveTwoFlag", 0);
			Editor edit2 = AlarmCatOneEveTwo.edit();
			if (alarmFlag2 == 0) {
				edit2.putInt("AlarmCatOneEveTwoFlag", 1);
				edit2.commit();
				statPosition = 1;
			} else {
				edit2.putInt("AlarmCatOneEveTwoFlag", 0);
				edit2.commit();
				statPosition = 0;
			}
			break;
		case 2:
			SharedPreferences AlarmCatOneEveThree = getActivity()
					.getSharedPreferences("AlarmCatOneEveThree", 0);
			alarmFlag3 = AlarmCatOneEveThree.getInt("AlarmCatOneEveThreeFlag",
					0);
			Editor edit3 = AlarmCatOneEveThree.edit();
			if (alarmFlag3 == 0) {
				edit3.putInt("AlarmCatOneEveThreeFlag", 1);
				edit3.commit();
				statPosition = 1;
			} else {
				edit3.putInt("AlarmCatOneEveThreeFlag", 0);
				edit3.commit();
				statPosition = 0;
			}
			break;
		case 3:
			SharedPreferences AlarmCatOneEveFour = getActivity()
					.getSharedPreferences("AlarmCatOneEveFour", 0);
			alarmFlag4 = AlarmCatOneEveFour.getInt("AlarmCatOneEveFourFlag", 0);
			Editor edit4 = AlarmCatOneEveFour.edit();
			if (alarmFlag4 == 0) {
				edit4.putInt("AlarmCatOneEveFourFlag", 1);
				edit4.commit();
				statPosition = 1;
			} else {
				edit4.putInt("AlarmCatOneEveFourFlag", 0);
				edit4.commit();
				statPosition = 0;
			}
			break;
		case 4:
			SharedPreferences AlarmCatOneEveFive = getActivity()
					.getSharedPreferences("AlarmCatOneEveFive", 0);
			alarmFlag5 = AlarmCatOneEveFive.getInt("AlarmCatOneEveFiveFlag", 0);
			Editor edit5 = AlarmCatOneEveFive.edit();
			if (alarmFlag5 == 0) {
				edit5.putInt("AlarmCatOneEveFiveFlag", 1);
				edit5.commit();
				statPosition = 1;
			} else {
				edit5.putInt("AlarmCatOneEveFiveFlag", 0);
				edit5.commit();
				statPosition = 0;
			}

			break;
		case 5:
			SharedPreferences AlarmCatOneEveSix = getActivity()
					.getSharedPreferences("AlarmCatOneEveSix", 0);
			alarmFlag6 = AlarmCatOneEveSix.getInt("AlarmCatOneEveSixFlag", 0);
			Editor edit6 = AlarmCatOneEveSix.edit();
			if (alarmFlag6 == 0) {
				edit6.putInt("AlarmCatOneEveSixFlag", 1);
				edit6.commit();
				statPosition = 1;
			} else {
				edit6.putInt("AlarmCatOneEveSixFlag", 0);
				edit6.commit();
				statPosition = 0;
			}

			break;
		}
	}

	public void putSharedValue() {

		SharedPreferences AlarmCatOneEveOne = getActivity()
				.getSharedPreferences("AlarmCatOneEveOne", 0);
		alarmFlag1 = AlarmCatOneEveOne.getInt("AlarmCatOneEveOneFlag", 0);
		checkBoxRefer[1] = alarmFlag1;

		SharedPreferences AlarmCatOneEveTwo = getActivity()
				.getSharedPreferences("AlarmCatOneEveTwo", 0);
		alarmFlag2 = AlarmCatOneEveTwo.getInt("AlarmCatOneEveTwoFlag", 0);
		checkBoxRefer[2] = alarmFlag2;

		SharedPreferences AlarmCatOneEveThree = getActivity()
				.getSharedPreferences("AlarmCatOneEveThree", 0);
		alarmFlag3 = AlarmCatOneEveThree.getInt("AlarmCatOneEveThreeFlag", 0);
		checkBoxRefer[3] = alarmFlag3;

		SharedPreferences AlarmCatOneEveFour = getActivity()
				.getSharedPreferences("AlarmCatOneEveFour", 0);
		alarmFlag4 = AlarmCatOneEveFour.getInt("AlarmCatOneEveFourFlag", 0);
		checkBoxRefer[4] = alarmFlag4;

		SharedPreferences AlarmCatOneEveFive = getActivity()
				.getSharedPreferences("AlarmCatOneEveFive", 0);
		alarmFlag5 = AlarmCatOneEveFive.getInt("AlarmCatOneEveFiveFlag", 0);
		checkBoxRefer[5] = alarmFlag5;

		SharedPreferences AlarmCatOneEveSix = getActivity()
				.getSharedPreferences("AlarmCatOneEveSix", 0);
		alarmFlag6 = AlarmCatOneEveSix.getInt("AlarmCatOneEveSixFlag", 0);
		checkBoxRefer[6] = alarmFlag6;

	}

	// For Alarm Purpose

	public void setAlarm(int Event_Number) {
		Calendar calset = Calendar.getInstance();
		Calendar calSet = Calendar.getInstance();
		calSet.clear();
		calSet.set(Calendar.DATE, Alarm_Day[Event_Number]);
		if (Event_Number == 3) {
			calSet.set(Calendar.MONTH, Calendar.FEBRUARY);
		} else {
			calSet.set(Calendar.MONTH, Calendar.JANUARY);
		}// first month is 0!!!
			// January is zero!!!
			// Hav To Update
		calSet.set(Calendar.YEAR, 2014);// year...
		calSet.set(Calendar.HOUR_OF_DAY, Alarm_Hour[Event_Number]);
		calSet.set(Calendar.MINUTE, Alarm_Minute[Event_Number]);
		calSet.set(Calendar.SECOND, 0);
		calSet.set(Calendar.MILLISECOND, 0);

		
		if (calset.compareTo(calSet) == 1) {
			// Today Set time passed, count to tomorrow
			Toast.makeText(getActivity(), "Event Finished Already ",
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
		Toast.makeText(getActivity(), "Alarm and Notification Canceled  ",
				Toast.LENGTH_LONG).show();

	}

	public void putvalue() {

		try {
			XmlResourceParser xpp = getResources().getXml(
					R.xml.eventdesciption1);

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

	public static SuperAwesomeEvent1 newInstance(int position) {
		SuperAwesomeEvent1 f = new SuperAwesomeEvent1();
		Bundle b = new Bundle();
		b.putInt(ARG_POSITION, position);

		f.setArguments(b);

		// Toast.makeText(null, "hai", Toast.LENGTH_LONG).show();
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
		TextView mapPlace = (TextView) V.findViewById(R.id.title);
		// Desctn.setText("JSR KURUKSHETRA ! ! !");

		// Static Reference

		// Desctn.setText("It is better to create than to learn! Creating is the essence of life\n                         -Julius Caesar");

		// setCheckBoxAlarm(position);

		quotedescription[position + 1] = quotedescription[position + 1].trim();
		maindescription[position + 1] = maindescription[position + 1].trim();
		quotedescription[position + 1] = quotedescription[position + 1]
				.replaceAll(" +", " ");

		String qrefer = quotedescription[position + 1].replaceAll(" \\s+", "");
		String mrefer = maindescription[position + 1].replaceAll(" \\s+", "");
		maindescription[position + 1] = maindescription[position + 1]
				.replaceAll(" +", " ");

		// Toast.makeText(getActivity(),"Refer : "+mrefer,Toast.LENGTH_SHORT).show();

		Desctn.setText(qrefer);

		// BriefDesctn.setText(mrefer);
		BriefDesctn.setText(mrefer);
		// Static Reference
		// ImageView iv=(ImageView) getView().findViewById(R.id.ivHeader);
		// ImageView iv=(ImageView) inflater.inflate(R.layout.singleevent,
		// null);
		iv.setImageResource(images[position % 7]);
		putName = name[position + 1].split("\\*");
		putNumber = mobnumber[position + 1].split("\\*");
		artistName.setText(putName[0] + " : " + putNumber[0]);
		timing.setText(timings[position]);
		mapPlace.setText(mapPlaces[position]);

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

	@SuppressLint("CutPasteId")
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
		// Toast.makeText(getActivity(),"Refer : "+checkBoxRefer[1]+" "+checkBoxRefer[2]+" "+checkBoxRefer[3]+" "+checkBoxRefer[4]+" "+checkBoxRefer[5]+" "+checkBoxRefer[6],Toast.LENGTH_LONG).show();

		//

	}

	public boolean onCreateOptionsMenu(Menu menu) {

		// menuitem.setIcon(R.drawable.selected);
		return true;
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
			/*
			 * SharedPreferences preferences =
			 * this.getActivity().getSharedPreferences("contactdata",0); Editor
			 * prefs=preferences.edit(); prefs.putString("contactname","hai");
			 * prefs.putString("contactnumber","bye" ); prefs.commit();
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
			myMapIntent.putExtra("locatethisplace", locateplace[position]);
			myMapIntent.putExtra("Eventname", mapPlaces[position]);

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

			okiebtn.startAnimation(fromRight);
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

			// Toast.makeText(getActivity(),
			// "Position : "+position,Toast.LENGTH_LONG).show();
		} else if (v.getId() == R.id.rlQuick) {
			myQuicklink = QLinks[position];
			Intent in = new Intent(Intent.ACTION_VIEW,
					Uri.parse("http://www.kurukshetra.org.in/events/"
							+ myQuicklink));
			startActivity(in);
		}

	}

}
