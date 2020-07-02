<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulario de Registro de accidentes</title>
</head>
<body>
<h1>Formulario de Registro de accidentes</h1>

<table>
	<tr>
		<th>ID</th>
		<th>Nombre</th>
		<th>Apellido</th>
		<th>Area Accidente</th>
		<th>Solicitud</th>
	</tr>
	
<c:forEach items="${listadoRegistroAccidente}" var="rgst">
<tr>
		<td>${rgst.idAccidentes}</td>
		<td>${rgst.nombre}</td>
		<td>${rgst.apellido}</td>
		<td>${rgst.areaAccidente}</td>
		<td>
			<a href="${pageContext.request.contextPath}/EliminarRegistroAccidente?id=${rgst.idAccidentes}">Eliminar</a>
			&nbsp;
			<a href="${pageContext.request.contextPath}/EditarRegistroAccidente?id=${rgst.idAccidentes}">Editar</a>
		</td>
	</tr>
	
</c:forEach>
</table>
<a href="${pageContext.request.contextPath}/CrearRegistroAcc">Crear Registro</a>
<br>
<c:out value="${cumensaje}"/>
</body>
</html>