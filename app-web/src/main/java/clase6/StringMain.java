package clase6;

public class StringMain {

	public static void main(String[] args) {
		
		/**
		 * 
		 */

		String palabra = "hola soy de river el mejor de america";//stack
		
		//variable primitivas
		// char, byte, short, int , long, double, float
		// boolean
		
		// String
		// metodo
		
		//comienza con "x" letra
		if(palabra.startsWith("ho")) {
			System.out.println("comienza con ho");
		}else {
			System.out.println("NO comienza con ha");
		}
		
		char primerCaracter = palabra.charAt(0);
		if(primerCaracter == 'h') {
			System.out.println("comienza con h");
		}else {
			System.out.println("comienza con h");
		}
		
		//operador new
		String otraPalabra = new String("Hola soy de river el mejor de america");
		
		if(palabra == otraPalabra) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
		
		//para comprar cadenas String debo usar .equals()
		if(palabra.equalsIgnoreCase(otraPalabra)) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
		
		//vectores/arrays/arreglos
		Object edad = new Integer(10);
		Object nombre  = "carlos";
		Object letra = new Character('a');
		Object[] unArrayCualquiera = {edad, nombre, letra};
		
		//for/while/do-while
		//for-each
		for(Object aux : unArrayCualquiera ) {
			//instaceof
			
			if(aux instanceof Integer) {
				Integer auxInteger = (Integer)aux;
				System.out.println(auxInteger);
			}else if(aux instanceof String) {
				String auxString = (String)aux;
				System.out.println(auxString);
			} else {
				Character auxChar = (Character)aux;
				System.out.println(auxChar);
			}
		}
		
		//AUTOBIXING >  1.5
		int a = 10;
		Integer b = new Integer(a); 
		
		a = b;
	}

}
