/*package com.etascioglu.controller;
 
 
 
 
 
 
 
 BU LAZIMDI AMA ÇÖZEMEDÝM ÞU AN XD
 
 
 
 
 
 
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etascioglu.dao.KullaniciDAO;
import com.etascioglu.dao.KullaniciDAOOO;

@WebServlet("/register")
public class Kayit_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private KullaniciDAO dao;
    
    public Kayit_Servlet() {
        super();
        dao = new KullaniciDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher( "register.html" );
        view.forward(request, response);	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("eposta");
		String parola = request.getParameter("parola");
		
		try {
			response.getWriter().print(dao.epostakontrol(email,parola));
			//System.out.println("alert('Kayýt Baþarýlý !');");
		} catch (SQLException e) {
			e.printStackTrace();
			//System.out.println("alert('Kayýt Baþarýlý !');");
		}
	}

}
*/