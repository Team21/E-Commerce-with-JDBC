package com.etascioglu.model;

public class Kategori {
	
	//ÜRÜNLERÝN KATEGORÝLERÝNE AÝT ÝD VE ÝSÝMLER SONRADAN KATEGORÝ GÝRÝÞÝ OLURSA DÝYE
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