package controller;

import java.io.IOException;

import bll.MovieBLL;
import bo.Movie;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/MoviePage")
public class MoviePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MovieBLL movBLL = new MovieBLL();
		
		int id = Integer.valueOf(request.getParameter("movie_id"));
		Movie movie = movBLL.selectById(id);
		
		request.setAttribute("movie", movie);
		request.getRequestDispatcher("/WEB-INF/jsp/movie_page.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
