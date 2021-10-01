package fr.formation.EvalSpring.services;

import java.util.List;
import java.util.Optional;

import fr.formation.EvalSpring.models.Infirmiere;
import fr.formation.EvalSpring.models.Patient;

public interface InfirmiereService {

	Infirmiere save(Infirmiere infirmiere);

	List<Infirmiere> findAll();

	Optional<Infirmiere> findById(Integer id);

	void deleteById(Integer id);

	List<Patient> findPatientByInfirmiereId(Integer id);

}