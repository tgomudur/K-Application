/*
 * Copyright (C) 2013 Andreas Stuetz <andreas.stuetz@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.twotoasters.jazzylistview.about;

import com.fourmob.panningview.PanningView;
import in.org.kurukshetra.app.R;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.Bitmap.Config;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SuperAwesomeCardFragmentold extends Fragment {

	private static final String ARG_POSITION = "position";

	private int position;
	private int i[] = { R.drawable.klogo, R.drawable.klogo };
	ImageView iv, iv1, iv2, iv3;

	public static SuperAwesomeCardFragmentold newInstance(int position) {
		SuperAwesomeCardFragmentold f = new SuperAwesomeCardFragmentold();
		Bundle b = new Bundle();
		b.putInt(ARG_POSITION, position);
		f.setArguments(b);
		return f;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		position = getArguments().getInt(ARG_POSITION);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View V = null;

		switch (position) {
		case 0:
			V = setfirstpage(inflater, container, savedInstanceState);
			break;
		case 1:
			V = seteventpage(inflater, container, savedInstanceState);
			break;
		case 2:
			V = setworkshoppage(inflater, container, savedInstanceState);
			break;
		case 3:
			V = setexhibitionpage(inflater, container, savedInstanceState);
			break;
		case 4:
			V = setlecturepage(inflater, container, savedInstanceState);
			break;
		case 5:
			V = setlikepage(inflater, container, savedInstanceState);
			break;

		}

		return V;

		/*
		 * TextView v = new TextView(getActivity()); params.setMargins(margin,
		 * margin, margin, margin); v.setLayoutParams(params);
		 * v.setLayoutParams(params); v.setGravity(Gravity.CENTER);
		 * v.setBackgroundResource(R.drawable.background_card);
		 * v.setText("CARD " + (position + 1));
		 * 
		 * fl.addView(v); return fl;
		 */
	}

	private View setfirstpage(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View V;
		V = inflater.inflate(R.layout.about, container, false);
		final PanningView panningView1 = (PanningView) V
				.findViewById(R.id.panningView1);
		iv = (ImageView) V.findViewById(R.id.ivKabout);
		TextView Desctn = (TextView) V.findViewById(R.id.tvDesc);

		// ImageView iv1 = (ImageView) V.findViewById(R.id.iv1);
		// ImageView iv2 = (ImageView) V.findViewById(R.id.iv2);
		// ImageView iv3 = (ImageView) V.findViewById(R.id.iv3);

		// iv1.setImageBitmap(getRoundedCornerBitmap(img1));
		// iv1.setAlpha(0.0f);
		// iv3.setAlpha(0.0f);
		// TextView Desctn = (TextView) V.findViewById(R.id.tvDesc);
		TextView Desctn1 = (TextView) V.findViewById(R.id.tvDesc3);
		Typeface font = Typeface.createFromAsset(getActivity().getAssets(),
				"Walkway_Bold.ttf");
		Typeface font1 = Typeface.createFromAsset(getActivity().getAssets(),
				"Walkway_Black.ttf");
		Desctn.setTypeface(font1);
		Desctn.setText("BIGGEST BATTLE OF BRAINS");
		Desctn1.setText("Swipe -->");
		Desctn1.setTypeface(font);
		iv.setImageResource(R.drawable.klogo);

		panningView1.setImageResource(R.drawable.xmen);

		panningView1.startPanning();
		return V;
	}

	private View seteventpage(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View V;
		V = inflater.inflate(R.layout.testabout, container, false);
		final PanningView panningView = (PanningView) V
				.findViewById(R.id.panningView);
		Typeface font = Typeface.createFromAsset(getActivity().getAssets(),
				"Walkway_Bold.ttf");
		Typeface font1 = Typeface.createFromAsset(getActivity().getAssets(),
				"Walkway_Black.ttf");
		iv1 = (ImageView) V.findViewById(R.id.iv1);
		iv2 = (ImageView) V.findViewById(R.id.iv2);
		iv3 = (ImageView) V.findViewById(R.id.iv3);

		// iv1.setImageBitmap(getRoundedCornerBitmap(img1));
		iv1.setImageResource(R.drawable.star);
		iv2.setImageResource(R.drawable.target);
		// iv2.setImageBitmap(getRoundedCornerBitmap(img2));
		iv3.setImageResource(R.drawable.trophy);

		TextView Desctn = (TextView) V.findViewById(R.id.tvDesc1);
		TextView Desctn1 = (TextView) V.findViewById(R.id.tvDesc2);
		Desctn.setTypeface(font1);
		Desctn1.setTypeface(font);
		Desctn.setText("EVENTS");
		Desctn1.setText("Where Creativity Meets Technology");

		TextView Desctnrefer = (TextView) V.findViewById(R.id.tvDescref);
		Desctnrefer.setTypeface(font);

		panningView.setImageResource(R.drawable.iron);

		panningView.startPanning();
		return V;
	}

	private View setworkshoppage(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View V;
		V = inflater.inflate(R.layout.testabout, container, false);
		final PanningView panningView = (PanningView) V
				.findViewById(R.id.panningView);
		Typeface font = Typeface.createFromAsset(getActivity().getAssets(),
				"Walkway_Bold.ttf");
		Typeface font1 = Typeface.createFromAsset(getActivity().getAssets(),
				"Walkway_Black.ttf");
		ImageView iv1 = (ImageView) V.findViewById(R.id.iv1);
		ImageView iv2 = (ImageView) V.findViewById(R.id.iv2);
		ImageView iv3 = (ImageView) V.findViewById(R.id.iv3);
		TextView Desctn = (TextView) V.findViewById(R.id.tvDesc1);
		TextView Desctn1 = (TextView) V.findViewById(R.id.tvDesc2);
		Desctn.setTypeface(font1);
		Desctn1.setTypeface(font);

		TextView Desctnrefer = (TextView) V.findViewById(R.id.tvDescref);
		Desctnrefer.setTypeface(font);

		panningView.setImageResource(R.drawable.purple);
		panningView.startPanning();
		return V;
	}

	private View setexhibitionpage(LayoutInflater inflater,
			ViewGroup container, Bundle savedInstanceState) {
		View V;
		V = inflater.inflate(R.layout.testabout, container, false);
		final PanningView panningView = (PanningView) V
				.findViewById(R.id.panningView);
		Typeface font = Typeface.createFromAsset(getActivity().getAssets(),
				"Walkway_Bold.ttf");
		Typeface font1 = Typeface.createFromAsset(getActivity().getAssets(),
				"Walkway_Black.ttf");
		iv1 = (ImageView) V.findViewById(R.id.iv1);
		iv2 = (ImageView) V.findViewById(R.id.iv2);
		iv3 = (ImageView) V.findViewById(R.id.iv3);
		TextView Desctn = (TextView) V.findViewById(R.id.tvDesc1);
		TextView Desctn1 = (TextView) V.findViewById(R.id.tvDesc2);
		Desctn.setTypeface(font1);
		Desctn1.setTypeface(font);
		iv1.setImageResource(R.drawable.rocket);
		iv2.setImageResource(R.drawable.brightness);
		iv3.setImageResource(R.drawable.dev);
		Desctn.setText("EXHIBITIONS");
		Desctn1.setText("The window to science and development");

		TextView Desctnrefer = (TextView) V.findViewById(R.id.tvDescref);
		Desctnrefer.setTypeface(font);

		panningView.setImageResource(R.drawable.hulk);
		panningView.startPanning();
		return V;
	}

	private View setlecturepage(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View V;
		V = inflater.inflate(R.layout.testabout, container, false);
		final PanningView panningView = (PanningView) V
				.findViewById(R.id.panningView);
		Typeface font = Typeface.createFromAsset(getActivity().getAssets(),
				"Walkway_Bold.ttf");
		Typeface font1 = Typeface.createFromAsset(getActivity().getAssets(),
				"Walkway_Black.ttf");
		iv1 = (ImageView) V.findViewById(R.id.iv1);
		iv2 = (ImageView) V.findViewById(R.id.iv2);
		iv3 = (ImageView) V.findViewById(R.id.iv3);
		TextView Desctn = (TextView) V.findViewById(R.id.tvDesc1);
		TextView Desctn1 = (TextView) V.findViewById(R.id.tvDesc2);
		Desctn.setTypeface(font1);
		Desctn1.setTypeface(font);
		iv1.setImageResource(R.drawable.easel);
		iv2.setImageResource(R.drawable.microphone);
		iv3.setImageResource(R.drawable.trends);
		Desctn.setText("GUEST LECTURES");
		Desctn1.setText("From the brightest minds of the century");

		TextView Desctnrefer = (TextView) V.findViewById(R.id.tvDescref);
		Desctnrefer.setTypeface(font);

		panningView.setImageResource(R.drawable.blue);
		panningView.startPanning();

		return V;
	}

	private View setlikepage(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View V;
		V = inflater.inflate(R.layout.testabout1, container, false);
		final PanningView panningView = (PanningView) V
				.findViewById(R.id.panningView);
		Typeface font = Typeface.createFromAsset(getActivity().getAssets(),
				"Walkway_Bold.ttf");
		Typeface font1 = Typeface.createFromAsset(getActivity().getAssets(),
				"Walkway_Black.ttf");
		Typeface font2 = Typeface.createFromAsset(getActivity().getAssets(),
				"gabo.otf");

		iv1 = (ImageView) V.findViewById(R.id.iv1);
		iv2 = (ImageView) V.findViewById(R.id.iv2);
		iv3 = (ImageView) V.findViewById(R.id.iv3);
		iv1.setClickable(true);
		iv2.setClickable(true);
		iv3.setClickable(true);

		TextView Desctn = (TextView) V.findViewById(R.id.tvDesc1);
		TextView Desctn1 = (TextView) V.findViewById(R.id.tvDesc2);
		TextView devHead = (TextView) V.findViewById(R.id.tvDev);
		TextView dev = (TextView) V.findViewById(R.id.tvDevTharun);
		TextView dev1 = (TextView) V.findViewById(R.id.tvDevKarthi);
		TextView proceed = (TextView) V.findViewById(R.id.tvProceed);
		Desctn.setTypeface(font1);
		Desctn1.setTypeface(font);
		devHead.setTypeface(font1);
		proceed.setTypeface(font2);
		dev.setTypeface(font);
		dev1.setTypeface(font);
		proceed.setTypeface(font2);
		iv1.setImageResource(R.drawable.fb);

		Bitmap kcircle = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.ka);
		iv2.setImageBitmap(getRoundedCornerBitmap(kcircle));
		// iv2.setImageBitmap(getRoundedCornerBitmap(c));
		// iv2.setBackgroundResource(R.drawable.cyclotron);

		// iv2.setImageResource(R.drawable.gmail);
		iv3.setImageResource(R.drawable.twit);
		Desctn.setText("What are you waiting for?");
		Desctn1.setText("Go Ahead and Explore!!!");

		ImageButton ibsend = (ImageButton) V.findViewById(R.id.ibSend);
		// ibsend.setClickable(true);
		/*
		 * ibsend.setOnClickListener((OnClickListener) V.getContext());
		 * iv1.setOnClickListener((OnClickListener) V.getContext());
		 * iv2.setOnClickListener((OnClickListener) V.getContext());
		 * iv3.setOnClickListener((OnClickListener) V.getContext());
		 */
		panningView.setImageResource(R.drawable.red);
		panningView.startPanning();

		return V;
	}

	public static Bitmap getRoundedCornerBitmap(Bitmap bitmap) {
		Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
				bitmap.getHeight(), Config.ARGB_8888);
		Canvas canvas = new Canvas(output);

		final int color = 0xff424242;
		final Paint paint = new Paint();
		final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
		final RectF rectF = new RectF(rect);
		final float roundPx = bitmap.getWidth();

		paint.setAntiAlias(true);
		canvas.drawARGB(0, 0, 0, 0);
		paint.setColor(color);
		canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
		canvas.drawBitmap(bitmap, rect, rect, paint);

		return output;
	}

	public void onImageClicked(View v) {
		switch (v.getId()) {
		case R.id.iv1:
			Toast.makeText(v.getContext(), "Like us on facebook page",
					Toast.LENGTH_SHORT).show();
			break;
		case R.id.iv2:
			Toast.makeText(v.getContext(), "Redirecting to Kurukshetra page",
					Toast.LENGTH_SHORT).show();
			break;
		case R.id.iv3:
			Toast.makeText(v.getContext(), "Follow us on Twitter page",
					Toast.LENGTH_SHORT).show();
			break;
		case R.id.ibSend:
			Toast.makeText(v.getContext(), "Sending your feedback",
					Toast.LENGTH_SHORT).show();
			break;
		}
	}
}
