package com.senai.contatos_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.senai.contatos_api.entidades.Grupo;
import com.senai.contatos_api.repository.GrupoRepository;

public class GrupoService {
	
	@Autowired
	private GrupoRepository grupoRepository;
	
	public void insert(Grupo grupo) {
		this.grupoRepository.save(grupo);
	}
	
	public void delete(Long id) {
		this.grupoRepository.deleteById(id);
	}
	
	public void update(Grupo grupo) {
		this.grupoRepository.save(grupo);
	}
	
	public Grupo findById(Long id) {
		return this.grupoRepository.findById(id).orElse(null);
	}
	
	public List<Grupo> findAll(){
		return this.grupoRepository.findAll();
	}
}
