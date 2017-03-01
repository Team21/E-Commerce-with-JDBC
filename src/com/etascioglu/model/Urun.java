package com.etascioglu.model;
public class Urun {
	// VER� TABANINDA �R�N TABLOSUNDA YER ALACAK �EMALARIMIZ BUNLAR
	// BU MODEL ANA EKRANDAK� MODELLERE DENK GELECEK T�M KATEGOR�LERDEK� G�B� ��TE
	// URUNLER�M�N �D S� �SM� F�YATI A�IKLAMASI RESM� VE KATEGOR� NUMARASINI MODELLED�M
	
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