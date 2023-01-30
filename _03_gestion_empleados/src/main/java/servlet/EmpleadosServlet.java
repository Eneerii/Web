package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Empleado;
import service.EmpleadosService;


@WebServlet("/EmpleadosServlet")
public class EmpleadosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmpleadosService service = new EmpleadosService();		
		String departamento = request.getParameter("dpto");
		List<Empleado> empleados = service.empleadosPorDepartamento(departamento);
		request.setAttribute("ListaEmpleados", empleados);
		request.setAttribute("Departamento", departamento);		
		request.getRequestDispatcher("empleados.jsp").forward(request, response);
	}

}
