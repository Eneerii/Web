package service;

import java.util.List;

import model.Pais;
import service.locator.PaisesLocator;

public class PaisesService {
	PaisesLocator sl=new PaisesLocator();
	//método que devuelve una lista de continentes
	public List<String> buscarContinentes(){
		return sl.getJsonStream()
		.map(p->p.getRegion())
		.toList();		
	}
	//método que devuelve una tabla con las características de cada país 
	
	public List<Pais> consultaPaisesContinente(String region){
		return sl.getJsonStream()
		.filter(e->e.getRegion().equals(region))
		.toList();
	}
}
