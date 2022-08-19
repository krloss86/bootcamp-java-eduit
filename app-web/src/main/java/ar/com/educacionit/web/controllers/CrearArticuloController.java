package ar.com.educacionit.web.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

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

@WebServlet("/controller/CrearArticuloController")
public class CrearArticuloController extends BaseServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String precio = req.getParameter("precio");
		String titulo = req.getParameter("titulo");
		String codigo = req.getParameter("codigo");
		String stock = req.getParameter("stock");
		String categoriaId = req.getParameter("categoriaId");//1
		String marcasId = req.getParameter("marcaId");//1
		
		//valido previamente
		//IValidador validator = new AltaWebValidator(req);//request es objeto de la web.
		
		ViewsEnum target = ViewsEnum.LISTADO_CONTROLLER;
		
		ArticulosService articuloService = new ArticulosServiceImpl();
		
		try {
			
			//IValidador validator2 = new AltaValidator(precio,titulo,....);//request es objeto de la web.

			Articulo nuevo = new Articulo(titulo, codigo, null, Double.parseDouble(precio), Long.parseLong(stock), Long.parseLong(marcasId), Long.parseLong(categoriaId));
			
			articuloService.create(nuevo);
			
			//msj ok
			super.setAttribute(AttributesEnum.EXITO, req, "ArticuloDTO id"+nuevo.getId()+" OK");
		} catch (ServiceException e) {
			super.setAttribute(AttributesEnum.ERROR_GENERAL, req, e.getMessage() + "-" + e.getCause().getMessage());
			//msj error
		} /*catch (ValidatoException ve) {
			super.setAttribute(AttributesEnum.ERROR_GENERAL, req, e.getMessage());
		}*/
		//de un controller voy a otro controller
		//getServletContext().getRequestDispatcher("/controller/ListadoController").forward(req, resp);
		
		redirect(target, req, resp);
	}

}
