# library
## Запуск
Чтобы запустить приложение нужно: 
- скачать данный проект
- иметь установленный докер
- иметь свободные порты 5432 и 8080
В каталоге корневом каталоге проекта запустить команду:
```
docker compose up --build
```
## Тесты
Чтобы запустить тесы необходимо:
- заменить application.yml на:
```
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/library
    username: postgres
    password: qwe
    driver-class-name: org.postgresql.Driver
```
- запустить базу данных
```
docker compose up -d db 
```
- запустить класс ```LibraryApplicationTests```
