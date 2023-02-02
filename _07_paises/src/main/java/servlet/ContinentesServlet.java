package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.PaisesService;

@WebServlet("/ContinentesServlet")
public class ContinentesServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recoge la lista de continentes y se la pasa al JSP
		PaisesService service=new PaisesService();
		List<String> continentes= service.buscarContinentes();
		request.setAttribute("continentes",continentes);
		request.getRequestDispatcher("continentes.jsp").forward(request, response);
	}

}
