CRUD Application - Система управления сотрудниками

Описание
Приложение представляет собой RESTful API для управления данными о сотрудниках. Проект построен с использованием Java, Spring Boot и JPA/Hibernate для взаимодействия с базой данных.

Функционал
- Получение списка всех сотрудников.
- Получение данных сотрудника по его ID.
- Добавление нового сотрудника.
- Обновление данных существующего сотрудника.
- Удаление сотрудника по ID.

Технологии
- Java: Основной язык разработки.
- Spring Boot: Фреймворк для создания RESTful API.
- JPA/Hibernate: Для работы с базой данных.
- Maven: Управление зависимостями.


API Эндпоинты

Получить всех сотрудников
GET `/api/employees`

Ответ:
```json
[
  {
    "id": 1,
    "firstName": "Иван",
    "lastName": "Иванов",
    "email": "ivanov@example.com"
  },
  ...
]
```

Получить сотрудника по ID
GET `/api/employees/{employeeId}`

Ответ:
```json
{
  "id": 1,
  "firstName": "Иван",
  "lastName": "Иванов",
  "email": "ivanov@example.com"
}
```

Добавить нового сотрудника
POST `/api/employees`

Тело запроса:
```json
{
  "firstName": "Иван",
  "lastName": "Иванов",
  "email": "ivanov@example.com"
}
```

Ответ:
```json
{
  "id": 1,
  "firstName": "Иван",
  "lastName": "Иванов",
  "email": "ivanov@example.com"
}
```

Обновить данные сотрудника
PUT `/api/employees`

Тело запроса:
```json
{
  "id": 1,
  "firstName": "Иван",
  "lastName": "Иванов",
  "email": "ivanov@example.com"
}
```

Ответ:
```json
{
  "id": 1,
  "firstName": "Иван",
  "lastName": "Иванов",
  "email": "ivanov@example.com"
}
```

Удалить сотрудника по ID
DELETE `/api/employees/{employeeId}`

Ответ:
```json
"Employee{id=1, firstName='Иван', lastName='Иванов', email='ivanov@example.com'}"
```

