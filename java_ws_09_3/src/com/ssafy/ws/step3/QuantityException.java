package com.ssafy.ws.step3;

public class QuantityException extends Exception {
	public QuantityException() {
		super("재고가 부족합니다.");
	}
}