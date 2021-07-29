package com.controllers;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.models.User;

/**
 * Servlet implementation class EnrollServlet
 */
@WebServlet("/enroll")
public class EnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String role = (String) session.getAttribute("role");
		if(role ==  null) {
			response.sendRedirect("login");
			return;
		}
		else if(role ==  "admin") {
			response.sendRedirect("admin");
			return;
		}
		User user = (User)session.getAttribute("user");
		int user_id = user.getUserId();
		boolean status;
		if(request.getParameter("enroll") != null) {
			int course_id = Integer.parseInt(request.getParameter("enroll"));
			status = Enroll.enrollCourse(user_id, course_id);
			if(!status) 
				request.setAttribute("message", "An error occurred! Please try again.");
		}
		else if(request.getParameter("unenroll") != null) {
			int course_id = Integer.parseInt(request.getParameter("unenroll"));
			status = Enroll.unenrollCourse(user_id, course_id);
			if(!status) 
				request.setAttribute("message", "An error occurred! Please try again.");
		}
		response.sendRedirect("home");
		return;
	}

}
