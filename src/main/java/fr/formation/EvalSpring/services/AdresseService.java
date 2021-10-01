package fr.formation.EvalSpring.services;

import java.util.List;

import fr.formation.EvalSpring.models.Adresse;

public interface AdresseService {

	Adresse save(Adresse adresse);

	List<Adresse> findAll();

	Adresse findById(Integer id);

	void deleteById(Integer id);

}