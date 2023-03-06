package com.example.LoveLive.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the etiqueta database table.
 * 
 */
@Entity
@NamedQuery(name="Etiqueta.findAll", query="SELECT e FROM Etiqueta e")
public class Etiqueta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	//bi-directional many-to-one association to Cancion
	@ManyToOne
	@JoinColumn(name="id_cancion")
	private Cancion cancion;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	public Etiqueta() {
	}
	
	public Etiqueta(int id,Cancion cancion,Usuario usuario) {
		this.id=id;
		this.cancion=cancion;
		this.usuario=usuario;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cancion getCancion() {
		return this.cancion;
	}

	public void setCancion(Cancion cancion) {
		this.cancion = cancion;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}