package com.ssafy.hw.step4;

public class ProductTest {

	public static void main(String[] args) {

		IProductManager pm = ProductManagerImpl.getInstance();

		pm.addProduct(new Product("1", "TV", 1000, 10, "LG", "good"));
		pm.addProduct(new Refrigerator("2", "냉장고", 2000, 5, "삼성", "cool", "가전", 500, true, 2024));

		try {
			pm.sell("1", 3);
			pm.sell("2", 10); // 재고 부족
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			pm.searchByCode("999"); // 없는 코드
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		pm.addReview(new Review(1, "1", "user", "좋아요"));

		try {
			System.out.println(pm.getProductReview("1"));
			System.out.println(pm.getProductReview("999")); // 없음
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("총 가격: " + pm.getTotalPrice());
	}
}