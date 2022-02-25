<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome page</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.6/cosmo/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<form:form action="insert" method="post" modelAttribute="person">
		<span>nombre del estudiante:</span>
		<form:input type="text" path="name" />
		<input type="submit" value="Guardar nombre estudiante" />
	</form:form>
	<br />
	<br /> El nombre de la estudiantes es
	<span><c:out value="${person.name}" /></span>
	<br />
	<br />
	<br />


	<form:form action="insert" method="post" modelAttribute="person">
		<span>nuevo item:</span>
		<span>nombre:</span>
		<form:input type="text" path="item.name" />
		<span>peso:</span>
		<form:input type="text" path="item.peso" />
		<span>tipo:</span>
		<form:input type="text" path="item.type" />
		<input type="submit" value="guardar item" />
	</form:form>
	<table border="1">
		<thead>
			<tr>
				<td>Mochila</td>
				<td>peso</td>
				<td>tipo</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${person.bag.items}">
				<tr>
					<td><c:out value="${item.name}" /></td>
					<td><c:out value="${item.peso}" /></td>
					<td><c:out value="${item.type}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br />
	<br />
	<table border="1">
		<thead>
			<tr>
				<td>armas disponibles</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				primaria
				<td><c:out value="${person.primary.name}" /></td>
			</tr>
			<tr>
				secundaria
				<td><c:out value="${person.secondary.name}" /></td>
			</tr>
		</tbody>
	</table>
	<br />
	<br />
	<table border="1">
		<thead>
			<tr>
				<td>primary customization</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${person.primary.items}">
				<tr>
					<td><c:out value="${item.name}" /></td>
					<td><c:out value="${item.peso}" /></td>
					<td><c:out value="${item.type}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br />


	<table border="1">
		<thead>
			<tr>
				<td>secundary customization</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${person.secondary.items}">
				<tr>
                    <td><c:out value="${item.name}" /></td>
                    <td><c:out value="${item.peso}" /></td>
                    <td><c:out value="${item.type}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


	<form:form action="switchWeapon" method="post">
		<input type="submit" value="cambiar armas" />
	</form:form>




</body>
</html>