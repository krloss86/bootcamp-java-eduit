package ar.com.educacionit.services.impl;

import ar.com.educacionit.daos.impl.MeliSIteDaoMysqlImpl;
import ar.com.educacionit.domain.Site;
import ar.com.educacionit.services.MeliSiteService;

public class MeliSiteServiceImpl extends AbstractBaseService<Site> implements MeliSiteService {

	public MeliSiteServiceImpl() {
		super(new MeliSIteDaoMysqlImpl());
	}
	
}
