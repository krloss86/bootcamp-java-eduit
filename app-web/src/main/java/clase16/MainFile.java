package clase16;

import clase16.service.FileService;
import clase16.service.FileServiceBuilder;

public class MainFile {

	public static void main(String[] args) {
		String archivo = "notas.pdf";
		
		String contenidoDeArchivo = "nombre;apellido;nota";

		FileServiceBuilder fsb = new FileServiceBuilder(archivo);
		
		FileService service = fsb.buildService(contenidoDeArchivo);
		
		service.save();
		
		service.validate();
	}

}
