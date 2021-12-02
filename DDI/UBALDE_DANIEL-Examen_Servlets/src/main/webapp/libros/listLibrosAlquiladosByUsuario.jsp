<%--
  Created by IntelliJ IDEA.
  User: dani
  Date: 2/12/21
  Time: 9:20
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
	<title>List Alquilados</title>
</head>
<body>
<div class="container">
	<!-- Table  -->
	<table class="table">
		<!-- Table head -->
		<thead>
		<tr>
			<th><i class="fas fa-user mr-2 blue-text" aria-hidden="true"></i> Titulo</th>
			<th><i class="fas fa-clock mr-2 indigo-text" aria-hidden="true"></i> Descripcion</th>
			<th><i class="fas fa-calendar mr-2 indigo-text" aria-hidden="true"></i> Fecha Creación</th>

		</tr>
		</thead>
		<!-- Table head -->

		<!-- Table body -->
		<tbody>

		<c:forEach var="libro" items="${requestScope.librosList}">
			<tr>
				<td>${libro.titulo}</td>
				<td>${libro.descripcion}</td>
				<td>${libro.fecha_creacion}</td>
		</c:forEach>


		</tbody>
		<!-- Table body -->
	</table>
	<a class="btn btn-primary" href="/">Index</a>
</div>
<!-- Table  -->
<!-- MDB -->
<script
				type="text/javascript"
				src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.6.0/mdb.min.js"
></script>
</body>
</html>
