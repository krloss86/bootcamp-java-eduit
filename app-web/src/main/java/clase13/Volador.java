package clase13;

public abstract class Volador {

	private String nombre;
	static int cont = 0;
	
	public Volador(String nombre) {
		this.nombre = nombre;
		Volador.cont++;
	}

	public String getNombre() {
		return nombre;
	}
	
}
