package fr.formation.EvalSpring.services;

import java.util.List;

import fr.formation.EvalSpring.models.Deplacement;

public interface DeplacementService {

	Deplacement save(Deplacement deplacement);

	List<Deplacement> findAll();

	Deplacement findById(Integer id);

	void deleteById(Integer id);

	List<Deplacement> findByInfirmiereId(Integer id);

	List<Deplacement> findByPatientId(Integer id);

}