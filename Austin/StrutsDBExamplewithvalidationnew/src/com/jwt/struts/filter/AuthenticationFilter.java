package com.jwt.struts.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jwt.struts.form.LoginForm;

@WebFilter("/AuthenticationFilter")
public class AuthenticationFilter implements Filter {

	private ServletContext context;

	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("AuthenticationFilter initialized");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		LoginForm loginForm = new LoginForm();
		String uri = req.getRequestURI();
		this.context.log("Requested Resource::" + uri);
		/*res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		res.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		res.setDateHeader("Expires", 30);
		res.setHeader("refresh", "30");*/
		HttpSession session = req.getSession(false);
		System.out.println("in filter out if");
		if (session == null ) {
			System.out.println("in filter");
			req.getRequestDispatcher("login.jsp").forward(req, res);
		}else if(session!= null && (loginForm.getRole()==2)){
			System.out.println("user loop");
			req.getRequestDispatcher("userhome.jsp").forward(req, res);
		}
		else {
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}
	}

	public void destroy() {
		// close any resources here
	}

}
