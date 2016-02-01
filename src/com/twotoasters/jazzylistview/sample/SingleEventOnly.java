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
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.manuelpeinado.fadingactionbar.FadingActionBarHelper;

public class SingleEventOnly extends FragmentActivity implements
		OnClickListener {

	private static final int ID_ADD = 1;
	private static final int ID_ACCEPT = 2;
	private static final int ID_UPLOAD = 3;

	Bitmap bitmap1, bitmap2;

	RelativeLayout rContact, rMaps, rRemainder;
	CheckBox alarmCheck;
	int imagePosition = 0;
	String mapPlaces[] = { "   Venue : Online Event", "Venue : Mini Gallery",
			"Venue : S N H Hall-201 to 212", "Venue : Event Finished Already",
			"   Venue : Main Gallery", "Venue : Online Event" };
	String Title[] = { "Riddles Of Sphinx", "God Speed", "Math Modelling",
			"3D Printing", "Innovate", "Dalal Bull" };
	String timings[] = { "Event Finished Already ",
			"Jan 31   10:30 AM to 10:00 PM ", "Feb 1   9:30 AM to 11:30 AM ",
			"Event Finished Already", "Jan 30   10:30 AM Onwards ",
			"Event Finished Already" };
	String mapplac[] = { " Venue : Ceg - Online Event",
			" Venue : Mini Gallery", " Venue : S N H Hall-201 to 212",
			"   Venue : Will Be Update", " Venue : Main Gallery",
			" Venue : Ceg - Online Event" };
	String quotes[] = new String[50];// Main Run has begun.","Main Run has
										// begun.","Main Run has begun.","Main
										// Run has begun."," To play the game.
										// Go to Link:
										// http://kurukshetra.org.in/ros/","Main
										// Run has begun."};
	String description[] = new String[50];
	String name[] = new String[50];
	String mobnumber[] = new String[50];// RoS 2014 is the 8th edition ","of the
										// online"," treasure ","hunt of
										// Kurukshetra. Contained within this
										// hunt, are a series of levels, along
										// with clues, ","both visual ","and
										// verbal and a plethora of labyrinths,
										// mazes and puzzles that only the most
										// intelligent and persistent of the
										// competitors can survive.\nRoS fosters
										// lateral thinking, on-the-spot multi
										// tasking and probes into the deeper
										// understanding of how the brain
										// processes things and how best our
										// train of thought works. RoS is widely
										// popular and quite addicting due to
										// its easy accessibility, universal
										// understanding and fun trivia.\nThe
										// key to every riddle can be solved
										// using your intellect and skill (luck
										// will not lead you to the answer).
										// Anyone anywhere in the world can
										// uncover the clues and solve the
										// riddles to discover the hidden
										// treasure. So if you are an Indie
										// Jones fan or have grown up yearning
										// to be a treasure hunter like Miss
										// Croft, fear not, RoS will bring you
										// the same puzzling challenges and
										// riddles at the comfort of your
										// home.\nStay tuned!\nMAIN EVENT starts
										// on January 5th, 2014 at 7.00 p.m.",
	String cur_name[];
	String cur_num[];
	int positionvalue;
	// };
	private Animation fromRight;
	int imageArray[] = { R.drawable.onlineros1, R.drawable.godspeed1,
			R.drawable.appgeneralmath1, R.drawable.printingnew,
			R.drawable.innovate1, R.drawable.onlinedalalbull1 };

	public void EnableGps() {
		Intent intent = new Intent("android.location.GPS_ENABLED_CHANGE");
		intent.putExtra("enabled", true);
		sendBroadcast(intent);
	}

	String notificationNames[] = { "Riddles OF Sphinx", "God Speed",
			"Math Modelling", "3D Printing", "Innovate", "Dalal Bull" };
	int locateplace[] = { 0, 7, 2, 0, 4, 0, 0, 0, 0 };
	int checkBoxRefer[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0 };
	int checkInc = 1;

	// For Alarm Purpose
	int Alarm_Day[] = { 28, 31, 1, 28, 30, 28, 30, 30 };
	int Alarm_Hour[] = { 11, 10, 9, 9, 10, 21 };
	int Alarm_Minute[] = { 45, 15, 15, 15, 15, 45 };
	int Unique_Id[] = { 60, 61, 62, 63, 64, 65 };
	int alarmFlag1, alarmFlag2, alarmFlag3, alarmFlag4, alarmFlag5, alarmFlag6;
	int setpage;
	int starImage[] = { R.drawable.star_notpressed2, R.drawable.star_pressed2 };
	public int statPosition = 0;
	ImageView remainderCheck;

	public void setPreference(int position) {
		switch (position) {
		case 0:
			/*
			 * SharedPreferences AlarmCatOneEveOne =
			 * this.getSharedPreferences("AlarmCatOneEveOne", 0); alarmFlag1 =
			 * AlarmCatOneEveOne.getInt("AlarmCatOneEveOneFlag", 0); Editor
			 * edit1 = AlarmCatOneEveOne.edit(); if(alarmFlag1==0) {
			 * edit1.putInt("AlarmCatOneEveOneFlag",1); edit1.commit();
			 * statPosition=1; } else { edit1.putInt("AlarmCatOneEveOneFlag",0);
			 * edit1.commit(); statPosition=0; }
			 */
			break;
		case 1:
			SharedPreferences AlarmCatTwoEveFive = this.getSharedPreferences(
					"AlarmCatTwoEveFive", 0);
			alarmFlag2 = AlarmCatTwoEveFive.getInt("AlarmCatTwoEveFiveFlag", 0);
			Editor edit2 = AlarmCatTwoEveFive.edit();
			if (alarmFlag2 == 0) {
				edit2.putInt("AlarmCatTwoEveFiveFlag", 1);
				edit2.commit();
				statPosition = 1;
			} else {
				edit2.putInt("AlarmCatTwoEveFiveFlag", 0);
				edit2.commit();
				statPosition = 0;
			}

			break;
		case 2:
			SharedPreferences AlarmCatEightEveTwo = this.getSharedPreferences(
					"AlarmCatEightEveTwo", 0);
			alarmFlag3 = AlarmCatEightEveTwo.getInt("AlarmCatEightEveTwoFlag",
					0);
			Editor edit3 = AlarmCatEightEveTwo.edit();
			if (alarmFlag3 == 0) {
				edit3.putInt("AlarmCatEightEveTwoFlag", 1);
				edit3.commit();
				statPosition = 1;
			} else {
				edit3.putInt("AlarmCatEightEveTwoFlag", 0);
				edit3.commit();
				statPosition = 0;
			}
			break;
		case 3:
			/*
			 * SharedPreferences AlarmCatOneEveFour =
			 * this.getSharedPreferences("AlarmCatOneEveFour", 0); alarmFlag4 =
			 * AlarmCatOneEveFour.getInt("AlarmCatOneEveFourFlag", 0); Editor
			 * edit4 = AlarmCatOneEveFour.edit(); if(alarmFlag4==0) {
			 * edit4.putInt("AlarmCatOneEveFourFlag",1); edit4.commit();
			 * statPosition=1; } else {
			 * edit4.putInt("AlarmCatOneEveFourFlag",0); edit4.commit();
			 * statPosition=0; }
			 */
			break;
		case 4:
			SharedPreferences AlarmCatTwoEveOne = this.getSharedPreferences(
					"AlarmCatTwoEveOne", 0);
			alarmFlag5 = AlarmCatTwoEveOne.getInt("AlarmCatTwoEveOneFlag", 0);
			Editor edit5 = AlarmCatTwoEveOne.edit();
			if (alarmFlag5 == 0) {
				edit5.putInt("AlarmCatTwoEveOneFlag", 1);
				edit5.commit();
				statPosition = 1;
			} else {
				edit5.putInt("AlarmCatTwoEveOneFlag", 0);
				edit5.commit();
				statPosition = 0;
			}
			break;
		case 5:
			/*
			 * SharedPreferences AlarmCatOneEveSix =
			 * this.getSharedPreferences("AlarmCatOneEveSix", 0); alarmFlag6 =
			 * AlarmCatOneEveSix.getInt("AlarmCatOneEveSixFlag", 0); Editor
			 * edit6 = AlarmCatOneEveSix.edit(); if(alarmFlag6==0) {
			 * edit6.putInt("AlarmCatOneEveSixFlag",1); edit6.commit();
			 * statPosition=1; } else { edit6.putInt("AlarmCatOneEveSixFlag",0);
			 * edit6.commit(); statPosition=0; }
			 */
			break;
		}
	}

	public void putSharedValue() {

		// SharedPreferences AlarmCatOneEveOne =
		// this.getSharedPreferences("AlarmCatOneEveOne", 0);
		// alarmFlag1 = AlarmCatOneEveOne.getInt("AlarmCatOneEveOneFlag", 0);
		checkBoxRefer[1] = 0;

		SharedPreferences AlarmCatTwoEveFive = this.getSharedPreferences(
				"AlarmCatTwoEveFive", 0);
		alarmFlag2 = AlarmCatTwoEveFive.getInt("AlarmCatTwoEveFiveFlag", 0);
		checkBoxRefer[2] = alarmFlag5;

		SharedPreferences AlarmCatEightEveTwo = this.getSharedPreferences(
				"AlarmCatEightEveTwo", 0);
		alarmFlag3 = AlarmCatEightEveTwo.getInt("AlarmCatEightEveTwoFlag", 0);
		checkBoxRefer[3] = alarmFlag3;

		// SharedPreferences AlarmCatOneEveFour =
		// this.getSharedPreferences("AlarmCatOneEveFour", 0);
		// alarmFlag4 = AlarmCatOneEveFour.getInt("AlarmCatOneEveFourFlag", 0);
		checkBoxRefer[4] = 0;

		SharedPreferences AlarmCatTwoEveOne = this.getSharedPreferences(
				"AlarmCatTwoEveOne", 0);
		alarmFlag5 = AlarmCatTwoEveOne.getInt("AlarmCatTwoEveOneFlag", 0);
		checkBoxRefer[5] = alarmFlag5;

		// SharedPreferences AlarmCatOneEveSix =
		// this.getSharedPreferences("AlarmCatOneEveSix", 0);
		// alarmFlag6 = AlarmCatOneEveSix.getInt("AlarmCatOneEveSixFlag", 0);
		checkBoxRefer[6] = 0;

	}

	// For Alarm Purpose

	public void setAlarm(int Event_Number) {
		Calendar calSet = Calendar.getInstance();
		calSet.clear();
		calSet.set(Calendar.DATE, Alarm_Day[Event_Number]);
		if (Event_Number == 2) {
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

		if (calSet.compareTo(calSet) <= 0) {
			// Today Set time passed, count to tomorrow

			// calSet.add(Calendar.DATE, 1);
		}

		Intent intent = new Intent(this, AlarmReceiver.class);
		intent.putExtra("alarmrefer", notificationNames[positionvalue]);
		AlarmManager alarmManager = (AlarmManager) this
				.getSystemService(Context.ALARM_SERVICE);
		PendingIntent pendingIntent = PendingIntent.getBroadcast(this,
				Unique_Id[Event_Number], intent, 0);
		alarmManager.set(AlarmManager.RTC_WAKEUP, calSet.getTimeInMillis(),
				pendingIntent);

		Toast.makeText(this, "Alarm is set@ " + calSet.getTime(),
				Toast.LENGTH_LONG).show();

	}

	private void cancelAlarm(int data) {
		Intent intent = new Intent(this, AlarmReceiver.class);
		// intent.setData(Uri.parse("myalarms://" + data));
		PendingIntent pendingIntent = PendingIntent.getBroadcast(this, data,
				intent, PendingIntent.FLAG_CANCEL_CURRENT);
		AlarmManager alarmManager = (AlarmManager) this
				.getSystemService(Context.ALARM_SERVICE);
		alarmManager.cancel(pendingIntent);
		Toast.makeText(this, "Alarm and Notification Canceled  ",
				Toast.LENGTH_LONG).show();

	}

	public void putvalue() {
		int i = 0;
		try {
			XmlResourceParser xpp = getResources().getXml(R.xml.singleeventdes);

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
					for (i = 0; i < 7; i++) {
						if (iter == i) {
							if (elemtext.equals("details")) {
								description[i] = xpp.getText();
							}
							if (elemtext.equals("quotes")) {
								quotes[i] = xpp.getText();
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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intent = getIntent();
		positionvalue = intent.getIntExtra("first", 0);
		// setTitle("   " + Title[positionvalue]);
		putvalue();
		putSharedValue();

		FadingActionBarHelper helper = new FadingActionBarHelper()
				// .actionBarBackground(R.drawable.white2) Refer
				.actionBarBackground(R.drawable.ab_background)
				.headerLayout(R.layout.header)
				.contentLayout(R.layout.singleevent1);

		setContentView(helper.createView(this));
		ImageView myImage = (ImageView) findViewById(R.id.image_header);
		TextView Desctn = (TextView) findViewById(R.id.descri);
		TextView briefDecspn = (TextView) findViewById(R.id.briefdescription);
		TextView artistDetails = (TextView) findViewById(R.id.artist);
		TextView timing = (TextView) findViewById(R.id.artist1);
		TextView mapplaces = (TextView) findViewById(R.id.title);

		cur_name = name[positionvalue + 1].split("\\.");
		cur_num = mobnumber[positionvalue + 1].split("\\.");

		artistDetails.setText(cur_name[0] + " : " + cur_num[0]);

		quotes[positionvalue + 1] = quotes[positionvalue + 1].trim();
		description[positionvalue + 1] = description[positionvalue + 1].trim();
		quotes[positionvalue + 1] = quotes[positionvalue + 1].replaceAll(" +",
				" ");
		description[positionvalue + 1] = description[positionvalue + 1]
				.replaceAll(" +", " ");

		// Toast.makeText(this,"Refer : "+description[positionvalue +
		// 1],Toast.LENGTH_SHORT).show();

		Desctn.setText(quotes[positionvalue + 1]);

		briefDecspn.setText(description[positionvalue + 1]);

		myImage.setBackgroundResource(imageArray[positionvalue]);

		timing.setText(timings[positionvalue]);

		mapplaces.setText(mapplac[positionvalue]);

		fromRight = AnimationUtils.loadAnimation(getApplicationContext(),

		R.anim.right);

		rContact = (RelativeLayout) findViewById(R.id.rlcontact);
		rMaps = (RelativeLayout) findViewById(R.id.rlmaps);
		rRemainder = (RelativeLayout) findViewById(R.id.rlReminder);
		remainderCheck = (ImageView) findViewById(R.id.checkBox1);

		rContact.setOnClickListener(this);
		rMaps.setOnClickListener(this);
		remainderCheck.setOnClickListener(this);
		// ImageView iv= (ImageView) findViewById(R.id.ivHeader);
		// iv.setBackgroundResource(imageArray[imagePosition]);
		// iv.setVisibility(View.INVISIBLE);
		// buttonref1.setOnClickListener(this);

		helper.initActionBar(this);
		remainderCheck
				.setBackgroundResource(starImage[checkBoxRefer[positionvalue + 1]]);

	}

	// setup the action item click listener

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		// getMenuInflater().inflate(R.menu.bottomaction, menu);
		return true;

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {

		case R.id.contactinformation:

			// Toast.makeText(this, "3", Toast.LENGTH_LONG).show();
			// mQuickAction.show(v);
			QuickContactFragment dialog = new QuickContactFragment();
			dialog.show(getSupportFragmentManager(), "QuickContactFragment");
			break;
		default:
			;

		}
		return false;
	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {

		case R.id.rlcontact:
			ViewGroup viewGroup = (ViewGroup) arg0;
			for (int i = 0; i < viewGroup.getChildCount(); i++) {

				View viewChild = viewGroup.getChildAt(i);
				viewChild.setPressed(true);

			}
			Intent intent = new Intent(Intent.ACTION_DIAL);
			intent.setData(Uri.parse("tel:" + cur_num[0]));
			startActivity(intent);
			// QuickContact newFragment=new
			// QuickContact(name[positionvalue+1],mobnumber[positionvalue+1]);
			// newFragment.setTargetFragment(this, "hai");

			break;

		case R.id.rlmaps:

			// Enabling Gps
			// EnableGps();
			// Enabling Gps
			// Intent openMap = new
			// Intent(SingleEventOnly.this,MapActivity.class);
			// Intent openMap = new Intent(SingleEventOnly.this,
			// NavigationView.class);
			ConnectionDetector cd = new ConnectionDetector(
					getApplicationContext());
			Boolean isInternetPresent = cd.isConnectingToInternet();

			// Must Refer

			/*
			 * if (isInternetPresent) { Intent openMap = new
			 * Intent(SingleEventOnly.this, MapNavigation.class);
			 * startActivity(openMap); } else { Intent openMap = new
			 * Intent(SingleEventOnly.this, NavigationView.class);
			 * startActivity(openMap);
			 * 
			 * }
			 */
			/*
			 * Intent openMap = new Intent(SingleEventOnly.this,
			 * MapNavigation.class);
			 */
			Intent myMapIntent = new Intent(SingleEventOnly.this,
					LocateMe.class);
			myMapIntent.putExtra("locatethisplace", locateplace[positionvalue]);
			myMapIntent.putExtra("Eventname", mapPlaces[positionvalue]);

			startActivity(myMapIntent);

			break;
		case R.id.rlReminder:

			break;
		case R.id.checkBox1:
			final Dialog dialog = new Dialog(SingleEventOnly.this,
					R.style.PauseDialog);
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
			setPreference(positionvalue);
			remainderCheck.setBackgroundResource(starImage[statPosition]);

			if (statPosition == 1) {
				setAlarm(positionvalue);

				toastmsg.setText("Alarm And Notification was Created");
			} else if (statPosition == 0) {
				cancelAlarm(Unique_Id[positionvalue]);
				toastmsg.setText("Alarm And Notification was Cancelled");
			}
			dialog.show();
			okiebtn.startAnimation(fromRight);

			break;

		default:
			;

		}

	}

	public class ConnectionDetector {

		private Context _context;

		public ConnectionDetector(Context context) {
			this._context = context;
		}

		public boolean isConnectingToInternet() {
			ConnectivityManager connectivity = (ConnectivityManager) _context
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			if (connectivity != null) {
				NetworkInfo[] info = connectivity.getAllNetworkInfo();
				if (info != null)
					for (int i = 0; i < info.length; i++)
						if (info[i].getState() == NetworkInfo.State.CONNECTED) {
							return true;
						}

			}
			return false;
		}
	}
}
