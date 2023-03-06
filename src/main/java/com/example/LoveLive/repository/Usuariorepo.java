package com.example.LoveLive.repository;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LoveLive.model.Usuario;

@Repository
public interface Usuariorepo extends JpaRepository<Usuario, Integer>{
	
	@Bean
	public abstract List<Usuario> findAll();
	public abstract Usuario findById(int id);
	public abstract Usuario findByNombreAndPass(String nombre, String pass);
	
	@Transactional
	public abstract void deleteById(int id);

	@SuppressWarnings("unchecked")
	@Transactional
	public abstract Usuario save(Usuario u);
	
	
	

}

