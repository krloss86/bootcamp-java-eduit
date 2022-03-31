package clase13.formulario;

public class FormularioLegales extends Formulario {

	public FormularioLegales(String nombre) {
		super(nombre);
	}

	@Override
	public void definirEtiquetas() {
		Etiqueta apellido = new Etiqueta("apelido");
		Etiqueta nombre = new Etiqueta("nombre");
		
		super.agregarEtiqueta(apellido);
		super.agregarEtiqueta(nombre);
	}

}
