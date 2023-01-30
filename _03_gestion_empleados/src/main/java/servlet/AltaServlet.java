package servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Empleado;
import service.EmpleadosService;

@WebServlet("/AltaServlet")
public class AltaServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmpleadosService service = new EmpleadosService();		
		String nombre = request.getParameter("nombre");
		String departamento =  request.getParameter("departamento");
		double salario =  Double.parseDouble(request.getParameter("salario"));
		LocalDate fecha = LocalDate.now();		
		service.altaEmpleado(new Empleado(nombre, departamento, salario, fecha ));
		request.getRequestDispatcher("inicio.html").forward(request, response);
	}

}
