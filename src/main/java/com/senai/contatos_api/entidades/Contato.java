package com.senai.contatos_api.entidades;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "contato")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    private String email;
    @Column
    private String telefone;
    @Column
    private Boolean isFavorite;
    
    @OneToMany(mappedBy = "contato")
    private Set<ContatoGrupo> grupos;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Set<ContatoGrupo> getGrupos() {
		return grupos;
	}
	public void setGrupos(Set<ContatoGrupo> grupos) {
		this.grupos = grupos;
	}
	public Contato() {
	}
	public Boolean getIsFavorite() {
		return isFavorite;
	}
	public void setIsFavorite(Boolean isFavorite) {
		this.isFavorite = isFavorite;
	}
    
	public void atualizarDados(Contato outro) {
	    this.setNome(outro.getNome());
	    this.setEmail(outro.getEmail());
	    this.setTelefone(outro.getTelefone());
	    this.setGrupos(outro.getGrupos());
	}
    
}

