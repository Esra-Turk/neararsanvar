package com.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.helper.Sha256Coding;

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
		
	
}

