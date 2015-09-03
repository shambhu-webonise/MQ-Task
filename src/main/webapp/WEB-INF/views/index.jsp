<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
	<title>MQ - Home</title>
</head>
<body>
<div align="center">
<h1>
	Message Queue Example  
</h1>
<form action="enque" method="POST">
	<input type="text" name="enqueText" placeholder="Messages..."/>
	<button type="submit">ENQUE</button>
</form>
</div>
<hr />

<div align="center">
	
	<p><h3>${queueName}</h3>${queueMessages}</p>
</div>
<div>
</body>
</html>
