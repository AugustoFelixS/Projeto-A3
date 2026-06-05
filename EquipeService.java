package com.guthinh0.projetoa3.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="usuarios")
public class Usuario {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="Nome completo é obrigatório")
    @Column(nullable=false)
    private String nomeCompleto;

    @NotBlank(message="CPF é obrigatório")
    @Column(nullable=false, unique=true)
    private String cpf;

    @Email(message="E-mail inválido")
    @NotBlank(message="E-mail é obrigatório")
    @Column(nullable=false, unique=true)
    private String email;

    @NotBlank(message="Cargo é obrigatório")
    @Column(nullable=false)
    private String cargo;

    @NotBlank(message="Login é obrigatório")
    @Column(nullable=false, unique=true)
    private String login;

    @NotBlank(message="Senha é obrigatória")
    @Size(min=4, message="Senha deve ter no mínimo 4 caracteres")
    @Column(nullable=false)
    private String senha;

    @NotNull(message="Perfil é obrigatório")
    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private Perfil perfil;

    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getNomeCompleto(){return nomeCompleto;} public void setNomeCompleto(String nomeCompleto){this.nomeCompleto=nomeCompleto;}
    public String getCpf(){return cpf;} public void setCpf(String cpf){this.cpf=cpf;}
    public String getEmail(){return email;} public void setEmail(String email){this.email=email;}
    public String getCargo(){return cargo;} public void setCargo(String cargo){this.cargo=cargo;}
    public String getLogin(){return login;} public void setLogin(String login){this.login=login;}
    public String getSenha(){return senha;} public void setSenha(String senha){this.senha=senha;}
    public Perfil getPerfil(){return perfil;} public void setPerfil(Perfil perfil){this.perfil=perfil;}
}
