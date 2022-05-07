package ar.com.educacionit.services;

import java.util.List;

import ar.com.educacionit.domain.Articulo;
import ar.com.educacionit.services.exceptions.ServiceException;

public interface ArticulosService {

	/**
	 * Obtiene un articulo dado su id=PK 
	 * @return
	 * @throws ServiceException 
	 */
	public Articulo getById(Long id) throws ServiceException;
 	
	public void deleteArticulo(Long id) throws ServiceException;
	
	public void updateArticulo(Articulo entity) throws ServiceException;

	public List<Articulo> obtenerTodos() throws ServiceException;
}
