package clase20;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class Ventas {

	private Collection<String> ventas;
	
	public Ventas() {
		ventas = new HashSet<String>();
		
		//primera liena del archivo 
		ventas.add("id_vendedor|fecha_venta|monto_venta");
		
		//cada vendedor
		ventas.add("1|18/04/2022|1500");
		ventas.add("1|15/04/2022|1500");
		ventas.add("2|10/03/2022|14000");
		// ventas.add("1|16/04/2022|3500");
	}
	
	//necesito un metodo publico
	public Collection<Venta> getVentas() {
		Collection<Venta> ventas = new ArrayList<Venta>();
		
		//otra forma
		Iterator<String> itVentas = this.ventas.iterator();
		if(itVentas.hasNext()) {
			itVentas.next();//id|nombre|sucursal
			while(itVentas.hasNext()) {
				//id,fecha,monto
				ventas.add(new Venta(itVentas.next()));								
			}
		}
		return ventas;
	}
}
