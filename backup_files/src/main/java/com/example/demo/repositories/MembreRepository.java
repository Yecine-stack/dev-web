package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Membre;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.EnseignantChercheur;
import java.util.List;

public interface MembreRepository extends JpaRepository<Membre, Long> {
	Membre findByCin(String cin);
	Membre findByEmail(String email);
	List<Membre> findByNom(String nom);
	List<Etudiant> findByDiplome(String diplome);
	List<EnseignantChercheur> findByGrade(String grade);//enseignant chercheur repository and fix in impl
	List<EnseignantChercheur> findByEtablissement(String etablissement);//same
}



//must have ensegnant rpository (cours)
