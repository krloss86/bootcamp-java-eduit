package ar.com.educacionit.web.enums;

import java.io.Serializable;
import java.util.Collection;
import java.util.stream.Collectors;

import ar.com.educacionit.services.parser.ArticuloDTO;

public class CSVAction implements IExportable {

	@Override
	public String exportar(Collection<Serializable> datos) {
		StringBuffer registros = new StringBuffer("id;titulo;codigo;precio\n");
		/*for(Serializable aux : datos) {			
			ArticuloDTO dato = (ArticuloDTO)aux;
			String registro = dato.toLine();
			registros.append(registro).append("\n");
		}*/
		
		//stream???
		String registrosStr = datos.stream()
			.map(aux -> ((ArticuloDTO)aux).toLine())
			.collect(Collectors.joining("\n"));
			
		return registros.append(registrosStr).toString();
	}

}
