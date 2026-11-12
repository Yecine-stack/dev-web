package com.example.demo.controllers;

import com.example.demo.entities.Etudiant;
import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Membre;
import com.example.demo.services.IMemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class MemberRestController {

	private final IMemberService memberService;

	// Constructor injection (conform to Chapitre 2 - Page 38 & 40)
	public MemberRestController(IMemberService memberService) {
		this.memberService = memberService;
	}

	// GET /membres - Page 38
	@GetMapping("/membres")
	public List<Membre> findMembres() {
		return memberService.findAll();
	}

	// GET /membres/{id} - Page 38
	@GetMapping("/membres/{id}")
	public Membre findOneMemberById(@PathVariable("id") Long id) {
		return memberService.findMember(id);
	}

	// GET /membres/search/cin?cin= - Page 39
	@GetMapping("/membres/search/cin")
	public Membre findOneMemberByCin(@RequestParam("cin") String cin) {
		return memberService.findByCin(cin);
	}

	// GET /membres/search/email?email= - Page 39
	@GetMapping("/membres/search/email")
	public Membre findOneMemberByEmail(@RequestParam("email") String email) {
		return memberService.findByEmail(email);
	}

	// POST /membres/etudiant - Page 41
	@PostMapping("/membres/etudiant")
	public Membre addEtudiant(@RequestBody Etudiant e) {
		return memberService.addMember(e);
	}

	// POST /membres/enseignant - Page 41
	@PostMapping("/membres/enseignant")
	public Membre addEnseignant(@RequestBody EnseignantChercheur m) {
		return memberService.addMember(m);
	}

	// PUT /membres/etudiant/{id} - Page 44
	@PutMapping("/membres/etudiant/{id}")
	public Membre updateEtudiant(@PathVariable("id") Long id, @RequestBody Etudiant p) {
		p.setId(id);
		return memberService.updateMember(p);
	}

	// PUT /membres/enseignant/{id} - Page 44
	@PutMapping("/membres/enseignant/{id}")
	public Membre updateEnseignant(@PathVariable("id") Long id, @RequestBody EnseignantChercheur p) {
		p.setId(id);
		return memberService.updateMember(p);
	}

	// DELETE /membres/{id} - Page 43
	@DeleteMapping("/membres/{id}")
	public void deleteMembre(@PathVariable("id") Long id) {
		memberService.deleteMember(id);
	}
}
