package ar.com.educacionit.web.jerseyclient.meli;

import java.util.List;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

public class MeliSiteRestExecutor extends RestClientExecutor<List<MeliSite>> {

	public MeliSiteRestExecutor(String urlRestApi) {
		super(urlRestApi);
	}

	@Override
	protected List<MeliSite> buildResponseDTO(Response response) {
		//return response.readEntity(List.class);
		return response.readEntity(new GenericType<List<MeliSite>>() {});
	}

}
