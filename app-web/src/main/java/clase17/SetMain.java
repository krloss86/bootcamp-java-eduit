package clase17;

import java.util.HashSet;
import java.util.Set;

public class SetMain {

	public static void main(String[] args) {
		Set<Carrito> carritosSet = new HashSet<Carrito>();
		
		Carrito c = new Carrito();
		carritosSet.add(c);
		
		Carrito c2 = new Carrito();
		carritosSet.add(c2);
		
		System.out.println(c.equals(c2));
		
		System.out.println(carritosSet.contains(c));
		System.out.println(carritosSet.contains(c2));
	}
}
