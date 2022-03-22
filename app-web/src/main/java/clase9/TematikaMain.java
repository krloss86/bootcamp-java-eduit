package clase9;

import java.util.Scanner;

import clase7.Buscador;
import clase7.Carrito;

public class TematikaMain {

	public static void main(String[] args) {
		
		
		Scanner teclado = new Scanner(System.in);

		int continuar;
		do {
			String claveBuscadaPorElUsuario;
			do {
				System.out.println("Ingrese clave de busqueda"); 
				claveBuscadaPorElUsuario = teclado.next();
			}while("".equals(claveBuscadaPorElUsuario) || "".equals(claveBuscadaPorElUsuario.trim()));
					
			Buscador miBuscador = new Buscador(claveBuscadaPorElUsuario);
			
			miBuscador.buscar();//F3
	
			miBuscador.mostrarCantidadResultados();
			
			//verifico si tengo resultados
			if(miBuscador.hayResultados()) {
				//alt+shit+m
				miBuscador.detalle();
			}
			
			System.out.println("¿Desea continuar?");
			System.out.println("1=SI / 0=NO");
			continuar = teclado.nextInt();
		}while(continuar == 1);
		
		teclado.close();
		System.out.println("fin");
	}

}
