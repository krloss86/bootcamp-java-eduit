package clase17;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CollectionEliminarDuplicados {

	public static void main(String[] args) {
		
		Collection<String> nombres = new LinkedList<>();
		
		nombres.add("carlos");
		nombres.add("juan");
		nombres.add("jose");
		nombres.add("jose");
		nombres.add("maria");
		
		System.out.println(nombres);
		//Object.toString() > Collection @override
		
		//quiero eliminar los elementos duplicados
		nombres = new HashSet<>(nombres);
		System.out.println(nombres);
		
		nombres = new ArrayList<>(nombres);
		System.out.println(nombres);
		
		boolean estaPepe = nombres.contains("maria");
		System.out.println(estaPepe);
		
		Collection<String> apellidos = new HashSet<>();//no importa el orden
		
		apellidos.add("matias");
		apellidos.add("brenda");
		apellidos.add("giuliana");
		

		//combino dos listas en una
		Collection<String> apyn = new ArrayList<>();
		apyn.addAll(nombres);
		apyn.addAll(apellidos);
		
		System.out.println(apyn);
		
		Set<String> personas = new HashSet<>();
		personas.add("giuliana");
		personas.add("maria");
		
		Set<String> personas2 = new HashSet<>();
		personas2.add("maria");
		personas2.add("giuliana");
		
		boolean estan  = apyn.containsAll(personas);
		System.out.println("estan? "+estan);
		
		boolean iguales = personas.equals(personas);
		boolean iguales2 = personas.equals(personas2);
		
		System.out.println("iguales?"+iguales);
		System.out.println("iguales2?"+iguales2);
		
	}
}
