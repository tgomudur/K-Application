package com.twotoasters.jazzylistview.sample;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView.ScaleType;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.capricorn.RayMenu;
import com.makeramen.RoundedImageView;
import com.twotoasters.jazzylistview.about.FinalContact;
import com.twotoasters.jazzylistview.home.NoBoringHomeActivity;
import com.twotoasters.jazzylistview.update.IndividualUpdate;
import in.org.kurukshetra.app.R;

public class Gallery extends FragmentActivity {
	public void startActivity(int position) {
		Intent description = new Intent(Gallery.this, GuestMainActivity.class);
		description.putExtra("descripn", position);
		startActivity(description);
	}

	public void gotoActivity(int position) {
		switch (position) {
		case 0:
			finish();
			Intent intent = new Intent(Gallery.this, NoBoringHomeActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			finish();
			break;
		case 1:
			finish();
			startActivity(new Intent(Gallery.this, EventSwipeCenter.class));
			break;

		case 2:
			finish();
			startActivity(new Intent(Gallery.this, Workshops.class));
			break;
		case 3:
			// startActivity(new Intent(Gallery.this, Gallery.class));
			// startActivity(new
			// Intent(HomeViewPager.this,SingleEventOnly.class));
			// startActivity(new
			// Intent(HomeViewPager.this,Eventcentremain.class));
			// startActivity(new Intent(MainHome.this,MainEvents.class));
			// startActivity(new Intent(Workshops.this, Workshops.class));
			break;
		case 4:
			// startActivity(new Intent(HomeViewPager.this,MainActivity.class));
			// startActivity(new Intent(HomeViewPager.this,Workshops.class));
			// startActivity(new Intent(HomeViewPager.this,GuestLecture.class));
			// startActivity(new Intent(Workshops.this, Gallery.class));
			finish();
			startActivity(new Intent(Gallery.this, FinalContact.class));
			break;
		case 5:
			// startActivity(new Intent(HomeViewPager.this,MainActivity.class));
			// startActivity(new Intent(HomeViewPager.this,GuestLecture.class));
			finish();
			startActivity(new Intent(Gallery.this, IndividualUpdate.class));
			break;
		case 6:
			// startActivity(new Intent(HomeViewPager.this,EventsCorner.class));
			// startActivity(new Intent(Workshops.this, SingleEventOnly.class));
			// startActivity(new Intent(HomeViewPager.this,GuestLecture.class));
			break;
		case 7:
			// startActivity(new Intent(HomeViewPager.this,MainActivity.class));

			break;
		default:
			;
		}
	}

	public void show(int position) {
		// Toast.makeText(this, "Position : " + position, Toast.LENGTH_SHORT)
		// .show();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.gallery);
		final int[] ITEM_DRAWABLES = { R.drawable.icon_home,
				R.drawable.icon_event1, R.drawable.icon_contact2,
				R.drawable.icon_event2, R.drawable.icon_contact,
				R.drawable.icon_info };
		RayMenu rayMenu = (RayMenu) findViewById(R.id.ray_menu);
		final int itemCount = ITEM_DRAWABLES.length;
		for (int i = 0; i < itemCount; i++) {
			ImageView item = new ImageView(this);
			item.setImageResource(ITEM_DRAWABLES[i]);

			final int position = i;
			rayMenu.addItem(item, new OnClickListener() {

				@Override
				public void onClick(View v) {
					// Toast.makeText(Gallery.this, "position:" + position,
					// Toast.LENGTH_SHORT).show();
					gotoActivity(position);
				}
			});// Add a menu item
		}

		StreamAdapter adapter = new StreamAdapter(this);
		((ListView) findViewById(R.id.main_list)).setAdapter(adapter);

		adapter.add(new StreamItem(this, R.drawable.appgl1, " ", " ",
				ScaleType.CENTER));
		adapter.add(new StreamItem(this, R.drawable.appgl2, " ", " ",
				ScaleType.CENTER_CROP));
		adapter.add(new StreamItem(this, R.drawable.lecphoto6, " ", " ",
				ScaleType.CENTER));
		adapter.add(new StreamItem(this, R.drawable.lecphoto4, " ", " ",
				ScaleType.FIT_CENTER));

		adapter.add(new StreamItem(this, R.drawable.lecphoto5, " ", " ",
				ScaleType.FIT_CENTER));

		adapter.add(new StreamItem(this, R.drawable.lecphoto8, " ", " ",
				ScaleType.FIT_CENTER));

		adapter.add(new StreamItem(this, R.drawable.lecphoto7, " ", " ",
				ScaleType.FIT_CENTER));

		adapter.add(new StreamItem(this, R.drawable.lecphoto9, " ", " ",
				ScaleType.FIT_CENTER));

	}

	class StreamItem {
		final Bitmap mBitmap;
		final String mLine1;
		final String mLine2;
		final ScaleType mScaleType;

		StreamItem(Context c, int resid, String line1, String line2,
				ScaleType scaleType) {
			mBitmap = BitmapFactory.decodeResource(c.getResources(), resid);
			mLine1 = line1;
			mLine2 = line2;
			mScaleType = scaleType;

		}
	}

	class StreamAdapter extends ArrayAdapter<StreamItem> {
		private final LayoutInflater mInflater;

		public StreamAdapter(Context context) {
			super(context, 0);
			mInflater = LayoutInflater.from(getContext());
		}

		@Override
		public View getView(final int position, View convertView,
				ViewGroup parent) {
			ViewGroup view = null;

			if (convertView == null) {
				view = (ViewGroup) mInflater.inflate(R.layout.rounded_item,
						parent, false);
			} else {
				view = (ViewGroup) convertView;
			}

			StreamItem item = getItem(position);

			((RoundedImageView) view.findViewById(R.id.imageView1))
					.setImageBitmap(item.mBitmap);
			((RoundedImageView) view.findViewById(R.id.imageView1))
					.setScaleType(item.mScaleType);
			// ((RoundedImageView)
			// view.findViewById(R.id.imageView1)).setOval(true);
			((TextView) view.findViewById(R.id.textView1)).setText(item.mLine1);
			((TextView) view.findViewById(R.id.textView2)).setText(item.mLine2);
			((TextView) view.findViewById(R.id.textView3)).setText("");
			view.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					show(position);
					startActivity(position);

				}
			});
			return view;
		}
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
			QuickContactFragment dialog = new QuickContactFragment();
			dialog.show(getSupportFragmentManager(), "QuickFragment");
			// dialog.show(getBaseContext(), "QuickContactFragment");
			break;
		default:
			;
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

}
