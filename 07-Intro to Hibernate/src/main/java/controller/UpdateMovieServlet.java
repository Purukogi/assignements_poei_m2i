package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import bll.CategoryBLL;
import bll.MovieBLL;
import bo.Actor;
import bo.Category;
import bo.Director;
import bo.Movie;


@WebServlet("/UpdateMovie")
public class UpdateMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieBLL movBLL = new MovieBLL();
		
		int id = Integer.valueOf(request.getParameter("movie_id"));
		Movie movie = movBLL.selectById(id);
		
		request.setAttribute("movie", movie);
		request.getRequestDispatcher("/WEB-INF/jsp/update_movie.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieBLL movBLL = new MovieBLL(); 
		CategoryBLL catBLL = new CategoryBLL();
		
		int id = Integer.valueOf(request.getParameter("movie_id"));
		String title = request.getParameter("title");
		int releaseYear = Integer.valueOf(request.getParameter("release"));
		Category category = catBLL.selectById(Integer.valueOf(request.getParameter("category_id")));
		
		boolean seen = false;
		if(request.getParameter("seen").equals("yes")) {
			seen = true;
		}
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("H:m");
		LocalTime duration = LocalTime.parse(request.getParameter("duration"), dtf);
		
		Director director = new Director(request.getParameter("director_first_name"), request.getParameter("director_last_name"));
				
		List<Actor> actors = new ArrayList<>();
		for(int i = 1; i <= 5; i++) {
			Actor actor = new Actor(request.getParameter("actor"+ i +"_first_name"), request.getParameter("actor" + i + "_last_name"));
			if(!actor.getFirstName().isBlank() && ! actor.getLastName().isBlank()) {
				actors.add(actor);
			}
		}
		
		String synopsis = request.getParameter("synopsis");
		
		Movie toUpdate = new Movie(id, title, releaseYear, category, seen,  duration, director, actors, synopsis);
		movBLL.update(toUpdate);
		
		response.sendRedirect("MovieList");
	}

}
