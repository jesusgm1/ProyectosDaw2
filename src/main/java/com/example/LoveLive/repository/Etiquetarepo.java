package com.example.LoveLive.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.context.annotation.Bean;


import com.example.LoveLive.model.Etiqueta;
import java.util.List;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Etiquetarepo extends JpaRepository<Etiqueta, Integer> {
	@Bean
	public abstract List<Etiqueta> findAll();
	public abstract Etiqueta findById(int id);
	
	
	@Transactional
	public abstract void deleteById(int id);
	

	@SuppressWarnings("unchecked")
	@Transactional
	public abstract Etiqueta save(Etiqueta E);
	
}
