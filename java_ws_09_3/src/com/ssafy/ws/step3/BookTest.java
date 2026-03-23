package com.ssafy.ws.step3;

public class BookTest {
	public static void main(String[] args) {

		BookManagerImpl bm = BookManagerImpl.getInstance();

		bm.add(new Book("111", "자바", "홍길동", "ssafy", 20000, "기초", 10));
		bm.add(new Book("222", "알고리즘", "김싸피", "ssafy", 30000, "심화", 5));
		bm.add(new Magazine("333", "월간IT", "기자", "it출판", 10000, "잡지", 2024, 3, 3));

		System.out.println("=== 전체 목록 ===");
		for (Book b : bm.getList()) {
			System.out.println(b);
		}

		try {
			bm.sell("111", 3);
			System.out.println("판매 성공");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			bm.sell("222", 100);
		} catch (QuantityException e) {
			System.out.println("재고 부족 예외 발생");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			bm.sell("999", 1);
		} catch (ISBNNotFoundException e) {
			System.out.println("ISBN 없음 예외 발생");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			bm.buy("333", 10);
			System.out.println("구매 완료");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("=== 최종 목록 ===");
		for (Book b : bm.getList()) {
			System.out.println(b);
		}

		System.out.println("평균 가격: " + bm.getPriceAvg());
	}
}