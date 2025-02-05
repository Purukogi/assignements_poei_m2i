package filters;

import java.io.IOException;

import bll.UserBLL;
import bo.User;
import jakarta.servlet.DispatcherType;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter(
		dispatcherTypes = DispatcherType.REQUEST,
		urlPatterns = "/*")

public class ConnectionFilter extends HttpFilter implements Filter {
       
	private static final long serialVersionUID = 1L;	

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		
		String url = httpRequest.getServletPath();
		
		if (url.contains(".css") || url.contains("Connection") || url.contains("Register")) {
			chain.doFilter(httpRequest, httpResponse);
			return;
		}
		
		User user = (User) httpRequest.getSession().getAttribute("user");
		
		if (user != null) {
			chain.doFilter(httpRequest, httpResponse);
			return;
		}
		
		Cookie[] cookies = httpRequest.getCookies();
		if (cookies != null) {
			for (Cookie current : cookies) {
				if ("token".equals(current.getName())) {
					UserBLL bll = new UserBLL();
					User userByToken = bll.selectByToken(current.getValue());
					if (userByToken != null) {
						httpRequest.getSession().setAttribute("user", userByToken);
						chain.doFilter(httpRequest, httpResponse);
						return;
					}
				}
			}
		}
		
		httpResponse.sendRedirect("Connection");
	}
	
	
}

