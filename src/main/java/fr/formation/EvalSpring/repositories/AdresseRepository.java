package fr.formation.EvalSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.EvalSpring.models.Adresse;

public interface AdresseRepository extends JpaRepository<Adresse, Integer> {

	Adresse findByNumeroAndRueAndCpAndVille(String numero, String rue, String cp, String ville);

}
