package com.etascioglu.model;

public class Kategori {
	
	//�R�NLER�N KATEGOR�LER�NE A�T �D VE �S�MLER SONRADAN KATEGOR� G�R��� OLURSA D�YE
	private int id;
	private String isim;
	
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	public String getisim(){
		return isim;
	}
	public void setisim(String isim){
		this.isim = isim;
	}
}