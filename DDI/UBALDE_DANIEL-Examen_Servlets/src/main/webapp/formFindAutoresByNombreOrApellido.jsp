<%--
  Created by IntelliJ IDEA.
  User: dani
  Date: 2/12/21
  Time: 8:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>FindAutores By Nombre or Apellido</title>
</head>
<body>
	<form method="post" action="/autores/byNombreOrApellido">

		<label for="nombre">
			<span>Nombre</span>
			<input type="text" name="nombre" id="nombre">
		</label>

		<label for="apellido">
			<span>Apellido</span>
			<input type="text" name="apellido" id="apellido">
		</label>

		<button type="submit">Buscar</button>
	</form>
</body>
</html>
