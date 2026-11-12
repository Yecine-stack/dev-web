package com.example.demo.services;

import com.example.demo.entities.Membre;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.repositories.MembreRepository;
import com.example.demo.repositories.EtudiantRepository;
import com.example.demo.repositories.EnseignantChercheurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberImpl implements IMemberService {

	private final MembreRepository memberRepository;
	private final EtudiantRepository etudiantRepository;
	private final EnseignantChercheurRepository enseignantChercheurRepository;

	// Manual constructor to replace @AllArgsConstructor
	public MemberImpl(MembreRepository memberRepository, EtudiantRepository etudiantRepository, EnseignantChercheurRepository enseignantChercheurRepository) {
		this.memberRepository = memberRepository;
		this.etudiantRepository = etudiantRepository;
		this.enseignantChercheurRepository = enseignantChercheurRepository;
	}

	@Override
	public Membre addMember(Membre m) {
		return memberRepository.save(m);
	}

	@Override
	public void deleteMember(Long id) {
		memberRepository.deleteById(id);
	}

	@Override
	public Membre updateMember(Membre m) {
		return memberRepository.saveAndFlush(m);
	}

	@Override
	public Membre findMember(Long id) {
		return memberRepository.findById(id).orElse(null);
	}

	@Override
	public List<Membre> findAll() {
		return memberRepository.findAll();
	}

	@Override
	public Membre findByCin(String cin) {
		return memberRepository.findByCin(cin);
	}

	@Override
	public Membre findByEmail(String email) {
		return memberRepository.findByEmail(email);
	}

	@Override
	public List<Membre> findByNom(String nom) {
		return memberRepository.findByNom(nom);
	}

	@Override
	public List<Etudiant> findByDiplome(String diplome) {
		return memberRepository.findByDiplome(diplome);
	}

	@Override
	public List<EnseignantChercheur> findByGrade(String grade) {
		return enseignantChercheurRepository.findByGrade(grade);
	}

	@Override
	public List<EnseignantChercheur> findByEtablissement(String etablissement) {
		return enseignantChercheurRepository.findByEtablissement(etablissement);
	}
    
	@Override
	public void affecter_EtudiantToEnseignat(Long idEtudiant, Long idEnseignat) {
		Etudiant etudiant = (Etudiant) memberRepository.findById(idEtudiant).orElse(null);
		EnseignantChercheur enseignant = (EnseignantChercheur) memberRepository.findById(idEnseignat).orElse(null);
        
		if (etudiant != null && enseignant != null) {
			etudiant.setEncadrant(enseignant);
			memberRepository.save(etudiant);
			System.out.println("L'étudiant " + etudiant.getNom() + " a été affecté à l'enseignant " + enseignant.getNom());
		}
	}
    
	@Override
	public List<Etudiant> findEtudiantsByEnseignant(EnseignantChercheur ens) {
		return etudiantRepository.findByEncadrant(ens);
	}
}
