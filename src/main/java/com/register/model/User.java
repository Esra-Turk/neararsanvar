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
    private List<Cart> cart;
    
    public User(int userID, String name, String surname, String email, String password, String cartID) {
		super();
		this.userID = userID;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.cart = new CartDAO().getCart(cartID);
	}
    
    public User() {
    	super();
    }
    
    public List<HashMap> getCartDetail() {
    	ArrayList<HashMap> list = new ArrayList<>();
    	
    	for(Cart c: cart) {
    		HashMap<String, Integer> map = new HashMap<String, Integer>();
    		map.put("productID", c.getProductId());
    		map.put("itemAmount", c.getItemAmount());
    		list.add(map);
    		
    	}
    	
    	return list;
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
	public List<Cart> getCart() {
		return cart;
	}
	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}
	
	
    
    

}
