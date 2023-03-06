//modelo Cancion
package com.example.LoveLive.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cancion database table.
 * 
 */
@Entity
@NamedQuery(name="Cancion.findAll", query="SELECT c FROM Cancion c")
public class Cancion implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Temporal(TemporalType.DATE)
	private Date año;

	@Column(name="imagen")
	private String imagen;

	@Column(name="nombre")
	private String nombre;

	@Column(name="precio")
	private int precio;
	
	@Column(name="id_etiquetaU")
	private int id_etiquetaU;

	//bi-directional many-to-one association to Cantante
	@ManyToOne
	@JoinColumn(name="cantante_id")
	private Cantante cantante;
	
	//bi-directional many-to-one association to Etiqueta
	@OneToMany(mappedBy="cancion")
	private List<Etiqueta> etiquetas;

	public Cancion() {
	}
	
	public Cancion(int id,String nombre,Date año,int precio,String imagen,Cantante cantante,int id_etiquetaU) {
		this.id = id;
		this.nombre = nombre;
		this.año = año;
		this.precio = precio;
		this.imagen = imagen;
		this.cantante = cantante;
		this.id_etiquetaU = id_etiquetaU;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getAño() {
		return this.año;
	}

	public void setAño(Date año) {
		this.año = año;
	}

	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return this.precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public Cantante getCantante() {
		return this.cantante;
	}

	public void setCantante(Cantante cantante) {
		this.cantante = cantante;
	}

	public List<Etiqueta> getEtiquetas() {
		return this.etiquetas;
	}

	public void setEtiquetas(List<Etiqueta> etiquetas) {
		this.etiquetas = etiquetas;
	}

	public Etiqueta addEtiqueta(Etiqueta etiqueta) {
		getEtiquetas().add(etiqueta);
		etiqueta.setCancion(this);

		return etiqueta;
	}

	public Etiqueta removeEtiqueta(Etiqueta etiqueta) {
		getEtiquetas().remove(etiqueta);
		etiqueta.setCancion(null);

		return etiqueta;
	}

	public int getId_etiquetaU() {
		return id_etiquetaU;
	}

	public void setId_etiquetaU(int id_etiquetaU) {
		this.id_etiquetaU = id_etiquetaU;
	}
	
	

}  