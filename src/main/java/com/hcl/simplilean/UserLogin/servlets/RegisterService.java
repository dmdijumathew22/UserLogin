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
 * Servlet implementation class RegisterService
 */
//Servlet mapping
@WebServlet("/RegisterService")
public class RegisterService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// static Session hibernateSession;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterService() {
		super();
		
	}

	public void destroy() {
		Services.hibernateSession.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// checks whether password and confirm password match or not
		if (request.getParameter("pwd").equals(request.getParameter("cnfpwd"))) {

			// if passwords match checks for existing user with same user id

			UserEntity user = Services.find(request.getParameter("userid"));
			if (user == null) {
				// creating new user
				user = new UserEntity();
				user.setUserid(request.getParameter("userid"));
				user.setFirstName(request.getParameter("first_name"));
				user.setLastName(request.getParameter("last_name"));
				user.setPwd(request.getParameter("pwd"));
				user.setEmail(request.getParameter("email"));
				Services.save(user);

				RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
				request.setAttribute("msg", "<div style=\"color:DodgerBlue;\">" + "Registraion Successfull !!</div>");
				rd.forward(request, response);

			} else {
				// error message is userid already exists
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/registration.jsp");
				request.setAttribute("msg", "<div style=\"color:Tomato;\">" + "Registraion UnSuccessfull !!"
						+ " Username already exists<br>" + "Please use different Username <br></div>");
				rd.forward(request, response);
			}
		} else {
			// error message if password and confirm password doesn't match
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/registration.jsp");
			request.setAttribute("msg", "<div style=\"color:Tomato;\">" + "Registraion UnSuccessfull !!"
					+ " Passwords Doesn't match<br></div>");
			rd.forward(request, response);

		}
	}

}
