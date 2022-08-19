package clase17;

import java.util.LinkedList;

public class LinkedListMain {

	public static void main(String[] args) {
		
		LinkedList<String> nombres = new LinkedList<>();
		
		nombres.add("carlos");
		nombres.add("juan");
		nombres.add("jose");
		nombres.add("maria");
		
		// Vector<String> vector = new Vector<>();
		
		nombres.addFirst("antes de carlos");
		nombres.addLast("despues de maria");
		
		//recorro el linkedlist
		for(String nombre : nombres ) {
			System.out.println(nombre);
		}
	}
}
