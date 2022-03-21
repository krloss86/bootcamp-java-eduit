package clase2;

public class LoBasico3 {

	public static void main(String[] args) {
		//mas tipos de datos
		
		// true o false: boolean
		boolean esViernes = false;
		boolean tuCuerpoLoSabe = false;
		
		// operadores logicos 
		// and Y => &&
		// or O =>  || da verdadero con al menos uno verdadero
		// nor  =>   ! "si es true lo pone false y si es false lo pone true"
		// xor
		
		boolean saleAfter = !esViernes || !tuCuerpoLoSabe;
		System.out.println(saleAfter);
		
	}

}
