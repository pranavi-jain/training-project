package com.controllers;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.models.Course;

import oracle.jdbc.OracleTypes;

public class CourseUtils {
	
	public static List<Course> allCourses() {
        List<Course> courses = new ArrayList<>();
		try {
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","web_admin","pass123");
            Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery("select * from course");
			while(res.next()) {
				int cid = res.getInt(1);
				String name = res.getString(2);
				String desc = res.getString(3);
				String fees = res.getString(4);
				String resource = res.getString(5);
				Course obj = new Course(cid, name, desc, fees, resource);
				courses.add(obj);
			}
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
		return courses;
	}

	public static List<Course> enrolledCourses(int user_id) {
        List<Course> courses = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","web_admin","pass123");
            CallableStatement stmt = con.prepareCall("begin userCourses(?,?); end;");
            stmt.setInt(1,user_id);
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            ResultSet res = (ResultSet) stmt.getObject(2);
			while(res.next()) {
				int cid = res.getInt("COURSE_ID");
				String name = res.getString("C_NAME");
				String desc = res.getString("C_DESP");
				String fees = res.getString("C_FEES");
				String resource = res.getString("C_RESOURCE");
				Course obj = new Course(cid, name, desc, fees, resource);
				courses.add(obj);
			}
            con.close();  
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
		return courses;
	}

	public static List<Course> otherCourses(int user_id) {
        List<Course> courses = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","web_admin","pass123");
            CallableStatement stmt = con.prepareCall("begin otherCourses(?,?); end;");
            stmt.setInt(1,user_id);
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            ResultSet res = (ResultSet) stmt.getObject(2);
			while(res.next()) {
				int cid = res.getInt("COURSE_ID");
				String name = res.getString("C_NAME");
				String desc = res.getString("C_DESP");
				String fees = res.getString("C_FEES");
				String resource = res.getString("C_RESOURCE");
				Course obj = new Course(cid, name, desc, fees, resource);
				courses.add(obj);
			}
            con.close();  
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
		return courses;
	}

}
