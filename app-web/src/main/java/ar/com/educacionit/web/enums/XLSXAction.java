package ar.com.educacionit.web.enums;

public class XLSXAction implements IFormato {

	@Override
	public void doAction() {
		System.err.println("Convirtiendo a " + getClass().getCanonicalName());
	}

}
