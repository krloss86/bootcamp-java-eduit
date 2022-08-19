package clase11;

public final class FSLog extends Log implements IEjecutable,ISaludable {

	public FSLog() {
		super();
		Log.cont++;
	}
	
	public FSLog(String msj) {
		super(msj);
		Log.cont++;
	}

	@Override
	public void loguear() {
		System.out.println("FSLOG: Escribiendo en c:/" + this.getMsj());
	}

	@Override
	public void ejecutar() {
		System.out.println("FSLOG ejecutando el metodo ejecutar definido en IEjecutable");		
	}
	@Override
	public void saludar() {
		System.out.println("FSLOG Saludando");
	}
}
