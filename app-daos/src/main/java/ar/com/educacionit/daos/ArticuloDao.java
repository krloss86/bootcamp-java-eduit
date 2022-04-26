package ar.com.educacionit.daos;

import ar.com.educacionit.domain.Articulo;

/**
 * 
 * @author LopezCar
 *
 */
public interface ArticuloDao {

	//definir los metodos CRUD
	public Articulo create(Articulo orden);
	public Articulo read(Long id);
	public Articulo update(Articulo ordenToUpdate);
	public Articulo delete(Long id);
 }
