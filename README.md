# Software Development Books

Kata project create for BNPP CCE-E - Selection Process using **Java 21** and **Spring Boot**.

Requirements are in : https://stephane-genicot.github.io/DevelopmentBooks.html





---

## Used Technologies

- Java 21

- Spring Boot 3.5.4
- JUnit 5 / Mockito
- Maven 

---

## Running the project

### Using Docker 

If you have Docker installed in your machine, run the following commands:

```bash
# 1. Building docker image
docker build -t development-books-kata .

# 2. Running the container
docker run -p 8080:8080 development-books-kata
```

### Without Docker
#### Pre-requisites:
- Java 21 installed
- Maven installed

```bash
Linux / macOS

./mvnw clean install
./mvnw spring-boot:run

```

```bash
Windows

mvnw.cmd clean install
mvnw.cmd spring-boot:run

```

#### Running Tests:
```bash
./mvnw test # Linux/ macOS
mvnw.cmd test # Windows
```


## Request Example
### Calculate Basket (`POST /basket/calculate`)
**Request example:**

```json
{
    "basketItens": [
        
         {
            "bookName": "Clean Code",
            "quantity": 1
        },
         {
            "bookName": "Clean Coder",
            "quantity": 1
        }
    ]
}
```
