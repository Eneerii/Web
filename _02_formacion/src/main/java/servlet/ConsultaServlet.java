package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.FormacionService;

@WebServlet("/ConsultaServlet")
public class ConsultaServlet extends HttpServlet {


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//debe recoger la lista de nombres de cursos, guardarla en algún lugar que sea accesible para el JSP, y después
		//transferir el control a la página seleccion.jsp
		FormacionService fs= new FormacionService();
		List<String> listaCursos= fs.cursos();
		request.setAttribute("nombresCursos", listaCursos);
		request.getRequestDispatcher("seleccion.jsp").forward(request,response); 
	}

}
