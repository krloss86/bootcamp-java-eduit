package ar.com.educacionit.web.jerseyclient.themoviedb;

import java.util.List;
import java.util.stream.Collectors;

public class MainTheMovieDBMain {

	public static void main(String[] args) {
		
		TheMovieApiService service = new TheMoviewAPiServiceRestImpl();
		Discover discover =  service.discover();
		
		List<MovieReducedDTO> movies = discover.getResults().stream()
			.filter(movie -> movie.getAdult() == false)
			.map(movie -> new MovieReducedDTO(movie.getId(),movie.getTitle()))
			.collect(Collectors.toList());
		
//		System.out.println(discover);
		System.out.println(movies);
		
		
	}

}
