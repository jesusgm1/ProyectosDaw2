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

import com.example.LoveLive.controller.CancionController.CancionNueva;
import com.example.LoveLive.model.Cancion;
import com.example.LoveLive.model.Cantante;
import com.example.LoveLive.repository.Cantanterepo;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CantanteController {

	 	@Autowired
	 	private Cantanterepo repository1;
	 	
	 	//Buscar todos
	 	@GetMapping("/Singers")
	 	public List<Cantante> allPersons(){
	 		//Creo una lista de hashmap para devolver un json
			List<DTO> listaUsuariosDto = new ArrayList<DTO>();
			//leo de repositorio todos los registros
			List<Cantante> usuarios = repository1.findAll();
			//Los voy cargar en el DTO
			
			for(Cantante ca : usuarios) {				
				DTO dtoUsuaria=new DTO();
				dtoUsuaria.put("id",ca.getId());
				dtoUsuaria.put("nombre",ca.getNombre());
				dtoUsuaria.put("edad",ca.getEdad());		
				listaUsuariosDto.add(dtoUsuaria);
			}
			
		
			return usuarios;
		}
	 	//buscar uno
	 	@GetMapping("/searchSI/{id}")
		public DTO getCollection(HttpServletRequest request, @PathVariable int id) {
			DTO dtoCollection = new DTO();
			Cantante ca = repository1.findById(id);
			if(ca!=null) {
				dtoCollection.put("id", ca.getId());
				dtoCollection.put("nombre", ca.getNombre());
				dtoCollection.put("edad", ca.getEdad());
			}else dtoCollection.put("result", "fail");
			return dtoCollection;
		}
	 	//crear uno
	 			@PostMapping(path="/newsinger", produces = MediaType.APPLICATION_JSON_VALUE)
	 			public void crearUsuario(@RequestBody
	 			CantanteNueva ca,HttpServletRequest request) {
	 				repository1.save(new Cantante(ca.id, ca.nombre,ca.edad));
	 			  }
	 			//clase para crear cantantes nuevos
	 			static class CantanteNueva{
	 			    int id;
	 				String nombre;
	 				int edad;
	 			  	
	 				
	 					public CantanteNueva(int id,String nombre,int edad) {
	 						super();
	 						this.id = id;
	 						this.nombre = nombre;
	 						this.edad = edad;
	 					}
	 			  	}
	 			
	 			//borrar uno
	 			@DeleteMapping("/deleteSI/{id}")
	 			public String deleteSong(@PathVariable int id) {
	 				Cantante ca = repository1.findById(id);
	 				if(ca != null) {
	 					repository1.deleteById(id);
	 					return "Eliminado correctamente.";
	 				}
	 				else {
	 					return "No encontrado.";
	 				}
	 			}
	 			//actualizar uno
	 			@PutMapping("/editSI/{id}")
	 			public String updateRopa(@RequestBody
	 					CantanteNueva ca1, @PathVariable int id) {
	 				Cantante ca = repository1.findById(id);
	 				if(ca1 != null) {
	 					ca.setId(ca1.id);
	 					ca.setNombre(ca1.nombre);
	 					ca.setEdad(ca1.edad);
	 					repository1.save(ca);
	 					return "Actualizado correctamente.";
	 				}
	 				else {
	 					return "No encontrado.";
	 				}
	 			}
	 		 	
}