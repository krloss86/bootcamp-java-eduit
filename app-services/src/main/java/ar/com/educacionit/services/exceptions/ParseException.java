package ar.com.educacionit.services.exceptions;

public class ParseException extends Exception {
	
	private static final long serialVersionUID = -7990974953972333021L;

	public ParseException(String msj) {
		super(msj);
	}

	public ParseException(String msj, Throwable e) {
		super(msj,e);
	}

}
