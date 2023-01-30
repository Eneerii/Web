<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script> 
</head>
<body>
	<center>
		<br><br><br><br>
		
		<form action="EmpleadosServlet">
			<select name="dpto">
				 <option value="selecciona">Selecciona un departamento</option>
				<%List<String> deps=(List<String>)request.getAttribute("departamentos");
				for(String s:deps){%>
					<option value = "<%=s%>"><%=s%></option>
				<%}%>
			</select>
			<br><br><br><br><br><br><br><br>
			<input type="submit" value="Ver empleados">
		</form>
	
	
	</center>

</body>
</html>