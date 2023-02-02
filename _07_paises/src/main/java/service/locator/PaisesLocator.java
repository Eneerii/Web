package service.locator;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

import com.google.gson.Gson;

import model.Pais;

public class PaisesLocator {
	String url="C:\\Irene Manana\\fichero\\paises.json";
	Gson gson=new Gson();
	public Stream<Pais> getJsonStream(){//ponemos public para poder llamarlo desde fuera de la clase
		try(FileReader fr=new FileReader(url);){
			Pais[] empleados=gson.fromJson(fr, Pais[].class);
			return Arrays.stream(empleados);
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return Stream.empty();
		}
	}

}
