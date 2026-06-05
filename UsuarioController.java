package com.guthinh0.projetoa3.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="equipes")
public class Equipe {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="Nome da equipe é obrigatório")
    @Column(nullable=false)
    private String nomeEquipe;

    @Column(length=1000)
    private String descricao;

    @ManyToMany
    @JoinTable(name="equipe_usuarios", joinColumns=@JoinColumn(name="equipe_id"), inverseJoinColumns=@JoinColumn(name="usuario_id"))
    private List<Usuario> membros = new ArrayList<>();

    @ManyToMany
    @JoinTable(name="equipe_projetos", joinColumns=@JoinColumn(name="equipe_id"), inverseJoinColumns=@JoinColumn(name="projeto_id"))
    private List<Projeto> projetos = new ArrayList<>();

    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getNomeEquipe(){return nomeEquipe;} public void setNomeEquipe(String nomeEquipe){this.nomeEquipe=nomeEquipe;}
    public String getDescricao(){return descricao;} public void setDescricao(String descricao){this.descricao=descricao;}
    public List<Usuario> getMembros(){return membros;} public void setMembros(List<Usuario> membros){this.membros=membros;}
    public List<Projeto> getProjetos(){return projetos;} public void setProjetos(List<Projeto> projetos){this.projetos=projetos;}
}
