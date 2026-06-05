package com.guthinh0.projetoa3.model;

public enum StatusProjeto {
    PLANEJADO("Planejado"), EM_ANDAMENTO("Em andamento"), CONCLUIDO("Concluído"), CANCELADO("Cancelado");
    private final String descricao;
    StatusProjeto(String descricao){this.descricao=descricao;}
    public String getDescricao(){return descricao;}
}
