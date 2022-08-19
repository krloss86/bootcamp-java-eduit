package clase20;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class Vendedores {

	private Collection<String> vendores;
	
	public Vendedores() {
		vendores = new HashSet<String>();
		
		//primera liena del archivo 
		vendores.add("id|nombre|sucursal");
		
		//cada vendedor
		vendores.add("1|juan|1");
		vendores.add("2|pedro|1");
		vendores.add("3|nico|2");
		vendores.add("4|santiago|3");
	}
	
	//necesito un metodo publico
	public Collection<Vendedor> getVendedores() {
		Collection<Vendedor> vendedores = new ArrayList<Vendedor>();
		//otra forma
		Iterator<String> itVendedores = this.vendores.iterator();
		if(itVendedores.hasNext()) {
			itVendedores.next();//id|nombre|sucursal
			while(itVendedores.hasNext()) {
				vendedores.add(new Vendedor(itVendedores.next()));								
			}
		}
		return vendedores;
	}
}
