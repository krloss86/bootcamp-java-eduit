package clase18;

public class FechaPagoDesc extends FechaPagoComparator {

	public int comparar(Cheque c1, Cheque c2) {
		return c2.getFechaPago().compareTo(c1.getFechaPago()); 
	}
}
