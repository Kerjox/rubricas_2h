<%--
  Created by IntelliJ IDEA.
  User: dani
  Date: 12/11/21
  Time: 9:40
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
	<title>List Alumnos</title>
</head>
<body>
<div class="container">
	<!-- Table  -->
	<table class="table">
		<!-- Table head -->
		<thead>
		<tr>
			<th><i class="fas fa-school mr-2 indigo-text" aria-hidden="true"></i> Titulacion</th>
			<th><i class="fas fa-location-arrow mr-2 indigo-text" aria-hidden="true"></i> Acciones</th>
		</tr>
		</thead>
		<!-- Table head -->

		<!-- Table body -->
		<tbody>

		<c:forEach var="titulacion" items="${requestScope.titulaciones}">
			<tr>
				<td>${titulacion.name}</td>

				<td>
					<form method="post" action="/titulacion/delete" style="float: left;">
						<input type="hidden" name="id" value="${titulacion.id}">
						<button type="submit" class="btn btn-danger btn-sm m-0"><i class="fas fa-times"></i></button>
					</form>
				</td>
			</tr>
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