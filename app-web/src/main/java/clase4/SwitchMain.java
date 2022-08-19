package clase4;

import java.util.Scanner;

public class SwitchMain {

	public static void main(String[] args) {
		/**
		 * Realizar una mini calculadora
		 * operaciones:
		 * +,-,/,*
		 * 
		 * El usuario ingrear la operacion(+,/,*,- 0 PARA SALIR)
		 * 0,1,2,3,4 (0=salir; 1=resta; 2=mult; 3=divi; 4 =suma)
		 */
		//switch
		//ascci ?
		//if
		//do;while
		
		int opcion;
		double res;
		double a;
		double b;
		int continuar;
		
		Scanner teclado = new Scanner(System.in);
		
		do { 
			//alt+shit+m
			
			//f3
			opcion = validarOpciones(1,4,teclado,"Ingrese operacion: \n 1=suma, 2=resta; 3=multi, 4=div");//?
			
			a = leerData("Ingrese a", teclado);
			
			b = leerData("Ingrese b", teclado);//f6
			
			// double aux = leerData("Ingrese c", teclado);
			
			switch(opcion) {//5
				case 1:
					res = a + b;			
					mostrarResultado(res, "+");
					break;
				case 2:			
					res = a - b;			
					mostrarResultado(res, "-");//f5
					break;
				case 3:			
					res = a * b;			
					mostrarResultado(res, "*");
					break;
				case 4:
					if(b != 0) {
						res = a / b;
						mostrarResultado(res, "/");
					}else {
						System.out.println("No se puede divir por 0");
					}
					break;
				default :
					System.out.println("Opcion invalida");
			}
			
			//pregunto 			
			continuar = validarOpciones(0, 1, teclado, "Continuar (1=si,0=no)");
			
			//sale con un 0 o con un 1
		}while(continuar == 1);//solo acepto 0 y 1
		
		teclado.close();
		
		System.out.println("Salida exitosa");
	}

	private static int validarOpciones(int i, int j, Scanner teclado, String msj) {
		int opcion;
		do {
			mostrarMenu(msj);//f5
			opcion = teclado.nextInt();
		}while(opcion < i || opcion > j);
		return opcion;
	}

	static double leerData(String msj, Scanner teclado) {
		System.out.println(msj);		
		return teclado.nextDouble(); 
	}

	static void mostrarMenu(String msj) {
		System.out.println(msj);
	}

	static void mostrarResultado(double res, String operacion) {
		System.out.println(" La operacion " + operacion + " = " + res);//f6
	}//f7
}
