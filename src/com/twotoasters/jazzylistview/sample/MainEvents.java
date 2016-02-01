package com.twotoasters.jazzylistview.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import com.twotoasters.jazzylistview.JazzyGridView;
import com.twotoasters.jazzylistview.JazzyHelper;

import in.org.kurukshetra.app.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MainEvents extends Activity {

	private static final String KEY_TRANSITION_EFFECT = "transition_effect";

	private JazzyGridView mGrid;
	private HashMap<String, Integer> mEffectMap;
	// private int mCurrentTransitionEffect = JazzyHelper.HELIX;
	private int mCurrentTransitionEffect = JazzyHelper.CARDS;

	public void startActivity(int position) {
		// Toast.makeText(this, "Refer : "+l2, Toast.LENGTH_LONG).show();
		Intent description = new Intent(MainEvents.this, MainActivity.class);
		description.putExtra("descripn", position);
		startActivity(description);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grid);

		mGrid = (JazzyGridView) findViewById(android.R.id.list);
		mGrid.setAdapter(new ListAdapter1(this, R.layout.grid_item));

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
		mGrid.setTransitionEffect(mCurrentTransitionEffect);
	}
}
