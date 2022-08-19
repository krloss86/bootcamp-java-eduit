package clase9;

public class Consola {

	//defino los atributos comunes a todas las consolas
	protected String marca;
	protected String empresa;
	protected int anio;
	
	public Consola(String marca, String empresa, int anio) {
		this.marca = marca;
		this.empresa = empresa;
		this.anio = anio;
	}
	
	//alf+shit+s
	
	public String getMarca() {
		return this.marca;
	}
}
