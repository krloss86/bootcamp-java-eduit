package clase3;

import java.util.Scanner;

public class PromedioNotas {

	public static void main(String[] args) {
		
		/**
		 * Calcular el promedio de notas de un alumno.
		 * Se debe ingresar las tres notas del año.
		 * Si el promedio es igual o o mayor (>=) 7 informar por consola que está aprobado.
		 * Si el promedio es menor a 7 informar por consola que no está aprobado.
		 */

		//necesito 3 variables de que tipo?
		//3 float, uno para cada nota y 1 float para el promedio
		float primerNota;
		float segundaNota;
		float tercerNota;
		
		//leer notas del teclado
		Scanner teclado = new Scanner(System.in);		
		
		System.out.println("Ingrese primer nota:");
		primerNota = teclado.nextFloat();
		
		System.out.println("Ingrese segunda nota:");
		segundaNota = teclado.nextFloat();
		
		System.out.println("Ingrese tercer nota:");
		tercerNota = teclado.nextFloat();
		
		//aca puedo cerrar el teclado
		//cierro conexion con el teclado.
		teclado.close();

		//calculo el promedio de las notas
		float promedio = (primerNota + segundaNota + tercerNota) / 3;
		
		
		if(promedio >= 7) {
			System.out.println("Uds está aprobado:" + promedio);
		}else {
			System.out.println("Uds no está aprobado: " + promedio);
		}
		
	}

}
