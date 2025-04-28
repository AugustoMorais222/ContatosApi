package com.senai.contatos_api.controller;

import java.util.ArrayList;
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

import com.senai.contatos_api.dtos.GrupoDto;
import com.senai.contatos_api.entidades.Grupo;
import com.senai.contatos_api.repository.GrupoRepository;

@RestController
@RequestMapping("/grupos")
@CrossOrigin(origins = "*")
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
    public ResponseEntity<GrupoDto> findById(@PathVariable Long id) {
    	Grupo grupo = grupoRepository.findById(id).orElse(null);
    	if (grupo != null) {
    		GrupoDto grupoDto = new GrupoDto(grupo);
    	    return ResponseEntity.ok(grupoDto);
    	} else {
    	    return ResponseEntity.notFound().build();
    	}
    }

    @GetMapping
    public ResponseEntity<List<GrupoDto>> findAll() {
        List<Grupo> grupos = grupoRepository.findAll();
        List<GrupoDto> gruposDto = new ArrayList<>();
		for (Grupo grupo : grupos) {
			GrupoDto grupoDto = new GrupoDto(grupo);
			gruposDto.add(grupoDto);
		}
		
        return ResponseEntity.ok(gruposDto);
    }
}