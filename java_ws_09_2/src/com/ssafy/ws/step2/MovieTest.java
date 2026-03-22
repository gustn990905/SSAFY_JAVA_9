package com.ssafy.ws.step2;

public class MovieTest {

	public static void main(String[] args) {

		IMovieManager manager = MovieManagerImpl.getInstance();

		Movie m1 = new Movie(1, "어벤져스", "마블", "액션", 120);
		Movie m2 = new Movie(2, "기생충", "봉준호", "드라마", 130);
		SeriesMovie sm1 = new SeriesMovie(3, "해리포터", "크리스", "판타지", 150, 1, "마법사의 돌");

		manager.add(m1);
		manager.add(m2);
		manager.add(sm1);

		System.out.println("-------------searchByTitle-------------");

		try {
			Movie[] result = manager.searchByTitle("GV");

			for (Movie m : result) {
				System.out.println(m);
			}

		} catch (TitleNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}