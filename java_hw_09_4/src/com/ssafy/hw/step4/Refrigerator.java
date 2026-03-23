package com.ssafy.hw.step4;

public class Refrigerator extends Product {
	private String category;
	private int liter;
	private boolean freezer;
	private int year;

	public Refrigerator(String pCode, String pName, int price, int quantity, String brand, String desc, String category,
			int liter, boolean freezer, int year) {
		super(pCode, pName, price, quantity, brand, desc);
		this.category = category;
		this.liter = liter;
		this.freezer = freezer;
		this.year = year;
	}

	public boolean isFreezer() {
		return freezer;
	}
}