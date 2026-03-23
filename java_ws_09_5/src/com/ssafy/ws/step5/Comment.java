package com.ssafy.ws.step5;

import java.util.Date;

public class Comment {
	private int commentId;
	private int articleId;
	private int userSeq;
	private String content;
	private Date regDate;

	public Comment(int commentId, int articleId, int userSeq, String content) {
		this.commentId = commentId;
		this.articleId = articleId;
		this.userSeq = userSeq;
		this.content = content;
		this.regDate = new Date();
	}

	public int getCommentId() {
		return commentId;
	}

	public int getArticleId() {
		return articleId;
	}

	@Override
	public String toString() {
		return commentId + " | " + content;
	}
}