package com.guthinh0.projetoa3.model;

public enum Perfil {
    ADMINISTRADOR("Administrador"), GERENTE("Gerente"), COLABORADOR("Colaborador");
    private final String descricao;
    Perfil(String descricao){this.descricao=descricao;}
    public String getDescricao(){return descricao;}
}
