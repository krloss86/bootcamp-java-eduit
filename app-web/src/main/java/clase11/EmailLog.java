package clase11;

public class EmailLog extends Log {

	public EmailLog() {
		super();
		Log.cont++;
	}
	
	public EmailLog(String msj) {
		super(msj);
		Log.cont++;
	}

	@Override
	public void loguear() {
		System.out.println("EMAILLOG: ENVIANDO A:" + this.getMsj());
	}

}
