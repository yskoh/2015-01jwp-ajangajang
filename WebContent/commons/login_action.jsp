<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import= "javax.servlet.RequestDispatcher" %>
<%@page import="net.slipp.user.User" %>
<%@ page import ="net.slipp.db.Database" %>
<%@page import="net.slipp.user.UserNotFoundException" %>
<%@page import="net.slipp.user.PasswordMismatchException" %>
<%
	String userId = request.getParameter("userId");
	String password = request.getParameter("password");

	try{
		User.login(userId, password);
		session.setAttribute("userId", userId);
		response.sendRedirect("/");
		
	} catch(UserNotfoundException e){
		request.setAttribute("errorMessage", "The user does not exist. Please retry logging in");
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	} catch(PasswordMismatchException e){
		request.setAttribute("errorMessage", "Wrong password. Please retry");
		Request Dispatcher rd= request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
		
	}
	
%>