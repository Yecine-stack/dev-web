package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.EnseignantChercheur;
import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
	List<Etudiant> findByEncadrant(EnseignantChercheur encadrant);
}
