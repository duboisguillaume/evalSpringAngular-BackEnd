package fr.formation.EvalSpring.services;

import java.util.List;

import fr.formation.EvalSpring.models.Patient;
import fr.formation.EvalSpring.repositories.PatientRepository;

public class PatientServiceImpl implements PatientService {
	
	private PatientRepository patientRepository;
	private AdresseService adresseService;
	


	public PatientServiceImpl(PatientRepository patientRepository, AdresseService adresseService) {
		this.patientRepository = patientRepository;
		this.adresseService = adresseService;
	}



	@Override
	public Patient save(Patient patient) {
		patient.setAdresse(adresseService.save(patient.getAdresse()));
		return patientRepository.save(patient);
	}

	@Override
	public List<Patient> findAll() {
		return patientRepository.findAll();
	}

	@Override
	public Patient findById(Integer id) {
		return patientRepository.findById(id).orElseThrow();
	}

	@Override
	public void deleteById(Integer id) {
		patientRepository.deleteById(id);
	}
	
	

}
