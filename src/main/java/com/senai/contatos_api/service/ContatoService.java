package com.senai.contatos_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.senai.contatos_api.entidades.Contato;
import com.senai.contatos_api.repository.ContatoRepository;

@Service
public class ContatoService {
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	public Contato insert(Contato contato) {
		return this.contatoRepository.save(contato);
	}
	
	public void delete(Long id) {
		Contato contato = contatoRepository.findById(id)
	            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contato não encontrado"));
		contatoRepository.delete(contato);
	}
	
	public Contato update(Contato contato) {
		Contato contatoExistente = contatoRepository.findById(contato.getId())
			    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contato não encontrado"));
		contatoExistente.atualizarDados(contato);		
		return this.contatoRepository.save(contatoExistente);
	}
	
	public Contato findById(Long id) {
		return contatoRepository.findById(id)
	            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contato não encontrado"));
	}
	
	public List<Contato> findAll(){
		return this.contatoRepository.findAll();
	}
	
}
