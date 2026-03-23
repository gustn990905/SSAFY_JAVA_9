package com.ssafy.ws.step4;

import java.util.List;

public interface IRestaurantManager {
	void addRestaurant(Restaurant restaurant);

	void removeRestaurant(int resId) throws RestaurantNotFoundException;

	List<Restaurant> getRestaurantList();

	Restaurant searchByResId(int resId) throws RestaurantNotFoundException;

	List<KoreanRestaurant> getKoreanRestaurants();

	List<Restaurant> getNonKoreanRestaurants();

	IReviewManager getReviewManager(int resId) throws RestaurantNotFoundException;
}