package clase11;

public abstract class Log {

	private String msj;
	private final Long id = 1l;//genero una constante
	protected static int cont = 0; //no le pertenece a ninguna instancia en particular,sino a la clase Log
	
	//solo lo podria asignar en el contructor 
	public Log() {
		
	}
	
	public Log(String msj) {
		this.msj = msj;
	}
	
	public abstract void loguear();

	public String getMsj() {
		String msj;
		if(this.msj == null) {
			msj = "";
		}else {
			msj = this.msj;
		}
		return msj;
	}

	public void setMsj(String msj) {
		this.msj = msj;
	}

	public Long getId() {
		return this.id;
	}
}
