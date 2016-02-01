package com.twotoasters.jazzylistview.sample;

final class ListModel6 {

	private static final String[] MODEL = { "Zero", "One", "Two", "Three",
			"Four", "Five", "Six", "Seven" };

	public static String[] getModel() {
		return MODEL;
	}

	public static String getModelItem(int position) {
		return MODEL[position];
	}

	private ListModel6() {
	}
}
