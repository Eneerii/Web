<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,model.Pais"%>
<!DOCTYPE html>
<html>

<head>
 <!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script> 
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h2>Paises del continente: <%=request.getAttribute("continente") %></h2>
		<%List<Pais> paises=(List<Pais>)request.getAttribute("paises"); %>
		<table class=o"table table-striped table-bordered">
			<tr><th>Nombre</th><th>Capital</th><th>Poblacion</th><th>Bandera</th></tr>
			<!-- Recorro la lista de empleados y generamos una fila en la tabla por cada empleado -->
			<%for(Pais p:paises){ %>
				<tr>
					<td><%=p.getName()%></td>
					<td><%=p.getCapital()%></td>
					<td><%=p.getPopulation()%></td>
					<td><img src="<%=p.getFlag() %> "width="32" height="16"></td>
				</tr>
			<%} %>
		</table>
		<br><br>
		<a href="inicio.html">Volver</a>
	</div>
</body>
</html>