package ar.com.educacionit.services;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

//import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import ar.com.educacionit.domain.Menu;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.MenuServiceImpl;

public class MenuServiceImplTestCase {

//	@Ignore
//	@Test
	public void when_find_then_show_menu_list() throws ServiceException {
		MenuService service = new MenuServiceImpl();
		List<Menu> menulist = service.findAll();
		assertTrue(menulist.isEmpty());
	}
	
	//T.D.D => desde el test hacia la implementacion
//	@Test
	public void when_find_1_then_show_it() throws ServiceException {
		MenuService service = new MenuServiceImpl();
		List<Menu> menulist = service.findAll();
		System.out.println(menulist);
		assertEquals(1, menulist.size());
	}
}
