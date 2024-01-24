package com.sip.gesti_banque.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // On veut que Hibernaate nous crée une table
public class Message {

	@Id // clé primaire et unique
	@GeneratedValue(strategy = GenerationType.AUTO) // Hibernate va générer l'id automatiquement avant l'insertion
	private int id;
	private String sujet;
	private String description;
	private LocalDateTime datime;
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSujet() {
		return sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getDatime() {
		return datime;
	}

	public void setDatime(LocalDateTime datime) {
		this.datime = datime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", sujet=" + sujet + ", description=" + description + ", datime=" + datime + ", email=" + email
				+ "]";
	}

	public Message(int id, String sujet, String desc, LocalDateTime datime, String email) {
		super();
		this.id = id;
		this.sujet = sujet;
		this.description = description;
		this.datime = datime;
		this.email = email;
	}

	public Message() {

	}

}
