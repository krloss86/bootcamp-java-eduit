package clase15.generic;

public class MainGenericTable {

	public static void main(String[] args) {
		
		ServiceTablaX sx = new ServiceTablaX();
		TablaX tx = sx.consultarPorID(1L);

		ServiceTablaY sy = new ServiceTablaY();
		TablaY ty = sy.consultarPorID(2L);
	}

}
