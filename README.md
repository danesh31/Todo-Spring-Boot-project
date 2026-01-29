📝 Spring Boot ToDo Application

A simple ToDo Management REST API built using Spring Boot.
This application allows users to create, update, view, and delete tasks efficiently and demonstrates core backend concepts like REST APIs, JPA, validation, and exception handling.

🚀 Features

Create a new ToDo task

View all ToDo tasks

View a ToDo by ID

Update an existing ToDo

Delete a ToDo

Input validation

Global exception handling

RESTful API design

🛠️ Technologies Used

Java 17 (or Java 11+)

Spring Boot

Spring Web

Spring Data JPA

Hibernate

MySQL / H2 Database

Maven

Lombok

Postman (for API testing)

📂 Project Structure
src/main/java
 └── com.example.todo
     ├── controller
     ├── service
     ├── repository
     ├── model
     ├── exception
     └── TodoApplication.java

⚙️ Configuration

Update your database configuration in application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/todo_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect


(You can also use H2 for testing purposes.)

▶️ How to Run the Project

Clone the repository

git clone https://github.com/your-username/spring-boot-todo.git


Navigate to the project folder

cd spring-boot-todo


Run the application

mvn spring-boot:run


Application will start at

http://localhost:8080

🔗 API Endpoints
Method	Endpoint	Description
POST	/todos	Create a new ToDo
GET	/todos	Get all ToDos
GET	/todos/{id}	Get ToDo by ID
PUT	/todos/{id}	Update ToDo
DELETE	/todos/{id}	Delete ToDo
🧪 Sample Request (POST)
{
  "title": "Learn Spring Boot",
  "description": "Build a ToDo REST API",
  "completed": false
}

❗ Exception Handling

Handles resource not found exceptions

Handles validation errors

Uses a Global Exception Handler (@ControllerAdvice)

📌 Future Enhancements

User authentication (Spring Security + JWT)

Pagination and sorting

Swagger/OpenAPI documentation

Frontend integration (React/Angular)

👨‍💻 Author

Danesh N
Backend Developer | Spring Boot | Java
