# api

# 🏥 Voll.med API

REST API developed with **Spring Boot 3** for managing medical records, built as part of the [Alura](https://www.alura.com.br/) Java + Spring Boot training.

---

## 📋 About

Voll.med API is a backend application for a fictional medical clinic. It provides endpoints to manage doctors, including registration, listing, updating, and deletion — following REST principles and industry best practices.

---

## 🚀 Technologies

| Technology | Version |
|---|---|
| Java | 17 |
| Spring Boot | 3.x |
| Spring Data JPA | - |
| Spring Validation | - |
| Flyway Migration | - |
| MySQL | 8.x |
| Maven | - |

---

## 🗂️ Project Structure

```
src/main/java/med/voll/api/
├── controller/
│   ├── HelloController.java
│   └── MedicosController.java
├── endereco/
│   ├── DadosEndereco.java
│   └── Endereco.java
├── medico/
│   ├── DadosCadastroMedico.java
│   ├── DadosListagemMedico.java
│   ├── Especialidade.java
│   ├── Medico.java
│   └── MedicoRepository.java
└── ApiApplication.java

src/main/resources/
├── db/migration/
│   ├── V1__create-table-medicos.sql
│   └── V2__alter-table-medicos-add-columns-telefone.sql
└── application.properties
```

---

## ⚙️ Features

- [x] Register doctor (`POST /medicos`)
- [x] List doctors with pagination (`GET /medicos`)
- [x] Address embedded in doctor entity
- [x] Medical specialty via enum (`Especialidade`)
- [x] Bean Validation on all inputs
- [x] Versioned database migrations with Flyway

---

## 🛠️ Running Locally

### Prerequisites

- Java 17+
- MySQL 8+
- Maven

### Setup

1. Clone the repository:
```bash
git clone https://github.com/your-username/api.git
cd api
```

2. Create the database:
```sql
CREATE DATABASE vollmed_api;
```

3. Configure `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost/vollmed_api
spring.datasource.username=your_username
spring.datasource.password=your_password
```

4. Run the application:
```bash
./mvnw spring-boot:run
```

The API will be available at `http://localhost:8080`.

---

## 📡 Endpoints

### Doctors

| Method | Route | Description |
|---|---|---|
| `POST` | `/medicos` | Register a new doctor |
| `GET` | `/medicos` | List all doctors (paginated) |

### Request body — `POST /medicos`

```json
{
  "nome": "Dr. João Silva",
  "email": "joao.silva@vollmed.com",
  "crm": "123456",
  "especialidade": "CARDIOLOGIA",
  "endereco": {
    "logradouro": "Rua Exemplo",
    "bairro": "Centro",
    "cep": "01001000",
    "cidade": "São Paulo",
    "uf": "SP",
    "numero": "100"
  }
}
```

---

## 📦 Database Migrations

Flyway manages the schema versioning automatically on startup:

- `V1` — Creates the `medicos` table
- `V2` — Adds `telefone` column to `medicos`

---

## 📄 License

This project is for educational purposes as part of the Alura Spring Boot 3 course.
