package clase13.formulario;

public class FormularioBlanco extends Formulario {

	public FormularioBlanco() {
		super("");
	}

	@Override
	public void definirEtiquetas() {
		super.agregarEtiqueta(new Etiqueta[] {});
	}

}
