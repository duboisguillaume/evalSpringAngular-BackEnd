package fr.formation.EvalSpring.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;


/**
 * The persistent class for the infirmiere database table.
 * 
 */
@Entity
@Table(name="infirmiere")
@Data
public class Infirmiere implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nom;

	private Integer numeroProfessionnel;

	private String prenom;

	private String telPerso;

	private String telPro;

	//bi-directional many-to-one association to Adresse
	@ManyToOne
	private Adresse adresse;

}