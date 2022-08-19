package clase11;

public class DefaultLog extends Log {

	public DefaultLog() {
		super();
		Log.cont++;
	}
	
	public DefaultLog(String msj) {
		super(msj);
		Log.cont++;
	}

	@Override
	public void loguear() {
		System.out.println("Escribiendo en c:/" + this.getMsj());
	}

}
