package com.hcl.simplilean.UserLogin.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hcl.simplilean.UserLogin.services.Services;

/**
 * Servlet implementation class login
 */
@WebServlet("/loginservice")
public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginService() {
		super();
		// TODO Auto-generated constructor stub
	}
//	public void init() {
//	      Services service =new Services();
//	   }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if (Services.validate(request.getParameter("userid"),request.getParameter("password"))) {
			out.println("Log In Successfull <br>");
			out.println("<a href=\"/user/index.jsp\">Log Out</a>");
		}else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
			request.setAttribute( "msg","<div style=\"color:Tomato;\">Wrong Username or Password used</div>");
			rd.forward(request, response);
		}
	}

}