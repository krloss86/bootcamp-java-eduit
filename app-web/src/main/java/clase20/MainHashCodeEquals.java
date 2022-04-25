package clase20;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class MainHashCodeEquals {

	public static void main(String[] args) {
		
		Set<Venta> ventas = new HashSet<Venta>();
		
		Date date = new Date();
		Venta v1 = new Venta(1L,date,1700D);
		Venta v2 = new Venta(1L,date,1700D);
		//Venta v3 = new Venta(2L,date,1700D);
	
		//ventas.add(v1);
		//ventas.add(v2);
		//ventas.add(v3);
		
		if(v1.equals(v2)) {//a nivel de negocio
			System.out.println("iguales");			
		}else {
			System.out.println("no iguales");
		}
		
		//hibernate 
	}

}
