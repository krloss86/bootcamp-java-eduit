package ar.com.educacionit.web.streams;

import java.util.Collection;
import java.util.Set;

import ar.com.educacionit.domain.Articulo;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ArticulosServiceImpl;

public class FiltroMainObjetos {

	public static void main(String[] args) throws ServiceException {
		
		Set<Integer> edades = Set.of(10, 20, 30, 50, 15,5);

		Integer suma  = 0;
		for(Integer edad : edades) {
			suma += edad;
		}
		System.out.println(suma);
		
		//---
		suma = edades.stream()
			.reduce(0,(x,y) -> x+y);
		System.out.println(suma);
		
		//
		Collection<Articulo> arts = new ArticulosServiceImpl().findAll();
		
		//el precio total de todos los articulos
		Double sumaD = arts.stream()
			.map(art -> art.getPrecio())//List<Double>
			.reduce(0D, (x, y) -> (x*1.2)+y);
			//      0,  0,  
		System.out.println(sumaD);
		//----
		
		Set<String> palabras = Set.of("Hola","juan","soy","carlos");
		
		String unaSolaPalabra = palabras.stream()
			.reduce("",(x,y) -> x + " - " + y);
		System.out.println(unaSolaPalabra);
	}

}
