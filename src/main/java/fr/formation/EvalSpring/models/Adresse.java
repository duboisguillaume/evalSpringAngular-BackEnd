package fr.formation.EvalSpring.models;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;


/**
 * The persistent class for the adresse database table.
 * 
 */
@Entity
@Data
@Table(name="adresse")
public class Adresse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String cp;

	private String numero;

	private String rue;

	private String ville;

}