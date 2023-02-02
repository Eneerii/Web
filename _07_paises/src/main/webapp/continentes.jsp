<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1" import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<form action="PaisesServlet">
			Seleccione continente:
			<select name="continente">
				<%List<String> continentes=(List<String>)request.getAttribute("continentes");
				for(String c:continentes){%>
					<option value="<%=c%>"><%=c%></option>
				<%}%>
			</select>
			<br><br>
			<input type="submit" value="ver Paises">
		
		
		</form>
	</center>
</body>
</html>