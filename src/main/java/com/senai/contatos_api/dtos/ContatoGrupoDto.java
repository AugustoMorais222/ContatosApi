package com.senai.contatos_api.dtos;


public class ContatoGrupoDto {
    private Long contatoId;
    private Long grupoId;

    public ContatoGrupoDto() {}

    public Long getContatoId() { return contatoId; }
    public void setContatoId(Long contatoId) { this.contatoId = contatoId; }

    public Long getGrupoId() { return grupoId; }
    public void setGrupoId(Long grupoId) { this.grupoId = grupoId; }
}

