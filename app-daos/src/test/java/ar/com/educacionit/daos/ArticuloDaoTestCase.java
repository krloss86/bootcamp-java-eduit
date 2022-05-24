package ar.com.educacionit.daos;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import ar.com.educacionit.daos.db.exceptions.DuplicatedException;
import ar.com.educacionit.daos.db.exceptions.GenericException;
import ar.com.educacionit.daos.impl.ArticuloDaoMysqlImpl;
import ar.com.educacionit.domain.Articulo;

@TestMethodOrder(OrderAnnotation.class)
public class ArticuloDaoTestCase {

	@Order(1)
	@Test
	public void then_initialize_then_showIt() {
		ArticuloDao art = new ArticuloDaoMysqlImpl();
		assertNotNull(art);
	}
	
	@Order(2)
//	@Test
	public void when_newArticulo_then_persistIt() throws GenericException, DuplicatedException {
		//quiero probar el metodo save
		ArticuloDao art = new ArticuloDaoMysqlImpl();
		
		//necesito un articulo
		Articulo newArticulo = new Articulo("titulo", "codigo001", new java.util.Date(), 1500d, 100l, 1l, 1l);
		
		art.save(newArticulo);
	
		assertNotNull(newArticulo.getId());
	}
	
	@Order(3)
	@Test
	public void when_finAll_then_listIt() throws GenericException, DuplicatedException {
		//quiero probar el metodo save
		ArticuloDao art = new ArticuloDaoMysqlImpl();
		
		List<Articulo> arts = art.findAll();
	
		assertNotEquals(0, arts.size());
		assertEquals(9, arts.size());
	}
	
	@Order(4)
	@Test
	public void when_getOneByCode_then_showIt() throws GenericException {	
		ArticuloDao artDao = new ArticuloDaoMysqlImpl();
		
		Articulo art = artDao.getByCode("codigo001"); 
		
		assertEquals("codigo001", art.getCodigo());
	}
	
	@Order(5)
	@Test
	public void when_exists_then_updateIt() throws GenericException, DuplicatedException {
		ArticuloDao artDao = new ArticuloDaoMysqlImpl();
		
		Articulo art = artDao.getByCode("med001");
		
		art.setTitulo("nuevo titulo");
		art.setCodigo("0000003");
		
		artDao.update(art);
		
		assertEquals("nuevo titulo", art.getTitulo());
	}
	
	// insert, update, delete
	@Test
	public void when_create_update_delete_then_notExits() throws GenericException, DuplicatedException {
		ArticuloDao artDao = new ArticuloDaoMysqlImpl();
		// Test save
		Articulo testArticulo = new Articulo("tituloTest", "codigoTest", new java.util.Date(), 1500d, 100l, 1l, 1l);
		artDao.save(testArticulo);
		
		Long id = testArticulo.getId();
		assertNotNull(id);

		// Test update
		testArticulo = artDao.getByCode("codigoTest");
		testArticulo.setTitulo("codigoTestUpdated");
		artDao.update(testArticulo);
		assertEquals("codigoTestUpdated", testArticulo.getTitulo());

		// Test delete
		artDao.delete(id);
		//buscar si existe art con ese id

		//opcional!
		Articulo artDeleted =  artDao.getByPK(id) ;
		assertNull(artDeleted);
	}
	
	@Test
	public void when_duplicate_then_throw_exception() throws GenericException, DuplicatedException {
		//quiero probar el metodo save
		ArticuloDao art = new ArticuloDaoMysqlImpl();
		
		//necesito un articulo
		Articulo newArticulo = new Articulo("titulo", "codigo1001", new java.util.Date(), 1500d, 100l, 1l, 1l);
		
		art.save(newArticulo);
		
		assertThrows(DuplicatedException.class, () -> {
			newArticulo.setCodigo("codigo1002");
			art.save(newArticulo);			
		});
		
	}
}
