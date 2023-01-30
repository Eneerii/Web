<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List , model.Empleado, java.time.format.DateTimeFormatter"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 60%;
}


tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
<body>
	<center>
		
		<br>
		<br>
	    <br>
	    <h2>Listado de empleados del departamento de <u><%=(String)request.getAttribute("Departamento")%></u></h2>
	    
		<%List<Empleado> empleados=(List<Empleado>)request.getAttribute("ListaEmpleados");
		  DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-YYYY");%>		  
		
		<table border="4" cellpadding="5">
			<tr><th><FONT SIZE=4>  Nombre  </FONT></th><th><FONT SIZE=4>  Salario  </FONT> </th><th><FONT SIZE=4>  Fecha de alta  </FONT></th></tr>
			<%for(Empleado e: empleados){%>
				<tr>
					<td><center><%=e.getNombre()%> </center>	</td>					
					<td><center><%=e.getSalario()%> </center>	</td>
					<td><center><%=e.getFecha().format(formato)%> </center>	</td>				
				</tr>		
			<%}%>
		</table>
		<br>
		<br>
	    <br>
		<br>
		<a href="inicio.html"><strong>Volver a inicio</strong></a>
 </center>	

</body>
</html>