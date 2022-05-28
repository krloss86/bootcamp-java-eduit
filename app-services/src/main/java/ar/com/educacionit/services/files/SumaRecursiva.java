package ar.com.educacionit.services.files;

public class SumaRecursiva {

	public static void main(String[] args) {
		/*
		 * Realizar la suma de N: N 5 > 5 + 4 +3 + 2 +1
		int n = 5;
		int suma = 0;

		while (n > 0) {
			suma += n;
			n--;
		} // suma(n-1)

		System.out.println(suma);
		*/
		
		int valorSumado = suma(5); 
		System.out.println(valorSumado);
		
		System.out.println(factorial(4));
		
		System.out.println(esPalindromo(""));
		System.out.println(esPalindromo("m"));
		System.out.println(esPalindromo("jose"));
		System.out.println(esPalindromo("neuquen"));
		
	}
	
	//un caso base: donde termina la recursividad
	// un metodo que se invoca a si mismo
	public static int suma(int n) {//5
		//identificar el caso base
		if(n > 0) {
			return n + suma(n-1); 
		}
		return n;
	}
	
	/*
	 * Calcular el factorial de un numero N
	 * N= 4
	 * N!= 4*3*2*1
	 */
	public static int factorial(int n) {//3*2*1
		//caso base n > 1
		if(n > 1) {
			return n * factorial(n-1); 
		}
		return 1;
	}
	
	/*  
	 *  
	 * 	M
	 *	MENEM
	 *	NENQUEN
	*/
	public static boolean esPalindromo(String palabra) {
		if(palabra.length() <= 1) {
			return true;
		}else {
			//cadena[0] con cadena[cadena.length()-1]
			if(palabra.charAt(0) == palabra.charAt(palabra.length()-1))
				return esPalindromo(palabra.substring(1,palabra.length() -1));
			else
				return false;
		}	
	}
}
