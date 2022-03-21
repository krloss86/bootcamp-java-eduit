package clase3;

import java.util.Scanner;

public class WhileMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int cont = 0;//f6
		int numero;//la jvm no "para" en las 
		//definiciones de variables
		
		//decir a java que voy a leer desde el
		//teclado
		Scanner teclado = new Scanner(System.in);//f6
		
		System.out.println("Ingrese dato:");
		
		numero = teclado.nextInt();//lee desde teclado
		
		while(numero !=0 && cont < 6) {
			cont++;//f6
			//ciclo infinito
			
			System.out.println("Ingrese dato:");
			//vuelvo a leer el valor 
			numero = teclado.nextInt();
		}
		System.out.println("fin");
	}

}
