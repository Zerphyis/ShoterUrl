## 🔗 ShoterUrl - URL Shortener API
![Java](https://img.shields.io/badge/Java-17+-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Clean Architecture](https://img.shields.io/badge/Clean_Architecture-A60000?style=for-the-badge&logo=architecture&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white)
![JSON](https://img.shields.io/badge/JSON-000000?style=for-the-badge&logo=json&logoColor=white)

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

## 🗄️ Configuração do Banco de Dados (MySQL)

Certifique-se de ter o MySQL instalado e em execução.

* *1. Criar banco de dados:*
````
SQL
CREATE DATABASE shorturl;
````
* *2. Configuração no application.properties:*
````
Properties
spring.datasource.url=jdbc:mysql://localhost:3306/shorturl
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
````
### 🧩 Decisões Técnicas
* Java Records: Utilizados para DTOs para garantir imutabilidade e reduzir boilerplate.

* ControllerAdvice: Centralização de exceções para melhor experiência do desenvolvedor/consumidor.

* Separação Domain vs Infra: Facilita testes unitários e permite trocar o banco de dados sem impactar a regra de negócio.

## 🛠️ Como executar
````
# Clone o repositório
git clone [https://github.com/Zerphyis/ShoterUrl.git](https://github.com/Zerphyis/ShoterUrl.git)

# Entre no diretório
cd ShoterUrl

# Execute a aplicação
./mvnw spring-boot:run
Aplicação disponível em: http://localhost:8080
````
