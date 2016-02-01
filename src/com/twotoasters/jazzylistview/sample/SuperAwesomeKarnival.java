package com.twotoasters.jazzylistview.sample;

import in.org.kurukshetra.app.R;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.content.Intent;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

//import com.actionbarsherlock.app.SherlockFragment;

public class SuperAwesomeKarnival extends Fragment implements
		View.OnClickListener {

	private static final String ARG_POSITION = "position";

	private int position, i;

	private Animation fromRight;

	private int[] images = { R.drawable.ace, R.drawable.ars,
			R.drawable.helpline, R.drawable.inceg, R.drawable.nomad,
			R.drawable.sewebot, R.drawable.baker1, R.drawable.livecoding1,
			R.drawable.texas1, R.drawable.nugen1, R.drawable.mobileapp1 };
	String[] maindescription = new String[50];
	String[] quotedescription = new String[50];
	String name[] = new String[50];
	String mobnumber[] = new String[50];
	String putName[] = new String[50];
	String putNumber[] = new String[50];
	String QLinks[] = { "3DPRINTING", "JOURNALISM", "FACEBOT", "BLUEBOT",
			"VENTURE", "KRITHI", "BAKER", "LIVECODING", "C2000", "NUGEN",
			"MOBAPPS" };
	String myQuicklink = "#";

	public void putvalue() {
		try {
			XmlResourceParser xpp = getResources().getXml(
					R.xml.karnivaldescription);

			xpp.next();
			int eventType = xpp.getEventType();
			int iter = 0;
			String elemtext = null;

			while (eventType != XmlPullParser.END_DOCUMENT) {

				if (eventType == XmlPullParser.START_TAG) {

					String elemName = xpp.getName();
					if (elemName.equals("article")) {
						iter = iter + 1;
					}

					if (elemName.equals("details")) {
						elemtext = "details";
					}
					if (elemName.equals("quotes")) {
						elemtext = "quotes";
					}
					if (elemName.equals("name")) {
						elemtext = "name";
					}
					if (elemName.equals("mobilenumber")) {
						elemtext = "mobilenumber";
					}

				}

				if (eventType == XmlPullParser.TEXT) {
					for (i = 0; i < 7; i++) {
						if (iter == i) {
							if (elemtext.equals("details")) {
								maindescription[i] = xpp.getText();
							}

							if (elemtext.equals("name")) {
								name[i] = xpp.getText();
							}

							if (elemtext.equals("mobilenumber")) {
								mobnumber[i] = xpp.getText();
							}

						}

					}
				}
				eventType = xpp.next();
			}

		} catch (XmlPullParserException e) {
		} catch (IOException e) {
		}
	}

	public static SuperAwesomeKarnival newInstance(int position) {
		SuperAwesomeKarnival f = new SuperAwesomeKarnival();
		Bundle b = new Bundle();
		b.putInt(ARG_POSITION, position);
		f.setArguments(b);
		return f;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		position = getArguments().getInt(ARG_POSITION);
		putvalue();
		fromRight = AnimationUtils.loadAnimation(getActivity(),

		R.anim.right);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View V = inflater.inflate(R.layout.singleeventkarnival, container,
				false);
		ImageView iv = (ImageView) V.findViewById(R.id.ivHeader);

		TextView BriefDesctn = (TextView) V.findViewById(R.id.briefdescription);
		TextView artistName = (TextView) V.findViewById(R.id.artist);
		// Desctn.setText("JSR KURUKSHETRA ! ! !");

		// Static Reference

		// Desctn.setText("It is better to create than to learn! Creating is the essence of life\n                         -Julius Caesar");
		// Desctn.setText(quotedescription[position + 1]);
		BriefDesctn.setText(maindescription[position + 1]);
		// Static Reference
		// ImageView iv=(ImageView) getView().findViewById(R.id.ivHeader);
		// ImageView iv=(ImageView) inflater.inflate(R.layout.singleevent,
		// null);
		iv.setImageResource(images[position]);
		putName = name[position + 1].split("\\*");
		putNumber = mobnumber[position + 1].split("\\*");
		artistName.setText(putName[0] + " : " + putNumber[0]);
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
		// get the button view
		RelativeLayout rlContact = (RelativeLayout) getView().findViewById(
				R.id.rlcontact);
		RelativeLayout rlMaps = (RelativeLayout) getView().findViewById(
				R.id.rlmaps);

		// set a onclick listener for when the button gets clicked
		rlContact.setOnClickListener(this);
		rlMaps.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v.getId() == R.id.rlcontact) {
			/*
			 * Intent mainIntent = new Intent(Intent.ACTION_DIAL);
			 * mainIntent.setData(Uri.parse("tel:9445426880"));
			 * startActivity(mainIntent);
			 */
			name[position + 1].trim();
			mobnumber[position + 1].trim();
			QuickContact dialog = new QuickContact(name[position + 1],
					mobnumber[position + 1]);
			dialog.show(getFragmentManager(), "QuickContactFragment");
		} else if (v.getId() == R.id.rlmaps) {
			/*
			 * Intent myIntent = new Intent(this.getActivity(),
			 * NavigationView.class);
			 */
			Intent myIntent = new Intent(this.getActivity(), LocateMe.class);
			this.getActivity().startActivity(myIntent);
			/*
			 * Intent mainIntent = new Intent(Intent.ACTION_DIAL);
			 * mainIntent.setData(Uri.parse("tel:9445426880"));
			 * startActivity(mainIntent);
			 */
		} /*
		 * else if (v.getId() == R.id.rlReminder) {
		 * 
		 * final Dialog dialog = new Dialog(getActivity(), R.style.PauseDialog);
		 * dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		 * dialog.setTitle("Notice ! ! !");
		 * dialog.getWindow().setBackgroundDrawable( new
		 * ColorDrawable(android.graphics.Color.TRANSPARENT));
		 * 
		 * dialog.setCancelable(true);
		 * 
		 * dialog.setContentView(R.layout.dialogue_clock);
		 * 
		 * Button okiebtn = (Button) dialog.findViewById(R.id.okie);
		 * okiebtn.setOnClickListener(new View.OnClickListener() {
		 * 
		 * @Override public void onClick(View View3) { dialog.dismiss(); } });
		 * dialog.show(); } else if (v.getId() == R.id.checkBox1) {
		 * 
		 * final Dialog dialog = new Dialog(getActivity(), R.style.PauseDialog);
		 * dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		 * dialog.setTitle("Notice ! ! !");
		 * dialog.getWindow().setBackgroundDrawable( new
		 * ColorDrawable(android.graphics.Color.TRANSPARENT));
		 * 
		 * dialog.setCancelable(true);
		 * 
		 * dialog.setContentView(R.layout.dialogue_clock);
		 * 
		 * final Button okiebtn = (Button) dialog.findViewById(R.id.okie);
		 * okiebtn.setOnClickListener(new View.OnClickListener() {
		 * 
		 * @Override public void onClick(View View3) { dialog.dismiss();
		 * 
		 * } });
		 * 
		 * dialog.show(); okiebtn.startAnimation(fromRight); }
		 */

	}

}
