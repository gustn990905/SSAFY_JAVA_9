package com.ssafy.ws.step5;

import java.util.*;

public class ArticleManagerImpl implements IArticleManager {

	private List<Article> articles = new ArrayList<>();
	private Map<Integer, List<Comment>> comments = new HashMap<>();

	private static IArticleManager instance = new ArticleManagerImpl();

	private ArticleManagerImpl() {
	}

	public static IArticleManager getInstance() {
		return instance;
	}

	@Override
	public List<Article> getArticleList() {
		return articles;
	}

	@Override
	public Article getArticle(int id) throws ArticleNotFoundException {
		for (Article a : articles) {
			if (a.getArticleId() == id) {
				a.setViewCnt(a.getViewCnt() + 1);
				return a;
			}
		}
		throw new ArticleNotFoundException(id);
	}

	@Override
	public void addArticle(Article article) throws ArticleIdDuplicateException {
		for (Article a : articles) {
			if (a.getArticleId() == article.getArticleId())
				throw new ArticleIdDuplicateException();
		}
		articles.add(article);
	}

	@Override
	public void removeArticle(int id) throws ArticleNotFoundException {
		Article a = getArticle(id);
		articles.remove(a);
		comments.remove(id);
	}

	@Override
	public void updateArticle(Article article) throws ArticleNotFoundException {
		Article a = getArticle(article.getArticleId());
		a.title = article.title;
		a.content = article.content;
	}

	@Override
	public List<Article> search(int option, String keyword) {
		List<Article> result = new ArrayList<>();

		for (Article a : articles) {
			if (option == 1 && a.title.contains(keyword)) {
				result.add(a);
			} else if (option == 2 && a.content.contains(keyword)) {
				result.add(a);
			}
		}
		return result;
	}

	@Override
	public void addComment(Comment c) {
		comments.putIfAbsent(c.getArticleId(), new ArrayList<>());
		comments.get(c.getArticleId()).add(c);
	}

	@Override
	public void removeComment(int articleId, int commentId) throws CommentNotFoundException {
		List<Comment> list = comments.get(articleId);
		if (list == null)
			throw new CommentNotFoundException();

		boolean removed = list.removeIf(c -> c.getCommentId() == commentId);
		if (!removed)
			throw new CommentNotFoundException();
	}

	@Override
	public List<Comment> getCommentList(int articleId) throws CommentNotFoundException {
		List<Comment> list = comments.get(articleId);
		if (list == null || list.isEmpty())
			throw new CommentNotFoundException();
		return list;
	}

	@Override
	public List<ImageArticle> getImageArticleList() {
		List<ImageArticle> result = new ArrayList<>();
		for (Article a : articles) {
			if (a instanceof ImageArticle)
				result.add((ImageArticle) a);
		}
		return result;
	}

	@Override
	public double getImageSizeAvg() {
		List<ImageArticle> list = getImageArticleList();
		if (list.isEmpty())
			return 0;

		double sum = 0;
		for (ImageArticle ia : list) {
			sum += ia.getWidth() * ia.getHeight();
		}
		return sum / list.size();
	}
}