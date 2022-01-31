<%--
  Created by IntelliJ IDEA.
  User: dani
  Date: 20/12/21
  Time: 9:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
	      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<title>Index</title>
</head>

<style>
    .cursor-normal {

        cursor: default;
    }
</style>
<body>

<div class="container">
	<div class="row justify-content-center">
		<div class="col-auto">
			<h1>Ahorcado</h1>
		</div>
	</div>
	<div class="row justify-content-center">
		<div class="col-auto">

		</div>
	</div>
	<div class="row justify-content-center">
		<div class="col-auto">
			<jsp:useBean id="ahorcado" scope="request" type="com.kerjox.ahorcado.entities.Ahorcado"/>
			<c:forEach var="letter" items="${ahorcado.wordToShow}" varStatus="i">

				<c:choose>

					<c:when test="${!ahorcado.lettersChecked.contains(letter)}">

						<c:if test="${letter.toString() == ' '}">

							<div class="btn btn-outline-danger invisible cursor-normal">_</div>
						</c:if>

						<c:if test="${letter.toString() != ' '}">

							<div class="btn btn-outline-dark cursor-normal">_</div>
						</c:if>

					</c:when>

					<c:when test="${letter.toString() == '-'}">

						<div class="btn cursor-normal">-</div>
					</c:when>

					<c:otherwise>
						<div class="btn btn-outline-dark cursor-normal">${letter}</div>
					</c:otherwise>
				</c:choose>

			</c:forEach>
		</div>
	</div>

	<div class="row justify-content-center bg-black">
		<div class="col-auto">
			<c:forEach var="letter" items="${alphabet}">
				<div class="d-flex justify-content-center p-1 float-start">
					<c:if test="${!ahorcado.lettersChecked.contains(letter)}">

						<a href="/checkLetter/?letter=${letter}" class="btn btn-primary">${letter}</a>
					</c:if>

					<c:if test="${ahorcado.lettersChecked.contains(letter)}">

						<a href="/checkLetter/?letter=${letter}" class="btn btn-primary disabled">${letter}</a>
					</c:if>
				</div>
			</c:forEach>
		</div>
	</div>
<footer>

	<div class="row justify-content-center">
		<div class="col-auto">
			<p><a href="/">Generar nueva palabra</a></p>
		</div>
	</div>
</footer>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
