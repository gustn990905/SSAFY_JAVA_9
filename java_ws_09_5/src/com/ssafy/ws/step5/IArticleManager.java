package com.ssafy.ws.step5;

import java.util.List;

public interface IArticleManager {

	List<Article> getArticleList();

	Article getArticle(int articleId) throws ArticleNotFoundException;

	void addArticle(Article article) throws ArticleIdDuplicateException;

	void removeArticle(int articleId) throws ArticleNotFoundException;

	void updateArticle(Article article) throws ArticleNotFoundException;

	List<Article> search(int option, String keyword);

	void addComment(Comment comment);

	void removeComment(int articleId, int commentId) throws CommentNotFoundException;

	List<Comment> getCommentList(int articleId) throws CommentNotFoundException;

	List<ImageArticle> getImageArticleList();

	double getImageSizeAvg();
}