package com.ssafy.ws.step4;

public class Restaurant {
	private int resId;
	private String name;
	private String address;
	private String type;

	public Restaurant(int resId, String name, String address, String type) {
		this.resId = resId;
		this.name = name;
		this.address = address;
		this.type = type;
	}

	public int getResId() {
		return resId;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return resId + " | " + name + " | " + type;
	}
}