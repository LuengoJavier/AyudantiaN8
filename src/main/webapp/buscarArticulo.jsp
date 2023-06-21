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
    <title>Buscar Articulo</title>
</head>
<body>
<h1>Buscar Articulo por categoria</h1>
<form action="buscarArticulo" method="post">
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
    <input type="submit" value="Buscar Articulo" class="boton">
</form>
</body>
</html>