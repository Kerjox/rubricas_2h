<%--
  Created by IntelliJ IDEA.
  User: dani
  Date: 11/11/21
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Insert Persona</title>
</head>
<body>
<div class="container">
	<form method="post" action="insert-alumno">
		<label>
			<span>Nombre</span>
			<input type="text" name="name">
		</label>
		<label>
			<span>Edad</span>
			<input type="number" name="age">
		</label>
		<label>
			<span>Titulacion</span>
			<select name="titulacion">
				<c:forEach items="${requestScope.titulaciones}" var="titulacion">
					<option value="${titulacion.id}">${titulacion.name}</option>
				</c:forEach>
			</select>
		</label>
		<button type="submit">Enviar</button>
	</form>
</div>
</body>
</html>
