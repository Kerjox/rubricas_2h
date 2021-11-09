<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
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
	<title>Form</title>
</head>
<body>
<div class="container">
	<br><br><br>
	<form method="post" action="send-user">
		<!-- Name input -->
		<div class="form-outline mb-4">
			<input type="text" id="form1Name" name="name" class="form-control" />
			<label class="form-label" for="form1Name">Nombre</label>
		</div>

		<!-- FNac input -->
		<div class="form-outline mb-4">
			<input type="date" id="form1fDate" name="birthday" class="form-control"/>
			<label class="form-label" for="form1fDate">Fecha nacimiento</label>
		</div>

		<!-- Curso input -->
		<div class="form-outline mb-4">
			<select name="step" id="form1step" class="form-control">
				<option label="" value="0"></option>
				<option label="Primero" value="1"></option>
				<option label="Segundo" value="2"></option>
			</select>
			<label class="form-label" for="form1step">Curso</label>
		</div>

		<!-- Submit button -->
		<button type="submit" class="btn btn-primary btn-block">Send</button>
	</form>
	<br>
	<a class="btn btn-primary" href="list-users">Listado</a>
	<c:if test="${requestScope.removed}">
	<br>
	<div class="alert alert-danger d-flex align-items-center" role="alert">
		<div>
			The user ${requestScope.persona.name} has been deleted
		</div>
	</div>
</div>
	</c:if>


	<!-- MDB -->
	<script
					type="text/javascript"
					src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.6.0/mdb.min.js"
	></script>
</body>
</html>