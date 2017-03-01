package com.etascioglu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.etascioglu.dao.KullaniciDAO;
import com.etascioglu.model.Kullanici;
import com.etascioglu.utility.hazirutility;
import com.etascioglu.dao.KullaniciDAOOO;
public class KullaniciDAO implements KullaniciDAOOO {
private Connection conn;
	public KullaniciDAO()  {
		conn = hazirutility.getConnection();
	}
	//EKLE METODU
	@Override
	public void kullaniciekle(Kullanici kullanici) {
		try {
            String query = "insert into kullanici (eposta, parola) values (?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setString( 1, kullanici.geteposta());
            preparedStatement.setString( 2, kullanici.getparola());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	//SÝL METODU
	public void kullanicisil(int id) {
		try {
            String query = "delete from kullanici where id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	//GUNCELLE METODU
	public void kullaniciguncelle(Kullanici kullanici) {
		try {
            String query = "update kategori set eposta = ?, parola = ? where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setString( 1, kullanici.geteposta());
            preparedStatement.setString( 1, kullanici.getparola());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	// KAYIT YAPARKENKÝ KISIM
	@Override
	public boolean epostakontrol(String email,String parola) throws SQLException {
			PreparedStatement preparedStatement = null;
        try {
            String query = "select eposta from kullanici where eposta=?";
            preparedStatement = conn.prepareStatement( query );
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	preparedStatement.close();
		}
		return false;
        
	}
	// BUNA GEREK YOK SANIRIM ADMÝN@ADMÝNSE EKLE SÝLE GEÇ DEÝRM
	public boolean isAdmin(int id) {
		PreparedStatement preparedStatement = null;
        try {
            String query = "select id from users where id = ? and is_admin = true";
            preparedStatement = conn.prepareStatement( query );
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return false;
	}
	public Kullanici kontrolgiris( String eposta, String parola) {
		PreparedStatement preparedStatement = null;
		Kullanici kullanici = new Kullanici();

        try {
            String query = "select * from kullanici where eposta = ? and parola= ?";
            preparedStatement = conn.prepareStatement( query );
            preparedStatement.setString(1, eposta);
            preparedStatement.setString(2, parola);
            ResultSet resultSet = preparedStatement.executeQuery();
            while( resultSet.next() ) {
                kullanici.setId(resultSet.getInt("id"));
                kullanici.seteposta(resultSet.getString("eposta"));
                kullanici.setadminmi(resultSet.getBoolean("adminmi"));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return kullanici;
	}
	
	
}