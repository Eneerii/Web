package principal;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import model.Curso;

public class TestEscritura {


	public static void main(String[] args) {
		String url="C:\\Irene Manana\\fichero\\cursos.json";
		Curso curso=new Curso("al4","JavaScript",6.7);
		//recuperamos el JSON completo. Añadimos el objeto, y después escribimos todo el contenido de nuevo
		Gson gson=new Gson();
		ArrayList<Curso> lista;
		
		try(FileReader fr=new FileReader(url);){ 
			Curso[] cursos=gson.fromJson(fr, Curso[].class);
			lista=new ArrayList<>(List.of(cursos)); //esta instrucción crea un arrayList a partir de un Array
			lista.add(curso); //añadimos nuevo curso al fichero
			
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return;
		}
		
		try(FileWriter fw=new FileWriter(url);){//modo append (añadiendo true)te da permiso de escribir y añadir, no destruir lo que ya hay
			gson.toJson(lista, fw); //escribimos en el fichero la lista entera
			System.out.println("Curso guardado!");
			
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}

	}

}
