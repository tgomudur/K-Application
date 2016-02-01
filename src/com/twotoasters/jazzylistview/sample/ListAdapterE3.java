package com.twotoasters.jazzylistview.sample;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import in.org.kurukshetra.app.R;

class ListAdapterE3 extends ArrayAdapter<String> {

	private final LayoutInflater inflater;
	private final Resources res;
	private final int itemLayout;
	// int
	// imaeglist[]={R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.one,R.drawable.two,R.drawable.three};
	int imagelist[] = { R.drawable.kentrepreneur1, R.drawable.chaos1,
			R.drawable.kidol1 };

	public ListAdapterE3(Context context, int itemLayout) {
		super(context, itemLayout, R.id.text, ListModel2.getModel());
		inflater = LayoutInflater.from(context);
		res = context.getResources();
		this.itemLayout = itemLayout;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;

		if (convertView == null) {
			convertView = inflater.inflate(itemLayout, null);
			holder = new ViewHolder(convertView);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		int colorResId = position % 2 == 0 ? R.color.even : R.color.odd;
		holder.text.setBackgroundColor(res.getColor(colorResId));
		// holder.text.setText(ListModel.getModelItem(position));
		holder.text.setBackgroundResource(imagelist[position]);

		return convertView;
	}

	static class ViewHolder {
		final TextView text;

		ViewHolder(View view) {
			text = (TextView) view.findViewById(R.id.text);
		}
	}
}
