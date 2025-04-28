package com.senai.contatos_api.dtos;

import com.senai.contatos_api.entidades.Contato;

public class ContatoDto {
	private Long id;
	private String nome;
	private String telefone;
	private String email;
	private Boolean isFavorite;

	public ContatoDto(Contato contato) {
        this.id = contato.getId();
        this.nome = contato.getNome();
        this.email = contato.getEmail();
        this.telefone = contato.getTelefone();
        this.isFavorite = contato.getIsFavorite(); 
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Boolean getIsFavorite() {
		return isFavorite;
	}
	
	public void setIsFavorite(Boolean isFavorite) {
		this.isFavorite = isFavorite;
	}
}
