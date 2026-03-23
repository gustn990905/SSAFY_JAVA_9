package com.ssafy.hw.step4;

public class Review {
	private int reviewId;
	private String pCode;
	private String writer;
	private String content;

	public Review(int reviewId, String pCode, String writer, String content) {
		this.reviewId = reviewId;
		this.pCode = pCode;
		this.writer = writer;
		this.content = content;
	}

	public int getReviewId() {
		return reviewId;
	}

	public String getpCode() {
		return pCode;
	}

	@Override
	public String toString() {
		return reviewId + " | " + pCode + " | " + content;
	}
}