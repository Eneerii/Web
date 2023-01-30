package service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import model.Alumno;
import model.Curso;

public class FormacionService {
	private static List<Curso> cursos=List.of(new Curso("Java for dummies",50,List.of(			
	   new Alumno("alumno1",25,7),
			new Alumno("alumno2",32,2),
			new Alumno("alumno3",19,8)
			)),
       new Curso("Spring",60,List.of(			
	        new Alumno("alumno5",18,6.9),
			new Alumno("alumno4",40,3.2),
			new Alumno("alumno8",28,6)
		    )),
       new Curso("JavaScript",75,List.of(			
			new Alumno("alumno2",32,7.1),
			new Alumno("alumno4",40,8.3),
			new Alumno("alumno7",33,4)
		    ))
);
	//duración media de todos los cursos
	public double duracionMedia () {
		int media;
		return cursos.stream()
			  .collect(Collectors.averagingInt(c->c.duracion()));
	}
	//lista de cursos con numero de alumnos inferior a un determinado valor
	
	public List<Curso> cursosInferiorAlumnos(int numAlumnos){
		return cursos.stream()
				.filter(c->c.matriculas().size()<numAlumnos) //Stream<Curso>
				.toList();
		
	}
	
	//edad media del curso de una determinada denominación
	public double duracionMediaCursos (String denominacion) {
		return cursos.stream()
				.filter(c->c.denominacion().equals(denominacion))//Stream<Curso>
		        .flatMap(c->c.matriculas().stream()) //Stream<Alumno>
		        .collect(Collectors.averagingDouble(a->a.edad()));
	}
	
	//Lista de nombres de alumnos
	public List<String> nombresAlumnos(){
		return cursos.stream()
				.flatMap(c->c.matriculas().stream())
				.map(a->a.nombre()) //Stream<String>
				.toList();
				
		
	}
	//nota media de todos los alumnos
	public double notaMediaCursos () {
		return cursos.stream()
				.flatMap(c-> c.matriculas().stream()) //Stream<Alumno>
				.collect(Collectors.averagingDouble(a->a.nota()));
				
	}
	//lista de alumnos aprobados
	
	public List<Alumno> aprobados(){
		return cursos.stream()
			   .flatMap(c->c.matriculas().stream()) //Stream<Alumno>
			   .filter(a->a.nota()>5) //Stream<Alumno>
			   //.collect(Collectors.toList()); //List<Alumno>
			   .toList(); //igual que el anterior, pero desde java 16
		
	}
	
	//lista de nombres de cursos
	public List<String> cursos(){
		return cursos.stream()
				.map(c->c.denominacion()) //Stream<String>
				.toList();
				
	}
	
	//nota media del curso de una determinada denominación
	
	public double notaMediaPorCurso (String denominacion) {
		return cursos.stream()
				    .filter(c->c.denominacion().equals(denominacion))//Stream<Curso>
			        .flatMap(c->c.matriculas().stream()) //Stream<Alumno>
			        .collect(Collectors.averagingDouble(a->a.nota()));
		
	}
	
	//lista de alumnos de un curso de un terminada denominación
	
	public List<Alumno> alumnosPorCurso (String curso){
		return cursos.stream()
				.filter(c->c.denominacion().equals(curso))
				.flatMap(c->c.matriculas().stream())
				.toList();
		/*return cursos.stream()
				.filter(c->c.denominacion().equals(denominacion))
				.findFirst()
				.get()
				.matriculas();*/
	}

}
