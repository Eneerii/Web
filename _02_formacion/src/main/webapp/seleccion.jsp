<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
		<form action="AlumnosServlet">
			<select name="curso">
				<%List<String> nombres=(List<String>)request.getAttribute("nombresCursos");
				for(String s:nombres){%>
				<option value="<%=s%>"><%=s%></option>
				  <%}%>
			</select>
			<br><br>
			<input type="submit" value= "ver alumnos">
		</form>
</center>

</body>
</html>