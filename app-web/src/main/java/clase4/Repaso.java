package clase4;

public class Repaso {

	//funcion main = principal
	public static void main(String[] args) {
		
		//tipos de datos
		
		//tipos primitivos
		//char, byte, short,int long, float, double
		//String (no es primitivo)

		//operadores
		/*
		 aritmeticos
			+,-,/,* (hay mas)		
		*/
		
		/**
		 logicos
		 	and &&
		 	or || 
		 	nor !
		 	xor ¿? 
		 */
		
		//quiero usar la funcion: invocar a la funcion
		float resultado = funcionXMas2(2);
	}

	static float funcionXMas2(float x) {
		//falta el calculo
		float y = x + 2;
		//falta retornar el valor
		return y;
	}
	
	static float dividir(float a, float b) {
		float res;
		if(b != 0) {
			res = a / b;
		}else {
			System.out.println("No se puede dividir por 0");
			res = -1;
		}
		//genero un solo return
		return res;
	}
	
	static void mostrarParidad(float numero) {
		boolean esPar = (numero % 2 == 0) ? true : false;
		System.out.println(esPar ? "es par" : "impar");
	}
}
