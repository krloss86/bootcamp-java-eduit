package ar.com.educacionit.services.impl;

import ar.com.educacionit.daos.db.exceptions.GenericException;
import ar.com.educacionit.daos.impl.ArticuloDaoMysqlImpl;
import ar.com.educacionit.domain.Articulo;
import ar.com.educacionit.services.ArticulosService;
import ar.com.educacionit.services.exceptions.ServiceException;

public class ArticulosServiceImpl extends AbstractBaseService<Articulo> implements ArticulosService {

	public ArticulosServiceImpl() {
		super(new ArticuloDaoMysqlImpl());
	}
	
	@Override
	public Articulo getByCodigo(String codigo) throws ServiceException {
		try {
			return ((ArticuloDaoMysqlImpl)dao).getByCode(codigo);
		} catch (GenericException e) {			
			throw new ServiceException("Error al consutlar T",e);
		}
	}
}
