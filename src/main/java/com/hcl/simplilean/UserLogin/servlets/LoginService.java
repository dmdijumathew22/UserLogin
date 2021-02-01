package com.hcl.simplilean.UserLogin.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hcl.simplilean.UserLogin.entity.UserEntity;
import com.hcl.simplilean.UserLogin.services.Services;

/**
 * Servlet implementation class login
 */

//url mapping
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		if (Services.validate(request.getParameter("userid"),request.getParameter("password"))) {
			//if login credentials match , forward to welcome.jsp.
			
			UserEntity u=Services.find(request.getParameter("userid"));
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/welcome.jsp");
			request.setAttribute( "first_name",u.getFirstName());
			request.setAttribute( "last_name",u.getLastName());
			request.setAttribute( "userid",u.getUserid());
			request.setAttribute( "email",u.getEmail());
			rd.forward(request, response);
		}else {
			//if login credentials doesn't match give error message
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
			request.setAttribute( "msg","<div style=\"color:Tomato;\">Wrong Username or Password used</div>");
			rd.forward(request, response);
		}
	}

}
