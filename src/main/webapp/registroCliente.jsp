<%--
  Created by IntelliJ IDEA.
  User: jluen
  Date: 08-06-2023
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>Registro Cliente</title>
</head>
<body>
<h1>Registro Cliente</h1>
<form action="registroCliente" method="post">
    <div class="form-group">
        <label for="rut">RUT Cliente:</label>
        <input type="text" id="rut" name="rut" required>
    </div>
    <div class="form-group">
        <label for= "nombre">Nombre:</label>
        <input type="text" id = "nombre" name="nombre" required>
    </div>
    <div class="form-group">
        <label for= "correo">Correo:</label>
        <input type="text" id = "correo" name="correo" required>
    </div>
    <input type="submit" value="Registrar" class="boton">
</form>
</body>
</html>
