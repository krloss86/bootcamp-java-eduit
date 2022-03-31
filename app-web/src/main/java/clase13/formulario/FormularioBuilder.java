package clase13.formulario;

public class FormularioBuilder {

	public static Formulario crearFormulario(int op) {
		
		Formulario f;
		switch (op) {
		case 1:
			f = new FormularioLegales("Legales");			
			break;
		case 2:
			f = new FormulariContrato("Contrato");			
			break;
		default:
			f = new FormularioBlanco();	
			break;
		}
		
		f.definirEtiquetas();
		return f;
	}

}
