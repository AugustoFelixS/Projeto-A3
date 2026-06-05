package com.guthinh0.projetoa3.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

@Entity
@Table(name="projetos")
public class Projeto {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="Nome do projeto é obrigatório")
    @Column(nullable=false)
    private String nomeProjeto;

    @Column(length=1000)
    private String descricao;

    @NotNull(message="Data de início é obrigatória")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(nullable=false)
    private LocalDate dataInicio;

    @NotNull(message="Data de término prevista é obrigatória")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(nullable=false)
    private LocalDate dataTerminoPrevista;

    @NotNull(message="Status é obrigatório")
    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private StatusProjeto status;

    @NotNull(message="Gerente responsável é obrigatório")
    @ManyToOne
    @JoinColumn(name="gerente_id", nullable=false)
    private Usuario gerenteResponsavel;

    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getNomeProjeto(){return nomeProjeto;} public void setNomeProjeto(String nomeProjeto){this.nomeProjeto=nomeProjeto;}
    public String getDescricao(){return descricao;} public void setDescricao(String descricao){this.descricao=descricao;}
    public LocalDate getDataInicio(){return dataInicio;} public void setDataInicio(LocalDate dataInicio){this.dataInicio=dataInicio;}
    public LocalDate getDataTerminoPrevista(){return dataTerminoPrevista;} public void setDataTerminoPrevista(LocalDate dataTerminoPrevista){this.dataTerminoPrevista=dataTerminoPrevista;}
    public StatusProjeto getStatus(){return status;} public void setStatus(StatusProjeto status){this.status=status;}
    public Usuario getGerenteResponsavel(){return gerenteResponsavel;} public void setGerenteResponsavel(Usuario gerenteResponsavel){this.gerenteResponsavel=gerenteResponsavel;}
}
