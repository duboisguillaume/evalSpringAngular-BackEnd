package fr.formation.EvalSpring.services;

import java.util.List;

import fr.formation.EvalSpring.models.Deplacement;
import fr.formation.EvalSpring.repositories.DeplacementRepository;

public class DeplacementServiceImpl implements DeplacementService {
	
	private DeplacementRepository deplacementRepository;

	public DeplacementServiceImpl(DeplacementRepository deplacementRepository) {
		this.deplacementRepository = deplacementRepository;
	}

	@Override
	public Deplacement save(Deplacement deplacement) {
		return deplacementRepository.save(deplacement);
	}

	@Override
	public List<Deplacement> findAll() {
		return deplacementRepository.findAll();
	}

	@Override
	public Deplacement findById(Integer id) {
		return deplacementRepository.findById(id).orElseThrow();
	}

	@Override
	public void deleteById(Integer id) {
		deplacementRepository.deleteById(id);
	}

	@Override
	public List<Deplacement> findByInfirmiereId(Integer id) {
		return deplacementRepository.findByInfirmiereId(id);
	}

	@Override
	public List<Deplacement> findByPatientId(Integer id) {
		return deplacementRepository.findByPatientId(id);
	}
	
	 
	

}
