package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_mbr", discriminatorType = DiscriminatorType.STRING, length = 3)
@Getter @Setter
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
}
