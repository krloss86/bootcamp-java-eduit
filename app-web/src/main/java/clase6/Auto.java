package clase6;

public class Auto {

	//atributos = variable
	String marca;
	Float velocidad;
	Float velocidadMaxima;
	String modelo;
	Integer anio;
	boolean encendido;
	
	//agrego el constructor que se anulo por usar el parametrizado
	Auto(){
		init();
	}
	
	//constructor
	Auto(String marcaDeNacimiento,String modeloDeNacimiento,Integer anioDeNacimiento,
			Float velocidadMaximaDeNacimiento) {
		marca = marcaDeNacimiento;
		modelo = modeloDeNacimiento;
		anio = anioDeNacimiento;
		velocidadMaxima = velocidadMaximaDeNacimiento;
		init();
	}
	
	void init() {
		//por defecto
		encendido = false;//
		velocidad = 0f;	
	}
	//metodos = funciones
	//modificar la/s variables dentro de la clase
	void encender() {
		if(!encendido) {
			encendido = true;
			System.out.println("se ha encendido");
		}else {
			System.out.println("encendido previamente");
		}
	}
	void apagar(){
		if(encendido) {
			
			//frenar mientras la velocidad se > 0 
			while(velocidad > 0) {
				frenar();			
			}
			
			encendido = false;
			System.out.println("Se ha apagado");
		}else {
			System.out.println("no se puede apagar, ya estaba apagado");
		}
	}
	
	void acelerar() {
		//solo acelera si esta encendido
		if(encendido) {
			velocidad++;
			System.out.println("Acelerando");
		}else {
			System.out.println("Debe encender el auto para acelerar");
		}
	}
	
	void frenar() {
		if(encendido) {
			if(velocidad > 0) {
				velocidad--;
			}else {
				System.out.println("El auto esta detenido");
			}
		}else {
			System.out.println("El auto esta apagado");
		}
	}
}
