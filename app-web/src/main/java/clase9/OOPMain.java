package clase9;

import clase10.Libro;
import clase7.Articulo;

public class OOPMain {

	public static void main(String[] args) {
		//dentro del paquete clase8 puedo instanciar un Articulo
		//lo puedo hacer porque el contructor el public
		Articulo a = new Libro();//new Articulo(null, null, null, null, null);
		
		//si una atributo es publico lo puedo ver y modificar
		a.color = "blanco";

		//a.id = 100l;
		
		a.setId(10l);
		
		System.out.println(a.getId());
	}

}
