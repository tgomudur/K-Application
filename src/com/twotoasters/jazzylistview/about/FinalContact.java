package com.twotoasters.jazzylistview.about;

import com.capricorn.RayMenu;
import com.twotoasters.jazzylistview.home.NoBoringHomeActivity;
import com.twotoasters.jazzylistview.sample.EventSwipeCenter;
import com.twotoasters.jazzylistview.sample.Gallery;
import com.twotoasters.jazzylistview.sample.QuickContactFragment;
import com.twotoasters.jazzylistview.sample.Workshops;
import com.twotoasters.jazzylistview.update.IndividualUpdate;

import in.org.kurukshetra.app.R;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class FinalContact extends FragmentActivity implements OnClickListener {

	RelativeLayout rl1, rl2, rl3, rl4, rl5, rl6, rl7, rl8, rl9, rl10, rl11,
			rl12;
	ImageView i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12;
	LinearLayout mylinearLayout;
	Animation rightslide;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.finalcontact);
		setupids();
		// setImages();
		mylinearLayout.startAnimation(rightslide);

	}

	private void setImages() {
		// TODO Auto-generated method stub

	}

	public void gotoActivity(int position) {

		switch (position) {
		case 0:

			/*
			 * Intent i= new Intent(EventSwipeCenter.this,
			 * NoBoringHomeActivity.class);
			 * i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY); startActivity(i);
			 */
			/*
			 * startActivity(new Intent(EventSwipeCenter.this,
			 * NoBoringHomeActivity.class));
			 */
			finish();
			Intent intent = new Intent(FinalContact.this,
					NoBoringHomeActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			finish();
		case 1:

			startActivity(new Intent(FinalContact.this, EventSwipeCenter.class));
			break;

		case 2:
			finish();
			startActivity(new Intent(FinalContact.this, Workshops.class));
			break;
		case 3:
			finish();
			startActivity(new Intent(FinalContact.this, Gallery.class));
			// startActivity(new
			// Intent(HomeViewPager.this,SingleEventOnly.class));
			// startActivity(new
			// Intent(HomeViewPager.this,EventSwipeCenter.class));
			// startActivity(new Intent(MainHome.this,MainEvents.class));
			// startActivity(new Intent(Workshops.this, Workshops.class));
			break;
		case 4:
			// startActivity(new Intent(HomeViewPager.this,MainActivity.class));
			// startActivity(new Intent(HomeViewPager.this,Workshops.class));
			// startActivity(new Intent(HomeViewPager.this,GuestLecture.class));
			// startActivity(new Intent(Workshops.this, Gallery.class));
			// startActivity(new Intent(FinalContact.this, FinalContact.class));
			break;
		case 5:
			startActivity(new Intent(FinalContact.this, IndividualUpdate.class));
			// startActivity(new Intent(HomeViewPager.this,GuestLecture.class));
			// startActivity(new Intent(Workshops.this, Gallery.class));
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

	private void setupids() {
		// TODO Auto-generated method stub
		rl1 = (RelativeLayout) findViewById(R.id.rlcontact1);
		rl2 = (RelativeLayout) findViewById(R.id.rlcontact2);
		rl3 = (RelativeLayout) findViewById(R.id.rlcontact3);
		rl4 = (RelativeLayout) findViewById(R.id.rlcontact4);
		rl5 = (RelativeLayout) findViewById(R.id.rlcontact5);
		rl6 = (RelativeLayout) findViewById(R.id.rlcontact6);
		rl7 = (RelativeLayout) findViewById(R.id.rlcontact7);
		rl8 = (RelativeLayout) findViewById(R.id.rlcontact8);
		rl9 = (RelativeLayout) findViewById(R.id.rlcontact9);
		rl10 = (RelativeLayout) findViewById(R.id.rlcontact10);
		rl11 = (RelativeLayout) findViewById(R.id.rlcontact11);
		rl12 = (RelativeLayout) findViewById(R.id.rlcontact12);

		i1 = (ImageView) findViewById(R.id.list_image1);
		i2 = (ImageView) findViewById(R.id.list_image2);
		i3 = (ImageView) findViewById(R.id.list_image3);
		i4 = (ImageView) findViewById(R.id.list_image4);
		i5 = (ImageView) findViewById(R.id.list_image5);
		i6 = (ImageView) findViewById(R.id.list_image6);
		i7 = (ImageView) findViewById(R.id.list_image7);
		i8 = (ImageView) findViewById(R.id.list_image8);
		i9 = (ImageView) findViewById(R.id.list_image9);
		i10 = (ImageView) findViewById(R.id.list_image10);
		i11 = (ImageView) findViewById(R.id.list_image11);
		i12 = (ImageView) findViewById(R.id.list_image12);

		mylinearLayout = (LinearLayout) findViewById(R.id.mylayoutrefer);
		rightslide = AnimationUtils.loadAnimation(getApplicationContext(),
				R.anim.right);

		rl1.setOnClickListener(this);
		rl2.setOnClickListener(this);
		rl3.setOnClickListener(this);
		rl4.setOnClickListener(this);
		rl5.setOnClickListener(this);
		rl6.setOnClickListener(this);
		rl7.setOnClickListener(this);
		rl8.setOnClickListener(this);
		rl9.setOnClickListener(this);
		rl10.setOnClickListener(this);
		rl11.setOnClickListener(this);
		rl12.setOnClickListener(this);
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
					// Toast.makeText(EventSwipeCenter.this, "position:" +
					// position, Toast.LENGTH_SHORT).show();
					gotoActivity(position);
				}
			});// Add a menu item
		}

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(Intent.ACTION_DIAL);

		switch (v.getId()) {
		case R.id.rlcontact1:
			intent.setData(Uri.parse("tel:8870118202"));
			startActivity(intent);
			break;
		case R.id.rlcontact2:
			intent.setData(Uri.parse("tel:9659382834"));
			startActivity(intent);
			break;
		case R.id.rlcontact3:
			intent.setData(Uri.parse("tel:9176206884"));
			startActivity(intent);
			break;
		case R.id.rlcontact4:
			intent.setData(Uri.parse("tel:9842521198"));
			startActivity(intent);
			break;
		case R.id.rlcontact5:
			intent.setData(Uri.parse("tel:9566607666"));
			startActivity(intent);
			break;
		case R.id.rlcontact6:
			intent.setData(Uri.parse("tel:8870002629"));
			startActivity(intent);
			break;
		case R.id.rlcontact7:
			intent.setData(Uri.parse("tel:8754534996"));
			startActivity(intent);
			break;
		case R.id.rlcontact8:
			intent.setData(Uri.parse("tel:9962288712"));
			startActivity(intent);
			break;
		case R.id.rlcontact9:
			intent.setData(Uri.parse("tel:8883729793"));
			startActivity(intent);
			break;
		case R.id.rlcontact10:
			intent.setData(Uri.parse("tel:9791793004"));
			startActivity(intent);
			break;
		case R.id.rlcontact11:
			intent.setData(Uri.parse("tel:8870709449"));
			startActivity(intent);
			break;

		case R.id.rlcontact12:
			intent.setData(Uri.parse("tel:9840671617"));
			startActivity(intent);
			break;

		}

	}

	public static Bitmap getRoundedCornerBitmap(Bitmap bitmap) {
		Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
				bitmap.getHeight(), Config.ARGB_8888);
		Canvas canvas = new Canvas(output);

		final int color = 0xff424242;
		final Paint paint = new Paint();
		final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
		final RectF rectF = new RectF(rect);
		final float roundPx = bitmap.getWidth();

		paint.setAntiAlias(true);
		canvas.drawARGB(0, 0, 0, 0);
		paint.setColor(color);
		canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
		canvas.drawBitmap(bitmap, rect, rect, paint);

		return output;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.action_contact:
			QuickContactFragment dialog = new QuickContactFragment();
			dialog.show(getSupportFragmentManager(), "QuickContactFragment");
			break;
		}
		return super.onOptionsItemSelected(item);
	}

}