package ar.com.educacionit.web.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.Articulo;
import ar.com.educacionit.services.ArticulosService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ArticulosServiceImpl;
import ar.com.educacionit.services.parser.ArticuloDTO;
import ar.com.educacionit.web.enums.AttributesEnum;
import ar.com.educacionit.web.enums.ViewsEnum;

@WebServlet("/controllers/CargarController")
@MultipartConfig
public class CargarController extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		ViewsEnum target = ViewsEnum.UPLOAD_PREVIEW;
		
		//bajar la lista de la sesion
		Collection<ArticuloDTO> datos = (Collection<ArticuloDTO>)req.getSession().getAttribute(AttributesEnum.UPLOAD_PREVIEW_KEY.getValue());
		
		if(datos == null) {
			datos = new ArrayList<>();
		}
		
		//grabar cada producto
		List<Articulo> oks = new ArrayList<>();
		List<ArticuloDTO> fails = new ArrayList<>();
		
		ArticulosService service = new ArticulosServiceImpl();
		
		for(ArticuloDTO aux : datos) {
			//TODO : agregar stock marca y categoria al archivo
			Articulo entity= new Articulo(aux.getTitle(), aux.getCode(), new Date(), aux.getPrice(), 1L, 1L, 1L);
			try {
				service.create(entity);
				oks.add(entity);
			} catch (ServiceException e) {
				fails.add(aux);
			}	
		}
		
		super.setAttribute(AttributesEnum.ARTICULOS_OKS, req, oks);
		super.setAttribute(AttributesEnum.ARTICULOS_FAILS, req.getSession(), fails);
		
		redirect(target, req, resp);
	}
}
