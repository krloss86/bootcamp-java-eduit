package clase3;

import java.util.Scanner;

public class ForContinueMain {

	public static void main(String[] args) {
		int sumaPares = 0;
		int sumaImpares = 0;
		
		int cantidadDeLecturas = 4;//dejo fijo, pero podria leerlo del teclado
		
		int numero;
		
		Scanner teclado = new Scanner(System.in);
		
		//ciclo for
		for(int i=0; i < cantidadDeLecturas; i++) {
			
			
			//leer el dato del teclado
			System.out.println("Ingrese valor:");
			numero = teclado.nextInt();

			if(numero==0) {
				cantidadDeLecturas--;
				continue;
			}//alt+flecha abajo o flecha arriba
			
			//pregunto si es par
			if(numero % 2 == 0) {//alt+shift+i > f6
				sumaPares +=numero;
			}else {
				//no es par
				sumaImpares += numero;
			}
		}
		teclado.close();
		
		//saber si pares > impares || pares < impares || si pares == impares
		if(sumaPares < sumaImpares) {
			System.out.println("Hay mas impares...");
		}
		if(sumaPares > sumaImpares) {
			System.out.println("Hay mas pares");
		}
		if(sumaPares == sumaImpares) {
			System.out.println("hay igual cantidad de pares que impares");
		}
		
		System.out.println("Suma Pares= " + sumaPares);
		System.out.println("Suma Impares= " + sumaImpares);
	}

}
