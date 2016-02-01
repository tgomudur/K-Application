package com.twotoasters.jazzylistview.sample;

final class ListModel4 {

	private static final String[] MODEL = { "Zero", "One", "Two", "Three",
			"Four"

	};

	public static String[] getModel() {
		return MODEL;
	}

	public static String getModelItem(int position) {
		return MODEL[position];
	}

	private ListModel4() {
	}
}
