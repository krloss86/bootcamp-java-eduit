package ar.com.educacionit.web.enums;

public class CSVAction implements IFormato {

	@Override
	public void doAction() {
		System.err.println("Convirtiendo a " + getClass().getCanonicalName());
	}

}
