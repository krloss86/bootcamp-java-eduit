package clase5;

import java.util.Arrays;

public class MinimoMainRefactor {

	public static void main(String[] args) {
		
		/**
		 * Buscar el numero minimo dentro del array
		 * el maximo e indicar sus posiciones
		 */
		int[] edades = {36,34,38,16,28,17, 17, 16, 15}; //1 > 0
		
		if(edades.length > 0) {
			
			int minimo = calcularMinimo(edades);
			int cantidadMinimos = contarMinimos(minimo,edades);
			int[] posicionesDeLosMinimos = indicarPosiciones(cantidadMinimos,minimo, edades);
			System.out.println("El minimo es: " + minimo + ", hay "+ cantidadMinimos + " y estan en:" + Arrays.toString(posicionesDeLosMinimos));
		}else {
			System.out.println("No hay a quien preguntar la edad");
		}
		
	}

	static int[] indicarPosiciones(int cantidadMinimos,int elMinimo, int[] edades) {
		int[] posicionesMinimos = new int[cantidadMinimos];
		int j=0;
		for(int i = 0; i < edades.length; i++) {
			if(edades[i] == elMinimo) {
				posicionesMinimos[j] = i;
				j++;
			}
		}
		return posicionesMinimos;
	}
	
	static int contarMinimos(int minimo, int[] edades) {
		int cantidad = 0;
		for(int i=0; i < edades.length; i++) {
			if(edades[i] == minimo) {
				cantidad++;
			}
		}
		return cantidad;
	}
	
	/**
	 * Pre: array con elementos (debe ser mayor a 0)
	 * post: retorna el minimo dentro del array
	 * @param array
	 * @return
	 */
	static int calcularMinimo(int[] edades) {
		int minimo = edades[0];
		for(int i = 1;i < edades.length;i++) {
			if(edades[i] < minimo) {
				minimo = edades[i];
			}
		}
		return minimo;
	}
	
}
