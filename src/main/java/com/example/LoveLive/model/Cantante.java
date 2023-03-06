package com.example.LoveLive.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cantante database table.
 * 
 */
@Entity
@NamedQuery(name="Cantante.findAll", query="SELECT c FROM Cantante c")
public class Cantante implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="edad")
	private int edad;

	@Column(name="nombre")
	private String nombre;

	//bi-directional many-to-one association to Cancion
	@OneToMany(mappedBy="cantante")
	private List<Cancion> cancions;

	public Cantante() {
	}
	
	public Cantante(int id,String nombre,int edad) {
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Cancion> getCancions() {
		return this.cancions;
	}

	public void setCancions(List<Cancion> cancions) {
		this.cancions = cancions;
	}

	public Cancion addCancion(Cancion cancion) {
		getCancions().add(cancion);
		cancion.setCantante(this);

		return cancion;
	}

	public Cancion removeCancion(Cancion cancion) {
		getCancions().remove(cancion);
		cancion.setCantante(null);

		return cancion;
	}

}