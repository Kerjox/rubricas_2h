<%--
  Created by IntelliJ IDEA.
  User: dani
  Date: 2/12/21
  Time: 8:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Edit Seudonimo</title>
</head>
<body>

<form method="post" action="/autores/editSeudonimo">
	<input type="hidden" name="id" value="${requestScope.autor.id}">
	<label for="seudonimo">
		<span>Seudonimo</span>
		<input type="text" id="seudonimo" name="seudonimo" value="${requestScope.autor.seudonimo}">
	</label>

	<button type="submit">Actualizar</button>
</form>
</body>
</html>
