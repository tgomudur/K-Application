package com.twotoasters.jazzylistview.home;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import in.org.kurukshetra.app.R;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.view.CardView;

public class Update extends Card {

	// private static String url = "http://api.androidhive.info/contacts/";
	private static String url = "http://kurukshetra.org.in/tech/news.txt";
	private static final String TAG_CONTACTS = "messages";
	private static final String TAG_ID = "id";
	private static final String TAG_NAME = "msg";
	JSONArray contacts = null;
	int i = 0;
	String myUpdate[] = new String[50];
	String refer[] = {
			"Welcome To Battle of Brains",
			"Deadline for Team Description paper for Robo Wars has been extended ",
			"Registration for accomodation is now open",
			"Workshop Registration is now open",
			"Xceed Warangal is scheduled on Jan 9-10",
			"Ros Main Run has now started",
			"Problem Statement For Soft Coding has been put up !!!" };
	int runLength = 5;
	int myUpdateCount = 0;
	private ProgressDialog pDialog;
	private ImageView refresh;
	private static Context contextOfApplication;

	public static Context getContextOfApplication() {
		return contextOfApplication;
	}

	public void refresh_update(int value) {
		if (IsNetPresent()) {
			if (value == 1) {
				Toast.makeText(getContext(), "Refreshing. . .",
						Toast.LENGTH_SHORT).show();
			}
			new GetContacts().execute();
		} else {
			for (int j = 0; j < 6; j++) {
				myUpdate[j] = refer[j];
			}
			if (value == 1) {
				Toast.makeText(getContext(),
						"Internet Connection Not Available", Toast.LENGTH_SHORT)
						.show();
			}

		}

	}

	public boolean IsNetPresent() {
		ConnectionDetector cd = new ConnectionDetector(getContext());
		Boolean isInternetPresent = cd.isConnectingToInternet();

		return isInternetPresent;

	}

	public Update(Context context) {
		this(context, R.layout.update);
	}

	public Update(Context context, int innerLayout) {
		super(context, innerLayout);
		init();
	}

	private void init() {
		// Add Header
		CardHeader header = new SingleTextHeader(getContext(), R.layout.dummy);
		header.setTitle("");
		addCardHeader(header);
		setShadow(false);

		contextOfApplication = getContext();

		Context applicationContext = Update.getContextOfApplication();
		SharedPreferences UpdateCorner = PreferenceManager
				.getDefaultSharedPreferences(applicationContext);

		String generalupdates = UpdateCorner.getString("normalupdates",
				"Refressing");

		if (generalupdates.equals("Refreshing")) {

			for (i = 0; i < 7; i++) {
				myUpdate[i] = refer[i];
			}

			SharedPreferences.Editor editor = UpdateCorner.edit();
			editor.putString("normalupdates", "Refressed");
			editor.commit();

		}

		if (IsNetPresent()) {
			new GetContacts().execute();
		} else {
			for (int j = 0; j < 6; j++) {
				myUpdate[j] = refer[j];
			}
			Toast.makeText(getContext(), "Internet Connection Not Available",
					Toast.LENGTH_SHORT).show();

		}

		/*
		 * try { SharedPreferences UpdateCorner
		 * =getSharedPreferences("UpdateCorner", Context.MODE_PRIVATE);
		 * SharedPreferences.Editor prefsEditorProfiles = UpdateCorner.edit();
		 * prefsEditorProfiles.putString("UpdateCorner","nj");
		 * prefsEditorProfiles.commit(); }catch(NullPointerException e) { }
		 */
		// Add Thumbnail
		/*
		 * CardThumbnail thumbnail = new CardThumbnail(getContext());
		 * thumbnail.setUrlResource
		 * ("https://plus.google.com/s2/photos/profile/114432517923423045208?sz=72"
		 * ); thumbnail.setErrorResource(R.drawable.ic_error_loadingsmall);
		 * addCardThumbnail(thumbnail);
		 */

		OnCardClickListener clickListener = new OnCardClickListener() {
			@Override
			public void onClick(Card card, View view) {
				// show();
			}
		};

		addPartialOnClickListener(Card.CLICK_LISTENER_CONTENT_VIEW,
				clickListener);
	}

