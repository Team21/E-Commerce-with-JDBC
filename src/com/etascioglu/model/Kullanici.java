package com.etascioglu.model;

public class  Kullanici {
	
	// KULLANICIYA AÝT VERÝTABANINDAKÝ GÝRÝÞ GEREKSÝNÝMLERÝ EPOSTA VE ÞÝFRE ÝLE KAYIT OLSUN
	// ADMÝN KONTROLÜ YAPACÐIZ BÝDE BOOLEAN DEÐER ÝLE ADMÝN MÝ DEÐÝL MÝ.
	
	private int id;
	private boolean adminmi;
	
	private String eposta;
	private String parola;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public boolean getadminmi() {
		return adminmi;
	}
	public void setadminmi(boolean adminmi) {
		this.adminmi = adminmi;
	}
	
	public String geteposta() {
		return eposta;
	}
	public void seteposta(String eposta) {
		this.eposta = eposta;
	}
	
	public String getparola() {
		return parola;
	}
	public void setparola(String parola) {
		this.parola = parola;
	}
	
}