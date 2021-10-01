package fr.formation.EvalSpring.models;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.util.Date;


/**
 * The persistent class for the deplacement database table.
 * 
 */
@Entity
@Table(name="deplacement")
@Data
public class Deplacement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Double cout;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	//bi-directional many-to-one association to Infirmiere
	@ManyToOne
	private Infirmiere infirmiere;

	//bi-directional many-to-one association to Patient
	@ManyToOne
	private Patient patient;
	
}