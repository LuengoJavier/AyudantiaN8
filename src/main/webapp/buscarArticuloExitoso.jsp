<%--
  Created by IntelliJ IDEA.
  User: jluen
  Date: 15-06-2023
  Time: 9:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Articulos Encontrados</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<h1>Lista de Articulos encontrados</h1>
<br>
<table class="table">
    <tr>
        <th>Nombre</th>
        <th>Categoria</th>
        <th>Precio</th>
    </tr>
    <c:forEach items="${articulos}" var="articulo">
        <tr>
            <td> <c:out value="${articulo.getNombre()}"></c:out> </td>
            <td> <c:out value="${articulo.getCategoria()}"></c:out> </td>
            <td> <c:out value="${articulo.getPrecio()}"></c:out> </td>
        </tr>
    </c:forEach>
</table>
<div class="form-group">
    <form>
        <a href="index.jsp" class="button-link">Volver al menú</a>
    </form>
</div>
</html>
