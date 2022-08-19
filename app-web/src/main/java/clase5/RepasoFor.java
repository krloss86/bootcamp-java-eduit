package clase5;

public class RepasoFor {

	public static void main(String[] args) {

		//ciclo for	
		
		/**
		 * Mostrar los primeros 10 numeros naturales (  si [0 + inf  )
		 * sin mostrar los pares
		 */
		int cantidad = 10;//scope mayor		
		
		for(int i = 0;i < cantidad;i++) { //cantidad 10 números 0 al 9
			
			if(i % 2 != 0) {
				System.out.println(i);
			}
		}
		
	}

}
