package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@DiscriminatorValue("ens")
@Getter @Setter
public class EnseignantChercheur extends Membre {
	private String grade;
	private String etablissement;

	public EnseignantChercheur() {
		super();
	}
}
