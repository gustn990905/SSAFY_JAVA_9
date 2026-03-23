package com.ssafy.ws.step4;

public class RestaurantTest {

	public static void main(String[] args) {

		IRestaurantManager rm = RestaurantManagerImpl.getInstance();

		rm.addRestaurant(new KoreanRestaurant(1, "한식당", "서울"));
		rm.addRestaurant(new Restaurant(2, "피자집", "부산", "Western"));

		System.out.println("=== 전체 식당 ===");
		System.out.println(rm.getRestaurantList());

		// 존재하는 식당 검색
		try {
			System.out.println(rm.searchByResId(1));
		} catch (RestaurantNotFoundException e) {
			System.out.println(e.getMessage());
		}

		// 존재하지 않는 식당
		try {
			rm.searchByResId(999);
		} catch (RestaurantNotFoundException e) {
			System.out.println("예외 발생: " + e.getMessage());
		}

		// 리뷰 추가
		try {
			IReviewManager rvm = rm.getReviewManager(1);
			rvm.addReview(new Review(1, 1, "맛있다", 5));
			rvm.addReview(new Review(2, 1, "보통", 3));

			System.out.println("=== 리뷰 목록 ===");
			System.out.println(rvm.getReviewList());

			// 없는 리뷰 삭제
			rvm.removeReview(999);

		} catch (RestaurantNotFoundException | ReviewNotFoundException e) {
			System.out.println("예외 처리: " + e.getMessage());
		}
	}
}