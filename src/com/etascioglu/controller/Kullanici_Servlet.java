package com.etascioglu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.etascioglu.dao.KullaniciDAO;

import com.etascioglu.model.Kullanici;


@WebServlet("/Kullanici_Servlet")
public class Kullanici_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private KullaniciDAO dao;
    
    public Kullanici_Servlet() {
        super();
        dao = new KullaniciDAO();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Kullanici kullanici = new Kullanici();
		
		kullanici.seteposta(request.getParameter("eposta"));
		kullanici.setparola(request.getParameter("parola"));
		
		
		dao.kullaniciekle(kullanici);
		
		RequestDispatcher view = request.getRequestDispatcher( "register.html" );
		
		request.setAttribute("userEmail", request.getParameter("email"));
        view.forward(request, response);
     
       
        	//response.sendRedirect("index.jsp");
        	//request.getRequestDispatcher("login.jsp").forward(request, response);
        	//JOptionPane.showMessageDialog(null,"Kayýt Baþarýlý-1","BAÞARILI-1",JOptionPane.INFORMATION_MESSAGE); 
        
	}
}