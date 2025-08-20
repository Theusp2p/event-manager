# 🎉 Event-manager
Gerenciador de Eventos (Event Manager)
Este projeto é uma API RESTful completa para um sistema de gestão de eventos e inscrições. 

## 🚀 Tecnologias
* **Java 21**
* **Spring Boot 3.5.4**
* **Maven**
* **PostgreSQL**
* **Docker & Docker Compose**
* **Lombok**
* **MapStruct**
* **Swagger (OpenAPI)**

## 📝 Pré-requisitos
* **Java Development Kit(JDK) 17 ou superior**
* **Maven**
* **Docker & Docker Compose**
* **IDE (preferencialmente o Intellij IDEA, devido ao suporte das demais tecnologias)**

## ⚙️ Instalação e Execução
1. **Clone o repositório**
    - git clone https://github.com/Theusp2p/event-manager.git
    - cd event-manager
2. **Configurar o ambiente**  
Crie um arquivo .env na raiz do projeto com as suas credenciais. Você pode usar o .env.example como guia.
    - **Exemplo do arquivo .env**
    - DB_URL=jdbc:postgresql://localhost:5432/event-manager
    - DB_USER=postgres
    - DB_PASSWORD=postgres
3. **Executar com Docker Compose**  
Suba o banco de dados e as outras dependências com o Docker Compose usando linha de comando.
    - docker compose up -d
4. **Rodar a aplicação**  
Execute a aplicação Spring Boot através da sua IDE ou por linha de comando.
    - ./mvnw spring-boot:run
## 🔗 Endpoints da API 
 * **POST** /events: Cria um novo evento.
 * **GET** /events: Lista todos os eventos.
 * **GET** /events/{id}: Busca um evento por ID.
 * **DELETE** /events/{id}: Deleta um evento por ID.
 * **PATCH** /events/{id}: Atualiza parcialmente ou totalmente os campos de um evento por ID.