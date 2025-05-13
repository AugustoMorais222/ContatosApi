package com.senai.contatos_api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

import com.senai.contatos_api.dtos.ContatoDto;
import com.senai.contatos_api.entidades.Compromisso;
import com.senai.contatos_api.entidades.Contato;
import com.senai.contatos_api.entidades.Grupo;
import com.senai.contatos_api.service.ContatoService;

@RestController
@RequestMapping("/contato")
@CrossOrigin(origins = "*")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @PostMapping
    public ResponseEntity<Contato> insert(@RequestBody Contato contato) {
        Contato novoContato = contatoService.insert(contato);
        return ResponseEntity.ok(novoContato);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
    	contatoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Contato> update(@RequestBody Contato contato) {
        return ResponseEntity.ok(contatoService.update(contato));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContatoDto> findById(@PathVariable Long id) {
        Contato contato = contatoService.findById(id);
		return ResponseEntity.ok(new ContatoDto(contato));
    }
    

    @GetMapping("/{id}/grupos")
    public ResponseEntity<Set<Grupo>> findAllGrupos(@PathVariable Long id) {
        Contato contatoOpt = contatoService.findById(id);
        if (contatoOpt != null) {
            return ResponseEntity.ok(contatoOpt.getGrupos());
        }
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/{id}/compromissos")
    public ResponseEntity<Set<Compromisso>> findAllCompromissos(@PathVariable Long id) {
        Contato contatoOpt = contatoService.findById(id);
        if (contatoOpt != null) {
            return ResponseEntity.ok(contatoOpt.getCompromissos());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<ContatoDto>> findAll() {
        List<Contato> contatos = contatoService.findAll();
        List<ContatoDto> contatoDtos = new ArrayList<>();

        for (Contato contato : contatos) {
            ContatoDto dto = new ContatoDto(contato);
            contatoDtos.add(dto);
        }

        return ResponseEntity.ok(contatoDtos);
    }
}
