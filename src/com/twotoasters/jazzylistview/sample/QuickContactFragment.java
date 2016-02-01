package com.twotoasters.jazzylistview.sample;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.astuetz.viewpager.extensions.PagerSlidingTabStrip;
import com.astuetz.viewpager.extensions.PagerSlidingTabStrip.IconTabProvider;
import in.org.kurukshetra.app.R;

public class QuickContactFragment extends DialogFragment {

	private PagerSlidingTabStrip tabs;
	private ViewPager pager;
	private ContactPagerAdapter adapter;
	private String contact = "";
	private int MyPosition = 0;

	public static QuickContactFragment newInstance() {
		QuickContactFragment f = new QuickContactFragment();
		return f;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		if (getDialog() != null) {
			getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
			getDialog().getWindow().setBackgroundDrawableResource(
					android.R.color.transparent);
		}

		View root = inflater.inflate(R.layout.fragment_quick_contact,
				container, false);

		tabs = (PagerSlidingTabStrip) root.findViewById(R.id.tabs);
		pager = (ViewPager) root.findViewById(R.id.pager);
		adapter = new ContactPagerAdapter();

		pager.setAdapter(adapter);

		tabs.setViewPager(pager);

		return root;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onStart() {
		super.onStart();

		// change dialog width
		if (getDialog() != null) {

			int fullWidth = getDialog().getWindow().getAttributes().width;

			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
				Display display = getActivity().getWindowManager()
						.getDefaultDisplay();
				Point size = new Point();
				display.getSize(size);
				fullWidth = size.x;
			} else {
				Display display = getActivity().getWindowManager()
						.getDefaultDisplay();
				fullWidth = display.getWidth();
			}

			final int padding = (int) TypedValue.applyDimension(
					TypedValue.COMPLEX_UNIT_DIP, 24, getResources()
							.getDisplayMetrics());

			int w = fullWidth - padding;
			int h = getDialog().getWindow().getAttributes().height;

			getDialog().getWindow().setLayout(w, h);
		}
	}

	public class ContactPagerAdapter extends PagerAdapter implements
			IconTabProvider {

		private final int[] ICONS = { R.drawable.ic_launcher_gmail,
				R.drawable.fb1, R.drawable.conref1 };
		private final String nameIt[] = { "Mail Your Queries",
				"Follow us on Fb", "Make a Call to K Team" };
		private final String uniqueId[] = { "1", "2", "3" };

		public ContactPagerAdapter() {
			super();
		}

		@Override
		public int getCount() {
			return ICONS.length;
		}

		@Override
		public int getPageIconResId(int position) {

			return ICONS[position];
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			// looks a little bit messy here

			LayoutInflater inflater = (LayoutInflater) container.getContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			int resId = R.layout.quickcontactceg;
			long con;

			View view = inflater.inflate(resId, null);
			RelativeLayout rlContact = (RelativeLayout) view
					.findViewById(R.id.rlContactPage1);
			TextView name = (TextView) view.findViewById(R.id.tvName);
			// TextView number = (TextView) view.findViewById(R.id.tvNumber);
			ImageView leftImage = (ImageView) view
					.findViewById(R.id.list_image1);
			ImageView rightImage = (ImageView) view
					.findViewById(R.id.rightImage);
			// leftImage.setBackgroundResource(R.drawable.about);
			rightImage.setBackgroundResource(ICONS[position]);
			name.setText(nameIt[position]);
			// MyPosition=position;
			// number.setText("9865238011");
			contact = uniqueId[position];
			rlContact.setOnClickListener(getOnClickDoSomething(rlContact,
					contact));
			((ViewPager) container).addView(view, 0);
			MyPosition = position;

			return view;

			/*
			 * TextView v = new TextView(getActivity());
			 * v.setBackgroundResource(R.color.background_window);
			 * v.setText("PAGE " + (position + 1)); final int padding = (int)
			 * TypedValue.applyDimension( TypedValue.COMPLEX_UNIT_DIP, 16,
			 * getResources() .getDisplayMetrics()); v.setPadding(padding,
			 * padding, padding, padding); v.setGravity(Gravity.CENTER);
			 * container.addView(v, 0);
			 */

		}

		View.OnClickListener getOnClickDoSomething(final RelativeLayout b,
				final String contact) {
			return new View.OnClickListener() {
				@Override
				public void onClick(View v) {

					switch (v.getId()) {
					case R.id.rlContactPage1:
						if (contact.equals("1")) {
							Intent i1 = new Intent(Intent.ACTION_SEND);

							i1.setType("message/rfc822");
							i1.putExtra(Intent.EXTRA_EMAIL,
									new String[] { "qms@kurukshetra.org.in" });
							i1.putExtra(Intent.EXTRA_SUBJECT,
									"Feedback for Kurukshetra '14");
							i1.putExtra(Intent.EXTRA_TEXT, "hello there ");
							try {
								startActivity(Intent.createChooser(i1,
										"Send mail..."));
							} catch (ActivityNotFoundException ex) {
								Toast.makeText(
										getActivity(),
										"There are no email clients installed.",
										Toast.LENGTH_SHORT).show();
							}
							Toast.makeText(v.getContext(),
									"Sending your feedback", Toast.LENGTH_SHORT)
									.show();
						} else if (contact.equals("2")) {
							Intent in = new Intent(
									Intent.ACTION_VIEW,
									Uri.parse("https://www.facebook.com/kurukshetra.org.in?ref=br_tf"));
							startActivity(in);
						} else if (contact.equals("3")) {
							Intent mainIntent = new Intent(Intent.ACTION_DIAL);
							String num = "tel:";

							mainIntent
									.setData(Uri.parse("tel:" + "8870118202"));
							startActivity(mainIntent);
						}

						break;
					}
				}
			};
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object view) {
			container.removeView((View) view);

		}

		@Override
		public boolean isViewFromObject(View v, Object o) {
			return v == ((View) o);
		}

	}

}
