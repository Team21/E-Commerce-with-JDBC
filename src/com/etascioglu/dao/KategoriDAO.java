package com.etascioglu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.etascioglu.model.Kategori;
import com.etascioglu.utility.hazirutility;
import com.mysql.jdbc.Statement;

public class KategoriDAO  {
	private Connection conn;
	public KategoriDAO() {
		conn = hazirutility.getConnection();
	}

	
	public void addKullanici(Kategori kategori) {
		try {
            String query = "insert into kategori (name, created_at, updated_at) values (?, now(), now())";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setString( 1, kategori.getisim());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	
	public void deleteCategory(int id) {
		try {
            String query = "delete from kategori where id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	
	public void updateCategory(Kategori category) {
		try {
            String query = "update kategori set isim = ? where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setString( 1, category.getisim() );
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	
	public Kategori getCategoryById(int id) {
		Kategori category = new Kategori();
        try {
            String query = "select * from kategori where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while( resultSet.next() ) {
                category.setId(resultSet.getInt("id"));
                category.setisim(resultSet.getString("name"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }
	
	public List<Kategori> tumKatagoriler() {
		List<Kategori> categories = new ArrayList<Kategori>();
		try {
			Statement statement = (Statement) conn.createStatement();
			ResultSet resultSet = statement.executeQuery( "select * from kategori" );
			while( resultSet.next() ) {
				Kategori category = new Kategori();
				category.setId(resultSet.getInt("id"));
				category.setisim(resultSet.getString("isim"));
				categories.add(category);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return categories;
	}
}