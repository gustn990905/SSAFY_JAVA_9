package com.ssafy.ws.step4;

import java.util.ArrayList;
import java.util.List;

public class ReviewManagerImpl implements IReviewManager {

	private List<Review> reviews = new ArrayList<>();

	@Override
	public void addReview(Review review) {
		reviews.add(review);
	}

	@Override
	public void removeReview(int reviewId) throws ReviewNotFoundException {
		Review r = searchByReviewId(reviewId);
		reviews.remove(r);
	}

	@Override
	public List<Review> getReviewList() {
		return reviews;
	}

	@Override
	public Review searchByReviewId(int reviewId) throws ReviewNotFoundException {
		for (Review r : reviews) {
			if (r.getReviewId() == reviewId)
				return r;
		}
		throw new ReviewNotFoundException(reviewId);
	}

	@Override
	public List<Review> getRestaurantReview(int resId) {
		List<Review> result = new ArrayList<>();
		for (Review r : reviews) {
			if (r.getResId() == resId)
				result.add(r);
		}
		return result;
	}
}