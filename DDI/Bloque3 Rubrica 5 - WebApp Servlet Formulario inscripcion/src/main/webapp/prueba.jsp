<%--
  Created by IntelliJ IDEA.
  User: dani
  Date: 8/11/21
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>Prueba</title>
</head>
<body>
${requestScope.persona.id}
${requestScope.persona.name}
${requestScope.persona.birthday}
${requestScope.persona.age}
<c:if test="${requestScope.persona.step == 1}">
	<c:out value="Primero"></c:out>
</c:if>
<c:if test="${requestScope.persona.step == 2}">
	<c:out value="Segundo"></c:out>
</c:if>

</body>
</html>
