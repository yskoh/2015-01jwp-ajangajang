package net.slipp.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/users/login")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");

		try{
			User.login(userId, password);
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);
			response.sendRedirect("/");
			
		} catch(UserNotFoundException e){
			forwardJSP(request, response, "The user does not exist. Please retry");
		} catch(PasswordMismatchException e){
			forwardJSP(request, response, "Wrong password. Please retry");
		}

	}
	
	private void forwardJSP(HttpServletRequest request, HttpServletResponse response, String errorMessage) throws ServletException, IOException{
		request.setAttribute("errorMessage", errorMessage);
		RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
		rd.forward(request, response);
	}
}
