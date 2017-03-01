package com.etascioglu.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.etascioglu.dao.KullaniciDAO;
import com.etascioglu.model.Kullanici;

@WebServlet("/Giris")
public class Giris extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  KullaniciDAO dao;
	
    public Giris() {
        super();
        dao = new KullaniciDAO();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.html");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String eposta = request.getParameter("eposta");
		String parola = request.getParameter("parola");
		Kullanici kullanici = dao.kontrolgiris(eposta,parola);
		HttpSession session = request.getSession();
		if (kullanici != null){
			session.setAttribute("eposta", eposta);	
			session.setAttribute("kullanici_id", kullanici.getId());
			if(kullanici.getadminmi()){
				session.setAttribute("admin", kullanici.getadminmi());
				response.sendRedirect("indexAdmin.jsp");		
			
			}else{
				response.sendRedirect("index.jsp");
				
			}
		}else {				
			request.setAttribute("status", "E-Posta adresiniz veya þifre hatalý");
			request.getRequestDispatcher("login.html").forward(request, response);
			//response.sendRedirect(request.getContextPath() + "/index.jsp");
		}
	}
}