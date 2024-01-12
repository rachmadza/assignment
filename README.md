# Spring Boot Application Assignment Rachmad Zaini Alberto

This is a simple Spring Boot application that provides three web services. The first service receives a JSON format string, extracts values, assigns them to a class object, and saves them in the database. The second service generates a JWT token based on the provided username, password. The third service validates the JWT token to check if it's valid or expired.

## Prerequisites

- Java 17 installed.
- Maven 3.9.1 installed.

## Getting Started

1. **Navigate to the project directory:**
    ```bash
    cd assignment
    ```

2. **Build the project:**
    ```bash
    mvn clean install
    ```
   
3. **Run the application using Spring Boot Maven plugin:**
    ```bash
    mvn spring-boot:run
    ```
   
4. **Run the application:**
    ```bash
    java -jar target/assignment.jar
    ```

The application will start, and you can access the services on `http://localhost:8080`.

## Web Services

### 1. Create User to Database

- **Endpoint:** `/user`
- **Method:** `POST`
- **Request Payload:**
    ```json
    {
      "firstname": "firstmane",
      "lastname": "lastname",
      "dateofbirth": "1995-06-23",
      "gender": "FEMALE",
      "email": "asd@asd.com",
      "mobileno": "9999999999",
      "address": "some where",
      "city": "mumbai",
      "state": "Maharastra",
      "country": "India",
      "pin": "302019"
    }
    ```
- **Response:**
    ```json
    {
      "id": 1,
      "firstname": "firstmane",
      "lastname": "lastname",
      "dateofbirth": "1995-06-23",
      "gender": "FEMALE",
      "email": "asd@asd.com",
      "mobileno": "9999999999",
      "address": "some where",
      "city": "mumbai",
      "state": "Maharastra",
      "country": "India",
      "pin": "302019",
      "password": "123456"
    }
    ```

### 2. Get User from Database

- **Endpoint:** `/user/{id}`
- **Method:** `GET`
- **Example Endpoint:** `/user/1`
- **Response:**
    ```json
    {
      "id": 1,
      "firstname": "firstmane",
      "lastname": "lastname",
      "dateofbirth": "1995-06-23",
      "gender": "FEMALE",
      "email": "asd@asd.com",
      "mobileno": "9999999999",
      "address": "some where",
      "city": "mumbai",
      "state": "Maharastra",
      "country": "India",
      "pin": "302019",
      "password": "123456"
    }
    ```

### 3. Login User

- **Endpoint:** `/auth/login`
- **Method:** `POST`
- **Request Payload:**
    ```json
    {
       "username": "your-username",
       "password": "your-password"
    }
    ```
- **Response:**
    ```json
    {
       "token": "your-generated-jwt-token"
    }
    ```

### 4. Validate JWT Token

- **Endpoint:** `/auth/validate`
- **Method:** `POST`
- **Request Payload:**
    ```json
    {
       "token": "your-jwt-token-to-validate"
    }
    ```
- **Response:**
    ```json
    {
       "tokenStatus": "your-token-status"
    }
    ```

## Database

This application uses an H2 in-memory database. You can access the H2 console at `http://localhost:8080/h2-console` with the following credentials:

- **JDBC URL:** `jdbc:h2:mem:testdb`
- **User Name:** `sa`
- **Password:** (leave it empty)

Make sure to replace placeholder values in the request payloads with your actual values.
