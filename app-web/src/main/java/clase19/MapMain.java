package clase19;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapMain {

	public static void main(String[] args) {
		/*
		 *Asociar los dias de la semana 
		 *1 - lunes
		 *2 - martes
		 *3 - miercoles
		 *......
		 * */

		//usamos Map>HashMap
		Map<Integer, String> mapSemana = new HashMap<>();
		
		//cargar un valor al mapa
		mapSemana.put(1, "Lunes");
		mapSemana.put(2, "Martes");
		mapSemana.put(3, "Miercoles");
		mapSemana.put(4, "Jueves");
		mapSemana.put(5, "Viernes");
		mapSemana.put(6, "Sabado");
		mapSemana.put(7, "Domingo");
		
		System.out.println(mapSemana);//toString() ya esta implementado
		
		//determinar si existe una clave dentro del mapa
		boolean existe = mapSemana.containsKey(6);
		
		System.out.println("El sabado " + existe);
		existe = mapSemana.containsKey(8);
		System.out.println("El dia 8 " + existe);
		
		//eliminar una clave-valor
		
		String value = mapSemana.remove(3);//quitar del mapa 3-Miercoles
		System.out.println(mapSemana);
		
		//vaciar el mapa
		//mapSemana.clear();
		
		//System.out.println(mapSemana);

		//la calve debe ser unica
		mapSemana.put(5, "VALOR NUEVO");
		System.out.println(mapSemana);
		
		mapSemana.replace(6, "SATURDAY");
		System.out.println(mapSemana);

		//obtener las claves del mapa
		Set<Integer> keys = mapSemana.keySet();
		System.out.println("claves del mapa: " + keys);
		
		//obtengo los valores del mapa
		Collection<String> values = mapSemana.values();
		System.out.println("valores del mapa: " + keys);

		//recorrer el mapa usando sus claves
		for(Integer oneKey : keys) {
			String oneValue = mapSemana.get(oneKey);
			System.out.println("key: " + oneKey + " value: " +oneValue);
			// mapSemana.put(oneKey*10, value + "-"+ oneKey);
		}
		
		System.out.println(mapSemana);
		
		//recorrido por valores
		for(String oneValue : values) {
			System.out.println("value: " + oneValue);
		}
		
		//Map.Entry<K,V>
		Set<Map.Entry<Integer, String>> entrySet = mapSemana.entrySet();
		
		//recorrer las entradas de un mapa usando Entry
		for(Map.Entry<Integer, String> oneEntry : entrySet) {
			Integer oneKey = oneEntry.getKey();
			String oneValue = oneEntry.getValue();
			
			System.out.println(oneKey + " - " +oneValue);
		}
		
	}

}
