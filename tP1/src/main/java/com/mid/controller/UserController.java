package com.mid.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mid.dao.InterfaceUserDao;
import com.mid.dao.UserDao;
import com.mid.model.User;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/index1")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	InterfaceUserDao mang;
	
	@Override
	public void init() throws ServletException {
		mang = new UserDao();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("connecter")){
		try {		
		String email_enterd = request.getParameter("email");
		String password_enterd = request.getParameter("password");
		
		 User  u =  mang.selectUser(email_enterd);
		
		 //affichage dans la console du serveur 
		 System.out.println(u.getEmail());
		 System.out.println(u.getPassword());		 
		 System.out.println(u.getRole());
		 
		 if(u.getEmail().equals(email_enterd) && u.getPassword().equals(password_enterd)) {
			 request.getSession().setAttribute("role", u.getRole());
			 response.sendRedirect("list.jsp");
			 
		 }
		 else {
			 String er = "coordonnées erronées";
			 request.setAttribute("error", er);
			 request.getRequestDispatcher("login.jsp").forward(request, response);
		 }
		}catch(NullPointerException e) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

		
	}
 }
}
