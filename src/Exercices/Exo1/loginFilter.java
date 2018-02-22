package Exercices.Exo1;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class loginFilter implements Filter {
	
	private ServletContext contextServlet;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("je suis la mon grand 1");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chaine)
			throws IOException, ServletException {
		HttpServletRequest httpRequest= (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession httpSession = httpRequest.getSession();
		
		String authentification = (String) httpSession.getAttribute("authentifier");
		
		if("oui".equals(authentification))
		{
			chaine.doFilter(request, response);
		}
		else
		{
			httpResponse.sendRedirect(contextServlet.getContextPath()+"/LoginExo1.html");
		}
		System.out.println("je suis la mon grand2");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		contextServlet = arg0.getServletContext();
		System.out.println("je suis la mon grand3");
	}

}
