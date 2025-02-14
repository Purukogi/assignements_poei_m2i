package controller;

import java.io.IOException;

import bll.MovieBLL;
import bo.Movie;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DropMovie")
public class DropMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MovieBLL movBLL = new MovieBLL();
		Movie toDelete = movBLL.selectById(Integer.valueOf(request.getParameter("movie_id")));
		
		movBLL.delete(toDelete);
		
		response.sendRedirect("MovieList");
	}


}
