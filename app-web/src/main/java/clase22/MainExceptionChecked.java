package clase22;

public class MainExceptionChecked {

	public static void main(String[] args) throws Exception {
		
		saludar(null);
		
		System.out.println("Continuamos la logica....");
	}

	static void saludar(String saludo) throws Exception{
		if(saludo == null) {
			throw new Exception("No informa saludo");
		}
		System.out.println("Mostrando Saludo=" + saludo);
	}
}
