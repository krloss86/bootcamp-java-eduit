package ar.com.educacionit.web.jerseyclient;

import java.util.List;

public interface RestClient<T> {

	public T get(String userId);
	
	public List<T> find();
}
