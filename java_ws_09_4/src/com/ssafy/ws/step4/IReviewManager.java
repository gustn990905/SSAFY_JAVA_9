package com.ssafy.ws.step4;

import java.util.List;

public interface IReviewManager {
	void addReview(Review review);

	void removeReview(int reviewId) throws ReviewNotFoundException;

	List<Review> getReviewList();

	Review searchByReviewId(int reviewId) throws ReviewNotFoundException;

	List<Review> getRestaurantReview(int resId);
}