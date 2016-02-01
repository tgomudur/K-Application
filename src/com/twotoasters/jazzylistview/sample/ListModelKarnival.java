package com.twotoasters.jazzylistview.sample;

final class ListModelKarnival {

	private static final String[] MODEL = { "Zero", "One", "Two", "Three",
			"Four", "Five"

	};

	public static String[] getModel() {
		return MODEL;
	}

	public static String getModelItem(int position) {
		return MODEL[position];
	}

	private ListModelKarnival() {
	}
}
