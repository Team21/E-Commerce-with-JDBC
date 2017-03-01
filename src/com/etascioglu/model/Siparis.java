
package com.etascioglu.model;

public class Siparis {	
	private int id;
	private int kullanici_id;
	private int urun_id;
	private boolean kontrol;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getkullanici_id() {
		return kullanici_id;
	}
	public void setkullanici_id(int kullanici_id) {
		this.kullanici_id = kullanici_id;
	}
	public int geturun_id() {
		return urun_id;
	}
	public void seturun_id(int urun_id) {
		this.urun_id = urun_id;
	}
	public boolean getkontrol() {
		return kontrol;
	}
	public void setkontrol(boolean kontrol) {
		this.kontrol = kontrol;
	}	
}