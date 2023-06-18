package com.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.dao.*;

@WebServlet("/pages/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public Logindao dao;
	
	public Login() {
		super();
		this.dao = new Logindao();
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String pass= request.getParameter("password");
	

		if(pass != null) {
				if(dao.check(email, pass)) {
					HttpSession session = request.getSession();
					session.setAttribute("email", email);
					response.sendRedirect("/neararsanvar/index.jsp");
					
				}
				else {
					response.sendRedirect("login.jsp");
				}
			
		}	
		
	}
	
}
