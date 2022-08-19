package clase12;

public class ServiceMain {

	public static void main(String[] args) {
		
		String sitio = "1";

		//creo mi servicio en base al sitio
		IService service = ServiceBuilder.buildService(sitio);
		
		//ctrl+t
		Dato dato = service.consultar();
		
		dato.detalle();
		
		Formateable formateador = new FormatoPDF(dato);
		
		formateador.formatear();
	}

}
