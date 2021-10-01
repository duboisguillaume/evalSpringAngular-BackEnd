package fr.formation.EvalSpring.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.EvalSpring.models.Deplacement;
import fr.formation.EvalSpring.services.DeplacementService;

@RestController
@CrossOrigin
@RequestMapping("deplacements")
public class DeplacementController {

	private DeplacementService deplacementService;

	public DeplacementController(DeplacementService deplacementService) {
		this.deplacementService = deplacementService;
	}

	@PostMapping
	public Deplacement save(@RequestBody Deplacement deplacement) {
		return deplacementService.save(deplacement);
	}

	@GetMapping
	public List<Deplacement> findAll() {
		return deplacementService.findAll();
	}

	@GetMapping("{id}")
	public Deplacement findById(@PathVariable Integer id) {
		return deplacementService.findById(id);
	}

	@DeleteMapping("{id}")
	public void deleteById(@PathVariable Integer id) {
		deplacementService.deleteById(id);
	}

	@GetMapping("infirmieres/{id}")
	public List<Deplacement> findByInfirmiereId(@PathVariable Integer id){
		return deplacementService.findByInfirmiereId(id);
	}
	
	@GetMapping("patients/{id}")
	public List<Deplacement> findByPatientId(@PathVariable Integer id){
		return deplacementService.findByPatientId(id);
	}


}
