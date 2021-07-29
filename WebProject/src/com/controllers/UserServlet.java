package com.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.models.Course;
import com.models.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/home")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
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
		List<Course> enrolled = CourseUtils.enrolledCourses(user_id);
		request.setAttribute("enrolled", enrolled);
		List<Course> other_courses = CourseUtils.otherCourses(user_id);
		request.setAttribute("other_courses", other_courses);
		List<Course> courses = CourseUtils.allCourses();
		request.setAttribute("courses", courses);
		request.getRequestDispatcher("home.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
