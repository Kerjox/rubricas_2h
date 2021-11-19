<%--
  Created by IntelliJ IDEA.
  User: dani
  Date: 11/11/21
  Time: 9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Insertar Titulación</title>
</head>
<body>
<div class="container">
	<h1>Insertar titulación</h1>
	<form method="post" action="/titulacion/insert">
		<label>
			<input type="text" name="name" placeholder="Titulación">
		</label>
		<button type="submit">Enviar</button>
	</form>
</div>
</body>
</html>
