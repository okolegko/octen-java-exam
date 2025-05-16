# Octen Java Exam (AutoRia Clone)

Це клон-проект платформи AutoRia, реалізований на Java з використанням Spring Boot. 
Підтримується створення оголошень, аутентифікація через JWT, ролі користувачів, 
преміум функції, перевірка нецензурної лексики, курс валют та статистика переглядів.

---

## Технології 
- Java 17
- Spring Boot
- Spring Security + JWT
- PostgreSQL
- Maven
- Docker (опціонально)
- Jsoup (перевірка лексики)
- REST API (Postman колекція додається)

---

## Як запустити

1. **Клонуйте репозиторій**
```bash
git clone https://github.com/your-username/octen-java-exam.git
cd octen-java-exam
```

2. **Налаштуйте PostgreSQL**
```sql
CREATE DATABASE autoria;
```

3. **Редагуйте application.yml** (якщо потрібно)
> `src/main/resources/application.yml`

4. **Запуск через Maven**
```bash
./mvnw clean install
./mvnw spring-boot:run
```

або

```bash
mvn clean install
mvn spring-boot:run
```


## Аутентифікація

### Реєстрація
`POST /auth/register`
```json
{
  "username": "user",
  "password": "pass"
}
```

### Логін
`POST /auth/login`
```json
{
  "username": "user",
  "password": "pass"
}
```

> Отримаєте JWT-токен у відповіді

## Оголошення

### Створити
`POST /listings`
(Треба передати JWT токен в Authorization Header)

```json
{
  "brand": "BMW",
  "model": "X5",
  "description": "Автомобіль у відмінному стані",
  "currency": "USD",
  "price": 25000
}
```

### Статистика переглядів
`GET /listings/{id}/statistics`


## Перевірка нецензурної лексики
`POST /profanity/check`
```json
{
  "text": "деякий нецензурний текст"
}
```


## Postman Колекція
Знаходиться у файлі `AutoRia_Postman_Collection.json`


## Docker (опціонально)
```bash
docker build -t octen-java-exam .
docker run -p 8080:8080 octen-java-exam
```

## Структура проєкту

```
octen-java-exam/
├── src/
│   └── main/
│       └── java/
│           └── com/octen/autoria/
│               ├── controller/
│               ├── dto/
│               ├── model/
│               ├── repository/
│               ├── security/
│               ├── service/
│               └── util/
│       └── resources/
│           ├── application.yml
│           └── ...
├── AutoRia_Postman_Collection.json
├── pom.xml
├── README.md
└── .gitignore
```

## Ролі
- **USER** — базовий доступ
- **PREMIUM** — доступ до статистики