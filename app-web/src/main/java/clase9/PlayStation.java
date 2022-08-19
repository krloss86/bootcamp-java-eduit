package clase9;

public class PlayStation extends Consola{

	//atributos propios
	private String codigoPlayNetwork;
	
	//ctrl+o+o
	
	//implemento el contructor del padre
	
	public PlayStation(
			String marca, String empresa, int anio, 
			String codigoPlayNetwork) {
		// la primer linea del contructor del hijo
		// es invocar al contructor del padre
		super(marca, empresa, anio);
		
		this.codigoPlayNetwork = codigoPlayNetwork;  		
	}
	
	//alt+shift+s
}