	private static SharedPreferences getSharedPreferences(String string,
			int modePrivate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setupInnerViewElements(ViewGroup parent, View view) {

		CardView cardView = getCardView();

		final Animation inAnimation = AnimationUtils.makeInAnimation(
				view.getContext(), true);
		final Animation outAnimation = AnimationUtils.makeOutAnimation(
				view.getContext(), true);
		final Animation up = AnimationUtils.makeInChildBottomAnimation(view
				.getContext());
		final String[] imageArray3 = { "\"Battle of Brains\"",
				"Dalal Bull has started!!!",
				"Registration for accomodation is now open",
				"Workshop Registration is now open",
				"Xceed Warangal is scheduled on Jan 9-10" };
		final Handler handler = new Handler();
		final TextView tv = (TextView) view.findViewById(R.id.tvUpdate);
		refresh = (ImageView) view.findViewById(R.id.imageView1);
		refresh.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				refresh_update(1);
			}
		});

		Runnable runnable = new Runnable() {
			int i = 0;

			@Override
			public void run() {
				if (true) {
					// iv2.setImageResource(imageArray[j]);
					// dddiv2.startAnimation(inAnimation);
					// iv.setImageResource(imageArray3[i]);
					// tv.setText(imageArray3[i]);
					tv.setText(myUpdate[i]);
					// ibCyber.setImageResource(imageArray3[i]);
					tv.startAnimation(up);

					// ImageViewAnimatedChange(this,iv,imageArray[i]);

					i++;
					myUpdateCount++;
					if (myUpdateCount > 25) {
						myUpdateCount = 0;
						refresh_update(0);
					}

					if (i > runLength - 1) {
						i = 0;
						// canrun=false;

					}
				}
				handler.postDelayed(this, 6000); // for interval...

				// iv.startAnimation(outAnimation);
			}

		};
		tv.startAnimation(up);
		handler.postDelayed(runnable, 50);
		// CardThumbnailView thumb = cardView.getInternalThumbnailLayout();
		// if (thumb != null) {
		// ViewGroup.LayoutParams lp = thumb.getLayoutParams();
		// if (lp instanceof ViewGroup.MarginLayoutParams) {
		// ((ViewGroup.MarginLayoutParams) lp).setMargins(25, 0, 0, 5);
		// }
		// }

	}

	class SingleTextHeader extends CardHeader {

		public SingleTextHeader(Context context, int innerLayout) {
			super(context, innerLayout);
		}

		@Override
		public void setupInnerViewElements(ViewGroup parent, View view) {
			super.setupInnerViewElements(parent, view);

			// TextView t1 = (TextView)
			// view.findViewById(R.id.carddemo_mayknow_main_inner_subtitle);
			// if (t1 != null)
			// t1.setText(getContext().getString(R.string.may_know_card_subtitle));
		}
	}

	private class GetContacts extends AsyncTask<Void, Void, Void> {

		@Override
		protected Void doInBackground(Void... arg0) {
			// Creating service handler class instance
			ServiceHandler sh = new ServiceHandler();

			// Making a request to url and getting response
			String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);

			Log.d("Response: ", "> " + jsonStr);

			if (jsonStr != null) {
				try {
					JSONObject jsonObj = new JSONObject(jsonStr);

					// Getting JSON Array node
					contacts = jsonObj.getJSONArray(TAG_CONTACTS);

					// looping through All Contacts
					runLength = contacts.length();
					for (int i = 0; i < contacts.length(); i++) {
						JSONObject c = contacts.getJSONObject(i);

						String id = c.getString(TAG_ID);
						String name = c.getString(TAG_NAME);
						myUpdate[i] = name;

						// Phone node is JSON Object

						// String mobile = phone.getString(TAG_PHONE_MOBILE);
						// String home = phone.getString(TAG_PHONE_HOME);
						// String office = phone.getString(TAG_PHONE_OFFICE);

						// tmp hashmap for single contact
						HashMap<String, String> contact = new HashMap<String, String>();

						// adding each child node to HashMap key => value
						contact.put(TAG_ID, id);
						contact.put(TAG_NAME, name);

						// adding contact to contact list

					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			} else {
				Log.e("ServiceHandler", "Couldn't get any data from the url");
			}

			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			// Dismiss the progress dialog

			/**
			 * Updating parsed JSON data into ListView
			 * */

		}

	}

	public static class LoadUpdate {
		public static String load() {
			SharedPreferences UpdateCorner = getSharedPreferences(
					"UpdateCorner", Context.MODE_PRIVATE);
			String currentupdate = UpdateCorner.getString("UpdateCorner",
					"nocontents");

			return currentupdate;

		}
	}

	public class ConnectionDetector {

		private Context _context;

		public ConnectionDetector(Context context) {
			this._context = context;
		}

		public boolean isConnectingToInternet() {
			ConnectivityManager connectivity = (ConnectivityManager) _context
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			if (connectivity != null) {
				NetworkInfo[] info = connectivity.getAllNetworkInfo();
				if (info != null)
					for (int i = 0; i < info.length; i++)
						if (info[i].getState() == NetworkInfo.State.CONNECTED) {
							return true;
						}

			}
			return false;
		}
	}

}
