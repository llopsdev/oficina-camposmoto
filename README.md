# 🏍️ Sistema de Gestão para Oficina de Motos — MVP Educacional

## 📌 Visão Geral

Este projeto é um **MVP (Minimum Viable Product)** desenvolvido com foco em **aprendizado prático**, **boas práticas de backend** e **simulação de um ambiente corporativo real**.

A aplicação representa um **sistema de gestão para uma oficina de motos**, contemplando funcionalidades essenciais como **cadastro de entidades, ordens de serviço e controle de peças com estoque**, servindo como base para evolução contínua.

> 🎯 **Objetivo principal:**  
> Consolidar conhecimentos em **Java + Spring Boot**, arquitetura **MVC**, separação de responsabilidades, regras de negócio no backend e organização do desenvolvimento em **sprints**, como ocorre em equipes profissionais.

---

## 🧠 Propósito do Projeto

- Projeto **educacional** e **não comercial**
- Desenvolvido para **portfólio profissional**
- Foco principal em **backend**
- Frontend simples, utilizado apenas como meio de interação
- Evolução incremental, com planejamento técnico e refatorações previstas

Este projeto **não tem como objetivo ser um sistema final de produção**, mas sim demonstrar:
- organização de código
- entendimento de arquitetura
- tomada de decisões técnicas
- capacidade de evoluir um sistema ao longo do tempo

---

## 🏗️ Arquitetura Utilizada

O sistema segue o padrão **MVC (Model–View–Controller)**, amplamente adotado em aplicações corporativas Java.

### 📂 Camadas da aplicação

- **Controller**
  - Recebe requisições HTTP
  - Integra com as views (Thymeleaf)
  - Trabalha com DTOs
  - Trata erros de validação e regras de negócio

- **Service**
  - Centraliza as regras de negócio
  - Coordena operações entre entidades e repositórios
  - Controla fluxos como cadastro, atualização e movimentação de estoque

- **Model (Entidades JPA)**
  - Representa o domínio da aplicação
  - Contém regras de consistência interna
  - Métodos de comportamento (ex: atualizar preço, entrada e saída de estoque)

- **Repository**
  - Comunicação com o banco de dados
  - Implementado com Spring Data JPA

- **DTOs (Data Transfer Objects)**
  - Isolam o domínio da camada web
  - Facilitam validações
  - Evitam exposição direta das entidades

---

## 🔁 Metodologia de Desenvolvimento

O desenvolvimento segue **práticas inspiradas em Scrum**, com:

- Organização por **sprints**
- Entregas incrementais
- Planejamento técnico por funcionalidade
- Revisão contínua de decisões arquiteturais

> 🧑‍💻 O projeto é conduzido simulando um ambiente real de empresa,  
> com abordagem **Tech Lead → Dev Júnior**, focando em:
> - boas práticas
> - clareza de responsabilidades
> - aprendizado progressivo

---

## ⚙️ Funcionalidades Implementadas (até o momento)

### 🔹 Gestão de Peças
- Cadastro de peças
- Validação de nome duplicado
- Atualização de dados (nome e preço)
- Controle de estoque
  - Entrada de peças
  - Saída de peças
- Regras de negócio no domínio (estoque não negativo)

### 🔹 Aspectos técnicos
- CRUD completo
- Validação com Bean Validation
- Erros globais tratados no controller
- Separação clara entre DTO e Entidade
- Persistência com JPA/Hibernate

---

## 🐳 Docker e Infraestrutura

A aplicação já utiliza **Docker**, com separação de responsabilidades:

- 🧱 **Container da aplicação (Spring Boot)**
- 🗄️ **Container do banco de dados (MySQL)**

Estado atual:
- Containers executados **de forma separada**
- Inicialização **manual**
- Ainda **não há Docker Compose**

> 🚧 **Evolução planejada:**  
> Uma sprint futura será dedicada à criação do **docker-compose.yml**, automatizando:
> - subida da aplicação
> - subida do banco
> - configuração de rede
> - variáveis de ambiente

---

## 🧰 Tecnologias Utilizadas

- **Java**
- **Spring Boot**
- **Spring Data JPA**
- **Thymeleaf**
- **MySQL**
- **Maven**
- **Hibernate Validator**
- **Docker**
- **Arquitetura MVC**

---

## 🚧 MVP e Dívidas Técnicas

Este projeto é um **MVP**, portanto:

- Algumas funcionalidades ainda estão em evolução
- Existem **sprints futuras planejadas exclusivamente para:**
  - refatoração
  - criação do Docker Compose
  - padronização de exceções
  - testes unitários e de integração
  - melhorias de UX
  - otimizações de performance

Essas decisões são **intencionais** e fazem parte do processo de aprendizado e amadurecimento técnico.

---

## 📈 Evolução Contínua

O projeto evolui por sprints, simulando um ciclo real de desenvolvimento de software.

Próximas evoluções previstas:
- Finalização das views
- Histórico de movimentação de estoque
- Integração com Ordens de Serviço
- Testes automatizados
- Automação completa com Docker Compose

---

## 🤝 Feedbacks

Este projeto faz parte do meu processo de consolidação de conhecimentos em **backend Java** e **arquitetura de software**.

Feedbacks técnicos, sugestões de melhoria e boas práticas são muito bem-vindos.

---

## 👨‍💻 Autor

Projeto desenvolvido por **Luan Lopes**, estudante de Análise e Desenvolvimento de Sistemas, com foco em **Java e Backend**, voltado à consolidação de fundamentos, boas práticas de engenharia de software e desenvolvimento de aplicações utilizando **Spring Boot**.
