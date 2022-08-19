package clase5;

import java.util.Scanner;

public class PisosMain {

	public static void main(String[] args) {
		
		//int[] aux = new int[1];//0 por el tipo int  > 0		
		//System.out.println(aux);//como es un array, muestra la posicion de memoria 
		
		//String miNombre = "carlos";
		
		/**
		 * Construir un edificio de tamaño indicado por el usuario.
		 */
		Scanner teclado = new Scanner(System.in);
		System.out.println("Ingrese el tamaño");
		int tamanio = teclado.nextInt();
		
		//construyo el edificio
		String[] edificio = new String[tamanio];

		//mostrar el tamaño, pero usando el edificio, no la variable
		System.out.println(edificio.length);

		//cargamos los nombres de las personas que viven en el edificio
		for(int piso = 0; piso < edificio.length; piso++) {
			edificio[piso] = "persona-"+piso;
		}
		
		//como recorrer un array (de cualquier tipo)
		
		for(int piso = 0; piso < edificio.length; piso++) {
			String fulano = edificio[piso]; //estoy en un piso que dice la variable piso
			//quiero mostar su nombre y el piso
			System.out.println(fulano + " vive en el piso" + piso );
		}
	}

}
