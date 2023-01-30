package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Alumno;
import service.FormacionService;

@WebServlet("/AlumnosServlet")
public class AlumnosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recoge el parámetro que contiene el nombre del curso selecciondo, después obtiene la lista de alumnos de ese curso, la guarda en un lugar
		//accesible para el JSP y transfiere el control a la página alumnos.jsp
		FormacionService fs= new FormacionService();
		String curso=request.getParameter("curso");
		List<Alumno> alumnosCurso=fs.alumnosPorCurso("curso");
		double media =fs.notaMediaPorCurso(curso);
		request.setAttribute("mediaCurso", media); 
		request.setAttribute("listado",alumnosCurso);
		request.getRequestDispatcher("alumnos.jsp").forward(request, response);
		

	}

}
