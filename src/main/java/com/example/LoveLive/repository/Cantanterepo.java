package com.example.LoveLive.repository;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.LoveLive.model.Cantante;

@Repository
public interface Cantanterepo extends JpaRepository<Cantante, Integer>{
	
	@Bean
	public abstract List<Cantante> findAll();
	public abstract Cantante findById(int id);
	
	@Transactional
	public abstract void deleteById(int id);

	
	@SuppressWarnings("unchecked")
	@Transactional
	public abstract Cantante save(Cantante ca);
		
}

