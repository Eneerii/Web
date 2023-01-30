package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import model.Empleado;

public class EmpleadosService {
	private Path ruta= Path.of("c:\\ficheroseclipse\\empleados.txt");
	DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	public EmpleadosService () {
		try {
			Files.createFile(ruta);
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}
	
	// recibe un empleado y lo guarda
	public void altaEmpleado (Empleado empleado) {
		
		String linea = empleado.getNombre()+","+empleado.getDepartamento()+","+empleado.getSalario()+","+LocalDate.now();
		
		try {
			Files.writeString(ruta, linea+System.lineSeparator() ,  StandardOpenOption.APPEND);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	//devuelve la lista de empleados de un determinado departamento
	public List<Empleado>  empleadosPorDepartamento(String dpto) {
		/*Empleado emp = new Empleado();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-mm-dd");
		ArrayList <Empleado> res = new ArrayList<>();

		try {
			List<String> Listalineas = Files.readAllLines(ruta);   // Devuelve Lista de lineas (... , ... , .... ,....)			
			for (String s : Listalineas) {
				
				String[] linea=s.split("[,]");
				Empleado e = new Empleado (linea[0], linea[1], Double.parseDouble(linea[2]), LocalDate.parse(linea[3],format));
				if (e.getDepartamento().equalsIgnoreCase(dpto)) {
					res.add(e);					
				}
			}			 
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return res;*/
		
		 try {
			//Stream<String> streamlineas = Files.lines(ruta);   // stream de lineas string (....  ,  .... ,  ....  ,  ....)
			
			//Quiero convertir a Stream <Empleado>  primera casilla nombre, segunda casilla dpto, tercera salario, cuarta fecha
			/*return Files.lines(ruta)
						.map( c -> new Empleado (c.split("[,]")[0], c.split("[,]")[1], Double.parseDouble(c.split("[,]")[2]), LocalDate.parse(c.split("[,]")[3],format)))
						.filter( e -> e.getDepartamento().equalsIgnoreCase(dpto))
						.toList();*/
			
			return Files.lines(ruta)
					.map( c -> {
							    String [] datos = c.split("[,]");
					            return new Empleado (datos[0], datos[1], Double.parseDouble(datos[2]), LocalDate.parse(datos[3],format));							
							   })
					.filter( e -> e.getDepartamento().equalsIgnoreCase(dpto))
					.toList();
			    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return List.of();
		}  
		     
	}
	
	
	//devuelve una lista de departamentos
	
	public List<String> departamentos () {
		try {
			return Files.lines(ruta)
					.map( l -> l.split("[,]")[1])
					.distinct()
					.toList();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return List.of();
		}
		
	}
		
	
	
}
