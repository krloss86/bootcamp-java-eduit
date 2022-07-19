package ar.com.educacionit.web.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.Articulo;
import ar.com.educacionit.services.ArticulosService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ArticulosServiceImpl;
import ar.com.educacionit.web.enums.AttributesEnum;
import ar.com.educacionit.web.enums.ViewsEnum;

@WebServlet("/controller/ListadoController")
public class ListadoController extends BaseServlet {

	private static final long serialVersionUID = -3953577187787582717L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		ArticulosService ar = new ArticulosServiceImpl();
		
		//asumo una vista target
		ViewsEnum target = ViewsEnum.LISTADO;
		
		Collection<Articulo> list = new ArrayList<>();
		
		try {
			list = ar.findAll();		
		} catch (ServiceException e) {			
			//target = ViewsEnum.REGISTRO_FAIL;
			e.printStackTrace();
		}
		
		setAttribute(AttributesEnum.ARTICULOS, request, list);
		
		redirect(target, request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
