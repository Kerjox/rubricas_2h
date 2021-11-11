<%--
  Created by IntelliJ IDEA.
  User: dani
  Date: 11/11/21
  Time: 12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Edit alumno titulacion</title>
</head>
<body>
<div class="container">
	<form method="post" action="update-alumno">
		<input type="hidden" name="id" value="${requestScope.alumno.id}">
		<label>
			<span>Nombre</span>
			<input type="text" name="name" placeholder="Nombre" value="${requestScope.alumno.name}">
		</label>
		<label>
			<span>Edad</span>
			<input type="number" name="age" placeholder="Edad" value="${requestScope.alumno.edad}">
		</label>
		<label>
			<span>Titulación</span>
			<select name="titulacion" name="titulacion">
				<c:forEach items="${requestScope.titulaciones}" var="titulacion">
					<c:if test="${titulacion.id == requestScope.alumno.titulacion.id}">
						<option value="${titulacion.id}" selected="true">${titulacion.name}</option>
					</c:if>

					<c:if test="${titulacion.id != requestScope.alumno.titulacion.id}">
						<option value="${titulacion.id}">${titulacion.name}</option>
					</c:if>
				</c:forEach>
			</select>
		</label>
		<button type="submit">Actualizar</button>
	</form>
</div>
</body>
</html>
