package clase22;

import java.util.Date;

import clase20.Vendedor;
import clase20.Vendedores;
import clase20.Venta;

public class MainException {

	public static void main(String[] args) {
		
		/*int a = 10;
		int b = 0;
		int c = a/b;
		
		System.out.println(c);
		*/
		
		/*Venta v1 = null;
		System.out.println(v1.getFecha());*/
		
		Object v1 = new Venta(1l,new Date(),1500d);
		
		//no hay una relacion de herencia entre Venta y Vendedor
		Vendedor v = (Vendedor)v1;
		System.out.println(v.getId());
	}

}
