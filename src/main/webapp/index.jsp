<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <link rel ="stylesheet" type="text/css" href="style.css">
    <title>Menú Tienda Electrónica</title>
</head>
<body>
<h1>Menú principal Tienda Electrónica</h1>
<br/>
<div class="form-group">
    <form action="registroCliente" method="get">
        <input type="submit" value="Registrar Cliente" class="boton">
    </form>
</div>
<div class="form-group">
    <form action="registroArticulo" method="get">
        <input type="submit" value="Registrar Articulo" class="boton">
    </form>
</div>
<div class="form-group">
    <form action="buscarArticulo" method="get">
        <input type="submit" value="Buscar Articulo" class="boton">
    </form>
</div>
<div class="form-group">
    <form action="modificarArticulo" method="get">
        <input type="submit" value="Modificar Articulo" class="boton">
    </form>
</div>
</body>
</html>