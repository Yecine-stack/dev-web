package com.example.demo.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_mbr", discriminatorType = DiscriminatorType.STRING, length = 3)
public abstract class Membre implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cin;
	private String nom;
	private String prenom;
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	private String cv;
	private String email;
	private String password;

	public Membre() {
	}

	public Membre(String cin, String nom, String prenom, Date dateNaissance, String cv, String email, String password) {
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.cv = cv;
		this.email = email;
		this.password = password;
	}

	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	public String getCin() { return cin; }
	public void setCin(String cin) { this.cin = cin; }

	public String getNom() { return nom; }
	public void setNom(String nom) { this.nom = nom; }

	public String getPrenom() { return prenom; }
	public void setPrenom(String prenom) { this.prenom = prenom; }

	public Date getDateNaissance() { return dateNaissance; }
	public void setDateNaissance(Date dateNaissance) { this.dateNaissance = dateNaissance; }

	public String getCv() { return cv; }
	public void setCv(String cv) { this.cv = cv; }

	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }

	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
}
