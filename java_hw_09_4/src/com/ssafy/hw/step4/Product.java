package com.ssafy.hw.step4;

public class Product {
	protected String pCode;
	protected String pName;
	protected int price;
	protected int quantity;
	protected String brand;
	protected String desc;

	public Product() {
	}

	public Product(String pCode, String pName, int price, int quantity, String brand, String desc) {
		this.pCode = pCode;
		this.pName = pName;
		this.price = price;
		this.quantity = quantity;
		this.brand = brand;
		this.desc = desc;
	}

	public String getpCode() {
		return pCode;
	}

	public String getpName() {
		return pName;
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
		return pCode + " | " + pName + " | " + quantity;
	}
}