package clase13.formulario;

public class FormulariContrato extends Formulario {

	public FormulariContrato(String nombre) {
		super(nombre);
	}

	@Override
	public void definirEtiquetas() {
		Etiqueta direccion = new Etiqueta("direccion");
		Etiqueta apellido = new Etiqueta("apelido");
		Etiqueta nombre = new Etiqueta("nombre");
		
		super.agregarEtiqueta(new Etiqueta[] {direccion, apellido, nombre});
		super.agregarEtiqueta(apellido);
		super.agregarEtiqueta(nombre);
	}

}
