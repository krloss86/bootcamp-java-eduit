package clase12;

public class ServiceS1 implements IService {

	@Override
	public Dato consultar() {
		
		//suponer que consultamos un url y nos retorna 
		//id=1|nombre=jose|sueldo=1400
		
		String response = "{id=1,nombre=jose,sueldo=1400}";
		
		String[] splitted = response.split(",");
		
		Long id = null;
		String description = null;
		//validar si recibi bien la data
		if(splitted.length > 2) {
			//id
			String idStr = parseString(splitted[0],"=",1);
			
			//nombre
			String nombre = parseString(splitted[1],"=",1);
			
			if(idStr != null) {
				id = Long.parseLong(idStr);
			}
			
			if(nombre != null) {
				description = nombre;
			}
		}
		
		return new Dato(id, description);		
	}

	public String parseString(String stringToParse,String deli,int idx) {
		return stringToParse.split(deli)[idx];//ctrl+shit+i
	}
}
