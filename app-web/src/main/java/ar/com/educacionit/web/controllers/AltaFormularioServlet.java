package ar.com.educacionit.web.controllers;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.Articulo;
import ar.com.educacionit.services.ArticulosService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ArticulosServiceImpl;

@WebServlet("/controller/AltaFormularioServlet")
public class AltaFormularioServlet extends HttpServlet {

	private static final long serialVersionUID = -3953577187787582717L;
	
	//GET
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String fecha = request.getParameter("fecha");//> String
		
		ArticulosService ar = new ArticulosServiceImpl();
		try {
			Collection<Articulo> list = ar.findAll();			
			request.setAttribute("articulos", list);
			//OK
			getServletContext().getRequestDispatcher("/registroOk.jsp").forward(request, response);
		} catch (ServiceException e) {
			//FAIL
			getServletContext().getRequestDispatcher("/registroFail.jsp").forward(request, response);
		}
		
	}
}
