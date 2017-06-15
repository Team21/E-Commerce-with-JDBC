package com.etascioglu.dao;

import com.etascioglu.model.Kullanici;
import java.sql.SQLException;

public interface KullaniciDAOOO {
	public void kullaniciekle(Kullanici kullanici);
	boolean epostakontrol(String email,String parola) throws SQLException;
}