package controller;

import java.io.IOException;
import java.util.List;

import bll.MovieBLL;
import bo.Movie;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/MovieList")
public class MovieListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MovieBLL movBLL = new MovieBLL();
		List<Movie> movies = movBLL.select();
		
		request.setAttribute("movies", movies);
		request.getRequestDispatcher("/WEB-INF/jsp/movie_list.jsp").forward(request, response);
	}

}
