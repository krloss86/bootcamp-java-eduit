package ar.com.educacionit.web.enums;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PDFAction implements IExportable {

	@Override
	public String exportar(Collection<Serializable> datos) {
		
		//obtener el jasper
		
		//armar los datos que son parametros
		Map<String,String> params = new HashMap<>();
		params.put("USERNAME", "CARLOS");
		
		//armar los datos de la lista > field
		
		
		//llenar el jasper
		
		return ""; 
	}

}
