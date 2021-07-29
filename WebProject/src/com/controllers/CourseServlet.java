package com.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.models.Course;

/**
 * Servlet implementation class CourseServlet
 */
@WebServlet("/course")
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		else if(role ==  "user") {
			response.sendRedirect("home");
			return;
		}
		boolean status;
		if(request.getParameter("add") != null) {
			request.getRequestDispatcher("course-add.jsp").forward(request,response);
			return;
		}
		else if(request.getParameter("delete") != null) {
			int course_id = Integer.parseInt(request.getParameter("delete"));
			status = CourseUtils.deleteCourse(course_id);
			if(!status) 
				request.setAttribute("message", "An error occurred! Please try again.");
		}
		response.sendRedirect("admin");
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String role = (String) session.getAttribute("role");
		if(role ==  null) {
			response.sendRedirect("login");
			return;
		}
		else if(role ==  "user") {
			response.sendRedirect("home");
			return;
		}
		boolean status=false;
		if(request.getParameter("add") != null) {
			if(request.getParameter("course-id") != "") {
				int course_id = Integer.parseInt(request.getParameter("course-id"));
				String name = request.getParameter("name");
				String desp = request.getParameter("desp");
				String fees = request.getParameter("fees");
				String resc = request.getParameter("rescource");
				Course newCourse = new Course(course_id, name, desp, fees, resc);
				status = CourseUtils.addCourse(newCourse);
			}
			if(!status) {
				request.setAttribute("message", "An error occurred! Please try again.");
				request.getRequestDispatcher("course-add.jsp").forward(request,response);
				return;
			}
		}
		response.sendRedirect("admin");
		return;
	}


}
