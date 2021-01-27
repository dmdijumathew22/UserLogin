package com.hcl.simplilean.UserLogin.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.hcl.simplilean.UserLogin.entity.UserEntity;
import com.hcl.simplilean.UserLogin.hibernate.HibernateUtils;

/**
 * Servlet implementation class RegisterService
 */
@WebServlet("/RegisterService")
public class RegisterService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Session hibernateSession;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterService() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		hibernateSession = HibernateUtils.buildSessionFactory().openSession();
		hibernateSession.beginTransaction();
		UserEntity user= UserEntity.find(request.getParameter("userid"));
		if (user==null) {
			user = new UserEntity();		
			user.setUserid(request.getParameter("userid"));
			user.setFirstName(request.getParameter("first_name"));
			user.setLastName(request.getParameter("last_name"));
			user.setPwd(request.getParameter("pwd"));
			user.setEmail(request.getParameter("email"));
			hibernateSession.save(user);
			out.println("Registration Successfull <br>"
					+ "Please ");
			out.println("<a href=\"/user/index.jsp\">Log In</a>");
			hibernateSession.getTransaction().commit();
			hibernateSession.close();
		} else {

			RequestDispatcher rd = getServletContext().getRequestDispatcher("/registration.jsp");
			request.setAttribute( "msg","<div style=\"color:Tomato;\">"+"Registraion UnSuccessfull !!"
										+ " Username already exists<br>"
										+ "Please use different Username <br></div>");
			rd.forward(request, response);
		}
	}


}
