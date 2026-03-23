package com.ssafy.ws.step3;

public class Book {
	protected String isbn;
	protected String title;
	protected String author;
	protected String publisher;
	protected int price;
	protected String desc;
	protected int quantity;

	public Book() {
	}

	public Book(String isbn, String title, String author, String publisher, int price, String desc, int quantity) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.desc = desc;
		this.quantity = quantity;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public int getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return isbn + " | " + title + " | " + quantity;
	}
}