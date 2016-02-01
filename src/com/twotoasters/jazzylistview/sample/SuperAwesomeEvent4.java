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

public class SuperAwesomeEvent4 extends Fragment implements
		View.OnClickListener {

	private static final String ARG_POSITION = "position";

	private int position, i;
	ImageView remainderCheck;
	private Animation fromRight;

	private int[] images = { R.drawable.scitechimg2, R.drawable.biz1,
			R.drawable.howstuffworks1, R.drawable.schoolquiz1,
			R.drawable.openquiz1 };
	String[] maindescription = new String[50];
	String[] quotedescription = new String[50];
	String[] name = new String[50];
	String[] mobnumber = new String[50];
	String[] putName = new String[50];
	String[] putNumber = new String[50];
	String QLinks[] = { "stq", "biz", "hsw", "school", "open" };
	String timings[] = { "Jan 30   1:30 PM to 3:00 PM ",
			"Jan 31   2:30 PM to 4:00 PM ", "Jan 30   11:00 AM to 12:30 PM ",
			"Feb 1   1:30 PM to 4:00 PM ", "Feb 1   5:00 PM to 11:00 PM " };
	String mapPlaces[] = { "Venue : Tag Auditorium", "Venue : Tag Auditorium",
			"Venue : Tag Auditorium", " Venue : Tag Auditorium",
			"Venue : Vivek Auditorium",
			"Venue : Ece Depat Ground Floor & Maxwell audi" };
	String myQuicklink = "#";
	String notificationNames[] = { "Sci - tech Quiz", "Biz Quiz",
			"How Stuff Works", "School Quiz", "Open Quiz", "Energise",
			"Mega Structures", "Aero Modelling", "Simply Circuits" };
	int locationplace[] = { 10, 10, 10, 10, 0 };
	int alarmFlag1, alarmFlag2, alarmFlag3, alarmFlag4, alarmFlag5, alarmFlag6,
			alarmFlag7, alarmFlag8, alarmFlag9, alarmFlag10;

	int checkBoxRefer[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0 };
	int starImage[] = { R.drawable.star_notpressed2, R.drawable.star_pressed2 };
	public int statPosition = 0;
	int Unique_Id[] = { 19, 20, 21, 22, 23 };
	int Alarm_Day[] = { 30, 31, 30, 1, 1, 31, 30, 30, 31 };
	int Alarm_Hour[] = { 13, 14, 10, 13, 16, 13, 9, 10, 11 };
	int Alarm_Minute[] = { 15, 15, 45, 15, 45, 45, 45, 45, 15 };

	public void setPreference(int position) {
		switch (position) {
		case 0:
			SharedPreferences AlarmCatFourEveOne = getActivity()
					.getSharedPreferences("AlarmCatFourEveOne", 0);
			alarmFlag1 = AlarmCatFourEveOne.getInt("AlarmCatFourEveOneFlag", 0);
			Editor edit1 = AlarmCatFourEveOne.edit();
			if (alarmFlag1 == 0) {
				edit1.putInt("AlarmCatFourEveOneFlag", 1);
				edit1.commit();
				statPosition = 1;
			} else {
				edit1.putInt("AlarmCatFourEveOneFlag", 0);
				edit1.commit();
				statPosition = 0;
			}
			break;
		case 1:
			SharedPreferences AlarmCatFourEveTwo = getActivity()
					.getSharedPreferences("AlarmCatFourEveTwo", 0);
			alarmFlag2 = AlarmCatFourEveTwo.getInt("AlarmCatFourEveTwoFlag", 0);
			Editor edit2 = AlarmCatFourEveTwo.edit();
			if (alarmFlag2 == 0) {
				edit2.putInt("AlarmCatFourEveTwoFlag", 1);
				edit2.commit();
				statPosition = 1;
			} else {
				edit2.putInt("AlarmCatFourEveTwoFlag", 0);
				edit2.commit();
				statPosition = 0;
			}
			break;
		case 2:
			SharedPreferences AlarmCatFourEveThree = getActivity()
					.getSharedPreferences("AlarmCatFourEveThree", 0);
			alarmFlag3 = AlarmCatFourEveThree.getInt(
					"AlarmCatFourEveThreeFlag", 0);
			Editor edit3 = AlarmCatFourEveThree.edit();
			if (alarmFlag3 == 0) {
				edit3.putInt("AlarmCatFourEveThreeFlag", 1);
				edit3.commit();
				statPosition = 1;
			} else {
				edit3.putInt("AlarmCatFourEveThreeFlag", 0);
				edit3.commit();
				statPosition = 0;
			}
			break;
		case 3:
			SharedPreferences AlarmCatFourEveFour = getActivity()
					.getSharedPreferences("AlarmCatFourEveFour", 0);
			alarmFlag4 = AlarmCatFourEveFour.getInt("AlarmCatFourEveFourFlag",
					0);
			Editor edit4 = AlarmCatFourEveFour.edit();
			if (alarmFlag4 == 0) {
				edit4.putInt("AlarmCatFourEveFourFlag", 1);
				edit4.commit();
				statPosition = 1;
			} else {
				edit4.putInt("AlarmCatFourEveFourFlag", 0);
				edit4.commit();
				statPosition = 0;
			}
			break;
		case 4:
			SharedPreferences AlarmCatFourEveFive = getActivity()
					.getSharedPreferences("AlarmCatFourEveFive", 0);
			alarmFlag5 = AlarmCatFourEveFive.getInt("AlarmCatFourEveFiveFlag",
					0);
			Editor edit5 = AlarmCatFourEveFive.edit();
			if (alarmFlag5 == 0) {
				edit5.putInt("AlarmCatFourEveFiveFlag", 1);
				edit5.commit();
				statPosition = 1;
			} else {
				edit5.putInt("AlarmCatFourEveFiveFlag", 0);
				edit5.commit();
				statPosition = 0;
			}

			break;

		}
	}

	public void putSharedValue() {

		SharedPreferences AlarmCatFourEveOne = getActivity()
				.getSharedPreferences("AlarmCatFourEveOne", 0);
		alarmFlag1 = AlarmCatFourEveOne.getInt("AlarmCatFourEveOneFlag", 0);
		checkBoxRefer[1] = alarmFlag1;

		SharedPreferences AlarmCatFourEveTwo = getActivity()
				.getSharedPreferences("AlarmCatFourEveTwo", 0);
		alarmFlag2 = AlarmCatFourEveTwo.getInt("AlarmCatFourEveTwoFlag", 0);
		checkBoxRefer[2] = alarmFlag2;

		SharedPreferences AlarmCatFourEveThree = getActivity()
				.getSharedPreferences("AlarmCatFourEveThree", 0);
		alarmFlag3 = AlarmCatFourEveThree.getInt("AlarmCatFourEveThreeFlag", 0);
		checkBoxRefer[3] = alarmFlag3;

		SharedPreferences AlarmCatFourEveFour = getActivity()
				.getSharedPreferences("AlarmCatFourEveFour", 0);
		alarmFlag4 = AlarmCatFourEveFour.getInt("AlarmCatFourEveFourFlag", 0);
		checkBoxRefer[4] = alarmFlag4;

		SharedPreferences AlarmCatFourEveFive = getActivity()
				.getSharedPreferences("AlarmCatFourEveFive", 0);
		alarmFlag5 = AlarmCatFourEveFive.getInt("AlarmCatFourEveFiveFlag", 0);
		checkBoxRefer[5] = alarmFlag5;

	}

	// For Alarm Purpose

	public void setAlarm(int Event_Number) {
		Calendar calSet = Calendar.getInstance();
		Calendar calset = Calendar.getInstance();
		calSet.clear();
		calSet.set(Calendar.DATE, Alarm_Day[Event_Number]);
		if (Event_Number == 3 || Event_Number == 4) {
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
			 Toast.makeText(getActivity(), "Event Finished Already",
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
		Toast.makeText(getActivity(), "Alarm and Notification Canceled ",
				Toast.LENGTH_LONG).show();

	}

	public void putvalue() {
		try {
			XmlResourceParser xpp = getResources().getXml(
					R.xml.eventdesciption4);

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

	public static SuperAwesomeEvent4 newInstance(int position) {
		SuperAwesomeEvent4 f = new SuperAwesomeEvent4();
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
		iv.setImageResource(images[position % 5]);
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
			myMapIntent.putExtra("locatethisplace", locationplace[position]);
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
				toastmsg.setText("Alarm And Notification was created");
			} else if (statPosition == 0) {
				cancelAlarm(Unique_Id[position]);
				toastmsg.setText("Alarm And Notification was cancelled");
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
