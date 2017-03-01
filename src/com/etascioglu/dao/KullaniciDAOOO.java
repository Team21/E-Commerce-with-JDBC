package com.etascioglu.dao;

import com.etascioglu.model.Kullanici;
import java.sql.SQLException;
import com.etascioglu.model.Kullanici;


	public interface KullaniciDAOOO {
	public void kullaniciekle(Kullanici kullanici);
	//public boolean getkullaniciConrol(String email,String parola) throws SQLException;
	//public boolean getKullaniciControl(String eposta, String parola)throws SQLException;
	boolean epostakontrol(String email,String parola) throws SQLException;
}