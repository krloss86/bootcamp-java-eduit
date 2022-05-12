package ar.com.educacionit.daos;


import ar.com.educacionit.daos.db.exceptions.GenericException;
import ar.com.educacionit.domain.Articulo;

/**
 * 
 * @author LopezCar
 *
 */
public interface ArticuloDao extends GenericDao<Articulo>{

	//no forma parte del crud
	public Articulo getByCode(String codigo) throws GenericException;
 }
