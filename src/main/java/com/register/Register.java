package com.register;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.register.dao.Registerdao;


import com.register.model.User;

@WebServlet("/pages/register")
public class Register extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
	private Registerdao dao;

    public void init() {
        this.dao = new Registerdao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = new User();
        
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setPassword(password);

        try {
            dao.registerUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("login.jsp");
    }
}
