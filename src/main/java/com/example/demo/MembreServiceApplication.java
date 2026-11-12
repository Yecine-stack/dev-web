package com.example.demo;

import com.example.demo.entities.Etudiant;
import com.example.demo.services.IMemberService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import java.util.Date;

@SpringBootApplication
@EnableDiscoveryClient
public class MembreServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MembreServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner testDatabase(IMemberService memberService) {
		return args -> {
			// Create 2 students using standard constructor
			Etudiant etd1 = new Etudiant(
					"1111", "Ali", "Ahmed", new Date(), 
					"cv1.pdf", "ali@gmail.com", "123", new Date(), "Master"
			);

			Etudiant etd2 = new Etudiant(
					"2222", "Sami", "Sara", new Date(), 
					"cv2.pdf", "sara@gmail.com", "456", new Date(), "Ingenieur"
			);

			// Use the Service layer as shown in the PDF
			memberService.addMember(etd1);
			memberService.addMember(etd2);
			System.out.println("2 Etudiants enregistres avec succes via le Service !");

			// Test the find by Diploma via Service
			var masters = memberService.findByDiplome("Master");
			System.out.println("Nombre d'etudiants en Master : " + masters.size());
		};
	}
}
