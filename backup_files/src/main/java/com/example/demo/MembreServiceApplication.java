package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.demo.entities.Etudiant;
import com.example.demo.repositories.MembreRepository;
import java.util.Date;

@SpringBootApplication
public class MembreServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MembreServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner testDatabase(MembreRepository membreRepository) {
		return args -> {
			// Using standard constructor instead of Builder
			Etudiant etd1 = new Etudiant(
					"1111", "Ali", "Ahmed", new Date(), 
					"cv1.pdf", "ali@gmail.com", "123", new Date(), "Master"
			);

			Etudiant etd2 = new Etudiant(
					"2222", "Sami", "Sara", new Date(), 
					"cv2.pdf", "sara@gmail.com", "456", new Date(), "Ingenieur"
			);

			membreRepository.save(etd1);
			membreRepository.save(etd2);
			System.out.println("2 Etudiants enregistres avec succes !");

			var masters = membreRepository.findByDiplome("Master");
			System.out.println("Nombre d'etudiants en Master : " + masters.size());
		};
	}
}
