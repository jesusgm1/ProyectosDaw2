package com.example.LoveLive.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
import com.example.LoveLive.model.Usuario;
import com.example.LoveLive.repository.Usuariorepo;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UsuarioController {
	
	@Autowired
 	private Usuariorepo repository2;
	
	@GetMapping("/Users")
 	public List<Usuario> allPersons(){
 		//Creo una lista de hashmap para devolver un json
		List<DTO> listaUsuariosDto = new ArrayList<DTO>();
		//leo de repositorio todos los registros
		List<Usuario> usuarios = repository2.findAll();
		//Los voy cargar en el DTO
		
		for(Usuario u : usuarios) {				
			DTO dtoUsuaria=new DTO();
			dtoUsuaria.put("id",u.getId());
			dtoUsuaria.put("nombre",u.getNombre());
			dtoUsuaria.put("pass",u.getPass());		
			listaUsuariosDto.add(dtoUsuaria);
		}
		
		
		return usuarios;
	}
		
	
	
	@PostMapping(path="/newuser", produces = MediaType.APPLICATION_JSON_VALUE)
	public void crearUsuario(@RequestBody
	UsuarioNuevo u1,HttpServletRequest request) {
		repository2.save(new Usuario(u1.id, u1.nombre,u1.pass,u1.id_etiquetaC));
	  }
	//clase constructor y metodo para crear
	
	static class UsuarioNuevo{
	    int id;
		String nombre;
		String pass;
		int id_etiquetaC;
	  	
		
			public UsuarioNuevo(int id,String nombre,String pass,int id_etiquetaC) {
				super();
				this.id = id;
				this.nombre = nombre;
				this.pass = pass;
				this.id_etiquetaC = id_etiquetaC;
			}
	  	}
	
	//borrar uno
		@DeleteMapping("/deleteU/{id}")
		public String deleteSong(@PathVariable int id) {
			Usuario u = repository2.findById(id);
			if(u != null) {
				repository2.deleteById(id);
				return "Eliminado correctamente.";
			}
			else {
				return "No encontrado.";
			}
		}
		
		//metodo de actualizar
				@PutMapping("/editU/{id}")
				public String updateSong(@RequestBody
						UsuarioNuevo u1, @PathVariable int id) {
					Usuario u = repository2.findById(id);
					if(u1 != null) {
						u.setId(u1.id);
						u.setNombre(u1.nombre);
						u.setPass(u1.pass);
						u.setId_etiquetaC(u1.id_etiquetaC);
						repository2.save(u);
						return "Actualizado correctamente.";
					}
					else {
						return "No encontrado.";
					}
			 	
				}
				
}