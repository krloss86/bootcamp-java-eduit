package ar.com.educacionit.web.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FiltroMain {

	public static void main(String[] args) {
		
		List<Integer> edades = new ArrayList<>();
		edades.add(150);
		edades.add(100);
		edades.add(55);
		edades.add(45);
		edades.add(175);

		//Filtrar los > a 55
		List<Integer> edadesFiltradas = new ArrayList<>();
		for(Integer edad : edades) {
			if(edad > 55) {
				edadesFiltradas.add(edad);
			}
		}
		System.out.println(edadesFiltradas);
		
		List<String> edadesString = new ArrayList<>();
		for(Integer edad : edadesFiltradas) {
			edadesString .add("EDAD:" +edad);
		}
		//ahora quiero una lista de String 
		System.out.println(edadesString);
		
		
		//-------------
		
		//1= conecto al stream
		Stream<Integer> stEdades = edades.stream();
		
		//2 aplica una funcion intermedia
		stEdades = stEdades.filter(edad -> edad > 55 );
		
		//3 funcion terminal
		edadesFiltradas = stEdades.collect(Collectors.toList());
		
		System.out.println(edadesFiltradas);
		
		// > 55 < 150
		edadesString = edades	
			.stream()
			.filter(edad -> edad > 55 && edad < 150)
			.map(edad -> "EDAD:" + edad)//define el tipo de dato de salida
			.collect(Collectors.toList());
		
		
		System.out.println(edadesFiltradas);
		System.out.println(edadesString);
	}

}
