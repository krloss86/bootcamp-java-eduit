package clase22;

public class MainExceptionChecked3 {

	public static void main(String[] args) {
			
		try {
			double res = Calculadora.calcular(0, 0, "div");
			System.out.println(res);
		} catch (OperationBaseException  e) {
			String message = e.getMessage();			
			Throwable cause =  e.getCause();
			System.out.println(message);
			System.out.println(cause.getMessage());
			e.printStackTrace();
		} catch(InvalidaOperation io) {
			
		}
		System.out.println("siguiente...");
	}

}
