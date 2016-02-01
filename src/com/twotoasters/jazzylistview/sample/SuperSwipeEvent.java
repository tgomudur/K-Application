package com.twotoasters.jazzylistview.sample;

import in.org.kurukshetra.app.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.twotoasters.jazzylistview.JazzyGridView;
import com.twotoasters.jazzylistview.JazzyHelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

//import com.actionbarsherlock.app.SherlockFragment;

public class SuperSwipeEvent extends Fragment implements View.OnClickListener {

	private static final String ARG_POSITION = "position";

	private int position, i;

	/*
	 * private int[] images = { R.drawable.coding1, R.drawable.debug1,
	 * R.drawable.hepthatalon1,R.drawable.hackathon1,R.drawable.soft1 };
	 */
	private int[] images = { R.drawable.onsite, R.drawable.debug1,
			R.drawable.hepthatalon1, R.drawable.foss1, R.drawable.hackathon1,
			R.drawable.soft1 };
	String[] maindescription = new String[50];
	String[] quotedescription = new String[50];
	public JazzyGridView mGrid1;
	// For Alarm Purpose
	int Alarm_Day[] = { 10, 10, 10 };
	int Alarm_Hour[] = { 18, 18, 18 };
	int Alarm_Minute[] = { 52, 54, 56 };
	int Unique_Id[] = { 1, 2, 3 };
	int alarmFlag;
	int setpage;
	private HashMap<String, Integer> mEffectMap;
	private int mCurrentTransitionEffect = JazzyHelper.WAVE;
	private static final String KEY_TRANSITION_EFFECT = "transition_effect";

	public void setmyjazzy(int position) {
		setupJazziness(mEffectMap.get("helix"));
	}

	public void startActivity(int EventPosition, int position) {

		switch (EventPosition) {
		case 1:
			Intent description1 = new Intent(getActivity(),
					MainFragmentE1.class);
			description1.putExtra("descripn", position);
			startActivity(description1);
			break;
		case 2:
			Intent description2 = new Intent(getActivity(),
					MainFragmentE2.class);
			description2.putExtra("descripn", position);
			startActivity(description2);
			break;
		case 3:
			Intent description3 = new Intent(getActivity(),
					MainFragmentE3.class);
			description3.putExtra("descripn", position);
			startActivity(description3);
			break;
		case 4:
			Intent description4 = new Intent(getActivity(),
					MainFragmentE4.class);
			description4.putExtra("descripn", position);
			startActivity(description4);
			break;
		case 5:
			Intent description5 = new Intent(getActivity(),
					MainFragmentE5.class);
			description5.putExtra("descripn", position);
			startActivity(description5);
			break;
		case 6:
			Intent description6 = new Intent(getActivity(),
					MainFragmentE6.class);
			description6.putExtra("descripn", position);
			startActivity(description6);
			break;
		case 7:
			Intent description7 = new Intent(getActivity(),
					MainFragmentE7.class);
			description7.putExtra("descripn", position);
			startActivity(description7);
			break;
		case 8:
			Intent description8 = new Intent(getActivity(),
					MainFragmentE8.class);
			description8.putExtra("descripn", position);
			startActivity(description8);
			break;
		default:
			;
		}
	}

	public static SuperSwipeEvent newInstance(int position) {
		SuperSwipeEvent f = new SuperSwipeEvent();
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
		// putvalue();
		if (savedInstanceState != null) {
			// mCurrentTransitionEffect =
			// savedInstanceState.getInt(KEY_TRANSITION_EFFECT,
			// JazzyHelper.HELIX);
			mCurrentTransitionEffect = savedInstanceState.getInt(
					KEY_TRANSITION_EFFECT, JazzyHelper.WAVE);
			setupJazziness(mCurrentTransitionEffect);
		}
	}

	private void setupJazziness(int mCurrentTransitionEffect2) {
		// TODO Auto-generated method stub

		mCurrentTransitionEffect = mCurrentTransitionEffect2;
		mGrid1.setTransitionEffect(mCurrentTransitionEffect);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View V = inflater.inflate(R.layout.mygrid, container, false);

		// ImageView iv = (ImageView) V.findViewById(R.id.ivHeader);
		// TextView Desctn = (TextView) V.findViewById(R.id.descri);
		// TextView BriefDesctn = (TextView)
		// V.findViewById(R.id.briefdescription);
		// mGrid1.setAdapter(new ListAdapterE2(this, R.layout.grid_item));

		mGrid1 = (JazzyGridView) V.findViewById(R.id.gridlist11);
		switch (position) {
		case 0:
			mGrid1.setAdapter(new ListAdapterE1(V.getContext(),
					R.layout.grid_item_event));
			break;
		case 1:
			mGrid1.setAdapter(new ListAdapterE2(V.getContext(),
					R.layout.grid_item_event));
			break;
		case 2:
			mGrid1.setAdapter(new ListAdapterE3(V.getContext(),
					R.layout.grid_item_event));
			break;
		case 3:
			mGrid1.setAdapter(new ListAdapterE4(V.getContext(),
					R.layout.grid_item_event));
			break;
		case 4:
			mGrid1.setAdapter(new ListAdapterE5(V.getContext(),
					R.layout.grid_item_event));
			break;
		case 5:
			mGrid1.setAdapter(new ListAdapterE6(V.getContext(),
					R.layout.grid_item_event));
			break;
		case 6:
			mGrid1.setAdapter(new ListAdapterE7(V.getContext(),
					R.layout.grid_item_event));
			break;
		case 7:
			mGrid1.setAdapter(new ListAdapterE8(V.getContext(),
					R.layout.grid_item_event));
			break;
		default:
			;

		}

		mGrid1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				startActivity(position + 1, arg2);
			}
		});

		// mGrid1.setAdapter(new ListAdapterE2(this, R.id.gridlist1));
		// Desctn.setText("JSR KURUKSHETRA ! ! !");

		// Static Reference

		// Desctn.setText("It is better to create than to learn! Creating is the essence of life\n                         -Julius Caesar");

		// Static Reference
		// ImageView iv=(ImageView) getView().findViewById(R.id.ivHeader);
		// ImageView iv=(ImageView) inflater.inflate(R.layout.singleevent,
		// null);
		// iv.setImageResource(images[position % 7]);
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
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		String strEffect = item.getTitle().toString();
		// Toast.makeText(getActivity(), strEffect, Toast.LENGTH_SHORT).show();
		setupJazziness(mEffectMap.get(strEffect));
		return true;
	}

	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		// TODO Auto-generated method stub
		// Toast.makeText(getActivity(), "Click :", Toast.LENGTH_SHORT).show();

		return true;
	}

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
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt(KEY_TRANSITION_EFFECT, mCurrentTransitionEffect);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

}
