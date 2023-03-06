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
import com.example.LoveLive.model.Etiqueta;
import com.example.LoveLive.model.Usuario;
import com.example.LoveLive.repository.Cancionrepo;
import com.example.LoveLive.repository.Etiquetarepo;
import com.example.LoveLive.repository.Usuariorepo;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class Etiquetacontroller {

	 	@Autowired
	 	private Cancionrepo repository;
	 	@Autowired
	 	private Etiquetarepo repository1;
	 	@Autowired
	 	private Usuariorepo repository2;
	 	
	 	//Buscar todos
	 	@GetMapping("/Tickets")
	 	public List<Etiqueta> allPersons(){
	 		//Creo una lista de hashmap para devolver un json
			List<DTO> listaUsuariosDto = new ArrayList<DTO>();
			//leo de repositorio todos los registros
			List<Etiqueta> usuarios = repository1.findAll();
			//Los voy cargar en el DTO
			
			for(Etiqueta E : usuarios) {				
				DTO dtoUsuaria=new DTO();
				dtoUsuaria.put("id",E.getId());
				dtoUsuaria.put("id_cancion", E.getCancion().getId());
				dtoUsuaria.put("id_usuario", E.getUsuario().getId());	
				listaUsuariosDto.add(dtoUsuaria);
			}
			return usuarios;
}
	 	
		//buscar uno
	 	@GetMapping("/searchT/{id}")
		public DTO getCollection(HttpServletRequest request, @PathVariable int id) {
			DTO dtoCollection = new DTO();
			Etiqueta E = repository1.findById(id);
			if(E!=null) {
				dtoCollection.put("id", E.getId());
				dtoCollection.put("id_cancion", E.getCancion().getId());
				dtoCollection.put("id_usuario", E.getUsuario().getId());	
			}else dtoCollection.put("result", "fail");
			return dtoCollection;
		}
	 	
		//crear uno
		@PostMapping(path="/newticket", produces = MediaType.APPLICATION_JSON_VALUE)
		public void crearUsuario(@RequestBody
		EtiquetaNueva E ,HttpServletRequest request) {
			Usuario u = repository2.findById(E.id_usuario);
			Cancion c = repository.findById(E.id_cancion);
			repository1.save(new Etiqueta(E.id,c,u));
		  }
		
		static class EtiquetaNueva{
		    int id;
			int id_usuario;
			int id_cancion;
			
				public EtiquetaNueva(int id,int id_usuario ,int id_cancion) {
					super();
					this.id = id;
					this.id_usuario = id_usuario;
					this.id_cancion = id_cancion;
				}
		  	}
		
		@DeleteMapping("/deleteT/{id}")
		public String deleteSong(@PathVariable int id) {
			Etiqueta E = repository1.findById(id);
			if(E != null) {
				repository1.deleteById(id);
				return "Eliminado correctamente.";
			}
			else {
				return "No encontrado.";
			}
		}
		
		//metodo de actualizar
		@PutMapping("/editT/{id}")
		public String updateSong(@RequestBody
				EtiquetaNueva E1, @PathVariable int id) {
			Etiqueta E = repository1.findById(id);
			if(E != null) {
				E.setId(E1.id);
				E.setUsuario(repository2.findById(E1.id_usuario));
				E.setCancion(repository.findById(E1.id_cancion));
				repository1.save(E);
				return "Actualizado correctamente.";
			}
			else {
				return "No encontrado.";
			} 	
	 	
}
}
