package com.ssafy.ws.step4;

import java.util.*;

public class RestaurantManagerImpl implements IRestaurantManager {

	private List<Restaurant> restaurants = new ArrayList<>();
	private Map<Integer, IReviewManager> rvm = new HashMap<>();

	private static IRestaurantManager instance = new RestaurantManagerImpl();

	private RestaurantManagerImpl() {
	}

	public static IRestaurantManager getInstance() {
		return instance;
	}

	@Override
	public void addRestaurant(Restaurant restaurant) {
		restaurants.add(restaurant);
		rvm.put(restaurant.getResId(), new ReviewManagerImpl());
	}

	@Override
	public void removeRestaurant(int resId) throws RestaurantNotFoundException {
		Restaurant r = searchByResId(resId);
		restaurants.remove(r);
		rvm.remove(resId);
	}

	@Override
	public List<Restaurant> getRestaurantList() {
		return restaurants;
	}

	@Override
	public Restaurant searchByResId(int resId) throws RestaurantNotFoundException {
		for (Restaurant r : restaurants) {
			if (r.getResId() == resId)
				return r;
		}
		throw new RestaurantNotFoundException(resId);
	}

	@Override
	public List<KoreanRestaurant> getKoreanRestaurants() {
		List<KoreanRestaurant> result = new ArrayList<>();
		for (Restaurant r : restaurants) {
			if (r instanceof KoreanRestaurant)
				result.add((KoreanRestaurant) r);
		}
		return result;
	}

	@Override
	public List<Restaurant> getNonKoreanRestaurants() {
		List<Restaurant> result = new ArrayList<>();
		for (Restaurant r : restaurants) {
			if (!(r instanceof KoreanRestaurant))
				result.add(r);
		}
		return result;
	}

	@Override
	public IReviewManager getReviewManager(int resId) throws RestaurantNotFoundException {
		searchByResId(resId); // 존재 확인
		return rvm.get(resId);
	}
}