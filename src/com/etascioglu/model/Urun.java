package com.etascioglu.model;
public class Urun {
	// VERÝ TABANINDA ÜRÜN TABLOSUNDA YER ALACAK ÞEMALARIMIZ BUNLAR
	// BU MODEL ANA EKRANDAKÝ MODELLERE DENK GELECEK TÜM KATEGORÝLERDEKÝ GÝBÝ ÝÞTE
	// URUNLERÝMÝN ÝD SÝ ÝSMÝ FÝYATI AÇIKLAMASI RESMÝ VE KATEGORÝ NUMARASINI MODELLEDÝM
	
	private int id;
	private String isim;
	private String fiyat;	
	private String aciklama;
	private String resim;
	private int kategoriid;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getisim() {
		return isim;
	}
	public void setisim(String isim) {
		this.isim = isim;
	}
	public String getfiyat() {
		return fiyat;
	}
	public void setfiyat(String fiyat) {
		this.fiyat = fiyat;
	}
	public String getaciklama() {
		return aciklama;
	}
	public void setaciklama(String aciklama) {
		this.aciklama = aciklama;
	}
	public String getresim() {
		return resim;
	}
	public void setresim(String resim) {
		this.resim = resim;
	}
	public int getkategoriid() {
		return kategoriid;
	}
	public void setkategoriid(int kategoriid) {
		this.kategoriid = kategoriid;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", isim=" + isim + ", fiyat=" + fiyat + ", aciklama=" + aciklama + ", resim="
				+ resim + ", kategoriid=" + kategoriid + "]";
	}
}