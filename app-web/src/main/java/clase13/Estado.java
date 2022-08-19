package clase13;

public class Estado {

	private boolean error;
	private String msj;
	
	public Estado(boolean error, String msj) {
		this.error = error;
		this.msj = msj;
	}

	public boolean isError() {
		return error;
	}

	public String getMsj() {
		return msj;
	}
	
}
