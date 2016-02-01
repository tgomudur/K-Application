package com.twotoasters.jazzylistview.home;

import com.github.espiandev.showcaseview.ShowcaseView;
import com.pushio.manager.PushIOActivityLauncher;
import com.pushio.manager.PushIOManager;
import com.twotoasters.jazzylistview.about.AboutUs;
import com.twotoasters.jazzylistview.about.FinalContact;

import com.twotoasters.jazzylistview.sample.EssayWin;
import com.twotoasters.jazzylistview.sample.EventKarnival;
import com.twotoasters.jazzylistview.sample.EventSwipeCenter;
import com.twotoasters.jazzylistview.sample.Gallery;
import com.twotoasters.jazzylistview.sample.Karnival;
import com.twotoasters.jazzylistview.sample.QuickContactFragment;

import in.org.kurukshetra.app.R;
import com.twotoasters.jazzylistview.sample.Workshops;
import com.twotoasters.jazzylistview.sponsors.FinalSponsors;
import com.twotoasters.jazzylistview.update.IndividualUpdate;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.internal.CardExpand;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.view.CardListView;

import java.util.ArrayList;
import java.util.List;

import net.simonvt.menudrawer.MenuDrawer;

public class NoBoringHomeActivity extends FragmentActivity implements
		OnClickListener, ShowcaseView.OnShowcaseEventListener {

	private static final String TAG = "NoBoringActionBarActivity";
	private int mActionBarTitleColor;
	private int mActionBarHeight;
	private int mHeaderHeight;
	private int mMinHeaderTranslation;
	private CardListView mListView;
	private KenBurnsView mHeaderPicture;
	private ImageView mHeaderLogo;
	private View mHeader;
	private View mPlaceHolderView;
	private AccelerateDecelerateInterpolator mSmoothInterpolator;
	SharedPreferences showcasepref;
	SharedPreferences.Editor showcaseeditor;

	private RectF mRect1 = new RectF();
	private RectF mRect2 = new RectF();

	private AlphaForegroundColorSpan mAlphaForegroundColorSpan;
	private SpannableString mSpannableString;

	private TypedValue mTypedValue = new TypedValue();

	private static final String STATE_ACTIVE_POSITION = "net.simonvt.menudrawer.samples.ContentSample.activePosition";
	private static final String STATE_CONTENT_TEXT = "net.simonvt.menudrawer.samples.ContentSample.contentText";

	private MenuDrawer mMenuDrawer;

	private MenuAdapter mAdapter;
	private ListView mList;

	private int mActivePosition = -1;
	private String mContentText;
	private TextView mContentTextView;

	ShowcaseView sv;

	@SuppressLint("NewApi")
	public void setupActionBar1() {
		ActionBar actionBar = getActionBar();
		actionBar.setIcon(R.drawable.klogo);

		// getActionBarTitleView().setAlpha(0f);
	}

	private ImageView getActionBarIconView() {
		return (ImageView) findViewById(android.R.id.home);
	}

	/*
	 * private TextView getActionBarTitleView() { int id =
	 * Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
	 * return (TextView) findViewById(id); }
	 */

	public int getActionBarHeight() {
		if (mActionBarHeight != 0) {
			return mActionBarHeight;
		}
		getTheme().resolveAttribute(android.R.attr.actionBarSize, mTypedValue,
				true);
		mActionBarHeight = TypedValue.complexToDimensionPixelSize(
				mTypedValue.data, getResources().getDisplayMetrics());
		return mActionBarHeight;
	}

	public void gotoEvents(int position) {

		switch (position) {

		case 1:

			// startActivity(new Intent(HomeViewPager.this,EventsCentre.class));
			// startActivity(new Intent(HomeViewPager.this,EventsCorner.class));
			// startActivity(new Intent(NoBoringHomeActivity.this,
			// Eventcentremain.class));
			startActivity(new Intent(NoBoringHomeActivity.this,
					EventSwipeCenter.class));
			break;

		case 2:

			break;
		case 3:
			// startActivity(new
			// Intent(HomeViewPager.this,SingleEventOnly.class));
			// startActivity(new
			// Intent(HomeViewPager.this,Eventcentremain.class));
			// startActivity(new Intent(MainHome.this,MainEvents.class));
			startActivity(new Intent(NoBoringHomeActivity.this, Workshops.class));
			break;
		case 4:
			// startActivity(new Intent(HomeViewPager.this,MainActivity.class));
			// startActivity(new Intent(HomeViewPager.this,Workshops.class));
			// startActivity(new Intent(HomeViewPager.this,GuestLecture.class));
			startActivity(new Intent(NoBoringHomeActivity.this, Gallery.class));
			break;
		case 5:
			// startActivity(new Intent(HomeViewPager.this,MainActivity.class));
			// startActivity(new Intent(HomeViewPager.this,GuestLecture.class));
			// startActivity(new Intent(NoBoringHomeActivity.this,
			// Gallery.class));
			break;
		case 6:
			// startActivity(new Intent(HomeViewPager.this,EventsCorner.class));
			// startActivity(new Intent(NoBoringHomeActivity.this,
			// SingleEventOnly.class));
			startActivity(new Intent(NoBoringHomeActivity.this,
					FinalContact.class));
			break;
		case 7:
			// startActivity(new Intent(HomeViewPager.this,MainActivity.class));
			// startActivity(new Intent(NoBoringHomeActivity.this,
			// SingleEventOnly.class));
			// startActivity(new Intent(NoBoringHomeActivity.this,
			// SponsorPage.class));
			// startActivity(new Intent(NoBoringHomeActivity.this,
			// Sponsor.class));
			// startActivity(new Intent(NoBoringHomeActivity.this,
			// FinalSponsors.class));
			startActivity(new Intent(NoBoringHomeActivity.this,
					IndividualUpdate.class));
			break;
		case 8:
			// startActivity(new
			// Intent(NoBoringHomeActivity.this,GeneralContact.class));
			// startActivity(new
			// Intent(NoBoringHomeActivity.this,EventSwipeCenter.class));

			// startActivity(new
			// Intent(NoBoringHomeActivity.this,ContactPage.class));

			// startActivity(new Intent(NoBoringHomeActivity.this,
			// SingleEventOnly.class));
			// startActivity(new Intent(NoBoringHomeActivity.this,
			// SingleEventOnly.class));

			break;
		case 9:
			// startActivity(new
			// Intent(NoBoringHomeActivity.this,GeneralContact.class));
			// startActivity(new
			// Intent(NoBoringHomeActivity.this,EventSwipeCenter.class));
			startActivity(new Intent(NoBoringHomeActivity.this,
					FinalSponsors.class));
			// startActivity(new
			// Intent(NoBoringHomeActivity.this,ContactPage.class));

			// startActivity(new Intent(NoBoringHomeActivity.this,
			// SingleEventOnly.class));
			// startActivity(new Intent(NoBoringHomeActivity.this,
			// SingleEventOnly.class));

			break;
		case 10:
			// startActivity(new
			// Intent(NoBoringHomeActivity.this,GeneralContact.class));
			// startActivity(new
			// Intent(NoBoringHomeActivity.this,EventSwipeCenter.class));
			// startActivity(new
			// Intent(NoBoringHomeActivity.this,IndividualUpdate.class));
			startActivity(new Intent(NoBoringHomeActivity.this, AboutUs.class));
			// startActivity(new
			// Intent(NoBoringHomeActivity.this,ContactPage.class));

			// startActivity(new Intent(NoBoringHomeActivity.this,
			// SingleEventOnly.class));
			// startActivity(new Intent(NoBoringHomeActivity.this,
			// SingleEventOnly.class));

			break;
		case 11:
			// startActivity(new
			// Intent(NoBoringHomeActivity.this,GeneralContact.class));
			// startActivity(new
			// Intent(NoBoringHomeActivity.this,EventSwipeCenter.class));
			// startActivity(new
			// Intent(NoBoringHomeActivity.this,IndividualUpdate.class));
			startActivity(new Intent(NoBoringHomeActivity.this,
					EventKarnival.class));
			// startActivity(new
			// Intent(NoBoringHomeActivity.this,ContactPage.class));

			// startActivity(new Intent(NoBoringHomeActivity.this,
			// SingleEventOnly.class));
			// startActivity(new Intent(NoBoringHomeActivity.this,
			// SingleEventOnly.class));

			break;
		case 12:
			// startActivity(new
			// Intent(NoBoringHomeActivity.this,GeneralContact.class));
			// startActivity(new
			// Intent(NoBoringHomeActivity.this,EventSwipeCenter.class));
			// startActivity(new
			// Intent(NoBoringHomeActivity.this,IndividualUpdate.class));
			startActivity(new Intent(NoBoringHomeActivity.this,
					EventKarnival.class));
			// startActivity(new
			// Intent(NoBoringHomeActivity.this,ContactPage.class));

			// startActivity(new Intent(NoBoringHomeActivity.this,
			// SingleEventOnly.class));
			// startActivity(new Intent(NoBoringHomeActivity.this,
			// SingleEventOnly.class));

			break;
		case 13:
			// startActivity(new
			// Intent(NoBoringHomeActivity.this,GeneralContact.class));
			// startActivity(new
			// Intent(NoBoringHomeActivity.this,EventSwipeCenter.class));
			// startActivity(new
			// Intent(NoBoringHomeActivity.this,IndividualUpdate.class));
			startActivity(new Intent(NoBoringHomeActivity.this, Karnival.class));
			// startActivity(new
			// Intent(NoBoringHomeActivity.this,ContactPage.class));

			// startActivity(new Intent(NoBoringHomeActivity.this,
			// SingleEventOnly.class));
			// startActivity(new Intent(NoBoringHomeActivity.this,
			// SingleEventOnly.class));

			break;
		case 14:
			// startActivity(new
			// Intent(NoBoringHomeActivity.this,GeneralContact.class));
			// startActivity(new
			// Intent(NoBoringHomeActivity.this,EventSwipeCenter.class));
			// startActivity(new
			// Intent(NoBoringHomeActivity.this,IndividualUpdate.class));
			startActivity(new Intent(NoBoringHomeActivity.this, EssayWin.class));
			// startActivity(new
			// Intent(NoBoringHomeActivity.this,ContactPage.class));

			// startActivity(new Intent(NoBoringHomeActivity.this,
			// SingleEventOnly.class));
			// startActivity(new Intent(NoBoringHomeActivity.this,
			// SingleEventOnly.class));

			break;
		default:
			;
		}

	}

	private void setupListView1() {
		ArrayList<Card> cards = new ArrayList<Card>();

		// ArrayList<String> FAKES = new ArrayList<String>();
		// FAKES.add("Welcome to K14!!!!!");
		/*
		 * for (int i = 0; i < 1000; i++) { FAKES.add("entry " + i); }
		 */
		Update s = new Update(this);
		MyCard card = new MyCard(this);
		CardHeader cardheader = new CardHeader(this);
		// cardheader.setTitle("");
		// card.addCardHeader(cardheader);
		cards.add(s);
		cards.add(card);
		// cardheader.setOtherButtonVisible(true);
		// cardheader.setButtonExpandVisible(true);
		CardExpand expand = new CardExpand(this);
		expand.setTitle("");
		card.addCardExpand(expand);

		/*
		 * Card card1 = new Card(this); CardHeader cardheader1 = new
		 * CardHeader(this); cardheader1.setTitle("");
		 * card1.addCardHeader(cardheader1); cards.add(card1);
		 * cardheader1.setOtherButtonDrawable(R.drawable.menu_arrow_bottom);
		 * cardheader1.setOtherButtonVisible(true);
		 * 
		 * /*Card card2 = new Card(this); CardHeader cardheader2 = new
		 * CardHeader(this); cardheader2.setTitle("");
		 * card2.addCardHeader(cardheader2); cards.add(card2);
		 * cardheader2.setOtherButtonVisible(true);
		 */

		SingleButtonCard k = new SingleButtonCard(this);
		ThreeButtonCard t = new ThreeButtonCard(this);
		// SingleButtonCardHeader kh=new
		// SingleButtonCardHeader(this,R.layout.dummy);
		cards.add(t);
		cards.add(k);

		CardArrayAdapter mCardArrayAdapter = new CardArrayAdapter(this, cards);
		// mCardArrayAdapter.setInnerViewTypeCount(2);
		// CardListView listView = (CardListView) findViewById(R.id.myList);*/
		mPlaceHolderView = getLayoutInflater().inflate(
				R.layout.view_header_placeholder, mListView, false);
		mListView.addHeaderView(mPlaceHolderView);
		// listView.addHeaderView(mPlaceHolderView);
		mListView.setAdapter(mCardArrayAdapter);

		// mListView.setAdapter(new ArrayAdapter<String>(this,
		// android.R.layout.simple_list_item_1, cards));
		mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
			// listView.setOnScrollListener(new AbsListView.OnScrollListener() {
			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
			}

			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {
				int scrollY = getScrollY();
				// sticky actionbar
				mHeader.setTranslationY(Math.max(-scrollY,
						mMinHeaderTranslation));
				// header_logo --> actionbar icon
				float ratio = clamp(mHeader.getTranslationY()
						/ mMinHeaderTranslation, 0.0f, 1.0f);
				interpolate(mHeaderLogo, getActionBarIconView(),
						mSmoothInterpolator.getInterpolation(ratio));
				// actionbar title alpha
				// getActionBarTitleView().setAlpha(clamp(5.0F * ratio - 4.0F,
				// 0.0F, 1.0F));
				// ---------------------------------
				// better way thanks to @cyrilmottier
				setTitleAlpha(clamp(5.0F * ratio - 4.0F, 0.0F, 1.0F));
			}
		});
	}

	@SuppressLint("NewApi")
	private void setTitleAlpha(float alpha) {
		mAlphaForegroundColorSpan.setAlpha(alpha);
		mSpannableString.setSpan(mAlphaForegroundColorSpan, 0,
				mSpannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		getActionBar().setTitle(mSpannableString);
	}

	public static float clamp(float value, float max, float min) {
		return Math.max(Math.min(value, min), max);
	}

	private void interpolate(View view1, View view2, float interpolation) {
		getOnScreenRect(mRect1, view1);
		getOnScreenRect(mRect2, view2);

		float scaleX = 1.0F + interpolation
				* (mRect2.width() / mRect1.width() - 1.0F);
		float scaleY = 1.0F + interpolation
				* (mRect2.height() / mRect1.height() - 1.0F);
		float translationX = 0.5F * (interpolation * (mRect2.left
				+ mRect2.right - mRect1.left - mRect1.right));
		float translationY = 0.5F * (interpolation * (mRect2.top
				+ mRect2.bottom - mRect1.top - mRect1.bottom));

		view1.setTranslationX(translationX);
		view1.setTranslationY(translationY - mHeader.getTranslationY());
		view1.setScaleX(scaleX);
		view1.setScaleY(scaleY);
	}

	private RectF getOnScreenRect(RectF rect, View view) {
		rect.set(view.getLeft(), view.getTop(), view.getRight(),
				view.getBottom());
		return rect;
	}

	public int getScrollY() {
		View c = mListView.getChildAt(0);
		if (c == null) {
			return 0;
		}

		int firstVisiblePosition = mListView.getFirstVisiblePosition();
		int top = c.getTop();

		int headerHeight = 0;
		if (firstVisiblePosition >= 1) {
			headerHeight = mPlaceHolderView.getHeight();
		}

		return -top + firstVisiblePosition * c.getHeight() + headerHeight;
	}

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (savedInstanceState != null) {
			mActivePosition = savedInstanceState.getInt(STATE_ACTIVE_POSITION);
			mContentText = savedInstanceState.getString(STATE_CONTENT_TEXT);
		}

		PushIOManager mPushIOManager = PushIOManager.getInstance(this);
		mPushIOManager.ensureRegistration();

		Intent newIntent = new Intent(this, PushIOActivityLauncher.class);
		Intent intent = new Intent(this, NoBoringHomeActivity.class);
		newIntent.putExtras(intent);

		mSmoothInterpolator = new AccelerateDecelerateInterpolator();
		mHeaderHeight = getResources().getDimensionPixelSize(
				R.dimen.header_height);
		mMinHeaderTranslation = -mHeaderHeight + getActionBarHeight() / 2;

		setContentView(R.layout.noboringhome);

		showcasepref = getSharedPreferences("showcasetest", MODE_PRIVATE);
		showcaseeditor = showcasepref.edit();
		String getStatus = showcasepref.getString("showcaseregister", "nil");

		if (getStatus.equals("true")) {

		} else {
			ShowcaseView.ConfigOptions mOptions = new ShowcaseView.ConfigOptions();
			mOptions.hideOnClickOutside = true;
			sv = ShowcaseView.insertShowcaseView(250, 50, this,
					"WELCOME TO KURUKSHETRA 14!",
					"Click on the logo to see the menu ", mOptions);

			sv.pointTo(70, 50);
			sv.setOnShowcaseEventListener(this);
			showcaseeditor.putString("showcaseregister", "true");
			showcaseeditor.commit();
		}

		mMenuDrawer = MenuDrawer.attach(this, MenuDrawer.MENU_DRAG_CONTENT);
		mMenuDrawer.setContentView(R.layout.noboringhome);
		mMenuDrawer.setTouchMode(MenuDrawer.TOUCH_MODE_FULLSCREEN);

		mMenuDrawer.setMenuSize(550);

		mListView = (CardListView) findViewById(R.id.listview);
		mHeader = findViewById(R.id.hheader);
		// mHeaderPicture = (KenBurnsView) findViewById(R.id.hheader_picture);
		// mHeaderPicture.setResourceIds(R.drawable.picture0,
		// R.drawable.picture1,
		// R.drawable.picture0, R.drawable.picture1);
		mHeaderLogo = (ImageView) findViewById(R.id.hheader_logo);

		mActionBarTitleColor = getResources().getColor(
				R.color.actionbar_title_color);

		mSpannableString = new SpannableString(
				getString(R.string.noboringactionbar_title));
		// getString(R.string.activity_title_fragment));
		mAlphaForegroundColorSpan = new AlphaForegroundColorSpan(
				mActionBarTitleColor);

		setupActionBar1();
		setupListView1();
		// new GetContacts().execute();
		mHeaderPicture = (KenBurnsView) findViewById(R.id.hheader_picture);
		// mHeaderPicture.setResourceIds(R.drawable.picture0,
		// R.drawable.picture1,
		// R.drawable.picture0, R.drawable.picture1);

		mHeaderPicture.setResourceIds(R.drawable.home_crowd1,
				R.drawable.home_robo1, R.drawable.home_pot1,
				R.drawable.home_speed1);
		List<Object> items = new ArrayList<Object>();

		items.add(new Item("Home", R.drawable.icon_home));
		items.add(new Item("Events", R.drawable.icon_event1));
		items.add(new Category("Cat 1"));
		items.add(new Item("Workshops", R.drawable.icon_contact2));
		items.add(new Item("Lectures", R.drawable.icon_event2));
		items.add(new Category("Cat 2"));
		items.add(new Item("Contact", R.drawable.icon_contact));
		items.add(new Item("Updates", R.drawable.icon_info));
		items.add(new Category("Cat 3"));
		items.add(new Item("Sponsors", R.drawable.sponsor));
		items.add(new Item("AboutUs", R.drawable.icon_help));
		items.add(new Category("Cat 4"));
		items.add(new Item("Karnival", R.drawable.karnival));
		items.add(new Item("K Projects", R.drawable.project1));
		items.add(new Item("SA Winners", R.drawable.essay));

		int BgColor = Color.parseColor("#222222");
		mList = new ListView(this);
		mList.setBackgroundColor(BgColor);
		mAdapter = new MenuAdapter(items);
		mList.setAdapter(mAdapter);
		mList.setOnItemClickListener(mItemClickListener);

		mMenuDrawer.setMenuView(mList);
		mMenuDrawer.setBackgroundColor(getTitleColor());

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}

		// mContentTextView = (TextView) findViewById(R.id.vont);
		// mContentTextView.setText(mContentText);

		mMenuDrawer
				.setOnInterceptMoveEventListener(new MenuDrawer.OnInterceptMoveEventListener() {
					@Override
					public boolean isViewDraggable(View v, int dx, int x, int y) {
						return v instanceof SeekBar;
						// return false;
					}
				});
	}

	private AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			mActivePosition = position;
			mMenuDrawer.setActiveView(view, position);
			// mContentTextView.setText(((TextView) view).getText());
			// Intent i =new Intent(this,HomeViewPager.class);
			gotoEvents(position);
			mMenuDrawer.closeMenu();
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt(STATE_ACTIVE_POSITION, mActivePosition);
		outState.putString(STATE_CONTENT_TEXT, mContentText);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_contact:
			QuickContactFragment dialog = new QuickContactFragment();
			dialog.show(getSupportFragmentManager(), "QuickFragment");
			break;
		case android.R.id.home:
			mMenuDrawer.toggleMenu();
			/*
			 * int width = (int) TypedValue.applyDimension(
			 * TypedValue.COMPLEX_MANTISSA_MASK, 30, getResources()
			 * .getDisplayMetrics()); SlideoutActivity.prepare(this, R.id.home,
			 * width);
			 * 
			 * return true; }
			 */
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onBackPressed() {
		new AlertDialog.Builder(this)
				.setMessage(
						"Do Visit Our Projects..."
								+ "Are You Sure You Want To Exit ?")
				.setCancelable(false)
				.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int id) {
								finish();
								finish();
								System.exit(0);
							}
						}).setNegativeButton("No", null).show();
		final int drawerState = mMenuDrawer.getDrawerState();
		if (drawerState == MenuDrawer.STATE_OPEN
				|| drawerState == MenuDrawer.STATE_OPENING) {
			mMenuDrawer.closeMenu();
			return;
		}
	}

	private static class Item {

		String mTitle;
		int mIconRes;

		Item(String title, int iconRes) {
			mTitle = title;
			mIconRes = iconRes;
		}
	}

	private static class Category {

		String mTitle;

		Category(String title) {
			mTitle = title;
		}
	}

	private class MenuAdapter extends BaseAdapter {

		private List<Object> mItems;

		MenuAdapter(List<Object> items) {
			mItems = items;
		}

		@Override
		public int getCount() {
			return mItems.size();
		}

		@Override
		public Object getItem(int position) {
			return mItems.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public int getItemViewType(int position) {
			return getItem(position) instanceof Item ? 0 : 1;
		}

		@Override
		public int getViewTypeCount() {
			return 2;
		}

		@Override
		public boolean isEnabled(int position) {
			return getItem(position) instanceof Item;
		}

		@Override
		public boolean areAllItemsEnabled() {
			return false;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View v = convertView;
			Object item = getItem(position);

			if (item instanceof Category) {
				if (v == null) {
					v = getLayoutInflater().inflate(R.layout.menu_row_category,
							parent, false);
				}

				((TextView) v).setText(((Category) item).mTitle);

			} else {
				if (v == null) {
					v = getLayoutInflater().inflate(R.layout.menu_row_item,
							parent, false);
				}

				TextView tv = (TextView) v;
				tv.setText(((Item) item).mTitle);
				tv.setCompoundDrawablesWithIntrinsicBounds(
						((Item) item).mIconRes, 0, 0, 0);
			}

			v.setTag(R.id.mdActiveViewPosition, position);

			if (position == mActivePosition) {
				mMenuDrawer.setActiveView(v, position);
			}

			return v;
		}

	}

	@Override
	public void onShowcaseViewHide(ShowcaseView showcaseView) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onShowcaseViewShow(ShowcaseView showcaseView) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

}
