package com.twotoasters.jazzylistview.sponsors;

import com.twotoasters.jazzylistview.sample.QuickContactFragment;

import in.org.kurukshetra.app.R;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.widget.FrameLayout;

public class FinalSponsors extends FragmentActivity {

	Animation slidein, slideout, left, right, bounce;
	FrameLayout frameid1, frameid2, frameid3, frameid4, frameid5, frameid6;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.finalsponsor);
		/*
		 * final PanningView panningView = (PanningView)
		 * findViewById(R.id.panningView1); // panningView.startPanning(); /*
		 * frameid1=(FrameLayout) findViewById(R.id.grouponId);
		 * frameid2=(FrameLayout) findViewById(R.id.logoId1);
		 * frameid3=(FrameLayout) findViewById(R.id.logoId2);
		 * frameid4=(FrameLayout) findViewById(R.id.logoId3);
		 * frameid5=(FrameLayout) findViewById(R.id.logoId4);
		 * frameid6=(FrameLayout) findViewById(R.id.logoId5); slidein =
		 * AnimationUtils.loadAnimation(getApplicationContext(),
		 * R.anim.zoom_in); slideout =
		 * AnimationUtils.loadAnimation(getApplicationContext(),
		 * R.anim.zoom_out);
		 * 
		 * bounce=AnimationUtils.loadAnimation(getApplicationContext(),
		 * R.anim.bounce);
		 * left=AnimationUtils.loadAnimation(getApplicationContext(),
		 * R.anim.left);
		 * right=AnimationUtils.loadAnimation(getApplicationContext(),
		 * R.anim.right);
		 * 
		 * 
		 * frameid1.startAnimation(bounce); frameid2.startAnimation(left);
		 * frameid3.startAnimation(right); frameid4.startAnimation(left);
		 * frameid5.startAnimation(right); frameid6.startAnimation(left);
		 */

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
