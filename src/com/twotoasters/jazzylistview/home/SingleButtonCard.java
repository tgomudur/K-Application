package com.twotoasters.jazzylistview.home;

import com.twotoasters.jazzylistview.about.AboutUs;
import in.org.kurukshetra.app.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.view.CardView;

public class SingleButtonCard extends Card implements View.OnClickListener {

	public SingleButtonCard(Context context) {
		this(context, R.layout.singlebuttoninner);
	}

	public SingleButtonCard(Context context, int innerLayout) {
		super(context, innerLayout);
		init();
	}

	private void init() {
		// Add Header
		CardHeader header = new SingleButtonCardHeader(getContext(),
				R.layout.dummy);
		header.setTitle("");
		addCardHeader(header);
		setShadow(false);

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
				// Do something
			}
		};

		addPartialOnClickListener(Card.CLICK_LISTENER_CONTENT_VIEW,
				clickListener);
	}

	@Override
	public void setupInnerViewElements(ViewGroup parent, View view) {

		ImageButton ibKuru = (ImageButton) view.findViewById(R.id.ibK);

		ibKuru.setBackgroundColor(Color.parseColor("#222222"));
		ibKuru.setClickable(true);
		ibKuru.setOnClickListener(this);

		// ImageButton event1 = (ImageButton) view.findViewById(R.id.ivWin8);
		// ImageButton event2 = (ImageButton) view.findViewById(R.id.ivOPC);
		// ImageButton event3 = (ImageButton) view.findViewById(R.id.ivCyber);
		// ibKuru.setBackgroundResource(R.drawable.printingnew);
		// event2.setBackgroundResource(R.drawable.innovate1);
		// event3.setBackgroundResource(R.drawable.onlinedalalbull1);

		// ibKuru.setBackgroundColor(Color.parseColor("#222222"));
		// event2.setBackgroundColor(Color.parseColor("#222222"));
		// event3.setBackgroundColor(Color.parseColor("#222222"));
		// ibKuru.setClickable(true);
		// event1.setClickable(true);
		// event2.setClickable(true);
		// event3.setClickable(true);

		// event1.setOnClickListener(this);
		// event2.setOnClickListener(this);
		// event3.setOnClickListener(this);

		CardView cardView = getCardView();
		// CardThumbnailView thumb = cardView.getInternalThumbnailLayout();
		// if (thumb != null) {
		// ViewGroup.LayoutParams lp = thumb.getLayoutParams();
		// if (lp instanceof ViewGroup.MarginLayoutParams) {
		// ((ViewGroup.MarginLayoutParams) lp).setMargins(25, 0, 0, 5);
		// }
		// }

	}

	class SingleButtonCardHeader extends CardHeader {

		public SingleButtonCardHeader(Context context, int innerLayout) {
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

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(getContext(), AboutUs.class);

		switch (arg0.getId()) {
		case R.id.ibK:
			// startActivity(intent);
			((Activity) getContext()).startActivity(intent);

			break;

		case R.id.event1:
			// start();

			// cont.startActivity(new Intent(cont,NoBoringHomeActivity.class));
			Log.d("CLICKED", "C 1");
			intent.putExtra("first", 0);

			break;
		case R.id.event2:
			Log.d("CLICKED", "C 2");
			intent.putExtra("first", 1);

			break;
		case R.id.event3:
			Log.d("CLICKED", "C 3");
			intent.putExtra("first", 2);

			break;
		default:
			;
		}
		((Activity) getContext()).startActivity(intent);

	}
}
