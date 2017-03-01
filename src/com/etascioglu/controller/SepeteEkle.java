package com.etascioglu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.etascioglu.dao.SiparisDAO;
import com.etascioglu.model.Siparis;

@WebServlet("/SepeteEkle")
public class SepeteEkle extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SiparisDAO dao;
    
    public SepeteEkle() {
        super();
        dao = new SiparisDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));	
		Siparis siparis = new Siparis(); 
		HttpSession session = request.getSession();
		int kullanici_id = (int) session.getAttribute("kullanici_id");
		siparis.setkullanici_id(kullanici_id);
		siparis.seturun_id(id);
			dao.siparisekle(siparis);
					//ArrayList<Urun> sepet = (ArrayList<Urun>) request.getSession().getAttribute("Sepetim");		
					//try {
			//sepet.addAll(dao.tekUrunGetir(id));
			
			
			//} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			//}
			
			//request.getRequestDispatcher("index").forward(request, response);
			response.sendRedirect("index.jsp");
		
		//doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
