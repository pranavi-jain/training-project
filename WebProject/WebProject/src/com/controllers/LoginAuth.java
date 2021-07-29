package com.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.models.Admin;
import com.models.User;

public class LoginAuth {
	
	public static String validate(String email, String password, String role) {
		String valid="Not Found";
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","web_admin","pass123");
            if(role.equals("Admin")) {
            	PreparedStatement stmt=con.prepareStatement("select * from admin where email=? and password=?");
                stmt.setString(1,email);
                stmt.setString(2,password);
                ResultSet res=stmt.executeQuery();
                if(res.next()) {
                	valid = "Admin";
                }	
            }
            else {
            	PreparedStatement stmt=con.prepareStatement("select * from allusers where email=? and password=?");
                stmt.setString(1,email);
                stmt.setString(2,password);
                ResultSet res=stmt.executeQuery();
                if(res.next()) {
                	valid = "User";
                }
            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
		return valid;
	}
	
	public static Admin getAdmin(String email) {
        Admin admin = new Admin();
		try {
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","web_admin","pass123");
            PreparedStatement stmt=con.prepareStatement("select * from admin where email=?");
            stmt.setString(1,email);
            ResultSet res=stmt.executeQuery();
            res.next();
            int adminid = res.getInt(1);
            String name = res.getString(2);
            admin = new Admin(adminid, name, email);
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
		return admin;
	}
	
	public static User getUser(String email) {
        User user = new User();
		try {
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","web_admin","pass123");
            PreparedStatement stmt=con.prepareStatement("select * from allusers where email=?");
            stmt.setString(1,email);
            ResultSet res=stmt.executeQuery();
            res.next();
        	int userid = res.getInt(1);
        	String name = res.getString(2);
        	int phone = res.getInt(3);
        	String addr = res.getString(5);
        	String regDate = res.getString(6);
        	user = new User(userid, name, phone, email, addr, regDate);
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
		return user;
	}
	
}
