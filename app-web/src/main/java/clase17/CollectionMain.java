package clase17;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionMain {

	public static void main(String[] args) {
		//tipos de datos de java:
		//char, int, .... String
		//wrapper Intener, Long, Float....
		
		//vectores / array / arreglos
		int [] edades = new int[2];
		edades[0] = 1;
		edades[edades.length-1] = 2; // ¿?
		
		for(int edad : edades) {
			System.out.println(edad);
		}
		
		//estaticos
		
		//Java Collection Framework
		// Collection<E> cualquier cosa
		//  List<T>: Admite elemento duplicados
		//     - ArrayList<T>
		//	   - LinkedList<T>	
		//  Set<U>: NO admite duplicados
		//
		// Map<K,V>: clave, valor
		
		//1- crear una Collection<String>
		
		Collection<String> nombres = new ArrayList<>();
		
		//2- agrego elementos 
		nombres.add("brenda");
		nombres.add("walter");
		nombres.add("nicolas");
		
		//3- tamaño 
		int tamanio = nombres.size();
		System.out.println("tamaño: " + tamanio);
		
		//4- recorrer
		for(String nombre : nombres) {
			System.out.println(nombre);
		}
		
		//5- eliminar
		nombres.remove("walter");
		
		//5.1 eliminar todos:
		nombres.clear();
		
		
		//tamaño = 2
		tamanio = nombres.size();
		System.out.println("ahora: " + tamanio);
	}

}
