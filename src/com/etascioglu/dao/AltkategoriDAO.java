package com.etascioglu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.etascioglu.dao.AltkategoriDAO;
import com.etascioglu.model.Altkategori;

import com.etascioglu.utility.hazirutility;

public class AltkategoriDAO {
private Connection conn;
	
	public AltkategoriDAO() {
		conn = hazirutility.getConnection();
	}
	

	public void altkategoriekle(Altkategori altkategori) {
		try {
            String query = "insert into alt_kategori (isim) values (?)";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setString( 1, altkategori.getisim());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}


	public void altkategorisil(int id) {
		try {
            String query = "delete from alt_kategori where id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}


	public void altkategoriguncelle(Altkategori altkategori) {
		try {
            String query = "update alt_kategori set isim = ? where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setString( 1, altkategori.getisim() );
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}


	public Altkategori getSubCategoryById(int id) {
		Altkategori altkategori = new Altkategori();
        try {
            String query = "select * from altkategori where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while( resultSet.next() ) {
            	altkategori.setId(resultSet.getInt("id"));
            	altkategori.setisim(resultSet.getString("isim"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return altkategori;
	}
}
