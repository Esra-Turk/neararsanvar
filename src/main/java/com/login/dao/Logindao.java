package com.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.helper.Sha256Coding;
import com.register.model.User;

public class Logindao {
	String sql = "select * from user where email=? and password=?";
	String url= "jdbc:mysql://localhost:3306/neararsanvar?useSSL=false";
	String username = "root";
	String password = "123456789";
	
	public boolean check(String email, String pass) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,email);
			st.setString(2,Sha256Coding.sha256(pass));
			
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				
				return true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	public User getUserByEmail(String mail) {
		try {
			String sql1 = "select * from user where email=?";
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sql1);
			st.setString(1,mail);
			
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
			    int userId = rs.getInt("userID");
			    String name = rs.getString("name");
			    String surname = rs.getString("surname");
			    String email = rs.getString("email");
			    String password = rs.getString("password");
			    String cartID = rs.getString("cartID");
			    
			    return new User(userId,name,surname,email,password,cartID);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
		
	}
		
	
}

