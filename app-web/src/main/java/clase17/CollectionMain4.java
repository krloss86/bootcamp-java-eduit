package clase17;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CollectionMain4 {

	public static void main(String[] args) {
		/*
		 * Los elementos eliminados de la collection deben ir a otra lista.
		 */
		
		Collection<String> nombres = new ArrayList<>();
		
		//2- agrego elementos 
		nombres.add("brenda");
		nombres.add("walter");
		nombres.add("nicolas");
		
		//eliminar de manera segura
		//1- me "conecto" a la collection por medio del metodo .iterator()
		Iterator<String> itNombres = nombres.iterator();
		List<String> eliminados = new ArrayList<>();
		while(itNombres.hasNext()) {
			String nombreActual = itNombres.next();
			System.out.println("eliminando:" + nombreActual);
			eliminados.add(nombreActual);
			itNombres.remove();
		}
		
		itNombres = eliminados.iterator();
		
		while(itNombres.hasNext()) {
			System.out.println(itNombres.next());
		}
		
		//determina si esta vacia la collection
		boolean vacio = nombres.isEmpty();
	}

}
