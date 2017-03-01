package com.etascioglu.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.etascioglu.model.Kategori;
import com.etascioglu.model.Urun;
import com.etascioglu.utility.hazirutility;
import com.mysql.jdbc.Statement;


public class UrunDAO {
	//staticyaptýk
private static Connection conn;
private static PreparedStatement psmt = null;
private static ResultSet rs = null;

	public UrunDAO() {
		conn = hazirutility.getConnection();
	}
	//ADMÝN URUN EKLEYECEK!
	public void urunekle(Urun urun) {
		try {
            String query = "insert into urun (isim, fiyat, aciklama, resim, kategoriid) values (?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setString(1, urun.getisim());
            preparedStatement.setString(2, urun.getfiyat());
            preparedStatement.setString(3, urun.getaciklama());
            preparedStatement.setString(4, urun.getresim());  
            preparedStatement.setInt(5, urun.getkategoriid());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	public void urunsil(int id) {
		try {
            String query = "delete from urun where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}


	public void urunguncelle(Urun urun) {
		try {
            String query = "update urun set isim = ?, aciklama = ?, resim = ?, fiyat = ? kategoriid = ? where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setString( 1, urun.getisim());
            preparedStatement.setString( 2, urun.getaciklama());
            preparedStatement.setString( 3, urun.getresim());
            preparedStatement.setString( 4, urun.getfiyat());
            preparedStatement.setInt( 5, urun.getkategoriid());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	public Urun getProductById(int id) {
		Urun urun = new Urun();
        try {
            String query = "select * from urun where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while( resultSet.next() ) {
            	urun.setId( resultSet.getInt("id"));
                urun.setaciklama(resultSet.getString("aciklama"));
                urun.setisim(resultSet.getString("isim"));
                urun.setresim(resultSet.getString("resim"));
                urun.setfiyat(resultSet.getString("fiyat"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return urun;
	}
	public List<Urun> tumUrunler() {
		List<Urun> categories = new ArrayList<Urun>();
		try {
			Statement statement = (Statement) conn.createStatement();
			ResultSet resultSet = statement.executeQuery( "select * from urun" );	
			while( resultSet.next() ) {
				Urun category = new Urun();
				category.setId(resultSet.getInt("id"));
				category.setisim(resultSet.getString("isim"));
				category.setfiyat(resultSet.getString("fiyat"));
				category.setaciklama(resultSet.getString("aciklama"));
				category.setresim(resultSet.getString("resim"));
				categories.add(category);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categories;
	}
	// SEPETE ÜRÜN EKLEMEK ÝÇÝN YAZDIK.
	public static ArrayList<Urun> tekUrunGetir(int urunID) throws SQLException {
		ArrayList<Urun> urun = new ArrayList<Urun>();
		try {	
			
			Statement statement = (Statement) conn.createStatement();
			//con = ConnectionDao.getConnection();
			
			psmt = conn.prepareStatement("select * from Urun where id=?;"); 
			psmt.setInt(1, urunID);
			rs = psmt.executeQuery();
			if (rs.next()) {
				Urun urunler = new Urun();
				urunler.setId(rs.getInt(1));
				urunler.setisim(rs.getString(2));
				urunler.setaciklama(rs.getString(3));
				urunler.setfiyat(rs.getString(4));
				//urunler.setUrunMiktar(rs.getInt(5));
				//urunler.setKategori_kategoriId(rs.getInt(8));
				urun.add(urunler);			
			}
			conn.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				conn.close();
				psmt.close();
				rs.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return urun;
	}	
	
		
}
