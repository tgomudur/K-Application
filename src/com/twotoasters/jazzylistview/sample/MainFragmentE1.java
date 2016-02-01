package com.twotoasters.jazzylistview.sample;

import in.org.kurukshetra.app.R;
import java.util.Calendar;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.astuetz.viewpager.extensions.PagerSlidingTabStrip;

public class MainFragmentE1 extends FragmentActivity {

	private final Handler handler = new Handler();

	private PagerSlidingTabStrip tabs;
	private ViewPager pager;
	private MyPagerAdapter adapter;

	private Drawable oldBackground = null;
	private int currentColor = 0xFF5161BC;

	// For Alarm Purpose
	int Alarm_Day[] = { 10, 10, 10 };
	int Alarm_Hour[] = { 18, 18, 18 };
	int Alarm_Minute[] = { 52, 54, 56 };
	int Unique_Id[] = { 1, 2, 3 };
	int alarmFlag;
	int setpage;
	// For Alarm Purpose

	MenuItem menuitem;

	public void display() {
		// TODO Auto-generated method stub
		// Toast.makeText(this, "hai", Toast.LENGTH_LONG).show();
	}

	public void setAlarm(int Event_Number) {
		Calendar calSet = Calendar.getInstance();
		calSet.clear();
		calSet.set(Calendar.DATE, Alarm_Day[Event_Number]);
		calSet.set(Calendar.MONTH, Calendar.DECEMBER); // first month is 0!!!
														// January is zero!!!
														// Hav To Update
		calSet.set(Calendar.YEAR, 2013);// year...
		calSet.set(Calendar.HOUR_OF_DAY, Alarm_Hour[Event_Number]);
		calSet.set(Calendar.MINUTE, Alarm_Minute[Event_Number]);
		calSet.set(Calendar.SECOND, 0);
		calSet.set(Calendar.MILLISECOND, 0);

		if (calSet.compareTo(calSet) <= 0) {
			// Today Set time passed, count to tomorrow

			// calSet.add(Calendar.DATE, 1);
		}
		Intent intent = new Intent(getBaseContext(), AlarmReceiver.class);
		AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
		PendingIntent pendingIntent = PendingIntent.getBroadcast(
				getBaseContext(), Unique_Id[Event_Number], intent, 0);
		alarmManager.set(AlarmManager.RTC_WAKEUP, calSet.getTimeInMillis(),
				pendingIntent);

		// Toast.makeText(this, "Alarm is set@ " + calSet.getTime(),
		// Toast.LENGTH_LONG).show();

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
		pager = (ViewPager) findViewById(R.id.pager);
		adapter = new MyPagerAdapter(getSupportFragmentManager());

		pager.setAdapter(adapter);

		final int pageMargin = (int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_DIP, 4, getResources()
						.getDisplayMetrics());
		pager.setPageMargin(pageMargin);

		tabs.setViewPager(pager);
		Intent description = getIntent();
		setpage = description.getIntExtra("descripn", 0);
		// Checking Alarm Flag
		switch (setpage) {
		case 0:
			SharedPreferences AlarmEventOne = MainFragmentE1.this
					.getSharedPreferences("AlarmEventOne", MODE_PRIVATE);
			alarmFlag = AlarmEventOne.getInt("AlarmEventOneFlag", 0);
			break;
		case 1:
			SharedPreferences AlarmEventTwo = MainFragmentE1.this
					.getSharedPreferences("AlarmEventTwo", MODE_PRIVATE);
			alarmFlag = AlarmEventTwo.getInt("AlarmEventTwoFlag", 0);
			break;
		case 2:
			SharedPreferences AlarmEventThree = MainFragmentE1.this
					.getSharedPreferences("AlarmEventThree", MODE_PRIVATE);
			alarmFlag = AlarmEventThree.getInt("AlarmEventThreeFlag", 0);
			break;
		case 3:
			SharedPreferences AlarmEventFour = MainFragmentE1.this
					.getSharedPreferences("AlarmEventFour", MODE_PRIVATE);
			alarmFlag = AlarmEventFour.getInt("AlarmEventFourFlag", 0);
			break;
		case 4:
			SharedPreferences AlarmEventFive = MainFragmentE1.this
					.getSharedPreferences("AlarmEventFive", MODE_PRIVATE);
			alarmFlag = AlarmEventFive.getInt("AlarmEventFiveFlag", 0);
			break;
		case 5:
			SharedPreferences AlarmEventSix = MainFragmentE1.this
					.getSharedPreferences("AlarmEventSix", MODE_PRIVATE);
			alarmFlag = AlarmEventSix.getInt("AlarmEventSixFlag", 0);
			break;
		case 6:
			SharedPreferences AlarmEventSeven = MainFragmentE1.this
					.getSharedPreferences("AlarmEventSeven", MODE_PRIVATE);
			alarmFlag = AlarmEventSeven.getInt("AlarmEventSevenFlag", 0);
			break;
		default:
			;
		}
		// Checking Alarm Flag
		pager.setCurrentItem(setpage);
		// Toast.makeText(this, "Swipped", Toast.LENGTH_LONG).show();
		changeColor(currentColor);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@SuppressLint("NewApi")
	boolean canAddItem = false;

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.action_contact:
			QuickContactFragment dialog = new QuickContactFragment();
			dialog.show(getSupportFragmentManager(), "QuickContactFragment");

			// change_icon();
			// getActionBar().setIcon(R.drawable.star_selected);
			// case 0:
			// Refer Here For Quick Contact
			// QuickContactFragment dialog = new QuickContactFragment();
			// dialog.show(getSupportFragmentManager(), "QuickContactFragment");
			// int current_postion=pager.getCurrentItem();
			// canAddItem=true;
			// Setting Alarm
			// setAlarm(current_postion);
			// invalidateOptionsMenu();
			// Setting Alarm
			// Toast.makeText(this,
			// "Current Position : "+current_postion,Toast.LENGTH_LONG).show();

			break;
		default:
			;
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// Please Refer This Alarm
		/*
		 * menuitem.setOnMenuItemClickListener(new OnMenuItemClickListener() {
		 * 
		 * @Override public boolean onMenuItemClick(MenuItem item) {
		 * menuitem.setIcon(R.drawable.selected); int
		 * current_postion=pager.getCurrentItem(); //canAddItem=true; //Setting
		 * Alarm setAlarm(current_postion); // Setting Prefernce flag
		 * switch(setpage) { case 0: SharedPreferences AlarmEventOne =
		 * MainFragmentE1.this.getSharedPreferences("AlarmEventOne",
		 * MODE_PRIVATE); SharedPreferences.Editor prefsEditorProfiles =
		 * AlarmEventOne.edit(); prefsEditorProfiles.putInt("AlarmEventOneFlag",
		 * 1); prefsEditorProfiles.commit(); break; case 1: SharedPreferences
		 * AlarmEventTwo =
		 * MainFragmentE1.this.getSharedPreferences("AlarmEventTwo",
		 * MODE_PRIVATE); SharedPreferences.Editor prefsEditorProfiles1 =
		 * AlarmEventTwo.edit();
		 * prefsEditorProfiles1.putInt("AlarmEventTwoFlag", 1);
		 * prefsEditorProfiles1.commit(); break; case 2: SharedPreferences
		 * AlarmEventThree =
		 * MainFragmentE1.this.getSharedPreferences("AlarmEventThree",
		 * MODE_PRIVATE); SharedPreferences.Editor prefsEditorProfiles2 =
		 * AlarmEventThree.edit();
		 * prefsEditorProfiles2.putInt("AlarmEventThreeFlag", 1);
		 * prefsEditorProfiles2.commit(); break; case 3: SharedPreferences
		 * AlarmEventFour =
		 * MainFragmentE1.this.getSharedPreferences("AlarmEventFour",
		 * MODE_PRIVATE); SharedPreferences.Editor prefsEditorProfiles3 =
		 * AlarmEventFour.edit();
		 * prefsEditorProfiles3.putInt("AlarmEventFourFlag", 1);
		 * prefsEditorProfiles3.commit(); break; case 4: SharedPreferences
		 * AlarmEventFive =
		 * MainFragmentE1.this.getSharedPreferences("AlarmEventFive",
		 * MODE_PRIVATE); SharedPreferences.Editor prefsEditorProfiles4 =
		 * AlarmEventFive.edit();
		 * prefsEditorProfiles4.putInt("AlarmEventFiveFlag", 1);
		 * prefsEditorProfiles4.commit(); break; case 5: SharedPreferences
		 * AlarmEventSix =
		 * MainFragmentE1.this.getSharedPreferences("AlarmEventSix",
		 * MODE_PRIVATE); SharedPreferences.Editor prefsEditorProfiles5 =
		 * AlarmEventSix.edit();
		 * prefsEditorProfiles5.putInt("AlarmEventSixFlag", 1);
		 * prefsEditorProfiles5.commit(); break; case 6: SharedPreferences
		 * AlarmEventSeven =
		 * MainFragmentE1.this.getSharedPreferences("AlarmEventSeven",
		 * MODE_PRIVATE); SharedPreferences.Editor prefsEditorProfiles6 =
		 * AlarmEventSeven.edit();
		 * prefsEditorProfiles6.putInt("AlarmEventSevenFlag", 1);
		 * prefsEditorProfiles6.commit(); break; case 7: SharedPreferences
		 * AlarmEventEight =
		 * MainFragmentE1.this.getSharedPreferences("AlarmEventEight",
		 * MODE_PRIVATE); SharedPreferences.Editor prefsEditorProfiles7 =
		 * AlarmEventEight.edit();
		 * prefsEditorProfiles7.putInt("AlarmEventEightFlag", 1);
		 * prefsEditorProfiles7.commit(); break; default: ; }
		 * 
		 * 
		 * // Setting Prefernce flag return false;
		 * 
		 * } });
		 */
		// Please Refer This Alarm
		if (canAddItem) {
			// menu.getItem(0).setIcon(R.drawable.selected);
			// logoutMI.setIcon(R.drawable.selected);
			// MenuItem mi = menu.add("New Item");
			// mi.setIcon(R.drawable.selected);
			// mi.setShowAsActionFlags(MenuItem.SHOW_AS_ACTION_IF_ROOM);
			// canAddItem = false;
		} else {
			// menu.getItem(0).setIcon(R.drawable.ic_action_user);
			// logoutMI.setIcon(R.drawable.ic_action_user);
			// canAddItem = true;
		}

		return super.onPrepareOptionsMenu(menu);
	}

