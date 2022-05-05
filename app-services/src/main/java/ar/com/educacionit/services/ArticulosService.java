package ar.com.educacionit.services;

import ar.com.educacionit.domain.Articulo;
import ar.com.educacionit.services.exceptions.ServiceException;

public interface ArticulosService {

	/**
	 * Obtiene un articulo dado su id=PK 
	 * @return
	 * @throws ServiceException 
	 */
	public Articulo getById(Long id) throws ServiceException;
}
