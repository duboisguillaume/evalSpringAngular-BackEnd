package fr.formation.EvalSpring.services;

import java.util.List;

import fr.formation.EvalSpring.models.Adresse;
import fr.formation.EvalSpring.repositories.AdresseRepository;

public class AdresseServiceImpl implements AdresseService {
	
	private AdresseRepository adresseRepository;

	public AdresseServiceImpl(AdresseRepository adresseRepository) {
		this.adresseRepository = adresseRepository;
	}

	@Override
	public Adresse save(Adresse adresse) {
		Adresse findAdresse = adresseRepository.findByNumeroAndRueAndCpAndVille(adresse.getNumero(),adresse.getRue(),adresse.getCp(),adresse.getVille());
		if(findAdresse==null){
			return adresseRepository.save(adresse);
		}
		return findAdresse;
	}

	@Override
	public List<Adresse> findAll() {
		return adresseRepository.findAll();
	}

	@Override
	public Adresse findById(Integer id) {
		return adresseRepository.findById(id).orElseThrow();
	}

	@Override
	public void deleteById(Integer id) {
		adresseRepository.deleteById(id);
	}
	
	

}
