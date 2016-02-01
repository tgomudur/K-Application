package com.twotoasters.jazzylistview.sample;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.manuelpeinado.fadingactionbar.FadingActionBarHelper;
import in.org.kurukshetra.app.R;

public class SingleEvent extends Activity implements OnClickListener {

	private static final int ID_ADD = 1;
	private static final int ID_ACCEPT = 2;
	private static final int ID_UPLOAD = 3;
	Button buttonref1, buttonref2;
	Bitmap bitmap1, bitmap2;
	RelativeLayout rContact, rMaps;
	ImageView header;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("     ROBOWARS       ");
		header = (ImageView) findViewById(R.id.ivHeader);
		header.setVisibility(0);
		/*
		 * bitmap1=BitmapFactory.decodeResource(getResources(),
		 * R.drawable.maps); Bitmap circleBitmap1 =
		 * Bitmap.createBitmap(bitmap1.getWidth(), bitmap1.getHeight(),
		 * Bitmap.Config.ARGB_8888);
		 * 
		 * 
		 * bitmap2=BitmapFactory.decodeResource(getResources(),
		 * R.drawable.contactsic); Bitmap circleBitmap2 =
		 * Bitmap.createBitmap(bitmap2.getWidth(), bitmap2.getHeight(),
		 * Bitmap.Config.ARGB_8888);
		 * 
		 * BitmapShader shader1 = new BitmapShader (bitmap1, TileMode.CLAMP,
		 * TileMode.CLAMP); Paint paint1 = new Paint();
		 * paint1.setShader(shader1); BitmapShader shader2 = new BitmapShader
		 * (bitmap2, TileMode.CLAMP, TileMode.CLAMP); Paint paint2 = new
		 * Paint(); paint2.setShader(shader2); Canvas c1 = new
		 * Canvas(circleBitmap1); c1.drawCircle(bitmap1.getWidth()/2,
		 * bitmap1.getHeight()/2, bitmap1.getWidth()/2, paint1); Canvas c2 = new
		 * Canvas(circleBitmap2); c2.drawCircle(bitmap2.getWidth()/2,
		 * bitmap2.getHeight()/2, bitmap2.getWidth()/2, paint2); ImageView
		 * ivContact= (ImageView) findViewById(R.id.list_image); ImageView ivMap
		 * =(ImageView) findViewById(R.id.list_image2);
		 * ivContact.setImageBitmap(circleBitmap1);
		 * ivMap.setImageBitmap(circleBitmap2);
		 */
		FadingActionBarHelper helper = new FadingActionBarHelper()
				// .actionBarBackground(R.drawable.white2) Refer
				.actionBarBackground(R.drawable.ab_background)
				.headerLayout(R.layout.header)
				.contentLayout(R.layout.singleevent);

		setContentView(helper.createView(this));

		rContact = (RelativeLayout) findViewById(R.id.rlcontact);
		rMaps = (RelativeLayout) findViewById(R.id.rlmaps);
		rContact.setOnClickListener(this);
		rMaps.setOnClickListener(this);
		buttonref1.setOnClickListener(this);

		helper.initActionBar(this);
		ActionItem addItem = new ActionItem(ID_ADD, "Add", getResources()
				.getDrawable(R.drawable.ic_add));
		ActionItem acceptItem = new ActionItem(ID_ACCEPT, "Accept",
				getResources().getDrawable(R.drawable.ic_accept));
		ActionItem uploadItem = new ActionItem(ID_UPLOAD, "Upload",
				getResources().getDrawable(R.drawable.ic_up));

		// use setSticky(true) to disable QuickAction dialog being dismissed
		// after an item is clicked
		uploadItem.setSticky(true);

		final QuickAction mQuickAction = new QuickAction(this);

		/*
		 * mQuickAction.addActionItem(addItem);
		 * mQuickAction.addActionItem(acceptItem);
		 * mQuickAction.addActionItem(uploadItem);
		 * 
		 * // setup the action item click listener mQuickAction
		 * .setOnActionItemClickListener(new
		 * QuickAction.OnActionItemClickListener() {
		 * 
		 * @Override public void onItemClick(QuickAction quickAction, int pos,
		 * int actionId) { ActionItem actionItem =
		 * quickAction.getActionItem(pos);
		 * 
		 * if (actionId == ID_ADD) { Toast.makeText(getApplicationContext(),
		 * "Add item selected", Toast.LENGTH_SHORT) .show();
		 * buttonref1.setPressed(true); buttonref1.invalidate();
		 * buttonref1.performClick();
		 * 
		 * } else if (actionId == ID_ACCEPT) { startActivity(new
		 * Intent(SingleEvent.this, Gallery.class)); } else if (actionId ==
		 * ID_UPLOAD) { // startActivity(new //
		 * Intent(SingleEvent.this,CustomList.class)); } else {
		 * Toast.makeText(getApplicationContext(), actionItem.getTitle() +
		 * " selected", Toast.LENGTH_SHORT).show(); } } });
		 * 
		 * mQuickAction.setOnDismissListener(new QuickAction.OnDismissListener()
		 * {
		 * 
		 * @Override public void onDismiss() {
		 * Toast.makeText(getApplicationContext(), "Ups..dismissed",
		 * Toast.LENGTH_SHORT).show(); } });
		 * 
		 * buttonref2.setOnClickListener(new OnClickListener() {
		 * 
		 * @Override public void onClick(View arg0) { mQuickAction.show(arg0);
		 * 
		 * } });
		 */

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// getMenuInflater().inflate(R.menu.activity_menu, menu);
		getMenuInflater().inflate(R.menu.bottomaction, menu);
		return true;

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {

		case R.id.contactinformation:
			// Toast.makeText(this, "3", Toast.LENGTH_LONG).show();
			// mQuickAction.show(v);
			buttonref2.setPressed(true);
			buttonref2.invalidate();
			buttonref2.performClick();
			break;
		default:
			;

		}
		return false;
	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		/*
		 * case R.id.buttonrefer1: PopupWindow window =
		 * PopupHelper.newBasicPopupWindow(this);
		 * 
		 * LayoutInflater inflater = (LayoutInflater)
		 * getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		 * 
		 * View popupView = inflater.inflate(R.layout.popup1, null);
		 * 
		 * window.setContentView(popupView); int totalHeight =
		 * getWindowManager().getDefaultDisplay() .getHeight(); int[] location =
		 * new int[2]; arg0.getLocationOnScreen(location);
		 * 
		 * if (location[1] < (totalHeight / 2.0)) { // top half of screen
		 * window.setAnimationStyle(R.style.Animations_PopDownMenuRight);
		 * window.showAsDropDown(arg0); } else { // bottom half
		 * PopupHelper.showLikeQuickAction(window, popupView, arg0,
		 * getWindowManager(), 0, 0); }
		 * 
		 * break;
		 */
		case R.id.rlcontact:
			ViewGroup viewGroup = (ViewGroup) arg0;
			for (int i = 0; i < viewGroup.getChildCount(); i++) {

				View viewChild = viewGroup.getChildAt(i);
				viewChild.setPressed(true);

			}
			Intent intent = new Intent(Intent.ACTION_DIAL);
			intent.setData(Uri.parse("tel:9445426880"));
			startActivity(intent);
			break;
		case R.id.rlmaps:
			Intent openMap = new Intent(SingleEvent.this, MapActivity.class);
			startActivity(openMap);
			break;
		default:
			;

		}

	}

}
