package ar.com.educacionit.web.jerseyclient.meli;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class MeiSiteRestClient {

	public static void main(String[] args) {
		
		//Client
		Client client = ClientBuilder.newClient();
		
		//WebTarget 
		//https://reqres.in/api/users/2
		WebTarget webTarget = client.target("https://api.mercadolibre.com/").path("sites");
		
		//Invocation
		Invocation.Builder invocation = webTarget.request(MediaType.APPLICATION_JSON);
		
		//get
		Response response = invocation.get();
		//json dinamico
		
		List<MeliSite> user = response.readEntity(new GenericType<List<MeliSite>>() {});
		
		//List<MeliSite> user = response.readEntity(List.class);
		System.out.println(user);
		
		Set<String> names = user.stream()
				.map(site -> site.getName())
				.collect(Collectors.toSet());
				
		System.out.println(names);
	}
}
