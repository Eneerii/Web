package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pais;
import service.PaisesService;

@WebServlet("/PaisesServlet")
public class PaisesServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recogemos el parametro que contiene el continente seleccionado
				//después obtenemos la lista de paises de ese continente
				//lo guardamos en un atributo y transferimos el control a la JSP
				PaisesService service=new PaisesService();
				String continente=request.getParameter("continente"); //recogemos el parámetro con el continente seleccionado
				List<Pais> paises=service.consultaPaisesContinente(continente);
				//guardamos paies y continente seleccionado
				request.setAttribute("paises", paises);
				request.setAttribute("region", continente);
				request.getRequestDispatcher("paises.jsp").forward(request, response);
	}

}
