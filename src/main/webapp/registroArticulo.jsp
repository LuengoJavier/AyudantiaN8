<%--
  Created by IntelliJ IDEA.
  User: jluen
  Date: 08-06-2023
  Time: 9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>Registro Articulos</title>
    </head>
<body>
    <h1>Registro de Articulos</h1>
    <form action="registroArticulo" method="post">
        <div class="form-group">
            <label for="id">Codigo Articulo:</label>
            <input type="text" id="id" name="id" required>
        </div>
        <div class="form-group">
            <label for= "nombre">Nombre:</label>
            <input type="text" id = "nombre" name="nombre" required>
        </div>
        <div class="form-group">
        <label for= "peso">Peso:</label>
            <input type="text" id = "peso" name="peso" required>
        </div>
        <div class="form-group">
            <label for= "precio">Precio:</label>
            <input type="text" id = "precio" name="precio" required>
        </div>
        <div class="form-group">
            <label>
                <select name ="categoria">
                    <option value ="0">Categoria</option>
                    <option value="Smartphones">Smartphones</option>
                    <option value="Notebooks">Notebooks</option>
                    <option value="Torres">Torres</option>
                    <option value="Smart TV">SmarT TV</option>
                    <option value="Pantallas">Pantallas</option>
                    <option value="Línea Blanca">Línea Blanca</option>
                </select>
            </label>
        </div>
        <input type="submit" value="Registrar" class="boton">
    </form>
    </body>
</html>
