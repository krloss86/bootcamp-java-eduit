package ar.com.educacionit.web.controllers;

import ar.com.educacionit.domain.Articulo;
import ar.com.educacionit.services.ArticulosService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ArticulosServiceImpl;

public class ArticuloController {

	public static void main(String[] args) {
		
		//necesito el service
		ArticulosService service = new ArticulosServiceImpl();
		
		try {
			Articulo articulo =  service.getById(4l);
			
			System.out.println(articulo);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}

}
