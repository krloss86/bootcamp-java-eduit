package clase5;

public class MinimoMain {

	public static void main(String[] args) {
		
		/**
		 * Buscar el numero minimo dentro del array
		 * el maximo e indicar sus posiciones
		 */
		int[] edades = {36,34,38,31,28,17, 17, 16}; //1 > 0
		
		//variable minimo
		//for
		//if		
		if(edades.length > 0) {
			//calcular el minimo
			//scope de la variable es "este if"
			int minimo = edades[0];
			int posMinimo = 0;
			int cantMinimos = 0;//contar cuantos minimos hay
			
			int maximo = edades[0];
			int posMaximo = 0;
			int cantMaximos = 0;
			
			for(int i = 1;i < edades.length;i++) {
				//calculo del minimo
				if(edades[i] < minimo) {
					//si la logica del if verdadero tiene solo una linea 
					minimo = edades[i];
					posMinimo = i;					
					cantMinimos++;
				}
				
				//calculo del maximo
				if(edades[i] >= maximo) {
					//si la logica del if verdadero tiene solo una linea 
					maximo = edades[i];
					posMaximo = i;
					cantMaximos++;
				}				
			}
			System.out.println("El minimo es: " + minimo + " y esta en " + posMinimo + " y hay: "+ cantMinimos);
			System.out.println("El maximo es: " + maximo + " y esta en " + posMaximo + " y hay: " + cantMaximos);
		}else {
			System.out.println("No hay a quien preguntar la edad");
		}
		
		
		//QUEDA DE EJERCICIO PARA QUE QUE UDS LO MOFIQUEN
	}

}
