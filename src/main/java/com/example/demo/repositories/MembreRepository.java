package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Membre;
import com.example.demo.entities.Etudiant;
import java.util.List;

public interface MembreRepository extends JpaRepository<Membre, Long> {
	Membre findByCin(String cin);
	Membre findByEmail(String email);
	List<Membre> findByNom(String nom);
	List<Etudiant> findByDiplome(String diplome);
}
