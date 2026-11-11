package com.example.demo.services;

import com.example.demo.entities.Membre;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.EnseignantChercheur;

import java.util.List;

public interface IMemberService {
	Membre addMember(Membre m);
	void deleteMember(Long id);
	Membre updateMember(Membre m);
	Membre findMember(Long id);
	List<Membre> findAll();
	Membre findByCin(String cin);
	Membre findByEmail(String email);
	List<Membre> findByNom(String nom);
	List<Etudiant> findByDiplome(String diplome);
	List<EnseignantChercheur> findByGrade(String grade);
	List<EnseignantChercheur> findByEtablissement(String etablissement);
}
