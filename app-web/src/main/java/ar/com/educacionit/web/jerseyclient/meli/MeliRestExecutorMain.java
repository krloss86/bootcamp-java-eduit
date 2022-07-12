package ar.com.educacionit.web.jerseyclient.meli;

import java.util.List;

public class MeliRestExecutorMain {

	public static void main(String[] args) {
		MeliSiteRestExecutor meli = new MeliSiteRestExecutor("https://api.mercadolibre.com/sites");
		List<MeliSite> meliSite = meli.execute();
		System.out.println(meliSite);
	}

}
