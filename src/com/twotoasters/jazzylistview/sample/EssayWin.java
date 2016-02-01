package com.twotoasters.jazzylistview.sample;

import java.util.Arrays;

import org.json.JSONArray;
import com.cuubonandroid.sugaredlistanimations.GPlusListAdapter;
import com.cuubonandroid.sugaredlistanimations.SpeedScrollListener;
import in.org.kurukshetra.app.R;

import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class EssayWin extends ListActivity {

	private SpeedScrollListener listener;
	private PlusImageAdapter plusAdapter;

	private static final String url = "http://kurukshetra.org.in/tech/news.txt";

	// JSON Node names
	private static final String TAG_CONTACTS = "messages";
	private static final String TAG_ID = "id";
	private static final String TAG_NAME = "msg";
	private ProgressDialog pDialog;
	Animation animLeft;

	int runLength = 5;
	static String myUpdateRefer[] = {
			"1. Aakash SA-AAAI (Sri Shakthi Institute of Engineering & Technology)",
			"2. Arun Prakash S (SA-AACRK Ramakrishnan College of Technology)",
			"3. Soundharya A M (SA-AACL Jansons Institute of Technology)",
			"4. Keerthi Kumar (SA-AAAV Panimalar Engineering College)",
			"5. Abilash R (SA-AACD Bannari Amman Institute of Technology)",
			"6. R.Deepak Kumar (SA-AACV Kongu Engineering College)",
			"7. Mohammed Farook Ali I (SA-AAAB KSR College of Engineering)",
			"8. Niraj Prasad Bhatta (SA-AAFC PSNA College of Engineering and Technology)",
			"9. Toms Fernando (SA-AAAS Alpha College of Engineering)",
			"10. Dhanush Murali (SA-AADL RMK Engineering College)",
			"11. Reuben Sajith R (SA-AADE Paavai Engineering College)",
			"12. Mudapaka Sai Krishna (SA-AAFQ Sagi Ramakrishnam Raju Engineering College)",
			"13. Sanjay.T (SA-AADH PSG College of Technology)",
			"14. Yagna Sri (SA-AACO K L University)",
			"15. Divya.J (SA-AAAN KSR College of Technology)",
			"16. Ravi Motasra (SA-AAAF SA Engineering College)",
			"17. Baskar K (SA-AAFF Adithya Institute of Technology)",
			"18. T.M.Ravindhiran (SA-AAGB Surya Engineering College)",
			"19. Balasubramanian B (SA-AADX Sree Sowdambika College of Engineering)",
			"20. Prashanth (SA-AAGG Coimbatore Institute of Technology)" };

	static String myUpdate[] = {
			"1. Aakash SA-AAAI (Sri Shakthi Institute of Engineering & Technology)",
			"2. Arun Prakash S (SA-AACRK Ramakrishnan College of Technology)",
			"3. Soundharya A M (SA-AACL Jansons Institute of Technology)",
			"4. Keerthi Kumar (SA-AAAV Panimalar Engineering College)",
			"5. Abilash R (SA-AACD Bannari Amman Institute of Technology)",
			"6. R.Deepak Kumar (SA-AACV Kongu Engineering College)",
			"7. Mohammed Farook Ali I (SA-AAAB KSR College of Engineering)",
			"8. Niraj Prasad Bhatta (SA-AAFC PSNA College of Engineering and Technology)",
			"9. Toms Fernando (SA-AAAS Alpha College of Engineering)",
			"10. Dhanush Murali (SA-AADL RMK Engineering College)",
			"11. Reuben Sajith R (SA-AADE Paavai Engineering College)",
			"12. Mudapaka Sai Krishna (SA-AAFQ Sagi Ramakrishnam Raju Engineering College)",
			"13. Sanjay.T (SA-AADH PSG College of Technology)",
			"14. Yagna Sri (SA-AACO K L University)",
			"15. Divya.J (SA-AAAN KSR College of Technology)",
			"16. Ravi Motasra (SA-AAAF SA Engineering College)",
			"17. Baskar K (SA-AAFF Adithya Institute of Technology)",
			"18. T.M.Ravindhiran (SA-AAGB Surya Engineering College)",
			"19. Balasubramanian B (SA-AADX Sree Sowdambika College of Engineering)",
			"20. Prashanth (SA-AAGG Coimbatore Institute of Technology)" };
	JSONArray contacts = null;
	TextView updateText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.essaywin);

		listener = new SpeedScrollListener();
		getListView().setOnScrollListener(listener);
		updateText = (TextView) findViewById(R.id.updateText);
		animLeft = AnimationUtils.loadAnimation(getApplicationContext(),
				R.anim.left);

		// new GetContacts().execute();

		updateText.startAnimation(animLeft);
		plusAdapter = new PlusImageAdapter(getApplicationContext(), listener,
				myUpdate);
		setListAdapter(plusAdapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		boolean handled = false;
		switch (item.getItemId()) {
		case R.id.updateplus:

			// new GetContacts().execute();
			// plusAdapter = new PlusImageAdapter(getApplicationContext(),
			// listener);
			// setListAdapter(plusAdapter);
			// QuickContactFragment dialog = new QuickContactFragment();
			// dialog.show(getBaseContext(), "QuickContactFragment");
			break;

		}
		return handled;

	}

	public static class PlusImageAdapter extends GPlusListAdapter implements
			OnClickListener {

		ViewHolder holder;
		Activity activity;

		Intent callIntent = new Intent(Intent.ACTION_CALL);
		String contactname[] = { "Welcome to Kurukshetra 14 ",
				"Dallal Bull Has Started ",
				"Registration for workshop have been started ",
				"Accomadation service has started ",
				"Welcome to Kurukshetra 14 ", "Industry Relations ",
				"Hospitality ", "Media ", "Virtual Participation ", "Web ",
				"Karnival ", "Student Relations " };

		String contactnumber[] = { "8870118202", "9659382834", "9176206884",
				"9842521198", "9566607666", "8870002629", "8754534996",
				"9962288712", "8883729793", "9791793004", "8870709449",
				"9840671617" };

		JSONArray contacts = null;

		public void setHolder(int position) {
			holder.text1.setText("  " + myUpdate[position]);
		}

		private Context context;

		public void show() {
			// Toast.makeText(context, "JSR", Toast.LENGTH_LONG).show();
		}

		public PlusImageAdapter(Context context,
				SpeedScrollListener scrollListener, String str[]) {
			super(context, scrollListener, Arrays.asList(str));
			this.context = context;

		}

		@Override
		protected View getRowView(int position, View convertView,
				ViewGroup parent) {
			// new GetContacts().execute();
			// new GetContacts().execute();
			if (convertView == null) {

				convertView = LayoutInflater.from(context).inflate(
						R.layout.individualrow, parent, false);

				holder = new ViewHolder();
				// holder.image1 = (ImageView)
				// convertView.findViewById(R.id.image1);
				holder.text1 = (TextView) convertView.findViewById(R.id.text1);

				convertView.setTag(holder);
			} else
				holder = (ViewHolder) convertView.getTag();

			// imageDownloader.download(URLS[position], holder.image1,position);
			// holder.text1.setBackgroundResource(firstImage[position]);
			// holder.text1.setBackgroundResource(R.drawable.bg);
			// holder.text1.setBackgroundResource(R.drawable.bg);

			setHolder(position);

			// holder.text1.setText("  "+mystring[position]);

			// holder.image1.setBackgroundResource(R.drawable.call1);
			// holder.text1.setBackgroundResource( R.drawable.sym_action_call);

			// holder.image1.setTag(position);
			// holder.text1.setTag(position);

			return convertView;
		}

		static class ViewHolder {

			TextView text1;
		}

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub

		}

	}

	public class GetContacts extends AsyncTask<Void, Void, Void> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			// Showing progress dialog
			pDialog = new ProgressDialog(EssayWin.this);
			pDialog.setMessage("Refreshing...");
			pDialog.setCancelable(true);
			pDialog.show();

		}

		@Override
		protected Void doInBackground(Void... arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		/*
		 * @Override protected Void doInBackground(Void... arg0) {
		 * //ServiceHandler sh = new ServiceHandler();
		 * 
		 * // Making a request to url and getting response //String jsonStr =
		 * sh.makeServiceCall(url, ServiceHandler.GET);
		 * 
		 * /* Log.d("Response: ", "> " + jsonStr);
		 * 
		 * if (jsonStr != null) { try { JSONObject jsonObj = new
		 * JSONObject(jsonStr);
		 * 
		 * // Getting JSON Array node contacts =
		 * jsonObj.getJSONArray(TAG_CONTACTS);
		 * 
		 * // looping through All Contacts
		 * 
		 * runLength = contacts.length(); String[] refer = new
		 * String[runLength]; for (int i = 0; i < contacts.length(); i++) {
		 * JSONObject c = contacts.getJSONObject(i);
		 * 
		 * String id = c.getString(TAG_ID); String name = c.getString(TAG_NAME);
		 * myUpdate[i] = name; Log.d("CLICKED", "CLICKED 122" + name); //
		 * myUpdate[i]=name;
		 * 
		 * // refer[i]=mystring[i]; refer[i] = myUpdate[i];
		 * 
		 * // Phone node is JSON Object
		 * 
		 * // String mobile = phone.getString(TAG_PHONE_MOBILE); // String home
		 * = phone.getString(TAG_PHONE_HOME); // String office =
		 * phone.getString(TAG_PHONE_OFFICE);
		 * 
		 * // tmp hashmap for single contact // HashMap<String, String> contact
		 * = new HashMap<String, // String>();
		 * 
		 * // adding each child node to HashMap key => value //
		 * contact.put(TAG_ID, id); // contact.put(TAG_NAME, name);
		 * 
		 * // adding contact to contact list
		 * 
		 * } } catch (JSONException e) { e.printStackTrace(); } } else {
		 * Log.e("ServiceHandler", "Couldn't get any data from the url"); }
		 * 
		 * return null; }
		 * 
		 * @Override protected void onPostExecute(Void result) {
		 * super.onPostExecute(result); if (pDialog.isShowing())
		 * pDialog.dismiss(); String refer1[] = new String[runLength - 1];
		 * 
		 * plusAdapter = new PlusImageAdapter(getApplicationContext(), listener,
		 * refer1); setListAdapter(plusAdapter); // Dismiss the progress dialog
		 */

		// Toast.makeText(context,"Updating",Toast.LENGTH_SHORT).show();

	}

}
