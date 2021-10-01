package fr.formation.EvalSpring.models;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.util.Date;


/**
 * The persistent class for the patient database table.
 * 
 */
@Entity
@Table(name="patient")
@Data
public class Patient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	private Adresse adresse;

	@Temporal(TemporalType.DATE)
	private Date dateDeNaissance;

	private String nom;

	private Long numeroSecuriteSociale;

	private String prenom;

	@Enumerated(EnumType.STRING)
	@Column(name = "sexe" , columnDefinition="ENUM('Homme','Femme','Autre')")
	private Sexe sexe;

	//bi-directional many-to-one association to Infirmiere
	@ManyToOne
	private Infirmiere infirmiere;

}