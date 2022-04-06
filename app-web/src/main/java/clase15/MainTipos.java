package clase15;

public class MainTipos {

	public static void main(String[] args) {
		
		String tipo = "x";
		
		
		if("x".equals(tipo)) {
			ServicioXImpl servicio = new ServicioXImpl();
			servicio.parse();
		}else {
			ServicioYImpl servicio = new ServicioYImpl();
			servicio.parse();
		}

	}

}
