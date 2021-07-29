package com.controllers;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Enroll {

	public static boolean enrollCourse(int user_id, int course_id) {
        boolean status=false;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","web_admin","pass123");
            CallableStatement stmt = con.prepareCall("begin enrollCourse(?,?); end;");
            stmt.setInt(1,user_id);
            stmt.setInt(2,course_id);
            stmt.execute();
            con.close();
            status = true;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
		return status;
	}

	public static boolean unenrollCourse(int user_id, int course_id) {
        boolean status=false;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","web_admin","pass123");
            CallableStatement stmt = con.prepareCall("begin unenrollCourse(?,?); end;");
            stmt.setInt(1,user_id);
            stmt.setInt(2,course_id);
            stmt.execute();
            con.close();
            status = true;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
		return status;
	}

}
