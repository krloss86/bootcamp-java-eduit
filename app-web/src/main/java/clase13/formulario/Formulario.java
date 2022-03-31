package clase13.formulario;

public abstract class Formulario {

	private String nombre;
	private Etiqueta[] etiquetas;
	static int cont = 0;

	public Formulario(String nombre) {
		this.etiquetas = new Etiqueta[] {};
		this.nombre = nombre;
		Formulario.cont++;
	}

	public abstract void definirEtiquetas();

	public void agregarEtiqueta(Etiqueta[] etiquetas2) {
		this.etiquetas = etiquetas2;
		//ver como implementar el agregado
	}

	public void agregarEtiqueta(Etiqueta apellido) {
		Etiqueta[] nuevas = new Etiqueta[etiquetas.length+1];
		/*for(int i=0; i<nuevas.length; i++) {
			if(i==nuevas.length){
				nuevas[i]=apellido;
			}else {
				nuevas[i]=etiquetas[i];
			}
		}*/
		
		for(int i = 0; i < etiquetas.length; i++) {
	    	nuevas[i] = etiquetas[i];
		}
	    nuevas[etiquetas.length] = apellido;
	    this.etiquetas = nuevas;
	}

	public String compilarEtiquetas() {
		
		StringBuffer texto = new StringBuffer(this.nombre);
		texto.append(": ");
		for(Etiqueta e : etiquetas) {
			texto.append(e.getTag());
			texto.append(", ");
		}
		
		return texto.toString();
	}
}
