package clase11;

import java.util.Scanner;

public class MainLog {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		String op = "2";//fs 2; email
		String msj = "mensaje a enviar";
		
		System.out.println("Ingrese cantidad de log");
		int cantidad = teclado.nextInt();
			
		// Padre p = new Hijo();
		Log[] log = new Log[cantidad];
		
		for(int i=0;i<log.length;i++) {
			System.out.println("1- FS, 2 - Email");
			op = teclado.next();
			//1, 2 
			
			Log aux = getLog(op);
			// aux.id = 100l;
			aux.setMsj(msj);//por polimorfismo se ejecuta el setter sin problemas
			//porque al ser publico en el padre, los hijos lo heredan
			
			log[i] = aux;			
		}
		
		// ahora que tengo todo el array cargado
		// lo recorro y voy invocando el metodo loguear()
		// y por polimorfismo se determina cual de las instancias
		for(Log _log : log) {
			_log.loguear();
			if(_log instanceof IEjecutable) {
				IEjecutable iinterface = (IEjecutable)_log;
				iinterface.ejecutar();
			}
			if(_log instanceof ISaludable) {
				ISaludable iinterface = (ISaludable)_log;
				iinterface.saludar();
			}
		}
		
		teclado.close();
	}

	public static Log getLog(String op) {
		//Padre p = new Hijo()
		Log log;
		switch (op) {//> 7 
			case "1":
				log = new FSLog();		
				break;	
			case "2":
				log = new EmailLog();		
				break;
			default:
				log = new DefaultLog();
				break;
		}
		return log;
	}
}
