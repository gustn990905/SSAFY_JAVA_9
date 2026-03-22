package com.ssafy.ws.step2;

import java.util.ArrayList;
import java.util.List;

public class MovieManagerImpl implements IMovieManager {

	private List<Movie> movieList = new ArrayList<>();
	private static IMovieManager instance = new MovieManagerImpl();

	private MovieManagerImpl() {
	}

	public static IMovieManager getInstance() {
		return instance;
	}

	@Override
	public void add(Movie movie) {
		movieList.add(movie);
	}

	@Override
	public Movie[] getList() {
		return movieList.toArray(new Movie[0]);
	}

	@Override
	public Movie[] getMovies() {
		List<Movie> list = new ArrayList<>();

		for (Movie m : movieList) {
			if (!(m instanceof SeriesMovie)) {
				list.add(m);
			}
		}

		return list.toArray(new Movie[0]);
	}

	@Override
	public SeriesMovie[] getSeriesMovies() {
		List<SeriesMovie> list = new ArrayList<>();

		for (Movie m : movieList) {
			if (m instanceof SeriesMovie) {
				list.add((SeriesMovie) m);
			}
		}

		return list.toArray(new SeriesMovie[0]);
	}

	@Override
	public Movie[] searchByTitle(String title) throws TitleNotFoundException {
		List<Movie> list = new ArrayList<>();

		for (Movie m : movieList) {
			if (m.getTitle().contains(title)) {
				list.add(m);
			}
		}

		if (list.size() == 0) {
			throw new TitleNotFoundException(title);
		}

		return list.toArray(new Movie[0]);
	}

	@Override
	public double getRunningTimeAvg() {
		int sum = 0;

		for (Movie m : movieList) {
			sum += m.getRunningTime();
		}

		return (double) sum / movieList.size();
	}
}