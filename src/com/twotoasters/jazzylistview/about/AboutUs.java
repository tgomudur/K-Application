package com.twotoasters.jazzylistview.about;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.net.Uri;
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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.astuetz.viewpager.extensions.PagerSlidingTabStrip;
import com.twotoasters.jazzylistview.home.NoBoringHomeActivity;
import com.twotoasters.jazzylistview.sample.QuickContactFragment;

import in.org.kurukshetra.app.R;

public class AboutUs extends FragmentActivity {

	private final Handler handler = new Handler();

	private PagerSlidingTabStrip tabs;
	private ViewPager pager;
	private MyPagerAdapter adapter;

	private Drawable oldBackground = null;
	private int currentColor = 0xFF222222;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);

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
		int setpage = description.getIntExtra("descripn", 0);
		pager.setCurrentItem(setpage);

		changeColor(currentColor);
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		finish();
		super.onBackPressed();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.action_contact:
			// case 0:
			/*
			 * QuickContactFragment dialog = new QuickContactFragment();
			 * dialog.show(getSupportFragmentManager(), "QuickContactFragment");
			 */
			QuickContactFragment dialog = new QuickContactFragment();
			dialog.show(getSupportFragmentManager(), "QuickContactFragment");
			break;
		default:
			;
			return true;
		}

		return super.onOptionsItemSelected(item);
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

	public void onImageClicked(View v) {
		switch (v.getId()) {
		case R.id.iv1:
			Toast.makeText(v.getContext(), "Like us on facebook page",
					Toast.LENGTH_SHORT).show();
			String uri = "fb://page/180742737591";
			Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));

			// Add try and catch because the scheme could be changed in an
			// update!
			// Another reason is that the Facebook-App is not installed
			try {

				startActivity(intent);

			} catch (ActivityNotFoundException ex) {

				// start web browser and the facebook mobile page as fallback
				String uriMobile = "http://touch.facebook.com/pages/x/180742737591";
				Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(uriMobile));
				startActivity(i);
			}
			break;
		case R.id.iv2:
			Toast.makeText(v.getContext(), "Redirecting to Kurukshetra page",
					Toast.LENGTH_SHORT).show();
			Intent i = new Intent(Intent.ACTION_VIEW,
					Uri.parse("http://www.kurukshetra.org.in"));
			startActivity(i);
			break;
		case R.id.iv3:
			try {
				Intent intent1 = new Intent(Intent.ACTION_VIEW,
						Uri.parse("twitter://user?screen_name=kurukshetra_ceg"));
				startActivity(intent1);

			} catch (Exception e) {
				startActivity(new Intent(Intent.ACTION_VIEW,
						Uri.parse("https://twitter.com/#!/kurukshetra_ceg")));
			}
			Toast.makeText(v.getContext(), "Follow us on Twitter page",
					Toast.LENGTH_SHORT).show();
			break;
		case R.id.ibSend:
			Intent i1 = new Intent(Intent.ACTION_SEND);
			EditText body = (EditText) findViewById(R.id.etEmail);
			i1.setType("message/rfc822");
			i1.putExtra(Intent.EXTRA_EMAIL,
					new String[] { "qms@kurukshetra.org.in" });
			i1.putExtra(Intent.EXTRA_SUBJECT, "Feedback for Kurukshetra '14");
			i1.putExtra(Intent.EXTRA_TEXT, body.getText().toString());
			try {
				startActivity(Intent.createChooser(i1, "Send mail..."));
			} catch (ActivityNotFoundException ex) {
				Toast.makeText(this, "There are no email clients installed.",
						Toast.LENGTH_SHORT).show();
			}
			Toast.makeText(v.getContext(), "Sending your feedback",
					Toast.LENGTH_SHORT).show();
			break;
		case R.id.tvProceed:
			TextView proceed = (TextView) findViewById(R.id.tvProceed);
			proceed.setBackgroundColor(0x445161BC);
			startActivity(new Intent(v.getContext(), NoBoringHomeActivity.class));

			break;
		}
		finish();
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

		private final String[] TITLES = { "Kurusketra", "Events", "Workshops",
				"Exhibitions", "lectures", "LikeUs" };

		public MyPagerAdapter(FragmentManager fm) {
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
			return SuperAwesomeCardFragmentold.newInstance(position);
		}

	}

}