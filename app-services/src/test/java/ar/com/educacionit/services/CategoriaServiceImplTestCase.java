package ar.com.educacionit.services;

import java.util.List;

import ar.com.educacionit.domain.Categorias;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.CategoriasServiceImpl;

public class CategoriaServiceImplTestCase {

	public static void main(String[] args) throws ServiceException {
		
		CategoriasService service = new CategoriasServiceImpl();
		
		List<Categorias> list = service.findAll();
		
		System.out.println(list.size() > 0);
	}
}
