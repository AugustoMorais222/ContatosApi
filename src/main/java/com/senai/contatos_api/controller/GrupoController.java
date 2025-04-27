package com.senai.contatos_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.contatos_api.entidades.Grupo;
import com.senai.contatos_api.repository.GrupoRepository;

@RestController
@RequestMapping("/grupos")
public class GrupoController {

    @Autowired
    private GrupoRepository grupoRepository;

    @PostMapping
    public ResponseEntity<Grupo> insert(@RequestBody Grupo grupo) {
        Grupo novoGrupo = grupoRepository.save(grupo);
        return ResponseEntity.ok(novoGrupo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (grupoRepository.existsById(id)) {
            grupoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity<Grupo> update(@RequestBody Grupo grupo) {
        if (grupoRepository.existsById(grupo.getId())) {
            Grupo atualizado = grupoRepository.save(grupo);
            return ResponseEntity.ok(atualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grupo> findById(@PathVariable Long id) {
    	Grupo grupo = grupoRepository.findById(id).orElse(null);
    	if (grupo != null) {
    	    return ResponseEntity.ok(grupo);
    	} else {
    	    return ResponseEntity.notFound().build();
    	}
    }

    @GetMapping
    public ResponseEntity<List<Grupo>> findAll() {
        List<Grupo> grupos = grupoRepository.findAll();
        return ResponseEntity.ok(grupos);
    }
}