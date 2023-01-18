# page-counter-rest

Приложение (REST-версия) для подсчета количества страниц в документах в структуре директорий.

После запуска приложения, для подсчета количества документов и страниц обратитесь по адресу
```
http://localhost:8080/v1/count?basePath=ПУТЬ-К-КОРНЕВОЙ-ДИРЕКТОРИИ
```

Примеры:

```
http://localhost:8080/v1/count?basePath=C:\Users\username\Documents
```
```
http://localhost:8080/v1/count?basePath=/home/username/Documents
```
