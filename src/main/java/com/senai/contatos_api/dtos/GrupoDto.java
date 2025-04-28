package com.senai.contatos_api.dtos;

import com.senai.contatos_api.entidades.Grupo;

public class GrupoDto {
    private Long id;
    private String nome;

    public GrupoDto(Grupo grupo) {
        this.id = grupo.getId();
        this.nome = grupo.getNome();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
