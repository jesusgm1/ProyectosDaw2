package com.example.LoveLive.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.LoveLive.model.Cancion;
import com.example.LoveLive.model.Cantante;
import com.example.LoveLive.model.Etiqueta;
import com.example.LoveLive.repository.Cancionrepo;
import com.example.LoveLive.repository.Cantanterepo;
import com.example.LoveLive.repository.Etiquetarepo;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CancionController {

	 	@Autowired
	 	private Cancionrepo repository;
	 	@Autowired
	 	private Cantanterepo repository1;
	 	@Autowired
	 	private Etiquetarepo repository2;
	 	
	 	//Buscar todos
	 	@GetMapping("/Songs")
	 	public List<Cancion> allPersons(){
	 		//Creo una lista de hashmap para devolver un json
			List<DTO> listaUsuariosDto = new ArrayList<DTO>();
			//leo de repositorio todos los registros
			List<Cancion> usuarios = repository.findAll();
			//Los voy cargar en el DTO
			
			for(Cancion c : usuarios) {				
				DTO dtoUsuaria=new DTO();
				dtoUsuaria.put("id",c.getId());
				dtoUsuaria.put("nombre",c.getNombre());
				dtoUsuaria.put("precio",c.getPrecio());		
				dtoUsuaria.put("año", c.getAño().toString());
				dtoUsuaria.put("imagen",c.getImagen());
				listaUsuariosDto.add(dtoUsuaria);
			}
			
		
			return usuarios;
		}
	 	//buscar uno
	 	@GetMapping("/searchS/{id}")
		public DTO getCollection(HttpServletRequest request, @PathVariable int id) {
			DTO dtoCollection = new DTO();
			Cancion c = repository.findById(id);
			if(c!=null) {
				dtoCollection.put("id", c.getId());
				dtoCollection.put("nombre", c.getNombre());
				dtoCollection.put("precio", c.getPrecio());
				dtoCollection.put("año", c.getAño().toString());
				dtoCollection.put("imagen",c.getImagen());
				dtoCollection.put("cantante_id", c.getCantante().getId());
				dtoCollection.put("id_etiquetaU", c.getId_etiquetaU());
			}else dtoCollection.put("result", "fail");
			return dtoCollection;
		}
	 	//crear uno
		@PostMapping(path="/newsong", produces = MediaType.APPLICATION_JSON_VALUE)
		public void crearUsuario(@RequestBody
		CancionNueva c,HttpServletRequest request) {
			Cantante ca = repository1.findById(c.cantante_id);
			repository.save(new Cancion(c.id, c.nombre,c.año,c.precio,c.imagen,ca,c.id_etiquetaU));
		  }
		//clase constructor y metodo para crear
		
		static class CancionNueva{
		    int id;
			String nombre;
			Date año;
			int precio;
			String imagen;
			int cantante_id;
			int id_etiquetaU;
		  	
			
				public CancionNueva(int id,String nombre,Date año, int precio,String imagen,int cantante_id,int id_etiquetaU) {
					super();
					this.id = id;
					this.nombre = nombre;
					this.año = año;
					this.precio = precio;
					this.imagen = imagen;
					this.cantante_id = cantante_id;
					this.id_etiquetaU = id_etiquetaU;
				}
		  	}
		
		//metodo de borrar
		@DeleteMapping("/deleteS/{id}")
		public String deleteSong(@PathVariable int id) {
			Cancion c = repository.findById(id);
			if(c != null) {
				repository.deleteById(id);
				return "Eliminado correctamente.";
			}
			else {
				return "No encontrado.";
			}
		}
		
		//metodo de actualizar
		@PutMapping("/editS/{id}")
		public String updateSong(@RequestBody
				CancionNueva c1, @PathVariable int id) {
			Cancion c = repository.findById(id);
			if(c1 != null) {
				c.setId(c1.id);
				c.setNombre(c1.nombre);
				c.setAño(c1.año);
				c.setPrecio(c1.precio);
				c.setImagen(c1.imagen);
				c.setCantante(repository1.findById(c1.cantante_id));
				c.setId_etiquetaU(c1.id_etiquetaU);
				repository.save(c);
				return "Actualizado correctamente.";
			}
			else {
				return "No encontrado.";
			}
	 	
}
}
