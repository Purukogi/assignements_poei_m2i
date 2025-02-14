package bll;

import java.util.List;

import bo.Movie;
import dal.MovieDAO;

public class MovieBLL {
	
	private MovieDAO dao;
	
	public MovieBLL() {
		this.dao = new MovieDAO();
	}
	
	public List<Movie> select(){
		return dao.select();
	}
	
	public Movie selectById(int id) {
		return dao.selectById(id);
	}
	
	public void insert(Movie movie) {
		//checkMovie(movie);
		
		dao.insert(movie);
	}
	
	public void update(Movie movie) {
		//checkMovie(movie);
		
		dao.update(movie);
	}
	
	public void delete(Movie movie) {
		dao.delete(movie);
	}

}
