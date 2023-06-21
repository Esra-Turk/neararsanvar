package com.register.model;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap; 

import cart.model.Cart;
import cart.dao.*;


public class User implements Serializable{
   
	private static final long serialVersionUID = 1L;
	private int userID;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String cartID;
    
    public User(int userID, String name, String surname, String email, String password, String cartID) {
		super();
		this.userID = userID;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.cartID = cartID;
	}
    
    public User() {
    	super();
    }
 
    
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public String getCartID() {
		return this.cartID;
	}
    
}
