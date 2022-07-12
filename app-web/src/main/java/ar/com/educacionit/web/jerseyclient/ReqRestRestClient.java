package ar.com.educacionit.web.jerseyclient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ReqRestRestClient {

	public static void main(String[] args) {
		
		//Client
		Client client = ClientBuilder.newClient();
		
		//WebTarget 
		//https://reqres.in/api/users/2
		WebTarget webTarget = client.target("https://reqres.in/").path("api/users/2");
		
		//Invocation
		Invocation.Builder invocation = webTarget.request(MediaType.APPLICATION_JSON);
		
		//get
		Response response = invocation.get();
		//json dinamico
		
		ReqResUser user = response.readEntity(ReqResUser.class);
		
		System.out.println(user);
	}
}
