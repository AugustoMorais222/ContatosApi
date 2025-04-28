package com.senai.contatos_api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.contatos_api.dtos.ContatoGrupoDto;
import com.senai.contatos_api.service.ContatoGrupoService;

@RestController
@RequestMapping("/contato-grupo")
@CrossOrigin(origins = "*")
public class ContatoGrupoController {

    @Autowired
    private ContatoGrupoService contatoGrupoServico;

    @PostMapping("/adicionar")
    public void adicionarContatoNoGrupo(@RequestBody ContatoGrupoDto dto) {
        contatoGrupoServico.adicionarContatoNoGrupo(dto.getContatoId(), dto.getGrupoId());
    }
    

}
