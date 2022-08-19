package clase10;

import java.util.Scanner;//jdk

public class RepasoOOP {

	//es el punto de inicio de la aplicacion
	public static void main(String[] args) {
		//crear una clase: molde para crear objetos 
		
		//instanciar un objeto de esa clase: objeto vivo
		Animal perro = new Animal("verde"); //invocar el contructor de la clase Animal
		
		//ejecutar un método de ese objeto: acción/comportamiento del objeto vivo
		perro.hablar();

		System.out.println(perro.getColor());
		
		//voy a cambiar el color del perro
		perro.setColor("negro");
		
		System.out.println(perro.getColor());
		
		//le pedimos al usuario que ingrese la edad el enimal
		Scanner teclado = new Scanner(System.in);
		Integer edad;
		do {
			System.out.println("Ingrese la edad del animal");
			edad  = teclado.nextInt();
		}while(edad == null);
		
		//invoco el metodo setEdad() del objeto perro
		perro.setEdad(edad);
		
		System.out.println(perro.getEdad());
		
	}

}
