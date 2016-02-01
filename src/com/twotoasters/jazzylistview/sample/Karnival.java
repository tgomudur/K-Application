package com.twotoasters.jazzylistview.sample;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.AdapterView.OnItemClickListener;
import com.capricorn.RayMenu;

import com.twotoasters.jazzylistview.JazzyGridView;
import com.twotoasters.jazzylistview.JazzyHelper;
import com.twotoasters.jazzylistview.about.FinalContact;
import com.twotoasters.jazzylistview.home.NoBoringHomeActivity;
import com.twotoasters.jazzylistview.update.IndividualUpdate;

import in.org.kurukshetra.app.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Karnival extends Activity {

	private static final String KEY_TRANSITION_EFFECT = "transition_effect";

	private JazzyGridView mGrid;
	private HashMap<String, Integer> mEffectMap;
	// private int mCurrentTransitionEffect = JazzyHelper.HELIX;
	private int mCurrentTransitionEffect = JazzyHelper.CARDS;

	private static final int[] ITEM_DRAWABLES = { R.drawable.icon_home,
			R.drawable.icon_event1, R.drawable.icon_contact2,
			R.drawable.icon_event2, R.drawable.icon_contact,
			R.drawable.icon_info };

	public void gotoActivity(int position) {
		switch (position) {
		case 0:
			finish();
			Intent intent = new Intent(Karnival.this,
					NoBoringHomeActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			finish();

			break;
		case 1:
			finish();
			startActivity(new Intent(Karnival.this, EventSwipeCenter.class));
			break;

		case 2:
			startActivity(new Intent(Karnival.this, Workshops.class));
			break;
		case 3:
			finish();
			startActivity(new Intent(Karnival.this, Gallery.class));
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
			// startActivity(new Intent(Karnival.this,GuestLecture.class));
			// startActivity(new Intent(Workshops.this, Gallery.class));
			finish();
			startActivity(new Intent(Karnival.this, FinalContact.class));
			break;
		case 5:
			// startActivity(new Intent(HomeViewPager.this,MainActivity.class));
			// startActivity(new Intent(HomeViewPager.this,GuestLecture.class));
			finish();
			startActivity(new Intent(Karnival.this, IndividualUpdate.class));
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

	private void initArcMenu(RayMenu menu, int[] itemDrawables) {
		final int itemCount = itemDrawables.length;
		for (int i = 0; i < itemCount; i++) {
			ImageView item = new ImageView(this);
			item.setImageResource(itemDrawables[i]);

			final int position = i;
			menu.addItem(item, new OnClickListener() {

				@Override
				public void onClick(View v) {
					// Toast.makeText(Workshops.this, "position:" + position,
					// Toast.LENGTH_SHORT).show();
					gotoActivity(position);
				}
			});
		}
	}

	public void startActivity(int position) {
		Intent description = new Intent(Karnival.this,
				Karnivalmainactivity.class);
		description.putExtra("descripn", position);
		startActivity(description);
	}

	public void display(int l2) {
		// Toast.makeText(this, "Refer : "+l2, Toast.LENGTH_LONG).show();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.karnival);

		mGrid = (JazzyGridView) findViewById(android.R.id.list);
		mGrid.setAdapter(new ListAdapterKarnival(this, R.layout.grid_item_event));

		// Satellite Menu
		RayMenu arcMenu = (RayMenu) findViewById(R.id.ray_menu);
		initArcMenu(arcMenu, ITEM_DRAWABLES);
		// Sateliite Menu

		if (savedInstanceState != null) {
			// mCurrentTransitionEffect =
			// savedInstanceState.getInt(KEY_TRANSITION_EFFECT,
			// JazzyHelper.HELIX);
			mCurrentTransitionEffect = savedInstanceState.getInt(
					KEY_TRANSITION_EFFECT, JazzyHelper.CARDS);
			setupJazziness(mCurrentTransitionEffect);
		}
		/*
		 * mGrid.setOnClickListener(new SateliteClickedListener() {
		 * 
		 * public void eventOccured(int id) { display(id); }
		 */
		mGrid.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {

				// display(arg2);
				startActivity(arg2);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		mEffectMap = new HashMap<String, Integer>();
		int i = 0;
		String[] effects = this.getResources().getStringArray(
				R.array.jazzy_effects);
		for (String effect : effects) {
			mEffectMap.put(effect, i++);
		}

		List<String> effectList = new ArrayList<String>(Arrays.asList(effects));
		Collections.sort(effectList);
		effectList.remove(getString(R.string.standard));
		effectList.add(0, getString(R.string.standard));
		for (String effect : effectList) {
			menu.add(effect);
		}

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		String strEffect = item.getTitle().toString();
		// Toast.makeText(this, strEffect, Toast.LENGTH_SHORT).show();
		setupJazziness(mEffectMap.get(strEffect));
		return true;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt(KEY_TRANSITION_EFFECT, mCurrentTransitionEffect);
	}

	private void setupJazziness(int effect) {
		mCurrentTransitionEffect = effect;
		mGrid.setTransitionEffect(mCurrentTransitionEffect);
	}
}
