package clase13;

public class TorreMain {

	public static void main(String[] args) {
		
		//simular que existen varios voladores
		Volador[] voladores = CreadorDeVoladores.crearVoladores();

		//analizar si pueden aterrizar en la pista
		for(Volador v : voladores) {
			
			//cumple con el contrato?
			if(v instanceof Aterrizable) {
				
				Aterrizable a = (Aterrizable)v;
				
				Estado estado = a.aterrizar();
				
				//si hay error > mando bomberos
				if(estado.isError()) {
					System.out.println(v.getNombre() + ":" + estado.getMsj() + " enviando ayuda...");
				}
			}else {
				System.out.println("No puede aterrizar acá...");
			}
		}
		
	}

}
