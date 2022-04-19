package clase20;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class VendedoresMainTest {

	public static void main(String[] args) {
		
		Vendedores archivoVendedores = new Vendedores();		
		Collection<Vendedor> vendedores = archivoVendedores.getVendedores();
		
		Ventas archivoVentas = new Ventas();
		Collection<Venta> ventas = archivoVentas.getVentas();
		
		Map<Vendedor, Collection<Venta>> mapVentasXVendedor = new HashMap<>();
		
		//cargar para cada vendedor las ventas que tiene
		for (Vendedor vendedor : vendedores) {
			mapVentasXVendedor.put(vendedor, new ArrayList<>());
		}
		
		//TPH: investigar hashcode e equals
		
		for (Vendedor vendedor : vendedores) {	
			for (Venta venta : ventas) {
				if(vendedor.getId().equals(venta.getIdVendedor())) {				
					Collection<Venta> ventasDelVendedor = mapVentasXVendedor.get(vendedor);					
					ventasDelVendedor.add(venta);
				}
			}
		}
		
		System.out.println(vendedores);

	}

}
