# Projeto A3 - Sistema de Gestão de Projetos

## Descrição

Sistema de Gestão de Projetos desenvolvido em Java utilizando Spring Boot e o padrão arquitetônico MVC (Model-View-Controller).

O sistema permite o gerenciamento de usuários, projetos e equipes, possibilitando o controle das atividades e dos responsáveis pelos projetos da organização.

---

## Funcionalidades

### Cadastro de Usuários

* Nome completo
* CPF
* E-mail
* Cargo
* Login
* Senha
* Perfil de acesso:

  * Administrador
  * Gerente
  * Colaborador

### Cadastro de Projetos

* Nome do projeto
* Descrição
* Data de início
* Data de término prevista
* Status:

  * Planejado
  * Em andamento
  * Concluído
  * Cancelado
* Gerente responsável

### Cadastro de Equipes

* Nome da equipe
* Descrição
* Associação de usuários
* Associação de projetos
* Uma equipe pode atuar em vários projetos

---

## Tecnologias Utilizadas

* Java 17
* Spring Boot
* Spring MVC
* Spring Data JPA
* Thymeleaf
* Banco de Dados H2
* Maven

---

## Arquitetura

O projeto foi desenvolvido seguindo o padrão MVC:

### Model

Responsável pelas entidades do sistema:

* Usuario
* Projeto
* Equipe
* Perfil
* StatusProjeto

### View

Interfaces desenvolvidas com Thymeleaf.

### Controller

Responsável pelo controle das requisições HTTP e comunicação entre View e Service.

---

## Estrutura do Projeto

```text
src/
└── main/
    ├── java/
    │   └── com/guthinh0/projetoa3/
    │       ├── controller/
    │       ├── model/
    │       ├── repository/
    │       ├── service/
    │       └── ProjetoA3Application.java
    │
    └── resources/
        ├── templates/
        ├── static/
        └── application.properties
```

---

## Como Executar

### Pré-requisitos

* Java 17 ou superior
* Maven 3.9+

### Executando a aplicação

```bash
git clone https://github.com/Guthinh0/Projeto-A3.git

cd Projeto-A3

mvn spring-boot:run
```

A aplicação estará disponível em:

```text
http://localhost:8080
```

---

## Banco de Dados

O projeto utiliza o banco H2 em memória para facilitar a execução.

Console H2:

```text
http://localhost:8080/h2-console
```

Configurações padrão:

```text
JDBC URL: jdbc:h2:mem:testdb
User: sa
Password:
```

---

## Funcionalidades Implementadas

* CRUD de Usuários
* CRUD de Projetos
* CRUD de Equipes
* Relacionamento Usuário ↔ Equipe
* Relacionamento Projeto ↔ Equipe
* Gerente responsável por projeto
* Persistência de dados via JPA
* Interface Web com Thymeleaf

---

## Autor

Augusto Gabriel

GitHub:
https://github.com/Guthinh0
