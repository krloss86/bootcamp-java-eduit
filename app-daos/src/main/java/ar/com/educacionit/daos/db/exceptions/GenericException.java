package ar.com.educacionit.daos.db.exceptions;

public class GenericException extends Exception {

	public GenericException(String msj, Throwable sqe) {
		super(msj,sqe);
	}

}
