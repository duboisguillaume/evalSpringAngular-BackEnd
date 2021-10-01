package fr.formation.EvalSpring.services;

import java.util.List;

import fr.formation.EvalSpring.models.Patient;

public interface PatientService {

	Patient save(Patient patient);

	List<Patient> findAll();

	Patient findById(Integer id);

	void deleteById(Integer id);

}