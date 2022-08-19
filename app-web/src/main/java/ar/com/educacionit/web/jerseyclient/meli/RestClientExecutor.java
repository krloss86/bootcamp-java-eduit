package ar.com.educacionit.web.jerseyclient.meli;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public abstract class RestClientExecutor<T> {

	//url
	protected String urlRestApi;//ej: https://reqres.in/
	
	public RestClientExecutor(String urlRestApi) {
		this.urlRestApi = urlRestApi;
	}
	
	public T execute() {
		
		//Client
		Client client = ClientBuilder.newClient();
		
		//WebTarget 
		//https://reqres.in/api/users/2
		WebTarget webTarget = this.buildWebTargert(client);//client.target("https://api.mercadolibre.com/").path("sites");
		
		//Invocation
		Invocation.Builder invocation = webTarget.request(MediaType.APPLICATION_JSON);
		
		//get
		Response response = this.buidResponse(invocation);//invocation.get();
		//json dinamico
		
		//List<MeliSite> user = response.readEntity(new GenericType<List<MeliSite>>() {});
		//List<MeliSite> user = response.readEntity(List.class);
		T responseDto = this.buildResponseDTO(response);
		
		return responseDto;
	}

	protected abstract T buildResponseDTO(Response response);

	private Response buidResponse(Builder invocation) {
		return invocation.get();
	}

	private WebTarget buildWebTargert(Client client) {		
		return client.target(this.getUrlRestApi());
	}
	
	public String getUrlRestApi() {
		return this.urlRestApi;
	}
}
