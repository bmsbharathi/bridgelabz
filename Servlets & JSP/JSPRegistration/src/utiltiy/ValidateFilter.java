package utiltiy;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ValidateFilter implements Filter {

	private ServletContext context;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain arg2)
			throws IOException, ServletException {
		String uname,pass;
		response.setContentType("text/html");
		
		System.out.println("Inside filter Checking paramters..");
		
		uname = request.getParameter("uname");
		pass = request.getParameter("pass");
		
		if(uname == "") {
		
			response.getWriter().println("Enter the UserName");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
		}
		else if(pass == "") {
			
			response.getWriter().println("Enter the Password");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
		}
		else {
			
			System.out.println("All clear..");
			arg2.doFilter(request, response);		
		}
		
	}

	@Override
	public void init(FilterConfig config) {
		this.context = config.getServletContext();
	}
	@Override
	public void destroy() {
		System.out.println("Filter Destroyed!");
		Filter.super.destroy();
	}
	

}

