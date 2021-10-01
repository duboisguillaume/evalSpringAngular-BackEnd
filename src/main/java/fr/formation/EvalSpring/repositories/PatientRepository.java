package fr.formation.EvalSpring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.EvalSpring.models.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer>{

	List<Patient> findByInfirmiereId(Integer id);

}
