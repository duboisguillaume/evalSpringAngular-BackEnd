package fr.formation.EvalSpring.services;

import java.util.List;
import java.util.Optional;

import fr.formation.EvalSpring.models.Infirmiere;
import fr.formation.EvalSpring.models.Patient;
import fr.formation.EvalSpring.repositories.InfirmiereRepository;
import fr.formation.EvalSpring.repositories.PatientRepository;

public class InfirmiereServiceImpl implements InfirmiereService {

	private InfirmiereRepository infirmiereRepository;
	private PatientRepository patientRepository;
	private AdresseService adresseService;


	public InfirmiereServiceImpl(InfirmiereRepository infirmiereRepository, PatientRepository patientRepository,
			AdresseService adresseService) {
		this.infirmiereRepository = infirmiereRepository;
		this.patientRepository = patientRepository;
		this.adresseService = adresseService;
	}


	@Override
	public Infirmiere save(Infirmiere infirmiere) {
		infirmiere.setAdresse(adresseService.save(infirmiere.getAdresse()));
		return infirmiereRepository.save(infirmiere);
	}

	@Override
	public List<Infirmiere> findAll() {
		return infirmiereRepository.findAll();
	}

	@Override
	public Optional<Infirmiere> findById(Integer id) {
		return infirmiereRepository.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		infirmiereRepository.deleteById(id);
	}

	@Override
	public List<Patient> findPatientByInfirmiereId(Integer id) {
		return patientRepository.findByInfirmiereId(id);
	}
	
	
}
