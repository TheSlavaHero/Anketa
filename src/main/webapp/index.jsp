<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>
<head>
    <meta charset="utf-8">
    <title>Анкета</title>
</head>
<body>
<form action="/results">
    <p><b>1. Вы знаете язык разметки HTML?</b></p>
    <p><input name="HTML" type="radio" value="yes"> Да</p>
    <p><input name="HTML" type="radio" value="no"> Нет</p>
    <p><b>2. Вы знаете, что такое JAVA</b></p>
    <p><input name="JAVA" type="radio" value="yes"> Да</p>
    <p><input name="JAVA" type="radio" value="no"> Нет</p>
    <p><input type="submit" value="Выбрать"></p>
</form>
</body>
</html>