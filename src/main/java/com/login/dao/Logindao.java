package com.login.dao;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
			st.setString(2,sha256(pass));
			
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				
				return true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	public static String sha256(final String base) {
	    try{
	        final MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        final byte[] hash = digest.digest(base.getBytes("UTF-8"));
	        final StringBuilder hexString = new StringBuilder();
	        for (int i = 0; i < hash.length; i++) {
	            final String hex = Integer.toHexString(0xff & hash[i]);
	            if(hex.length() == 1) 
	              hexString.append('0');
	            hexString.append(hex);
	        }
	        return hexString.toString();
	    } catch(Exception ex){
	       throw new RuntimeException(ex);
	    }
	
	
	}
}
