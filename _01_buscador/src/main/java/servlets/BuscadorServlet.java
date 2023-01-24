package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pagina;
import service.BuscadorService;

//informa al servidor de aplicaciones de que esa clase es un servlet y tiene como dirección indicada:
@WebServlet("/BuscadorServlet") //Anotación para decirle al servidor que este servlte tiene esta aplicación
public class BuscadorServlet extends HttpServlet {
     
	//sobrescritura del método service
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//creamos un objeto de la capa de negocio
		BuscadorService buscadorService=new BuscadorService();
		//recoge el parámetro (datos enviados desde la pagina cliente)
		String tema=request.getParameter("tema");
		//obtenemos lista de páginas de dicho tema
		List<Pagina> paginas=buscadorService.buscador(tema);
		//guardamos la lista en un atributo de petición para que pueda recogerlo la JSP
		request.setAttribute("paginas", paginas);
		//transfiero el control a la página JSP, o sea, se ejecuta el JSP
		request.getRequestDispatcher("resultado.jsp").forward(request,response); 
	}

}
