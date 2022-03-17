<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
	      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<title>Index</title>
</head>
<body>

<div class="container">
	<br>
	<h1>Bingo</h1>
	<br>
	<div style="width: 500px">

		<div class="row row-cols-5">
			<%--@elvariable id="carton" type="java.util.List"--%>
			<c:forEach var="numero" items="${carton.numeros}">
				<div class="col p-1">
						<%--@elvariable id="numerosSacados" type="java.util.HashSet"--%>
					<c:if test="${numerosSacados.contains(numero)}">
						<div class="btn btn-success">${numero}</div>
					</c:if>
					<c:if test="${!numerosSacados.contains(numero)}">
						<div class="btn btn-dark disabled">${numero}</div>
					</c:if>
				</div>
			</c:forEach>
		</div>
	</div>
	<br>
	<span><a class="btn btn-primary" href="/play">Sacar Bola</a> <p>Numero sacado: ${lastNumber}</p></span>

	<div class="row">

		<c:forEach var="numero" begin="${1}" end="${90}" step="${1}">
			<div class="col p-1">
				<c:if test="${numerosSacados.contains(numero)}">
					<div class="btn btn-warning">${numero}</div>
				</c:if>
				<c:if test="${!numerosSacados.contains(numero)}">
					<div class="btn btn-dark disabled">${numero}</div>
				</c:if>
			</div>
		</c:forEach>
	</div>


</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
