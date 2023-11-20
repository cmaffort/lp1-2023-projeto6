<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>id-contrato</title>
</head>
<body>

    <form action="/visualizarcontrato" method="POST">
        <label for="usuario">ID:</label>
        <input type="text" id="usuario" name="usuario" required>
        <input type="submit" value="Enviar">
    </form>

</body>
</html>