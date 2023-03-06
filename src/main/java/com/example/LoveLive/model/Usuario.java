package com.example.LoveLive.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="nombre")
	private String nombre;

	@Column(name="pass")
	private String pass;
	
	@Column(name="id_etiquetaC")
	private int id_etiquetaC;

	//bi-directional many-to-one association to Etiqueta
	@OneToMany(mappedBy="usuario")
	private List<Etiqueta> etiquetas;

	public Usuario() {
	}
	
	public Usuario(int id,String nombre,String pass,int id_etiquetaC) {
		this.id=id;
		this.nombre=nombre;
		this.pass=pass;
		this.id_etiquetaC = id_etiquetaC;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	


	public List<Etiqueta> getEtiquetas() {
		return this.etiquetas;
	}

	public void setEtiquetas(List<Etiqueta> etiquetas) {
		this.etiquetas = etiquetas;
	}

	public Etiqueta addEtiqueta(Etiqueta etiqueta) {
		getEtiquetas().add(etiqueta);
		etiqueta.setUsuario(this);

		return etiqueta;
	}

	public Etiqueta removeEtiqueta(Etiqueta etiqueta) {
		getEtiquetas().remove(etiqueta);
		etiqueta.setUsuario(null);

		return etiqueta;
	}

	public int getId_etiquetaC() {
		return id_etiquetaC;
	}

	public void setId_etiquetaC(int id_etiquetaC) {
		this.id_etiquetaC = id_etiquetaC;
	}

}
	
