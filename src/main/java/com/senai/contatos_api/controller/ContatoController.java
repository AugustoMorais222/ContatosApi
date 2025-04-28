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

import com.senai.contatos_api.dtos.ContatoDto;
import com.senai.contatos_api.entidades.Contato;
import com.senai.contatos_api.repository.ContatoRepository;

@RestController
@RequestMapping("/contato")
@CrossOrigin(origins = "*")
public class ContatoController {

    @Autowired
    private ContatoRepository contatoRepository;

    @PostMapping
    public ResponseEntity<Contato> insert(@RequestBody Contato contato) {
        Contato novoContato = contatoRepository.save(contato);
        return ResponseEntity.ok(novoContato);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (contatoRepository.existsById(id)) {
            contatoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity<Contato> update(@RequestBody Contato contato) {
        if (contatoRepository.existsById(contato.getId())) {
            Contato atualizado = contatoRepository.save(contato);
            return ResponseEntity.ok(atualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContatoDto> findById(@PathVariable Long id) {
        Contato contato = contatoRepository.findById(id).orElse(null);

        if (contato != null) {
            ContatoDto contatoDto = new ContatoDto(contato);
            return ResponseEntity.ok(contatoDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ContatoDto>> findAll() {
        List<Contato> contatos = contatoRepository.findAll();
        List<ContatoDto> contatoDtos = new ArrayList<>();

        for (Contato contato : contatos) {
            ContatoDto dto = new ContatoDto(contato);
            contatoDtos.add(dto);
        }

        return ResponseEntity.ok(contatoDtos);
    }
}
