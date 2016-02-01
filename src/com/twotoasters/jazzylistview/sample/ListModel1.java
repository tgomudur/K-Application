package com.twotoasters.jazzylistview.sample;

final class ListModel1 {

	private static final String[] MODEL = { "Zero", "One"

	};

	public static String[] getModel() {
		return MODEL;
	}

	public static String getModelItem(int position) {
		return MODEL[position];
	}

	private ListModel1() {
	}
}
