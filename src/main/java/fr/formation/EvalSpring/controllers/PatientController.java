package fr.formation.EvalSpring.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.EvalSpring.models.Patient;
import fr.formation.EvalSpring.services.PatientService;

@RestController
@CrossOrigin
@RequestMapping("patients")
public class PatientController {

	private PatientService patientService;

	public PatientController(PatientService patientService) {
		this.patientService = patientService;
	}

	@PostMapping
	public Patient save(@RequestBody Patient patient) {
		return patientService.save(patient);
	}

	@GetMapping
	public List<Patient> findAll() {
		return patientService.findAll();
	}

	@GetMapping("{id}")
	public Patient findById(@PathVariable Integer id) {
		return patientService.findById(id);
	}

	@DeleteMapping("{id}")
	public void deleteById(@PathVariable Integer id) {
		patientService.deleteById(id);
	}
	
	@PutMapping
	public Patient update(@RequestBody Patient patient) {
		return patientService.save(patient);
	}
	
}
