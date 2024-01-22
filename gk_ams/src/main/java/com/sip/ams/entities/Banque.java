package com.sip.ams.entities;

public class Banque {

	private String nomBanque;
	private String adresseBanque;
	private double capitalBanque;

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

	public Banque(String nomBanque, String adresseBanque, double capitalBanque) {
		super();
		this.nomBanque = nomBanque;
		this.adresseBanque = adresseBanque;
		this.capitalBanque = capitalBanque;
	}

	@Override
	public String toString() {
		return "Banque [\nnomBanque=" + nomBanque + ", \nadresseBanque=" + adresseBanque + ", \ncapitalBanque="
				+ capitalBanque + "\n]";
	}

}
