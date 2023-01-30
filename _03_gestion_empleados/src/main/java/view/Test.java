package view;

import java.time.format.DateTimeFormatter;
import java.util.List;

import model.Empleado;
import service.EmpleadosService;

public class Test {
	static EmpleadosService service= new EmpleadosService();
	public static void main(String[] args) {

		System.out.println(service.departamentos());
		System.out.println(service.empleadosPorDepartamento("rrhh"));
	//	service.altaEmpleado(new Empleado("juan", "rrhh", 2800, LocalDate.now()));
		List<Empleado> emp = service.empleadosPorDepartamento("rrhh");
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-YYYY");
		emp.stream()
		   .forEach(e -> System.out.println(e.getFecha().format(formato)));
	}

}
