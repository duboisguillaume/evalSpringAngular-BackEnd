package fr.formation.EvalSpring.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.EvalSpring.models.Infirmiere;
import fr.formation.EvalSpring.models.Patient;
import fr.formation.EvalSpring.services.InfirmiereService;

@RestController
@CrossOrigin
@RequestMapping("infirmieres")
public class InfirmiereController {

	private InfirmiereService infirmiereService;

	public InfirmiereController(InfirmiereService infirmiereService) {
		this.infirmiereService = infirmiereService;
	}

	@PostMapping
	public Infirmiere save(@RequestBody Infirmiere infirmiere) {
		return infirmiereService.save(infirmiere);
	}

	@GetMapping
	public List<Infirmiere> findAll() {
		return infirmiereService.findAll();
	}

	@GetMapping("{id}")
	public Optional<Infirmiere> findById(@PathVariable Integer id) {
		return infirmiereService.findById(id);
	}

	@DeleteMapping("{id}")
	public void deleteById(@PathVariable Integer id) {
		infirmiereService.deleteById(id);
	}
	
	@GetMapping("{id}/patients")
	public List<Patient> findPatientByInfirmierId(@PathVariable Integer id){
		return infirmiereService.findPatientByInfirmiereId(id);
	}
	
	@PutMapping
	public Infirmiere update(@RequestBody Infirmiere infirmiere) {
		return infirmiereService.save(infirmiere);
	}
	
	
	
}
