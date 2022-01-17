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
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<title>Index</title>
</head>
<body>

<div class="container">
	<div class="position-absolute start-50 translate-middle" style="top: 25%;">

		<jsp:useBean id="ahorcado" scope="request" type="com.kerjox.ahorcado.entities.Ahorcado"/>
		<c:forEach var="letter" items="${ahorcado.word}" varStatus="i">

			<c:if test="${ahorcado.wordMask[i.index]}">
				<div class="btn btn-outline-dark">${ahorcado.word[i.index]}</div>

			</c:if>

			<c:if test="${!ahorcado.wordMask[i.index]}">
				<div class="btn btn-outline-dark">_</div>
			</c:if>
		</c:forEach>
	</div>
	<div class="position-absolute start-50 translate-middle" style="top: 60%">
		<c:forEach var="letter" items="${alphabet}">
		<div class="d-flex justify-content-center p-1 float-start">
			<a href="/checkLetter/?letter=${letter}" class="btn btn-primary">${letter}</a>
		</div>
		</c:forEach>
	</div>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
