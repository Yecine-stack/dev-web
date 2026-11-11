package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@DiscriminatorValue("etd")
@Getter @Setter
public class Etudiant extends Membre {
	@Temporal(TemporalType.DATE)
	private Date dateInscription;
	private String diplome;
    
	@ManyToOne
	private EnseignantChercheur encadrant;

	public Etudiant() {
		super();
	}

	public Etudiant(String cin, String nom, String prenom, Date dateNaissance, String cv, String email, String password, Date dateInscription, String diplome) {
		super(cin, nom, prenom, dateNaissance, cv, email, password);
		this.dateInscription = dateInscription;
		this.diplome = diplome;
	}
}
