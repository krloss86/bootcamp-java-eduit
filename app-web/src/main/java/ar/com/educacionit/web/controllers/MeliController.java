package ar.com.educacionit.web.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.Site;
import ar.com.educacionit.services.MeliSiteService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.MeliSiteServiceImpl;
import ar.com.educacionit.web.jerseyclient.meli.MeliSite;
import ar.com.educacionit.web.jerseyclient.meli.MeliSiteRestExecutor;

@WebServlet("/api/meli/MeliController")
public class MeliController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//db
		MeliSiteService service = new MeliSiteServiceImpl();
		
		List<Site> sitesDb = new ArrayList<>();
		try {
			sitesDb = service.findAll();
		} catch (ServiceException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(!sitesDb.isEmpty()) {
			resp.getWriter().print(sitesDb);
		}else {
			//params
			MeliSiteRestExecutor meli = new MeliSiteRestExecutor("https://api.mercadolibre.com/sites");
			
			List<MeliSite> sites = meli.execute();
			
			for(MeliSite siteDto  : sites) {
				Site siteEntity = new Site(siteDto.getId(), siteDto.getName());
				try {
					service.create(siteEntity);
				} catch (ServiceException e) {
					e.printStackTrace();
				}
			}
			
			resp.getWriter().print(sites);
		}
	}
}
