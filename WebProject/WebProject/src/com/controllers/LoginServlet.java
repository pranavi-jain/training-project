package com.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.models.Admin;
import com.models.User;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("index.jsp").include(request,response);
	}
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String role = request.getParameter("user_role");

		String validate = LoginAuth.validate(email, password, role);
		if(validate == "Admin") {
			HttpSession session = request.getSession();
			Admin admin = LoginAuth.getAdmin(email);
			session.setAttribute("admin", admin);
			session.setAttribute("role", "admin");
			response.sendRedirect("admin");
		}
		else if(validate == "User") {
			HttpSession session = request.getSession();
			User user = LoginAuth.getUser(email);
			session.setAttribute("user", user);
			session.setAttribute("role", "user");
			response.sendRedirect("home");
		}
		else {
			request.setAttribute("message", "Invalid credentials, OR User not found.");
		    request.getRequestDispatcher("index.jsp").forward(request,response);
		}
	}

}
