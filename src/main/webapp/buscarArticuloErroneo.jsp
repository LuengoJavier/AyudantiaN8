<%--
  Created by IntelliJ IDEA.
  User: jluen
  Date: 15-06-2023
  Time: 9:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>Busqueda Articulo</title>
</head>
<body>
<h1>Busqueda Articulo por categoria</h1>
<p>Algo salió mal, intente nuevamente</p>
<form action="buscarArticulo" method="post">
    <div class="form-group">
        <label>
            <select name ="articulo">
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
    <input type="submit" value="Buscar Articulo" class="boton">
</form>
</body>
</html>
