package com.ssafy.ws.step5;

public class ImageArticle extends Article {
	private String imageName;
	private int width;
	private int height;

	public ImageArticle(int articleId, String title, String content, int userSeq, String imageName, int width,
			int height) {
		super(articleId, title, content, userSeq);
		this.imageName = imageName;
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}