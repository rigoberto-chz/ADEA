<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<style>
	table, th, td {
      border: 1px solid black;
      border-collapse: collapse;
      text-align: center;
    }
    .center {
	  margin-left: auto;
	  margin-right: auto;
	}
</style>
<html>
<head>
<title>Bienvenido</title>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>
	<br/>
	<h2>${message}</h2>
	<br/>
	<form method="get" action="mantenimiento.htm">
		<button type="submit" name="status" value="A" class="button-green">Activos</button>
		<button type="submit" name="status" value="B" class="button-gray">Inactivos</button>
		<button type="submit" name="status" value="R" class="button-orange">Revocados</button>
		<br /> <br /> <br />
		<c:choose>
			<c:when test="${list.size() > 0}">
				<table style="width: 80%" class="center">
					<tr>
						<th>NOMBRE</th>
						<th>LOGIN</th>
						<th>FECHA ALTA</th>
						<th>STATUS</th>
						<th>ACCION</th>
					</tr>
					<c:forEach items="${list}" var="usuario">
						<tr>
							<td>${usuario.nombre}</td>
							<td>${usuario.login}</td>
							<td>${usuario.fechaAlta}</td>
							<td>${usuario.status}</td>
							<td>
								<button type="submit" formaction="edit.htm" name="editar" value="${usuario.login}" class="button-blue">Editar</button>
								<button type="submit" formaction="baja.htm" name="baja" value="${usuario.login}" class="button-red">Baja</button>
							</td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:when test="${list.size() == 0}">
			    No se encontro información.
			  </c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>
	</form>
</body>
</html>