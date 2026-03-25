## 🔗 ShoterUrl - URL Shortener API

API RESTful para encurtamento de URLs desenvolvida com Spring Boot, aplicando princípios de Clean Architecture, separação de responsabilidades e boas práticas modernas de backend.

O sistema permite gerar URLs curtas, redirecionar para o destino original e estruturar respostas HTTP padronizadas, com foco em escalabilidade, manutenibilidade e clareza arquitetural.

## 🚀 Tecnologias

* **Java 17+**
* **Spring Boot** (Spring Web, Spring Data JPA)
* **Bean Validation**
* **Maven**
* **MySQL**

 ## 🎯 Objetivo

Este projeto foi desenvolvido para demonstrar:
* Construção de APIs REST robustas.
* Aplicação de **Clean Architecture** na prática.
* Organização de código orientada a domínio.
* Padronização de respostas e erros.
* Baixo acoplamento entre camadas.

## 🧠 Arquitetura

O projeto segue uma abordagem de Arquitetura em Camadas com influência de Clean Architecture, separando claramente as responsabilidades.

### Estrutura de Pastas
```text
dev.Zerphyis.shortUrl
│
├── domain          # Núcleo da aplicação (regras puras e interfaces)
├── application     # Casos de uso / serviços e DTOs
├── infra           # Controllers, persistência (banco) e integrações
└── config          # Configurações do framework
