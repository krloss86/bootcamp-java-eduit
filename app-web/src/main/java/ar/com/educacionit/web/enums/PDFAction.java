package ar.com.educacionit.web.enums;

public class PDFAction implements IFormato {

	@Override
	public void doAction() {
		System.err.println("Convirtiendo a " + getClass().getCanonicalName());
	}

}
