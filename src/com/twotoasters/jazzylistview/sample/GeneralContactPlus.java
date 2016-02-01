package com.twotoasters.jazzylistview.sample;

import android.app.Activity;

import in.org.kurukshetra.app.R;
import java.util.Arrays;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cuubonandroid.sugaredlistanimations.GPlusListAdapter;
import com.cuubonandroid.sugaredlistanimations.SpeedScrollListener;

public class GeneralContactPlus extends GPlusListAdapter implements
		OnClickListener {

	ViewHolder holder;
	Activity activity;
	Intent callIntent = new Intent(Intent.ACTION_CALL);
	String contactname[] = { "Queries & Info ", "Events ", "Workshops ",
			"Guest Lectures ", "Xceed ", "Industry Relations ", "Hospitality ",
			"Media ", "Virtual Participation ", "Web ", "Karnival ",
			"Student Relations " };

	String contactnumber[] = { "8870118202", "9659382834", "9176206884",
			"9842521198", "9566607666", "8870002629", "8754534996",
			"9962288712", "8883729793", "9791793004", "8870709449",
			"9840671617" };

	private static final String[] URLS = {
			"http://lh5.ggpht.com/_mrb7w4gF8Ds/TCpetKSqM1I/AAAAAAAAD2c/Qef6Gsqf12Y/s144-c/_DSC4374%20copy.jpg",
			"http://lh5.ggpht.com/_Z6tbBnE-swM/TB0CryLkiLI/AAAAAAAAVSo/n6B78hsDUz4/s144-c/_DSC3454.jpg",
			"http://lh3.ggpht.com/_GEnSvSHk4iE/TDSfmyCfn0I/AAAAAAAAF8Y/cqmhEoxbwys/s144-c/_MG_3675.jpg",
			"http://lh5.ggpht.com/_mrb7w4gF8Ds/TCpetKSqM1I/AAAAAAAAD2c/Qef6Gsqf12Y/s144-c/_DSC4374%20copy.jpg",
			"http://lh5.ggpht.com/_Z6tbBnE-swM/TB0CryLkiLI/AAAAAAAAVSo/n6B78hsDUz4/s144-c/_DSC3454.jpg",
			"http://lh3.ggpht.com/_GEnSvSHk4iE/TDSfmyCfn0I/AAAAAAAAF8Y/cqmhEoxbwys/s144-c/_MG_3675.jpg",
			"http://lh5.ggpht.com/_mrb7w4gF8Ds/TCpetKSqM1I/AAAAAAAAD2c/Qef6Gsqf12Y/s144-c/_DSC4374%20copy.jpg",
			"http://lh5.ggpht.com/_Z6tbBnE-swM/TB0CryLkiLI/AAAAAAAAVSo/n6B78hsDUz4/s144-c/_DSC3454.jpg",
			"http://lh3.ggpht.com/_GEnSvSHk4iE/TDSfmyCfn0I/AAAAAAAAF8Y/cqmhEoxbwys/s144-c/_MG_3675.jpg",
			"http://lh5.ggpht.com/_mrb7w4gF8Ds/TCpetKSqM1I/AAAAAAAAD2c/Qef6Gsqf12Y/s144-c/_DSC4374%20copy.jpg",
			"http://lh5.ggpht.com/_Z6tbBnE-swM/TB0CryLkiLI/AAAAAAAAVSo/n6B78hsDUz4/s144-c/_DSC3454.jpg",
			"http://lh3.ggpht.com/_GEnSvSHk4iE/TDSfmyCfn0I/AAAAAAAAF8Y/cqmhEoxbwys/s144-c/_MG_3675.jpg"

	};
	private Context context;

	public void show() {
		// Toast.makeText(context, "JSR", Toast.LENGTH_LONG).show();
	}

	public GeneralContactPlus(Context context,
			SpeedScrollListener scrollListener) {
		super(context, scrollListener, Arrays.asList(URLS));
		this.context = context;
	}

	@Override
	protected View getRowView(int position, View convertView, ViewGroup parent) {

		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.generalcontact, parent, false);

			holder = new ViewHolder();
			holder.image1 = (ImageView) convertView.findViewById(R.id.image1);
			holder.text1 = (TextView) convertView.findViewById(R.id.text1);

			convertView.setTag(holder);
		} else
			holder = (ViewHolder) convertView.getTag();

		// imageDownloader.download(URLS[position], holder.image1,position);
		// holder.text1.setBackgroundResource(firstImage[position]);
		// holder.text1.setBackgroundResource(R.drawable.bg);
		holder.text1.setBackgroundResource(R.drawable.bg);

		holder.text1.setText("  " + contactname[position]
				+ "\n\n               " + contactnumber[position]);
		holder.image1.setBackgroundResource(R.drawable.call1);
		// holder.text1.setBackgroundResource( R.drawable.sym_action_call);

		holder.image1.setTag(position);
		// holder.text1.setTag(position);

		final OnClickListener makeListener1 = new OnClickListener() {
			@Override
			public void onClick(View v) {
				LinearLayout ll = (LinearLayout) v.getParent();
				ImageView tv = (ImageView) ll.getChildAt(1);
				Integer pos = (Integer) tv.getTag();
				// main.show(pos);

				// show(pos);
				// Toast.makeText(context, "First + Pos : "+pos,
				// Toast.LENGTH_LONG).show();
				// callIntent.setData(Uri.parse("tel:7654644564"));
				// context.startActivity(callIntent);
				Intent intent = new Intent(Intent.ACTION_CALL);
				intent.setData(Uri.fromParts("tel", contactnumber[pos],
						contactnumber[pos]));// Number is string variable..
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				context.startActivity(intent);
			}
		};
		holder.image1.setOnClickListener(makeListener1);

		return convertView;
	}

	static class ViewHolder {
		ImageView image1;
		TextView text1;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

}
