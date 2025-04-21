package com.senai.contatos_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.contatos_api.entidades.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {


}
