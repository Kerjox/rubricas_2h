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
<body>

<div class="container">
	<div class="row justify-content-center">
		<div class="col-auto">
			<h1>Dardos</h1>
		</div>
	</div>
	<div class="row justify-content-center">
		<%--@elvariable id="players" type="java.util.List"--%>
		<c:forEach var="player" items="${players}">
			<div class="col-6">
				<table class="table table-bordered border-primary">
					<thead>
					<tr>
						<th scope="col">${player.getName()}</th>
						<th scope="col">Puntos</th>
					</tr>
					</thead>
					<tbody>
					<c:forEach var="tirada" items="${player.getTiradas()}">
						<tr>
							<td>
								<span>Trada ${tirada.getId()}:</span>
								<table class="table table-bordered border-primary">
									<thead>
									<tr>
										<th>Dardo 1</th>
										<th>Dardo 2</th>
										<th>Dardo 3</th>
									</tr>
									</thead>
									<tr>
										<c:forEach var="dardo" items="${tirada.getDardos()}">
											<td>${dardo.toString()}</td>
										</c:forEach>
									</tr>
								</table>
							</td>
							<td>
									${tirada.getPuntosTirada()}
							</td>

						</tr>
					</c:forEach>

					<tr>
						<td><b>Total:</b></td>
						<td><b>${player.getPuntos()}</b></td>
					</tr>

					</tbody>
				</table>
			</div>
		</c:forEach>

		<h2>Tirada: ${players.get(0).getIdTirada()}</h2>
	</div>

	<a type="button" class="btn btn-primary" href="play">Play</a>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
