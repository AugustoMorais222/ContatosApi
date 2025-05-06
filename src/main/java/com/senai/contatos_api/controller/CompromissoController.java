package com.senai.contatos_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.contatos_api.entidades.Compromisso;
import com.senai.contatos_api.service.CompromissoService;

@RestController
@RequestMapping("/compromisso")
@CrossOrigin(origins = "*")
public class CompromissoController {
	
	@Autowired
	private CompromissoService compromissoService;
	
	@GetMapping
	public ResponseEntity<List<Compromisso>> findAll(){
		return ResponseEntity.ok(this.compromissoService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Compromisso> findById(@PathVariable Long id){
		Compromisso compromisso = this.compromissoService.findById(id);
		return ResponseEntity.ok(compromisso);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		compromissoService.delete(id);
        return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<Compromisso> insert(@RequestBody Compromisso compromisso) {
		return ResponseEntity.ok(this.compromissoService.insert(compromisso));
	}
	
	@PutMapping
	public ResponseEntity<Compromisso> update(@RequestBody Compromisso compromisso) {
		return ResponseEntity.ok(this.compromissoService.update(compromisso));
	}
	
}
