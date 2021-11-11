<%--
  Created by IntelliJ IDEA.
  User: dani
  Date: 9/11/21
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<!-- Font Awesome -->
	<link
					href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
					rel="stylesheet"
	/>
	<!-- Google Fonts -->
	<link
					href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
					rel="stylesheet"
	/>
	<!-- MDB -->
	<link
					href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.6.0/mdb.min.css"
					rel="stylesheet"
	/>
	<title>List Personas</title>
</head>
<body>
<div class="container">
	<!-- Table  -->
	<table class="table">
		<!-- Table head -->
		<thead>
		<tr>
			<th><i class="fas fa-user mr-2 blue-text" aria-hidden="true"></i> Nombre</th>
			<th><i class="fas fa-birthday-cake mr-2 teal-text" aria-hidden="true"></i> Cumpleaños</th>
			<th><i class="fas fa-clock mr-2 indigo-text" aria-hidden="true"></i> Edad</th>
			<th><i class="fas fa-school mr-2 indigo-text" aria-hidden="true"></i> Curso</th>
			<th><i class="fas fa-location-arrow mr-2 indigo-text" aria-hidden="true"></i> Acciones</th>
		</tr>
		</thead>
		<!-- Table head -->

		<!-- Table body -->
		<tbody>
		<c:forEach var="persona" items="${requestScope.personas}">
			<tr>

				<td>${persona.name}</td>
				<td>${persona.birthday}</td>
				<td>${persona.age} años</td>
				<td>
					<c:if test="${persona.step == 1}">
						<c:out value="Primero"></c:out>
					</c:if>
					<c:if test="${persona.step == 2}">
						<c:out value="Segundo"></c:out>
					</c:if>
				</td>
				<td>
					<form method="post" action="delete-user">
						<input type="hidden" name="id" value="${persona.id}">
						<button type="submit" class="btn btn-danger btn-sm m-0"><i class="fas fa-times"></i></button>
					</form>
				</td>
			</tr>
		</c:forEach>

		</tbody>
		<!-- Table body -->
	</table>
	<a class="btn btn-primary" href="index.jsp">Index</a>
</div>
<!-- Table  -->
<!-- MDB -->
<script
				type="text/javascript"
				src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.6.0/mdb.min.js"
></script>
</body>
</html>
