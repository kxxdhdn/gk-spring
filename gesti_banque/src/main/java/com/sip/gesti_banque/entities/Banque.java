package com.sip.gesti_banque.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // On veut que Hibernaate nous crée une table
public class Banque {
	
	@Id // clé primaire et unique
	@GeneratedValue(strategy = GenerationType.AUTO) // La clé primaire est auto-incrément
	private int idBanque;
	private String nomBanque;
	private String adresseBanque;
	private double capitalBanque;
	
	public int getIdBanque() {
		return idBanque;
	}

	public void setIdBanque(int idBanque) {
		this.idBanque = idBanque;
	}

	public String getNomBanque() {
		return nomBanque;
	}

	public void setNomBanque(String nomBanque) {
		this.nomBanque = nomBanque;
	}

	public String getAdresseBanque() {
		return adresseBanque;
	}

	public void setAdresseBanque(String adresseBanque) {
		this.adresseBanque = adresseBanque;
	}

	public double getCapitalBanque() {
		return capitalBanque;
	}

	public void setCapitalBanque(double capitalBanque) {
		this.capitalBanque = capitalBanque;
	}

	@Override
	public String toString() {
		return "Banque [idBanque=" + idBanque + ", nomBanque=" + nomBanque + ", adresseBanque=" + adresseBanque
				+ ", capitalBanque=" + capitalBanque + "]";
	}

	public Banque(int idBanque, String nomBanque, String adresseBanque, double capitalBanque) {
		super();
		this.idBanque = idBanque;
		this.nomBanque = nomBanque;
		this.adresseBanque = adresseBanque;
		this.capitalBanque = capitalBanque;
	}

	public Banque() {
		
	}

}
