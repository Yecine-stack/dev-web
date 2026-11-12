package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.EnseignantChercheur;
import java.util.List;

public interface EnseignantChercheurRepository extends JpaRepository<EnseignantChercheur, Long> {
	List<EnseignantChercheur> findByGrade(String grade);
	List<EnseignantChercheur> findByEtablissement(String etablissement);
}
