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

public class SuperAwesomeEvent2 extends Fragment implements
		View.OnClickListener {

	private static final String ARG_POSITION = "position";

	private int position, i;
	ImageView remainderCheck;
	private Animation fromRight;

	private int[] images = { R.drawable.innovate1, R.drawable.electrowarriors1,
			R.drawable.contraptions1, R.drawable.paper1, R.drawable.godspeed1,
			R.drawable.energise1, R.drawable.mega1, R.drawable.aero1,
			R.drawable.simplycircuits };
	String[] maindescription = new String[50];
	String[] quotesdescription = new String[50];
	String name[] = new String[50];
	String mobnumber[] = new String[50];
	String putName[] = new String[50];
	String putNumber[] = new String[50];
	// String
	// QLinks[]={"contraptions","godspeed","paperpresentation","energise","megastructures",,"innovate","aeromodelling","simplycircuits"};
	String timings[] = { "Jan 30   10:30 AM Onwards ",
			"Jan 31   10:30 AM to 1:30 PM ", "Jan 31   10:30 AM to 11:30 PM ",
			"Jan 30  11:30 AM to 5:30 PM ", "Jan 31  10:30 AM to 10:00 PM ",
			"Jan 31   2:00 PM to 4:30 PM ", "Jan 30   10:00 AM to 2:30 PM ",
			"Jan 30   11:00 AM to 7:00 PM ", "Jan 31   11:30 AM to 3:30 PM " };
	String mapPlaces[] = { "   Venue : Main Gallery",
			"Venue : S N H Hall-206 to 212", "Venue : Red Building Hall-13",
			"Venue : ECE Department,Maxwell Audi", "   Venue : Mini Gallery",
			"Venue : Red Building Hall-74 to 81",
			"Venue : Red Building Hall-82 to 84", "Venue : FootBall Ground",
			"Venue : Ece Depat Ground Floor & Maxwell audi" };
	String QLinks[] = { "innovate", "electrowarriors", "contraptions",
			"paperpresentation", "godspeed", "energise", "megastructures",
			"aeromodelling", "simplycircuits" };
	String myQuicklink = "#";
	int alarmFlag1, alarmFlag2, alarmFlag3, alarmFlag4, alarmFlag5, alarmFlag6,
			alarmFlag7, alarmFlag8, alarmFlag9, alarmFlag10;
	String notificationNames[] = { "Innovate", "Electro Warriors",
			"Contraptions", "Paper Presentation", "God Speed", "Energise",
			"Mega Structures", "Aero Modelling", "Simply Circuits" };

	int checkBoxRefer[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0 };
	int starImage[] = { R.drawable.star_notpressed2, R.drawable.star_pressed2 };
	public int statPosition = 0;
	int Unique_Id[] = { 7, 8, 9, 10, 11, 12, 13, 14, 15 };
	int Alarm_Day[] = { 30, 31, 31, 30, 31, 31, 30, 30, 31 };
	int Alarm_Hour[] = { 10, 10, 10, 11, 10, 13, 9, 10, 11 };
	int Alarm_Minute[] = { 15, 15, 15, 15, 15, 45, 45, 45, 15 };
	int locateplace[] = { 4, 2, 5, 6, 7, 5, 5, 8, 6 };

	public void setPreference(int position) {
		switch (position) {
		case 0:
			SharedPreferences AlarmCatTwoEveOne = getActivity()
					.getSharedPreferences("AlarmCatTwoEveOne", 0);
			alarmFlag1 = AlarmCatTwoEveOne.getInt("AlarmCatTwoEveOneFlag", 0);
			Editor edit1 = AlarmCatTwoEveOne.edit();
			if (alarmFlag1 == 0) {
				edit1.putInt("AlarmCatTwoEveOneFlag", 1);
				edit1.commit();
				statPosition = 1;
			} else {
				edit1.putInt("AlarmCatTwoEveOneFlag", 0);
				edit1.commit();
				statPosition = 0;
			}
			break;
		case 1:
			SharedPreferences AlarmCatTwoEveTwo = getActivity()
					.getSharedPreferences("AlarmCatTwoEveTwo", 0);
			alarmFlag2 = AlarmCatTwoEveTwo.getInt("AlarmCatTwoEveTwoFlag", 0);
			Editor edit2 = AlarmCatTwoEveTwo.edit();
			if (alarmFlag2 == 0) {
				edit2.putInt("AlarmCatTwoEveTwoFlag", 1);
				edit2.commit();
				statPosition = 1;
			} else {
				edit2.putInt("AlarmCatTwoEveTwoFlag", 0);
				edit2.commit();
				statPosition = 0;
			}
			break;
		case 2:
			SharedPreferences AlarmCatTwoEveThree = getActivity()
					.getSharedPreferences("AlarmCatTwoEveThree", 0);
			alarmFlag3 = AlarmCatTwoEveThree.getInt("AlarmCatTwoEveThreeFlag",
					0);
			Editor edit3 = AlarmCatTwoEveThree.edit();
			if (alarmFlag3 == 0) {
				edit3.putInt("AlarmCatTwoEveThreeFlag", 1);
				edit3.commit();
				statPosition = 1;
			} else {
				edit3.putInt("AlarmCatTwoEveThreeFlag", 0);
				edit3.commit();
				statPosition = 0;
			}
			break;
		case 3:
			SharedPreferences AlarmCatTwoEveFour = getActivity()
					.getSharedPreferences("AlarmCatTwoEveFour", 0);
			alarmFlag4 = AlarmCatTwoEveFour.getInt("AlarmCatTwoEveFourFlag", 0);
			Editor edit4 = AlarmCatTwoEveFour.edit();
			if (alarmFlag4 == 0) {
				edit4.putInt("AlarmCatTwoEveFourFlag", 1);
				edit4.commit();
				statPosition = 1;
			} else {
				edit4.putInt("AlarmCatTwoEveFourFlag", 0);
				edit4.commit();
				statPosition = 0;
			}
			break;
		case 4:
			SharedPreferences AlarmCatTwoEveFive = getActivity()
					.getSharedPreferences("AlarmCatTwoEveFive", 0);
			alarmFlag5 = AlarmCatTwoEveFive.getInt("AlarmCatTwoEveFiveFlag", 0);
			Editor edit5 = AlarmCatTwoEveFive.edit();
			if (alarmFlag5 == 0) {
				edit5.putInt("AlarmCatTwoEveFiveFlag", 1);
				edit5.commit();
				statPosition = 1;
			} else {
				edit5.putInt("AlarmCatTwoEveFiveFlag", 0);
				edit5.commit();
				statPosition = 0;
			}

			break;
		case 5:
			SharedPreferences AlarmCatTwoEveSix = getActivity()
					.getSharedPreferences("AlarmCatTwoEveSix", 0);
			alarmFlag6 = AlarmCatTwoEveSix.getInt("AlarmCatTwoEveSixFlag", 0);
			Editor edit6 = AlarmCatTwoEveSix.edit();
			if (alarmFlag6 == 0) {
				edit6.putInt("AlarmCatTwoEveSixFlag", 1);
				edit6.commit();
				statPosition = 1;
			} else {
				edit6.putInt("AlarmCatTwoEveSixFlag", 0);
				edit6.commit();
				statPosition = 0;
			}

			break;
		case 6:
			SharedPreferences AlarmCatTwoEveSeven = getActivity()
					.getSharedPreferences("AlarmCatTwoEveSeven", 0);
			alarmFlag7 = AlarmCatTwoEveSeven.getInt("AlarmCatTwoEveSevenFlag",
					0);
			Editor edit7 = AlarmCatTwoEveSeven.edit();
			if (alarmFlag7 == 0) {
				edit7.putInt("AlarmCatTwoEveSevenFlag", 1);
				edit7.commit();
				statPosition = 1;
			} else {
				edit7.putInt("AlarmCatTwoEveSevenFlag", 0);
				edit7.commit();
				statPosition = 0;
			}

			break;
		case 7:
			SharedPreferences AlarmCatTwoEveEight = getActivity()
					.getSharedPreferences("AlarmCatTwoEveEight", 0);
			alarmFlag8 = AlarmCatTwoEveEight.getInt("AlarmCatTwoEveEightFlag",
					0);
			Editor edit8 = AlarmCatTwoEveEight.edit();
			if (alarmFlag8 == 0) {
				edit8.putInt("AlarmCatTwoEveEightFlag", 1);
				edit8.commit();
				statPosition = 1;
			} else {
				edit8.putInt("AlarmCatTwoEveEightFlag", 0);
				edit8.commit();
				statPosition = 0;
			}

			break;
		case 8:
			SharedPreferences AlarmCatTwoEveNine = getActivity()
					.getSharedPreferences("AlarmCatTwoEveNine", 0);
			alarmFlag9 = AlarmCatTwoEveNine.getInt("AlarmCatTwoEveNineFlag", 0);
			Editor edit9 = AlarmCatTwoEveNine.edit();
			if (alarmFlag9 == 0) {
				edit9.putInt("AlarmCatTwoEveNineFlag", 1);
				edit9.commit();
				statPosition = 1;
			} else {
				edit9.putInt("AlarmCatTwoEveNineFlag", 0);
				edit9.commit();
				statPosition = 0;
			}

			break;

		}
	}

	public void putSharedValue() {

		SharedPreferences AlarmCatTwoEveOne = getActivity()
				.getSharedPreferences("AlarmCatTwoEveOne", 0);
		alarmFlag1 = AlarmCatTwoEveOne.getInt("AlarmCatTwoEveOneFlag", 0);
		checkBoxRefer[1] = alarmFlag1;

		SharedPreferences AlarmCatTwoEveTwo = getActivity()
				.getSharedPreferences("AlarmCatTwoEveTwo", 0);
		alarmFlag2 = AlarmCatTwoEveTwo.getInt("AlarmCatTwoEveTwoFlag", 0);
		checkBoxRefer[2] = alarmFlag2;

		SharedPreferences AlarmCatTwoEveThree = getActivity()
				.getSharedPreferences("AlarmCatTwoEveThree", 0);
		alarmFlag3 = AlarmCatTwoEveThree.getInt("AlarmCatTwoEveThreeFlag", 0);
		checkBoxRefer[3] = alarmFlag3;

		SharedPreferences AlarmCatTwoEveFour = getActivity()
				.getSharedPreferences("AlarmCatTwoEveFour", 0);
		alarmFlag4 = AlarmCatTwoEveFour.getInt("AlarmCatTwoEveFourFlag", 0);
		checkBoxRefer[4] = alarmFlag4;

		SharedPreferences AlarmCatTwoEveFive = getActivity()
				.getSharedPreferences("AlarmCatTwoEveFive", 0);
		alarmFlag5 = AlarmCatTwoEveFive.getInt("AlarmCatTwoEveFiveFlag", 0);
		checkBoxRefer[5] = alarmFlag5;

		SharedPreferences AlarmCatTwoEveSix = getActivity()
				.getSharedPreferences("AlarmCatTwoEveSix", 0);
		alarmFlag6 = AlarmCatTwoEveSix.getInt("AlarmCatTwoEveSixFlag", 0);
		checkBoxRefer[6] = alarmFlag6;

		SharedPreferences AlarmCatTwoEveSeven = getActivity()
				.getSharedPreferences("AlarmCatTwoEveSeven", 0);
		alarmFlag7 = AlarmCatTwoEveSeven.getInt("AlarmCatTwoEveSevenFlag", 0);
		checkBoxRefer[7] = alarmFlag7;

		SharedPreferences AlarmCatTwoEveEight = getActivity()
				.getSharedPreferences("AlarmCatTwoEveEight", 0);
		alarmFlag8 = AlarmCatTwoEveEight.getInt("AlarmCatTwoEveEightFlag", 0);
		checkBoxRefer[8] = alarmFlag8;

		SharedPreferences AlarmCatTwoEveNine = getActivity()
				.getSharedPreferences("AlarmCatTwoEveNine", 0);
		alarmFlag9 = AlarmCatTwoEveNine.getInt("AlarmCatTwoEveNineFlag", 0);
		checkBoxRefer[9] = alarmFlag9;

	}

	// For Alarm Purpose

	public void setAlarm(int Event_Number) {
		Calendar calset = Calendar.getInstance();
		Calendar calSet = Calendar.getInstance();
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
		
		if (calset.compareTo(calSet) == 1) {
			// Today Set time passed, count to tomorrow
			// Toast.makeText(getActivity(), "Event Finished Already",
			// Toast.LENGTH_LONG).show();
			// calSet.add(Calendar.DATE, 1);

			Toast.makeText(getActivity(), "Event Finished Already" ,
					Toast.LENGTH_LONG).show();
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
		// Toast.makeText(getActivity(),"Alarm Canceled : "+Alarm_Hour[data-1],Toast.LENGTH_LONG).show();

	}

	public void putvalue() {
		try {
			XmlResourceParser xpp = getResources().getXml(
					R.xml.eventdesciption2);

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
								quotesdescription[i] = xpp.getText();
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

	public static SuperAwesomeEvent2 newInstance(int position) {
		SuperAwesomeEvent2 f = new SuperAwesomeEvent2();
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
		TextView mapplaces = (TextView) V.findViewById(R.id.title);
		// Desctn.setText("JSR KURUKSHETRA ! ! !");

		// Static Reference

		// Desctn.setText("It is better to create than to learn! Creating is the essence of life\n                         -Julius Caesar");
		Desctn.setText(quotesdescription[position + 1]);
		BriefDesctn.setText(maindescription[position + 1]);
		// Static Reference
		// ImageView iv=(ImageView) getView().findViewById(R.id.ivHeader);
		// ImageView iv=(ImageView) inflater.inflate(R.layout.singleevent,
		// null);
		iv.setImageResource(images[position]);
		putName = name[position + 1].split("\\*");
		putNumber = mobnumber[position + 1].split("\\*");
		artistName.setText(putName[0] + " : " + putNumber[0]);
		timing.setText(timings[position]);
		mapplaces.setText(mapPlaces[position]);
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
				toastmsg.setText("Alarm And Notification was Created");
			} else if (statPosition == 0) {
				cancelAlarm(Unique_Id[position]);
				toastmsg.setText("Alarm And Notification was Cancelled");
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
