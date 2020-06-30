<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crear Registro</title>
</head>
<body>
<h1>Crear Registro</h1>


<form action="CrearRegistroAcc" method="post">
Nombre: <input type="text" name="txtnombre"/><br/>
Apellido: <input type="text" name="txtapellido"/><br/>
Area Accidente: <input type="text" name="txtarea"/><br/>
<input type="submit" value="Agregar registro"/>
</form>
<a href="${pageContext.request.contextPath}/FormRegAccidente">Volver al historial</a>
<br>
<c:out value="${cumensaje}"/>
</body>
</html>