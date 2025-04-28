package com.senai.contatos_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.contatos_api.entidades.Contato;
import com.senai.contatos_api.entidades.ContatoGrupo;
import com.senai.contatos_api.entidades.Grupo;
import com.senai.contatos_api.repository.ContatoGrupoRepository;
import com.senai.contatos_api.repository.ContatoRepository;
import com.senai.contatos_api.repository.GrupoRepository;

@Service
public class ContatoGrupoService {

    @Autowired
    private ContatoRepository contatoRepositorio;

    @Autowired
    private GrupoRepository grupoRepositorio;

    @Autowired
    private ContatoGrupoRepository contatoGrupoRepositorio;

    public void adicionarContatoNoGrupo(Long contatoId, Long grupoId) {
        Contato contato = contatoRepositorio.findById(contatoId).orElseThrow(() -> new RuntimeException("Contato não encontrado"));
        Grupo grupo = grupoRepositorio.findById(grupoId).orElseThrow(() -> new RuntimeException("Grupo não encontrado"));

        ContatoGrupo contatoGrupo = new ContatoGrupo();
        contatoGrupo.setContato(contato);
        contatoGrupo.setGrupo(grupo);

        contatoGrupoRepositorio.save(contatoGrupo);
    }
}
