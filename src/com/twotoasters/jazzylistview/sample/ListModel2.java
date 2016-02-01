package com.twotoasters.jazzylistview.sample;

final class ListModel2 {

	private static final String[] MODEL = { "Zero", "One", "Two"

	};

	public static String[] getModel() {
		return MODEL;
	}

	public static String getModelItem(int position) {
		return MODEL[position];
	}

	private ListModel2() {
	}
}
