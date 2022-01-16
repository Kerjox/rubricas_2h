<%--
  Created by IntelliJ IDEA.
  User: dani
  Date: 20/12/21
  Time: 9:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title>Index</title>
</head>
<body>
<form action="/fin" method="get">
	<label>

		<input type="number" name="age">
	</label>
	<input type="submit" value="Send">
</form>
<%--@elvariable id="student" type="com.kerjox.entity.Student"--%>
<form:form action="/student" method="get" modelAttribute="student">
	<input type="text" name="name" path="name">
	<input type="number" name="age" path="age">
	<input type="submit" value="Send">
</form:form>
</body>
</html>
