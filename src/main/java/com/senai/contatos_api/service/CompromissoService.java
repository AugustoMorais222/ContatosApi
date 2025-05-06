package com.senai.contatos_api.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.senai.contatos_api.entidades.Compromisso;
import com.senai.contatos_api.repository.CompromissoRepository;

@Service
public class CompromissoService {
	
	@Autowired
	private CompromissoRepository compromissoRepository;
	
	public Compromisso findById(Long id) {
		return compromissoRepository.findById(id)
	            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Compromisso não encontrado"));
	}
	
	public List<Compromisso> findAll() {
		return this.compromissoRepository.findAll();
	}
	
	public void delete(Long id) {
		Compromisso compromisso = compromissoRepository.findById(id)
	            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Compromisso não encontrado"));
		compromissoRepository.delete(compromisso);
	}
	
	public Compromisso insert(Compromisso compromisso) {
		if (compromisso.getData().isBefore(LocalDateTime.now())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Data do compromisso não pode ser no passado");
		}
		if(existsCompromissoByData(compromisso)){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não é possível cadastrar dois compromissos no mesmo horário");
		}
		return this.compromissoRepository.save(compromisso);
	}
	
	public Compromisso update(Compromisso compromisso) {
		Compromisso compromissoExistente = compromissoRepository.findById(compromisso.getId())
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Compromisso não encontrado"));
		
		if (compromisso.getData().isBefore(LocalDateTime.now())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Data do compromisso não pode ser no passado");
		}
		
		if(existsCompromissoByData(compromisso)){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não é possível cadastrar dois compromissos no mesmo horário");
		}
		
		compromissoExistente.atualizarDados(compromisso);
		
		return this.compromissoRepository.save(compromissoExistente);
	}
	
	private Boolean existsCompromissoByData(Compromisso compromisso) {
		List<Compromisso> compromissos = compromissoRepository.findAll();
		for(Compromisso c : compromissos) {
            if (c.getData().equals(compromisso.getData()) && c.getData().getHour() == compromisso.getData().getHour()) {
                return true;
            }
        }
		return false;
	}
	
}
