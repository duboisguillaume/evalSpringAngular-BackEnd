package fr.formation.EvalSpring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.EvalSpring.models.Deplacement;

public interface DeplacementRepository extends JpaRepository<Deplacement, Integer>{

	List<Deplacement> findByInfirmiereId(Integer id);

	List<Deplacement> findByPatientId(Integer id);

}
