package clase18;

import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetMain {

	public static void main(String[] args) {
		
		//Collection
		// >List: admiten duplicados
		// >Set: No admiten duplicados 

		Collection<String> nombres = new TreeSet<>();

		nombres.add("jose");
		
		nombres.add("jose");
		
		//los tipos wrapper de java implementan la interface Comparable
		
		System.out.println(nombres);
		
		//-----
		
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1986);
		cal.set(Calendar.MONTH, 2);//0 ene|1 fe | 2mar
		cal.set(Calendar.DATE, 10);
		
		Cheque c1 = new Cheque("1002000","rio", cal.getTime());//ROOT
		
		//cal.add(Calendar.DATE, 1);//+1 dia		
		Cheque c2 = new Cheque("1002001","bbva",cal.getTime());//DER
		
		cal.add(Calendar.DATE, 1);//+1 dia		
		Cheque c3 = new Cheque("1000000","patagonia",cal.getTime());//IZQ
		
		cal.add(Calendar.DATE, 1);//+1 dia
		Cheque c4 = new Cheque("1002000","patagonia",cal.getTime());//IZQ
						
		//agrego un orden externo a la collection
		Comparator<Cheque> comparador = new ComparadorDeCheques();
		
		Collection<Cheque> cheques = new TreeSet<>(comparador);
		
		cheques.add(c1);
		cheques.add(c2);
		cheques.add(c3);
		cheques.add(c4);
		
		System.out.println(cheques.isEmpty());
		
		Iterator<Cheque> itCheques = cheques.iterator();
		while(itCheques.hasNext()) {
			Cheque unCheque = itCheques.next();
			System.out.println(unCheque);
			itCheques.remove();
		}
		
		System.out.println(cheques.isEmpty());
	}

}
