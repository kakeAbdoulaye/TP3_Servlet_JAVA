package Exercices.Exo1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckLogin extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3055953490719318697L;
	
	public void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException , IOException
	{
		response.setContentType("UTF-8");
		
		HttpSession session = request.getSession();
		RequestDispatcher dispatch ;
		
		String goodLogin = getInitParameter("loginInXML");
		String goodPassword = getInitParameter("passwordinXML");
		
		String loginUser = request.getParameter("login");
		String passwordUser = request.getParameter("password");
		
		if(goodLogin.equalsIgnoreCase(loginUser) && goodPassword.equals(passwordUser))
		{
			session.setAttribute("authentifier","oui");
			dispatch = request.getRequestDispatcher("OkExo1.html");
			dispatch.forward(request, response);
		}
		else
		{
			session.setAttribute("authentifier","non");
			dispatch = request.getRequestDispatcher("FailExo1.html");
			dispatch.forward(request, response);
		}
		
		
	}

}
