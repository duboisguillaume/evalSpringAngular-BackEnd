package fr.formation.EvalSpring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fr.formation.EvalSpring.repositories.AdresseRepository;
import fr.formation.EvalSpring.repositories.DeplacementRepository;
import fr.formation.EvalSpring.repositories.InfirmiereRepository;
import fr.formation.EvalSpring.repositories.PatientRepository;
import fr.formation.EvalSpring.services.AdresseService;
import fr.formation.EvalSpring.services.AdresseServiceImpl;
import fr.formation.EvalSpring.services.DeplacementService;
import fr.formation.EvalSpring.services.DeplacementServiceImpl;
import fr.formation.EvalSpring.services.InfirmiereService;
import fr.formation.EvalSpring.services.InfirmiereServiceImpl;
import fr.formation.EvalSpring.services.PatientService;
import fr.formation.EvalSpring.services.PatientServiceImpl;

@Configuration
public class AppConfig {

	@Bean
	public InfirmiereService infirmiereService(InfirmiereRepository infirmiereRepository, PatientRepository patientRepository,
			AdresseService adresseService) {
		return new InfirmiereServiceImpl(infirmiereRepository, patientRepository, adresseService);
	}

	@Bean
	public PatientService patientService(PatientRepository patientRepository, AdresseService adresseService) {
		return new PatientServiceImpl(patientRepository, adresseService);
	}

	@Bean 
	DeplacementService deplacementService(DeplacementRepository deplacementRepository) {
		return new DeplacementServiceImpl(deplacementRepository);
	}

	@Bean 
	AdresseService adresseService(AdresseRepository adresseRepository) {
		return new AdresseServiceImpl(adresseRepository);
	}
}
