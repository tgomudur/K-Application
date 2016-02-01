package com.twotoasters.jazzylistview.sample;

import android.os.Bundle;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.capricorn.ArcMenu;
import com.capricorn.RayMenu;

import com.twotoasters.jazzylistview.JazzyGridView;
import com.twotoasters.jazzylistview.JazzyHelper;
import com.twotoasters.jazzylistview.home.NoBoringHomeActivity;
import com.twotoasters.jazzylistview.sample.ListAdapterE1;
import in.org.kurukshetra.app.R;

import android.app.TabActivity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabContentFactory;
import android.widget.Toast;

public class Eventcentremain extends TabActivity implements
		OnTabChangeListener, OnPageChangeListener {

	private static final String LIST1_TAB_TAG = "Coding Corner";
	private static final String LIST2_TAB_TAG = "Engineering";
	private static final String LIST3_TAB_TAG = "Managements";
	private static final String LIST4_TAB_TAG = "Quizzes";
	private static final String LIST5_TAB_TAG = "Robotics";
	private static final String LIST6_TAB_TAG = "Xceed";
	private static final String LIST7_TAB_TAG = "Online Events";
	private static final String LIST8_TAB_TAG = "General";
	private static final String KEY_TRANSITION_EFFECT = "transition_effect";
	private HashMap<String, Integer> mEffectMap;
	private int mCurrentTransitionEffect = JazzyHelper.REVERSE_FLY;

	private JazzyGridView mGrid1;
	private JazzyGridView mGrid2;
	private JazzyGridView mGrid3;
	private JazzyGridView mGrid4;
	private JazzyGridView mGrid5;
	private JazzyGridView mGrid6;
	private JazzyGridView mGrid7;
	private JazzyGridView mGrid8;

	private TabHost tabHost;

	public void gotoActivity(int position) {

		switch (position) {
		case 0:

			startActivity(new Intent(Eventcentremain.this,
					NoBoringHomeActivity.class));
		case 1:

			// startActivity(new Intent(Eventcentremain.this,
			// Eventcentremain.class));
			break;

		case 2:
			startActivity(new Intent(Eventcentremain.this, Workshops.class));
			break;
		case 3:
			startActivity(new Intent(Eventcentremain.this, Gallery.class));
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
			startActivity(new Intent(Eventcentremain.this,
					SingleEventOnly.class));
			break;
		case 5:
			// startActivity(new Intent(HomeViewPager.this,MainActivity.class));
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

	private void initArcMenu(ArcMenu menu, int[] itemDrawables) {
		final int itemCount = itemDrawables.length;
		for (int i = 0; i < itemCount; i++) {
			ImageView item = new ImageView(this);
			item.setImageResource(itemDrawables[i]);

			final int position = i;
			menu.addItem(item, new OnClickListener() {

				@Override
				public void onClick(View v) {
					Toast.makeText(Eventcentremain.this,
							"position:" + position, Toast.LENGTH_SHORT).show();
				}
			});
		}
	}

	public void startActivity(int EventPosition, int position) {

		switch (EventPosition) {
		case 1:
			Intent description1 = new Intent(Eventcentremain.this,
					MainFragmentE1.class);
			description1.putExtra("descripn", position);
			startActivity(description1);
			break;
		case 2:
			Intent description2 = new Intent(Eventcentremain.this,
					MainFragmentE2.class);
			description2.putExtra("descripn", position);
			startActivity(description2);
			break;
		case 3:
			Intent description3 = new Intent(Eventcentremain.this,
					MainFragmentE3.class);
			description3.putExtra("descripn", position);
			startActivity(description3);
			break;
		case 4:
			Intent description4 = new Intent(Eventcentremain.this,
					MainFragmentE4.class);
			description4.putExtra("descripn", position);
			startActivity(description4);
			break;
		case 5:
			Intent description5 = new Intent(Eventcentremain.this,
					MainFragmentE5.class);
			description5.putExtra("descripn", position);
			startActivity(description5);
			break;
		case 6:
			Intent description6 = new Intent(Eventcentremain.this,
					MainFragmentE6.class);
			description6.putExtra("descripn", position);
			startActivity(description6);
			break;
		case 7:
			Intent description7 = new Intent(Eventcentremain.this,
					MainFragmentE7.class);
			description7.putExtra("descripn", position);
			startActivity(description7);
			break;
		case 8:
			Intent description8 = new Intent(Eventcentremain.this,
					MainFragmentE8.class);
			description8.putExtra("descripn", position);
			startActivity(description8);
			break;
		default:
			;
		}

		Toast.makeText(this, "Current Position : " + position,
				Toast.LENGTH_LONG).show();

	}

	public void display(int id) {
		Toast.makeText(this, "REFER : " + id, Toast.LENGTH_LONG).show();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.eventcentremain);

		tabHost = getTabHost();
		tabHost.setOnTabChangedListener(this);

		// setup list view 1

		// create some dummy strings to add to the list
		mGrid1 = (JazzyGridView) findViewById(R.id.gridlist1);
		mGrid2 = (JazzyGridView) findViewById(R.id.gridlist2);
		mGrid3 = (JazzyGridView) findViewById(R.id.gridlist3);
		mGrid4 = (JazzyGridView) findViewById(R.id.gridlist4);
		mGrid5 = (JazzyGridView) findViewById(R.id.gridlist5);
		mGrid6 = (JazzyGridView) findViewById(R.id.gridlist6);
		mGrid7 = (JazzyGridView) findViewById(R.id.gridlist7);
		mGrid8 = (JazzyGridView) findViewById(R.id.gridlist8);
		// mGrid2=(JazzyGridView) findViewById(R.id.list2);
		// mGrid1 = (JazzyGridView) findViewById(android.R.id.list);
		mGrid1.setAdapter(new ListAdapterE1(this, R.layout.grid_item));

		// Satellite Menu
		final int[] ITEM_DRAWABLES = { R.drawable.ic_1, R.drawable.ic_2,
				R.drawable.ic_3, R.drawable.ic_4, R.drawable.ic_5,
				R.drawable.ic_6 };
		RayMenu rayMenu = (RayMenu) findViewById(R.id.ray_menu);
		final int itemCount = ITEM_DRAWABLES.length;
		for (int i = 0; i < itemCount; i++) {
			ImageView item = new ImageView(this);
			item.setImageResource(ITEM_DRAWABLES[i]);

			final int position = i;
			rayMenu.addItem(item, new OnClickListener() {

				@Override
				public void onClick(View v) {
					// Toast.makeText(Eventcentremain.this, "position:" +
					// position, Toast.LENGTH_SHORT).show();
					gotoActivity(position);
				}
			});// Add a menu item
		}
		/*
		 * SatelliteMenu menu = (SatelliteMenu) findViewById(R.id.menu);
		 * 
		 * List<SatelliteMenuItem> items = new ArrayList<SatelliteMenuItem>();
		 * items.add(new SatelliteMenuItem(4, R.drawable.ic_1)); items.add(new
		 * SatelliteMenuItem(4, R.drawable.ic_3)); items.add(new
		 * SatelliteMenuItem(4, R.drawable.ic_4)); items.add(new
		 * SatelliteMenuItem(3, R.drawable.ic_5)); items.add(new
		 * SatelliteMenuItem(2, R.drawable.ic_6)); items.add(new
		 * SatelliteMenuItem(1, R.drawable.ic_2));
		 * 
		 * menu.addItems(items);
		 * 
		 * menu.setOnItemClickedListener(new SateliteClickedListener() {
		 * 
		 * @Override public void eventOccured(int id) { display(id); } });
		 */
		// Satellite Menu

		if (savedInstanceState != null) {
			// mCurrentTransitionEffect =
			// savedInstanceState.getInt(KEY_TRANSITION_EFFECT,
			// JazzyHelper.HELIX);
			mCurrentTransitionEffect = savedInstanceState.getInt(
					KEY_TRANSITION_EFFECT, JazzyHelper.REVERSE_FLY);
			setupJazziness(mCurrentTransitionEffect);
		}
		/*
		 * mGrid.setOnClickListener(new SateliteClickedListener() {
		 * 
		 * public void eventOccured(int id) { display(id); }
		 */
		mGrid1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {

				// display(arg2);
				startActivity(1, arg2);
			}
		});
		mGrid2.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {

				// display(arg2);
				startActivity(2, arg2);
			}
		});
		mGrid3.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {

				// display(arg2);
				startActivity(3, arg2);
			}
		});
		mGrid4.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {

				// display(arg2);
				startActivity(4, arg2);
			}
		});
		mGrid5.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {

				// display(arg2);
				startActivity(5, arg2);
			}
		});
		mGrid6.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {

				// display(arg2);
				startActivity(6, arg2);
			}
		});

		mGrid7.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {

				// display(arg2);
				startActivity(7, arg2);
			}
		});

		mGrid8.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {

				// display(arg2);
				startActivity(8, arg2);
			}
		});

		// add views to tab host
		tabHost.addTab(tabHost.newTabSpec(LIST1_TAB_TAG)
				.setIndicator(LIST1_TAB_TAG)
				.setContent(new TabContentFactory() {
					@Override
					public View createTabContent(String arg0) {
						return mGrid1;
					}
				}));
		tabHost.addTab(tabHost.newTabSpec(LIST2_TAB_TAG)
				.setIndicator(LIST2_TAB_TAG)
				.setContent(new TabContentFactory() {
					@Override
					public View createTabContent(String arg0) {
						return mGrid2;
					}
				}));
		tabHost.addTab(tabHost.newTabSpec(LIST3_TAB_TAG)
				.setIndicator(LIST3_TAB_TAG)
				.setContent(new TabContentFactory() {
					@Override
					public View createTabContent(String arg0) {
						return mGrid3;
					}
				}));
		tabHost.addTab(tabHost.newTabSpec(LIST4_TAB_TAG)
				.setIndicator(LIST4_TAB_TAG)
				.setContent(new TabContentFactory() {
					@Override
					public View createTabContent(String arg0) {
						return mGrid4;
					}
				}));
		tabHost.addTab(tabHost.newTabSpec(LIST5_TAB_TAG)
				.setIndicator(LIST5_TAB_TAG)
				.setContent(new TabContentFactory() {
					@Override
					public View createTabContent(String arg0) {
						return mGrid5;
					}
				}));
		tabHost.addTab(tabHost.newTabSpec(LIST6_TAB_TAG)
				.setIndicator(LIST6_TAB_TAG)
				.setContent(new TabContentFactory() {
					@Override
					public View createTabContent(String arg0) {
						return mGrid6;
					}
				}));
		tabHost.addTab(tabHost.newTabSpec(LIST7_TAB_TAG)
				.setIndicator(LIST7_TAB_TAG)
				.setContent(new TabContentFactory() {
					@Override
					public View createTabContent(String arg0) {
						return mGrid7;
					}
				}));
		tabHost.addTab(tabHost.newTabSpec(LIST8_TAB_TAG)
				.setIndicator(LIST8_TAB_TAG)
				.setContent(new TabContentFactory() {
					@Override
					public View createTabContent(String arg0) {
						return mGrid8;
					}
				}));
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
		Toast.makeText(this, strEffect, Toast.LENGTH_SHORT).show();
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
		mGrid1.setTransitionEffect(mCurrentTransitionEffect);
		mGrid2.setTransitionEffect(mCurrentTransitionEffect);
		mGrid3.setTransitionEffect(mCurrentTransitionEffect);
		mGrid4.setTransitionEffect(mCurrentTransitionEffect);
		mGrid5.setTransitionEffect(mCurrentTransitionEffect);
		mGrid6.setTransitionEffect(mCurrentTransitionEffect);
		mGrid7.setTransitionEffect(mCurrentTransitionEffect);
		mGrid8.setTransitionEffect(mCurrentTransitionEffect);

		/*
		 * tabHost.addTab(tabHost.newTabSpec(LIST3_TAB_TAG).setIndicator(
		 * LIST3_TAB_TAG).setContent(new TabContentFactory() { public View
		 * createTabContent(String arg0) { return listView3; } }));
		 * 
		 * tabHost.addTab(tabHost.newTabSpec(LIST4_TAB_TAG).setIndicator(
		 * LIST4_TAB_TAG).setContent(new TabContentFactory() { public View
		 * createTabContent(String arg0) { return listView4; } }));
		 * 
		 * tabHost.addTab(tabHost.newTabSpec(LIST5_TAB_TAG).setIndicator(
		 * LIST5_TAB_TAG).setContent(new TabContentFactory() { public View
		 * createTabContent(String arg0) { return listView5; } }));
		 * tabHost.addTab
		 * (tabHost.newTabSpec(LIST6_TAB_TAG).setIndicator(LIST6_TAB_TAG
		 * ).setContent(new TabContentFactory() { public View
		 * createTabContent(String arg0) { return listView6; } }));
		 * 
		 * 
		 * 
		 * /*
		 * 
		 * tabHost.addTab(tabHost.newTabSpec(LIST2_TAB_TAG).setIndicator(
		 * LIST2_TAB_TAG).setContent(new TabContentFactory() { public View
		 * createTabContent(String arg0) { return listView3; } }));
		 * tabHost.addTab
		 * (tabHost.newTabSpec(LIST2_TAB_TAG).setIndicator(LIST2_TAB_TAG
		 * ).setContent(new TabContentFactory() { public View
		 * createTabContent(String arg0) { return listView4; } }));
		 * tabHost.addTab
		 * (tabHost.newTabSpec(LIST2_TAB_TAG).setIndicator(LIST2_TAB_TAG
		 * ).setContent(new TabContentFactory() { public View
		 * createTabContent(String arg0) { return listView5; } }));
		 * tabHost.addTab
		 * (tabHost.newTabSpec(LIST2_TAB_TAG).setIndicator(LIST2_TAB_TAG
		 * ).setContent(new TabContentFactory() { public View
		 * createTabContent(String arg0) { return listView6; } }));
		 */

	}

	/**
	 * Implement logic here when a tab is selected
	 */
	@Override
	public void onTabChanged(String tabName) {
		if (tabName.equals(LIST1_TAB_TAG)) {
			// do something
		} else if (tabName.equals(LIST2_TAB_TAG)) {
			// do something
			mGrid2.setAdapter(new ListAdapterE2(this, R.layout.grid_item));
		} else if (tabName.equals(LIST3_TAB_TAG)) {
			// do something
			mGrid3.setAdapter(new ListAdapterE3(this, R.layout.grid_item));
		} else if (tabName.equals(LIST4_TAB_TAG)) {
			// do something
			mGrid4.setAdapter(new ListAdapterE4(this, R.layout.grid_item));
		} else if (tabName.equals(LIST5_TAB_TAG)) {
			// do something
			mGrid5.setAdapter(new ListAdapterE5(this, R.layout.grid_item));
		} else if (tabName.equals(LIST6_TAB_TAG)) {
			// do something
			mGrid6.setAdapter(new ListAdapterE6(this, R.layout.grid_item));
		} else if (tabName.equals(LIST7_TAB_TAG)) {
			// do something
			mGrid7.setAdapter(new ListAdapterE7(this, R.layout.grid_item));
		} else if (tabName.equals(LIST8_TAB_TAG)) {
			// do something
			mGrid8.setAdapter(new ListAdapterE8(this, R.layout.grid_item));
		}
		/*
		 * mGrid2.setAdapter(new ListAdapterE3(this, R.layout.grid_item));
		 * mGrid3.setAdapter(new ListAdapterE3(this, R.layout.grid_item));
		 * mGrid4.setAdapter(new ListAdapterE3(this, R.layout.grid_item));
		 * mGrid5.setAdapter(new ListAdapterE3(this, R.layout.grid_item));
		 * mGrid6.setAdapter(new ListAdapterE3(this, R.layout.grid_item));
		 */

		/*
		 * else if(tabName.equals(LIST4_TAB_TAG)) { //do something } else
		 * if(tabName.equals(LIST5_TAB_TAG)) { //do something } else
		 * if(tabName.equals(LIST6_TAB_TAG)) { //do something }
		 */

	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub

	}

	/*
	 * public void onPageScrolled(int arg0, float arg1, int arg2) {
	 * 
	 * int pos = this.mViewPager.getCurrentItem();
	 * 
	 * this.mTabHost.setCurrentTab(pos);
	 * 
	 * }
	 */

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		// int pos=this.mCurrentTransitionEffect.
		Toast.makeText(this, "Position : " + arg0 + " " + arg2,
				Toast.LENGTH_LONG).show();

	}

	@Override
	public void onPageSelected(int arg0) {
		// TODO Auto-generated method stub

	}
}