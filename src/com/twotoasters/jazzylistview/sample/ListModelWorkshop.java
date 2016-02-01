package com.twotoasters.jazzylistview.sample;

final class ListModelWorkshop {

	private static final String[] MODEL = { "Zero", "One", "Two", "Three",
			"Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"

	};

	public static String[] getModel() {
		return MODEL;
	}

	public static String getModelItem(int position) {
		return MODEL[position];
	}

	private ListModelWorkshop() {
	}
}
