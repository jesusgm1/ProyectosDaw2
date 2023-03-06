package com.example.LoveLive.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.LoveLive.model.Cancion;


public interface Cancionrepo extends JpaRepository<Cancion, Integer> {

	@Bean
	public abstract List<Cancion> findAll();
	public abstract Cancion findById(int id);
	
	
	@Transactional
	public abstract void deleteById(int id);
	

	@SuppressWarnings("unchecked")
	@Transactional
	public abstract Cancion save(Cancion c);
	
	
}
