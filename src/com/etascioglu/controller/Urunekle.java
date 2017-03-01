package com.etascioglu.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.etascioglu.dao.UrunDAO;
import com.etascioglu.model.Urun;
import com.etascioglu.utility.*;


@WebServlet("/Urunekle")
public class Urunekle extends HttpServlet {
	private static final long serialVersionUID = 1L;  
	private UrunDAO dao;
    public Urunekle() {	
        super();  
        dao = new UrunDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		Urun urun = new Urun();
		urun.setisim(request.getParameter("isim"));
		urun.setfiyat(request.getParameter("fiyat"));
		urun.setaciklama(request.getParameter("aciklama"));
		urun.setresim(request.getParameter("resim"));	
		urun.setkategoriid(1);
		
		
		dao.urunekle(urun);
		
		RequestDispatcher view = request.getRequestDispatcher( "urunEkleAdmin.jsp" );	
		view.forward(request, response);
	//    request.setAttribute("userEmail", request.getParameter("isim"));
        
        
       // JOptionPane.showMessageDialog(null,"Ürün eklendi xd","BAÞARILI",JOptionPane.INFORMATION_MESSAGE);
	
	}
}	




		/*String isim = request.getParameter("isim");
		String fiyat = request.getParameter("fiyat");
		String aciklama = request.getParameter("aciklama");
		String resim=request.getParameter("resim");
		
		if(isim!="" && aciklama!="" && fiyat!=""){
			/*Urun urun=new Urun();
			urun.setisim(isim);
			urun.setaciklama(aciklama);
			urun.setfiyat(fiyat);
			urun.setresim(resim);		
		}
		else{			
		System.out.println("hata büyük");
		response.sendRedirect("urunEkle");	*/
			