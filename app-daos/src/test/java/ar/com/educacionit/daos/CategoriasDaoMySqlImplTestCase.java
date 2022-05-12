package ar.com.educacionit.daos;

import java.util.List;

import ar.com.educacionit.daos.db.exceptions.GenericException;
import ar.com.educacionit.daos.impl.CategoriasDaoMysqlImpl;
import ar.com.educacionit.domain.Categorias;

public class CategoriasDaoMySqlImplTestCase {

	public static void main(String[] args) throws GenericException {
		
		//test when_findall_then_showlist

		CategoriasDao dao = new CategoriasDaoMysqlImpl();
		
		List<Categorias> list = dao.findAll();
		
		System.out.println(list.size() > 0);
	}

}
