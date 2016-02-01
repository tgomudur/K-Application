package com.twotoasters.jazzylistview.sample;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import in.org.kurukshetra.app.R;

public class ContactPage extends Activity {

	ImageButton call1, call2, call3, call4, call5, call6, call7, call8, call9,
			call10, call11, call12;
	Intent callIntent = new Intent(Intent.ACTION_CALL);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contactpage);
		call1 = (ImageButton) findViewById(R.id.call1);
		call2 = (ImageButton) findViewById(R.id.call2);
		call3 = (ImageButton) findViewById(R.id.call3);
		call4 = (ImageButton) findViewById(R.id.call4);
		call5 = (ImageButton) findViewById(R.id.call5);
		call6 = (ImageButton) findViewById(R.id.call6);
		call7 = (ImageButton) findViewById(R.id.call7);
		call8 = (ImageButton) findViewById(R.id.call8);
		call9 = (ImageButton) findViewById(R.id.call9);
		call10 = (ImageButton) findViewById(R.id.call10);
		call11 = (ImageButton) findViewById(R.id.call11);
		call12 = (ImageButton) findViewById(R.id.call12);

		call1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				callIntent.setData(Uri.parse("tel:8870118202"));
				startActivity(callIntent);
			}
		});
		call2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				callIntent.setData(Uri.parse("tel:9659382834"));
				startActivity(callIntent);
			}
		});
		call3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				callIntent.setData(Uri.parse("tel:9176206884"));
				startActivity(callIntent);
			}
		});
		call4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				callIntent.setData(Uri.parse("tel:9842521198"));
				startActivity(callIntent);
			}
		});
		call5.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				callIntent.setData(Uri.parse("tel:9566607666"));
				startActivity(callIntent);
			}
		});
		call6.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				callIntent.setData(Uri.parse("tel:8870002629"));
				startActivity(callIntent);
			}
		});
		call7.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				callIntent.setData(Uri.parse("tel:8754534996"));
				startActivity(callIntent);
			}
		});
		call8.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				callIntent.setData(Uri.parse("tel:9962288712"));
				startActivity(callIntent);
			}
		});
		call9.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				callIntent.setData(Uri.parse("tel:8883729793"));
				startActivity(callIntent);
			}
		});

		call10.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				callIntent.setData(Uri.parse("tel:9791793004"));
				startActivity(callIntent);
			}
		});
		call11.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				callIntent.setData(Uri.parse("tel:8870709449"));
				startActivity(callIntent);
			}
		});

		call12.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				callIntent.setData(Uri.parse("tel:9840671617"));
				startActivity(callIntent);

			}
		});

	}
}
