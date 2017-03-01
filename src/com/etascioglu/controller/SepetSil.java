package com.etascioglu.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etascioglu.model.Urun;

@WebServlet("/SepetSil")
public class SepetSil extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SepetSil() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("urunid"));
		@SuppressWarnings("unchecked")
		ArrayList<Urun> sepet = (ArrayList<Urun>) request.getSession().getAttribute("cart");
		
		sepet.remove(id);
		request.getRequestDispatcher("cart").forward(request, response);
	}

}
