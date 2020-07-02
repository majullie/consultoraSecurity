<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Registro Accidentes</title>
</head>
<body>

<h1>Editar Registro de Accidentes</h1>

<form action="EditarRegistroAccideente" method="post">
	Nombre: <input type="text" name="txtnombre" value="${datosregistro.nombre}" /><br/>
	Apellido: <input type="text" name="txtapellido" value="${datosregistro.apellido}" /> <br/>
	Area Accidente: <input type="text" name="txtarea" value="${datosregistro.areaAccidente}" /> <br/>
	<input type="hidden" name="hdnidregistro"  value="${datosregistro.idAccidentes}" />
	<input type="submit" value="Agregar registro" />
</form>

<a href="${pageContext.request.contextPath}/ListarRegistrosAccidentes">Volver al Historial de Accidentes</a>

</body>
</html>