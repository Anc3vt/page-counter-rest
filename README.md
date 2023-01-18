# page-counter-rest
### Приложение (REST-версия) для подсчета количества страниц в документах в структуре директорий.

Сборка приложения:
```
mvn install
```

Запуск:
```
java -jar target/page-counter-cli-0.0.0.1.jar
```

После запуска приложения, для подсчета количества документов и страниц обратитесь при помощи web-обозревателя или какого-либо инструмента для отправки HTTP-запросов (curl, wget, и т.д.) по адресу:
```
http://localhost:8080/v1/count?basePath=ПУТЬ-К-КОРНЕВОЙ-ДИРЕКТОРИИ
```

Примеры:

```
http://localhost:8080/v1/count?basePath=C:/Users/username/Documents
```
```
http://localhost:8080/v1/count?basePath=/home/username/Documents
```

При корректной отработке сценария вы увидите результат вроде следующего:
```
Documents: 4
Pages: 201 
```

Если указанная вами директория отсутствует, будет возвращена ошибка 400 BAD REQUEST (No such directory)
