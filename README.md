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
```
### 🔍 Detalhamento das Camadas
🧩 Domain: Entidades principais e interfaces de repositório. Contém regras independentes de framework e não depende de nenhuma outra camada.

⚙️ Application: Serviços (use cases) e DTOs (records). Responsável por orquestrar a lógica, criar URLs e validar regras.

🌐 Infrastructure (Infra): Controllers REST, implementação de repositórios e tratamento global de exceções. Interfaceia com o mundo externo (HTTP e Banco de Dados).

## ⚙️ Funcionalidades
 * *🔗 Encurtar URL: Recebe uma URL válida, gera um identificador único (slug/hash) e persiste no banco.*

 * *🔁 Redirecionamento: Ao acessar /{shortCode}, o sistema retorna um HTTP 302 Redirect para a URL original.*

 * *📄 Consulta: Recupera dados da URL encurtada (estrutura preparada para métricas futuras).*

 * *❌ Tratamento Global de Erros: Implementado com @ControllerAdvice para garantir respostas consistentes.*




## 📡 Endpoints da API
A URL base da aplicação é: http://localhost:8080/api/urls

### 1. Criar URL Curta
*POST /api/urls*

Request:
````
JSON
{
  "url": "[https://google.com](https://google.com)"
}
````
Response (201 Created):
````
JSON
{
  "url": "http://localhost:8080/api/urls/r/abc123"
}
````
### 2. Redirecionamento
*GET /api/urls/r/{code}*
Ação: Redireciona via HTTP 302 Found para a URL original de destino.

### 3. Buscar URL por ID
*GET /api/urls/{id}*
Response (200 OK):
````
JSON
{
  "id": 1,
  "fullUrl": "[https://google.com](https://google.com)",
  "shortUrl": "http://localhost:8080/api/urls/r/abc123"
}
````
### 4. Listar Todas as URLs
* GET /api/urls*

Response (200 OK):
````
JSON
{
  "urls": [
    {
      "id": 1,
      "fullUrl": "[https://google.com](https://google.com)",
      "shortUrl": "http://localhost:8080/api/urls/r/abc123"
    }
  ]
}
````
### 5. Deletar URL
* DELETE /api/urls/{id}*

Response (200 OK):
````
JSON
{
  "message": "URL deleted successfully"
}
````
