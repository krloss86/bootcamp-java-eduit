package ar.com.educacionit.web.enums;

import java.util.Collection;

import ar.com.educacionit.domain.Articulo;

public class XLSXAction implements IExportable {

	@Override
	public void exportar(Collection<Articulo> datos) {
		System.err.println("Convirtiendo a " + getClass().getCanonicalName());
	}

}
