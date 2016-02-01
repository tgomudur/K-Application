package com.twotoasters.jazzylistview.home;

import in.org.kurukshetra.app.R;
import com.twotoasters.jazzylistview.sample.SingleEventOnly;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.view.CardView;

public class MyCard extends Card implements View.OnClickListener {

	public MyCard(Context context) {
		this(context, R.layout.threebuttons);
	}

	public MyCard(Context context, int innerLayout) {
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

		ImageButton event1 = (ImageButton) view.findViewById(R.id.event1);
		ImageButton event2 = (ImageButton) view.findViewById(R.id.event2);
		ImageButton event3 = (ImageButton) view.findViewById(R.id.event3);

		event1.setBackgroundResource(R.drawable.b100);
		event2.setBackgroundResource(R.drawable.b200);
		event3.setBackgroundResource(R.drawable.b300);
		// ibKuru.setBackgroundColor(Color.parseColor("#222222"));
		// event2.setBackgroundColor(Color.parseColor("#222222"));
		// event3.setBackgroundColor(Color.parseColor("#222222"));
		// ibKuru.setClickable(true);
		event1.setClickable(true);
		event2.setClickable(true);
		event3.setClickable(true);

		event1.setOnClickListener(this);
		event2.setOnClickListener(this);
		event3.setOnClickListener(this);

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
	public void onClick(View v) {
		// TODO Auto-generated method stub

		Intent intent = new Intent(getContext(), SingleEventOnly.class);

		switch (v.getId()) {
		case R.id.event1:
			// start();

			// cont.startActivity(new Intent(cont,NoBoringHomeActivity.class));
			intent.putExtra("first", 0);

			break;
		case R.id.event2:
			intent.putExtra("first", 1);

			break;
		case R.id.event3:
			intent.putExtra("first", 2);

			break;
		default:
			;
		}
		((Activity) getContext()).startActivity(intent);
	}
}
