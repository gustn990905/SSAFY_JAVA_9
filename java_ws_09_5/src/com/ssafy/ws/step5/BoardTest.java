package com.ssafy.ws.step5;

public class BoardTest {

	public static void main(String[] args) {

		IUserManager um = UserManagerImpl.getInstance();
		IArticleManager am = ArticleManagerImpl.getInstance();

		try {
			// 회원가입
			um.signup(new User(1, "id1", "1234", "홍길동", "길동", "a@a.com"));
			um.signup(new User(2, "id2", "1234", "김싸피", "싸피", "b@b.com"));

			// 중복 회원
			try {
				um.signup(new User(3, "id1", "1234", "중복", "dup", "c@c.com"));
			} catch (UserIdDuplicateException e) {
				System.out.println("중복 회원 예외: " + e.getMessage());
			}

			// 로그인
			um.login("id1", "1234");
			System.out.println("로그인 성공: " + um.getLoginUser());

			// 로그인 실패
			try {
				um.login("id1", "wrong");
			} catch (LoginException e) {
				System.out.println("로그인 실패 예외");
			}

			// 게시글 추가
			am.addArticle(new Article(1, "자바", "기초", 1));
			am.addArticle(new ImageArticle(2, "이미지", "내용", 1, "img.jpg", 100, 200));

			// 중복 게시글
			try {
				am.addArticle(new Article(1, "중복", "내용", 1));
			} catch (ArticleIdDuplicateException e) {
				System.out.println("게시글 중복 예외");
			}

			// 조회수 증가 확인
			System.out.println(am.getArticle(1));
			System.out.println(am.getArticle(1));

			// 검색
			System.out.println("제목 검색: " + am.search(1, "자바"));

			// 댓글 추가
			am.addComment(new Comment(1, 1, 1, "댓글1"));
			am.addComment(new Comment(2, 1, 2, "댓글2"));

			System.out.println("댓글 목록: " + am.getCommentList(1));

			// 댓글 삭제
			am.removeComment(1, 1);

			// 없는 댓글 삭제
			try {
				am.removeComment(1, 999);
			} catch (CommentNotFoundException e) {
				System.out.println("댓글 없음 예외");
			}

			// 없는 게시글
			try {
				am.getArticle(999);
			} catch (ArticleNotFoundException e) {
				System.out.println("게시글 없음 예외");
			}

			// 이미지 평균 크기
			System.out.println("이미지 평균: " + am.getImageSizeAvg());

			// 로그아웃
			um.logout();
			System.out.println("로그아웃 완료");

		} catch (Exception e) {
			System.out.println("전체 예외: " + e.getMessage());
		}
	}
}