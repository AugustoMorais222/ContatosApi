package com.senai.contatos_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.senai.contatos_api.entidades.Contato;
import com.senai.contatos_api.repository.ContatoRepository;

public class ContatoService {
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	public void insert(Contato contato) {
		this.contatoRepository.save(contato);
	}
	
	public void delete(Long id) {
		this.contatoRepository.deleteById(id);
	}
	
	public void update(Contato contato) {
		this.contatoRepository.save(contato);
	}
	
	public Contato findById(Long id) {
		return this.contatoRepository.findById(id).orElse(null);
	}
	
	public List<Contato> findAll(){
		return this.contatoRepository.findAll();
	}
	
}
