<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,model.Alumno"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<center>
<%double media= (Double)request.getAttribute("mediaCurso"); %>
<%List<Alumno> alumnos= (List<Alumno>)request.getAttribute("listado");%>
<!--  montamos la tabla de alumnos -->
       <table border="2">
       <tr><th>Nombre</th><th>Edad</th><th>Nota</th></tr>
          <%for(Alumno a:alumnos) {%>
              <tr>
                <td><%=a.nombre() %> </td> 
                <td><%=a.edad() %> </td>
                <td><%=a.nota() %> </td>
              </tr>
       <%}%>
       </table>
       
      <h2>Nota media:<%=media%></h2>
      <%%>
       <br>
       <br>
       <a href="ConsultaServlet">Volver</a>
</center>

</body>
</html>