	@SuppressLint("NewApi")
	private void changeColor(int newColor) {

		tabs.setIndicatorColor(newColor);

		// change ActionBar color just if an ActionBar is available
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {

			Drawable colorDrawable = new ColorDrawable(newColor);
			Drawable bottomDrawable = getResources().getDrawable(
					R.drawable.actionbar_bottom);
			LayerDrawable ld = new LayerDrawable(new Drawable[] {
					colorDrawable, bottomDrawable });

			if (oldBackground == null) {

				if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
					ld.setCallback(drawableCallback);
				} else {
					getActionBar().setBackgroundDrawable(ld);
				}

			} else {

				TransitionDrawable td = new TransitionDrawable(new Drawable[] {
						oldBackground, ld });

				// workaround for broken ActionBarContainer drawable handling on
				// pre-API 17 builds
				// https://github.com/android/platform_frameworks_base/commit/a7cc06d82e45918c37429a59b14545c6a57db4e4
				if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
					td.setCallback(drawableCallback);
				} else {
					getActionBar().setBackgroundDrawable(td);
				}

				td.startTransition(200);

			}

			oldBackground = ld;

			// http://stackoverflow.com/questions/11002691/actionbar-setbackgrounddrawable-nulling-background-from-thread-handler
			getActionBar().setDisplayShowTitleEnabled(false);
			getActionBar().setDisplayShowTitleEnabled(true);

		}

		currentColor = newColor;

	}

	public void onColorClicked(View v) {

		int color = Color.parseColor(v.getTag().toString());
		changeColor(color);

	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt("currentColor", currentColor);
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		currentColor = savedInstanceState.getInt("currentColor");
		changeColor(currentColor);
	}

	private Drawable.Callback drawableCallback = new Drawable.Callback() {
		@SuppressLint("NewApi")
		@Override
		public void invalidateDrawable(Drawable who) {
			getActionBar().setBackgroundDrawable(who);
		}

		@Override
		public void scheduleDrawable(Drawable who, Runnable what, long when) {
			handler.postAtTime(what, when);
		}

		@Override
		public void unscheduleDrawable(Drawable who, Runnable what) {
			handler.removeCallbacks(what);
		}

	};

	public class MyPagerAdapter extends FragmentPagerAdapter {

		private final String[] TITLES = { "OnsiteProgramming",
				"OnsiteDebugging", "Heptathlon", "Wizards of FOSS",
				"Microsoft SoftCoding", "Hackathon" };
		MainFragmentE1 mainfrag;// =new MainFragmentE1();

		public MyPagerAdapter(FragmentManager fm) {

			// display(fm)

			super(fm);
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return TITLES[position];
		}

		@Override
		public int getCount() {
			return TITLES.length;
		}

		@Override
		public Fragment getItem(int position) {
			// return SuperAwesomeCardFragment.newInstance(position);
			// mainfrag.display();
			return SuperAwesomeEvent1.newInstance(position);
		}

	}

}