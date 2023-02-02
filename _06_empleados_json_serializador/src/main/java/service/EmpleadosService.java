package service;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.Empleado;

public class EmpleadosService {
	String url="C:\\Irene Manana\\fichero\\empleados.json";
	//Gson gson=new Gson();
	Gson gson=(new GsonBuilder())
			.registerTypeAdapter(LocalDate.class,new Adaptador())
			.create();
	
	private Stream<Empleado> getJsonStream(){
		try(FileReader fr=new FileReader(url);){
			Empleado[] empleados=gson.fromJson(fr, Empleado[].class);
			return Arrays.stream(empleados);
 		}
		catch(IOException ex) {
			ex.printStackTrace();
			return Stream.empty();
		}
	}
	public void guardarEmpleado(Empleado empleado) {
		//creamos un ArrayList para poder guardar el objeto de empleado
		ArrayList<Empleado> lista=new ArrayList<>(getJsonStream().toList());
		lista.add(empleado);
		try(FileWriter fw=new FileWriter(url);){
			gson.toJson(lista,fw);
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	
	}
	
	
	//método que devuelva la lista de empleados de un determinado departamento
	public List<Empleado> empleadosDepartamento(String departamento){
		return getJsonStream()
		.filter(e->e.getDepartamento().equals(departamento))
		.toList();
		
	}

	//método que devuelva una lista de departamentos
	public List<String> departamentos(){
		return getJsonStream()//stream <Empleado>
		.map(e-> e.getDepartamento()) //Stream<String>
		.distinct()
		.toList();
		
	}
	
}
