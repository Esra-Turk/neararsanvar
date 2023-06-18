package com.register.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.helper.Sha256Coding;
import com.register.model.User;

public class Registerdao {
	 public int registerUser(User user) throws ClassNotFoundException {
		 
	        String sql = "INSERT INTO user" +
	            " (name, surname, email, password, cartID) VALUES " +
	            " (?, ?, ?, ?, ?);";
	        String username = "root";
	        String pass = "123456789";

	        int result = 0;

	        Class.forName("com.mysql.jdbc.Driver");

	        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/neararsanvar?useSSL=false", username,pass);

	            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	            preparedStatement.setString(1, user.getName());
	            preparedStatement.setString(2, user.getSurname());
	            preparedStatement.setString(3, user.getEmail());
	            preparedStatement.setString(4, Sha256Coding.sha256(user.getPassword()));
	            preparedStatement.setString(5, Sha256Coding.sha256(user.getEmail()));
	            
	            System.out.println(preparedStatement);
	            result = preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        return result;
	    }

	 private void printSQLException(SQLException ex) {
	        for (Throwable e: ex) {
	            if (e instanceof SQLException) {
	                e.printStackTrace(System.err);
	                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	                System.err.println("Message: " + e.getMessage());
	                Throwable t = ex.getCause();
	                while (t != null) {
	                    System.out.println("Cause: " + t);
	                    t = t.getCause();
	                }
	            }
	        }

	 }
}
