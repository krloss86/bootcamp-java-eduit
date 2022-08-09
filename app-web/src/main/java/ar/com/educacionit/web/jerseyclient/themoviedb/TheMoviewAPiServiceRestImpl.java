package ar.com.educacionit.web.jerseyclient.themoviedb;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class TheMoviewAPiServiceRestImpl implements TheMovieApiService {

	private String URL;
	private String API_KEY;
	
	public TheMoviewAPiServiceRestImpl() {
		URL = "https://api.themoviedb.org/3";
		API_KEY = "f4e274acbb7f90c87b86ade5c873c6c8";
	}
	
	@Override
	public Discover discover() {
		// Client
		Client client = ClientBuilder.newClient();

		// WebTarget
		// https://reqres.in/api/users/2
		WebTarget webTarget = client.target(URL+"/discover/movie?api_key="+API_KEY+"&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1&with_watch_monetization_types=flatrate");

		// Invocation
		Invocation.Builder invocation = webTarget.request(MediaType.APPLICATION_JSON);

		// get
		Response response = invocation.get();
		// json dinamico

		Discover movie = response.readEntity(Discover.class);
		
		return movie;
	}

}
