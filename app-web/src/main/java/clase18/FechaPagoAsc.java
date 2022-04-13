package clase18;

public class FechaPagoAsc extends FechaPagoComparator {

	public int comparar(Cheque c1, Cheque c2) {
		return c1.getFechaPago().compareTo(c2.getFechaPago()); 
	}
}
