package com.senai.contatos_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.senai.contatos_api.entidades.Grupo;
import com.senai.contatos_api.repository.GrupoRepository;

@Service
public class GrupoService {
	
	@Autowired
	private GrupoRepository grupoRepository;
	
	public Grupo insert(Grupo grupo) {
		return this.grupoRepository.save(grupo);
	}
	
	public void delete(Long id) {
		Grupo grupo = grupoRepository.findById(id)
	            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Grupo não encontrado"));
		grupoRepository.delete(grupo);
	}
	
	public Grupo update(Grupo grupo) {
		Grupo grupoExistente = grupoRepository.findById(grupo.getId())
        	.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Grupo não encontrado"));
		grupoExistente.setNome(grupo.getNome());
		return this.grupoRepository.save(grupoExistente);
	}
	
	public Grupo findById(Long id) {
		return grupoRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Grupo não encontrado"));
	}
	
	public List<Grupo> findAll(){
		return this.grupoRepository.findAll();
	}
}
