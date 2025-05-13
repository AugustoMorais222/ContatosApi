package com.senai.contatos_api.entidades;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
    
    @OneToMany
    private Set<Compromisso> compromissos = new HashSet<>();
    
    @ManyToMany
    @JoinTable(
        name = "contato_grupo",
        joinColumns = @JoinColumn(name = "contato"),
        inverseJoinColumns = @JoinColumn(name = "grupo")
    )
    private Set<Grupo> grupos = new HashSet<>();
	
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
	public Set<Grupo> getGrupos() {
		return grupos;
	}
	public void setGrupos(Set<Grupo> grupos) {
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
	public Set<Compromisso> getCompromissos() {
		return compromissos;
	}
	public void setCompromissos(Set<Compromisso> compromissos) {
		this.compromissos = compromissos;
	}
	public void atualizarDados(Contato outro) {
	    this.setNome(outro.getNome());
	    this.setEmail(outro.getEmail());
	    this.setTelefone(outro.getTelefone());
	    this.setGrupos(outro.getGrupos());
	}
    
}

