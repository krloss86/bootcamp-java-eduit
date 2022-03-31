package clase13.formulario;

public class MainFormulariio {

	public static void main(String[] args) {

		//opcion de formulario
		int op = 2; //1=Legales 2=Contrato
		
		Formulario f = FormularioBuilder.crearFormulario(op);
		
		String textoFinal = f.compilarEtiquetas();
		
		System.out.println(textoFinal);
	}

}
