package com.etascioglu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
// MODELLER GELDÝ
import com.etascioglu.dao.KullaniciDAO;
import com.etascioglu.dao.SiparisDAO;
import com.etascioglu.model.Kullanici;
import com.etascioglu.model.Siparis;
import com.etascioglu.model.Urun;
import com.etascioglu.utility.hazirutility;

public class SiparisDAO {
private Connection conn;
	
	public SiparisDAO() {
		conn = hazirutility.getConnection();
	}
	
	
	public void siparisekle(Siparis siparis) {
		try {
            String query = "insert into siparis (kullanici_id, urun_id) values (?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setInt(1, siparis.getkullanici_id());
            preparedStatement.setInt(2, siparis.geturun_id());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}


	public void siparissil(int urun_id, int kullanici_id) {
		try {
            String query = "delete from siparis where siparis.kullanici_id = ? and siparis.urun_id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, kullanici_id);
            preparedStatement.setInt(2, urun_id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	public List<Urun> siparisgoster(int kullanici_id) {
		List<Urun> urunler = new ArrayList<Urun>();
        try {
        	String query = "select * from urun as p inner join siparis as o on o.urun_id = p.id where o.kullanici_id = ?";
        	PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setInt(1, kullanici_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while( resultSet.next() ) {
            	Urun urun = new Urun();
            	urun.setId( resultSet.getInt("id"));
            	urun.setisim(resultSet.getString("isim"));
            	urun.setaciklama(resultSet.getString("aciklama"));
            	urun.setfiyat(resultSet.getString("fiyat"));
                urunler.add(urun);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return urunler;
	}
}
