package ar.com.educacionit.web.controllers;

import java.io.IOException;

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
		String categoriaId = req.getParameter("categoria");//1
		String marcasId = req.getParameter("marcas");//1
		
		ViewsEnum target = ViewsEnum.LISTADO;
		
		try {
			ArticulosService articuloService = new ArticulosServiceImpl();

			Articulo nuevo = new Articulo(titulo, codigo, null, Double.parseDouble(precio), Long.parseLong(stock), Long.parseLong(marcasId), Long.parseLong(categoriaId));
			
			articuloService.create(nuevo);
			
			//msj ok
			super.setAttribute(AttributesEnum.EXITO, req, "Producto id"+nuevo.getId()+" OK");
		} catch (ServiceException e) {
			super.setAttribute(AttributesEnum.ERROR_GENERAL, req, e.getMessage());
			//msj error
		}
		
		redirect(target, req, resp);
	}

}
