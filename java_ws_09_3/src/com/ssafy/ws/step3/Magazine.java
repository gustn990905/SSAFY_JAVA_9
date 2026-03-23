package com.ssafy.ws.step3;

public class Magazine extends Book {
	private int year;
	private int month;

	public Magazine(String isbn, String title, String author, String publisher, int price, String desc, int year,
			int month, int quantity) {
		super(isbn, title, author, publisher, price, desc, quantity);
		this.year = year;
		this.month = month;
	}

	@Override
	public String toString() {
		return super.toString() + " | " + year + "." + month;
	}
}