package clase17;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionMain2 {

	public static void main(String[] args) {
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
		
		//eliminar de manera segura
		//1- me "conecto" a la collection por medio del metodo .iterator()
		Iterator<String> itNombres = nombres.iterator();
		while(itNombres.hasNext()) {
			String nombreActual = itNombres.next();
			System.out.println("eliminando:" + nombreActual);
			itNombres.remove();
		}
		
		//determina si esta vacia la collection
		boolean vacio = nombres.isEmpty();
	}

}
