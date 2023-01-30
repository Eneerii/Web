package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.List;

import model.Empleado;

public class EmpleadosService {
	private Path pt=Path.of("C:\\Irene Manana\\fichero\\empleados.csv");
	
	//método que reciba un empleado y lo grabe en el fichero
	public void altaEmpleado (Empleado empleado) {
		//Creamos una línea de caracteres con los datos del empleado separados por "," porque no está indicado como guardarlo en el Files
		String linea=empleado.getNombre()+","+empleado.getDepartamento()+","+empleado.getSalario()+","+empleado.getSalario();
		try {
			Files.writeString(pt, linea+System.lineSeparator(),StandardOpenOption.APPEND);
		}catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	//método que devuelva una lista de empleados de un determinado departamento
	public List<Empleado> EmpleadosPorDepartamento(String departamento) {
		
	}
	
	//método que devuelva una lista de departamentos
	
	public List<String> buscarDepartamento(){
		
	}
	
}
