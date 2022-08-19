package ar.com.educacionit.web.enums;

import java.io.Serializable;
import java.util.Collection;

public class XLSXAction implements IExportable {

	@Override
	public String exportar(Collection<Serializable> datos) {
		System.err.println("Convirtiendo a " + getClass().getCanonicalName());
		return "algo";
	}

}
