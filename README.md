# Library
Приложение для управления библиотекой, разработанное на **Spring Boot**. Оно включает в себя два микросервиса:

- **BookService** - для управления книгами.
```
http://localhost:8084/book-service/api/v1/books/*
```
- **LibraryService** - для учета свободных книг.
```
http://localhost:8083/library-service/api/v1/library/*
```

## Установка

### 1. Предварительно установить
- Docker
- Git
### 2. Склонировать репозиторий

```bash
git clone https://github.com/dulfinne/Library
```
### 3. Запустить Docker и в папке с проектом выполнить команду
```
docker-compose up
```
### 4. По окончании работы использовать команду 
```
docker-compose down
```
# BookService

## 1. **Получение списка всех книг**
   - **GET**

     ```
     http://localhost:8084/book-service/api/v1/books
     ```

   - **Ответ:**

     ```http
     
     [
     {
        "id": 1,
        "isbn": "978-3-48410-746-0",
        "name": "The Great Gatsby",
        "genre": "Fiction",
        "info": "A story about the mysterious millionaire Jay Gatsby and his obsessive pursuit of the past, set against the backdrop of the Jazz Age and the American Dream.",
        "author": "F. Scott Fitzgerald"
     },
     {
        "id": 2,
        "isbn": "978-0-06112-008-4",
        "name": "To Kill a Mockingbird",
        "genre": "Fiction",
        "info": "A novel that deals with racial injustice and growing up in the southern United States, told through the eyes of young Scout Finch.",
        "author": "Harper Lee"
      },
     и т.д.
     ]
     ```
 ## 2. **Получение определённой книги по её Id**
   - **GET**

     ```
     http://localhost:8084/book-service/api/v1/books/6
     ```

   - **Ответ:**

     ```http
     
     {
            "id": 6,
            "isbn": "978-0-74327-356-5",
            "name": "The Da Vinci Code",
            "genre": "Thriller",
            "info": "A gripping thriller where professor Robert Langdon deciphers mysterious codes and symbols to uncover ancient secrets hidden in famous works of art.",
            "author": "Dan Brown"
     }
     ```
## 3. **Получение книги по её ISBN**
   - **GET**

     ```
     http://localhost:8084/book-service/api/v1/books/isbn/978-0-06112-008-4
     ```

   - **Ответ:**

     ```http

     {
            "id": 2,
            "isbn": "978-0-06112-008-4",
            "name": "To Kill a Mockingbird",
            "genre": "Fiction",
            "info": "A novel that deals with racial injustice and growing up in the southern United States, told through the eyes of young Scout Finch.",
            "author": "Harper Lee"
     }
     ```
## 4. **Добавление новой книги**
   - **POST**

     ```
     http://localhost:8084/book-service/api/v1/books
     ```

     ```http
        {
            "isbn": "123-4-56789-876-5",
            "name": "Test Book",
            "genre": "test genre",
            "info": "test info",
            "author": "Test Author"
        }
     ```
   - **Ответ:**

     ```http

     {
            "id": 7,
            "isbn": "123-4-56789-876-5",
            "name": "Test Book",
            "genre": "test genre",
            "info": "test info",
            "author": "Test Author"
     }
     ```
## 5. **Удаление книги**
   - **DELETE**

     ```
     http://localhost:8084/book-service/api/v1/books/4
     ```
# LibraryService

## 1. **Получение списка всех книг**
   - **GET**

     ```
     http://localhost:8083/library-service/api/v1/library/books
     ```

   - **Ответ:**

 ```http
     
 [
    {
        "id": 1,
        "status": "AVAILABLE"
    },
    {
        "id": 2,
        "status": "AVAILABLE"
    },
        и т. д.
   ]
```
 ## 2. **Получение определённой книги по её Id**
   - **GET**

     ```
     http://localhost:8083/library-service/api/v1/library/books/6
     ```

   - **Ответ:**

     ```http
     
     {
            "id": 6,
            "status": "AVAILABLE"
     }
     ```
## 3. **Занять книгу**
   - **POST**

     ```
     http://localhost:8083/library-service/api/v1/library/books/6/borrow
     ```

   - **Ответ:**

     ```http

     {
            "id": 1,
            "book": {
                "id": 6,
                "status": "BORROWED"
            },
            "borrowedAt": "2024-09-15T22:18:41.946187637+03:00",
            "returnBy": "2024-09-22T22:18:41.946187637+03:00"
        }
     ```
## 4.  **Получение списка свободных книг**
   - **GET**

     ```
     http://localhost:8083/library-service/api/v1/library/books/available
     ```
   - **Ответ:**

 ```http
     
 [
    {
        "id": 1,
        "status": "AVAILABLE"
    },
    {
        "id": 2,
        "status": "AVAILABLE"
    },
        и т. д.
   ]
```
## 5. **Просмотр информации о всех прокатах книг**
   - **GET**

     ```
     http://localhost:8083/library-service/api/v1/library/book-rentals
     ```
   - **Ответ:**

 ```http
     
[
    {
        "id": 1,
        "book": {
            "id": 6,
            "status": "BORROWED"
        },
        "borrowedAt": "2024-09-15T19:18:41.946188Z",
        "returnBy": "2024-09-22T19:18:41.946188Z"
    }
]
```
