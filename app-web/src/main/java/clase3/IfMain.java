package clase3;

public class IfMain {

	public static void main(String[] args) {
		
		int edad = 17; 
		
		/**
		 * Y &&
		 */
		
		/**
		 * Operador relacional
		 * > < <= < <= !=
		 */
		if( edad >= 18  ) { // esViernes == true
			if(edad >= 20 && edad <=30) {
				System.out.println("Es mayor y está entre 20 y 30 años");
			}else {
				System.out.println("Es mayor pero no está entre 20 y 30 años");
			}
		}else {
			//syso+ctrl+space
			System.out.println("Es menor de edad");
		}
		
	}

}
