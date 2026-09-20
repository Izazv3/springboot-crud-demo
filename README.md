# Spring Boot PostgreSQL CRUD Demo

Java 21 + Spring Boot 3.5.6 + Spring Data JPA/Hibernate + PostgreSQL.

Architecture: Controller -> Service -> Repository -> Hibernate/JPA -> PostgreSQL

## Run
1. docker compose up -d
2. mvn spring-boot:run
3. Open http://localhost:8080/api/products

Database: springboot_crud, user postgres, password postgres, port 5432.

## CRUD
POST /api/products
GET /api/products
GET /api/products/{id}
PUT /api/products/{id}
DELETE /api/products/{id}

POST/PUT JSON:
{"productId":"P001","name":"Laptop","price":55000.00}

Create returns 201; delete returns 204; validation errors 400; duplicate product IDs 409; missing products 404.

Override DB_URL, DB_USERNAME, DB_PASSWORD and PORT with environment variables.