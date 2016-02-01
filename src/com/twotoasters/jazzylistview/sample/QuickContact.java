package com.twotoasters.jazzylistview.sample;

import android.annotation.SuppressLint;
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

import android.widget.RelativeLayout;
import android.widget.TextView;
import com.astuetz.viewpager.extensions.PagerSlidingTabStrip;
import com.astuetz.viewpager.extensions.PagerSlidingTabStrip.IconTabProvider;
import in.org.kurukshetra.app.R;

@SuppressLint("ValidFragment")
public class QuickContact extends DialogFragment {

	private PagerSlidingTabStrip tabs;
	private ViewPager pager;
	private ContactPagerAdapter adapter;
	public String contact = "";
	public static String contactrefer = "";
	public static String contactName = "Old";
	public static String contactNumber = "Old";
	public static String putName[] = new String[10];
	public static String putNumber[] = new String[10];

	public QuickContact(String con_name, String con_number) {
		// TODO Auto-generated constructor stub
		contactName = con_name;
		contactNumber = con_number;
	}

	@SuppressLint("ValidFragment")
	public static QuickContact newInstance(String con_name, String con_num) {
		QuickContact f = new QuickContact(con_name, con_num);
		contactName = con_name;
		contactNumber = con_num;
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

		// private final int[] ICONS = { R.drawable.ic_launcher_gplus,
		// R.drawable.ic_launcher_gmail, R.drawable.ic_launcher_gmaps,
		// R.drawable.ic_launcher_chrome };
		private final int[] ICONS = { R.drawable.profle,

		R.drawable.profle };

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
			int resId = R.layout.quickcontact;
			long con;

			// View V = inflater.inflate(R.layout.singleevent, container,
			// false);
			/*
			 * TextView v = new TextView(getActivity());
			 * v.setBackgroundResource(R.color.background_window);
			 * v.setText("PAGE " + (position + 1)); final int padding = (int)
			 * TypedValue.applyDimension( TypedValue.COMPLEX_UNIT_DIP, 16,
			 * getResources() .getDisplayMetrics()); v.setPadding(padding,
			 * padding, padding, padding); v.setGravity(Gravity.CENTER);
			 * container.addView(v, 0); return v;
			 */

			View view = inflater.inflate(resId, null);
			RelativeLayout rlContact = (RelativeLayout) view
					.findViewById(R.id.rlContactPage1);
			TextView name = (TextView) view.findViewById(R.id.tvName);
			TextView number = (TextView) view.findViewById(R.id.tvNumber);

			// String name1[]={"Tharun"," Karthi"};
			// String number1[]={"9445426880","1234567890"};

			putName = contactName.split("\\*");
			putNumber = contactNumber.split("\\*");

			switch (position) {
			case 0:
				resId = R.layout.quickcontact;
				name.setText(putName[position]);
				number.setText(putNumber[position]);
				contact = putNumber[position];
				// Toast.makeText(getActivity(),"Ref : "+contactName+" "+contactNumber,Toast.LENGTH_SHORT).show();
				break;
			case 1:
				resId = R.layout.quickcontact;
				name.setText(putName[position]);
				number.setText(putNumber[position]);
				contact = putNumber[position];
				break;
			}

			rlContact.setOnClickListener(getOnClickDoSomething(rlContact,
					contact));
			((ViewPager) container).addView(view, 0);

			return view;

		}

		View.OnClickListener getOnClickDoSomething(final RelativeLayout b,
				final String contact) {
			return new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					switch (v.getId()) {
					case R.id.rlContactPage1:
						Intent mainIntent = new Intent(Intent.ACTION_DIAL);
						String num = "tel:";

						mainIntent.setData(Uri.parse("tel:" + contact));
						startActivity(mainIntent);

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
