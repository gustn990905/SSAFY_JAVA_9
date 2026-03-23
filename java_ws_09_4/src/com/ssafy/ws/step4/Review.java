package com.ssafy.ws.step4;

public class Review {
	private int reviewId;
	private int resId;
	private String content;
	private int score;

	public Review(int reviewId, int resId, String content, int score) {
		this.reviewId = reviewId;
		this.resId = resId;
		this.content = content;
		this.score = score;
	}

	public int getReviewId() {
		return reviewId;
	}

	public int getResId() {
		return resId;
	}

	@Override
	public String toString() {
		return reviewId + " | " + resId + " | " + content + " | " + score;
	}
}