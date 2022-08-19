package clase4;

import java.util.Scanner;

public class DoMain {

	public static void main(String[] args) {
		
		/**
		 * Leer un dato hasta que el usuario ingrese 0
		 */
		
		// la variable debe estar fuera del do-while
		Scanner teclado = new Scanner(System.in);//f8
		int continuar;
		
		do {
			int opcion;
			do {
				mostrarMenu();
				opcion = teclado.nextInt();
			}while(opcion < 0 || opcion > 4); //salir si < 0 || >4
			
			System.out.println("Desea continuar (1=si, 0=no)");
			continuar = teclado.nextInt();
		}while(continuar == 1);
		teclado.close();
		System.out.println("Fin");
	}

	private static void mostrarMenu() {
		System.out.println("Ingrese opcion (0 para salir, 1=suma; 2=restar,3= multi, 4=div)");
	}

}
