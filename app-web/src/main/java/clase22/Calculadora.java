package clase22;

public class Calculadora {

	public static int dividir(int a, int b) throws DivisionException {
		if(b == 0) {
			throw new DivisionException("El parametro b es 0, no se puede dividir por 0"); 
		}
		
		return a / b;
	}
	
	public static double calcular(int a, int b, String op) 
			throws OperationBaseException, InvalidaOperation {
		
		if("div".equals(op)) {
			if(b == 0) {
				throw new OperationBaseException("operacion " + op +"invalida...",
					new DivisionException("El parametro b es 0, no se puede dividir por 0")); 
			}
			
			return a / b;
		}else if("log".equals(op)) {
			if(a < 1) {
				throw new OperationBaseException("operacion "+ op +"invalida", 
				  new LogaritmoException("Debe ser mayor a 0"));
			}
			return Math.log(a);
		}else {
			throw new InvalidaOperation();
		}
	}
}
