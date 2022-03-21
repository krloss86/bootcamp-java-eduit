package clase6;

public class AutoMain {

	public static void main(String[] args) {
		//crear nuestro primer objeto de la clase auto
		
		//Clase nombreObjeto = new Clase();
		Auto miAuto = new Auto("renault","clio mio",2022,200f);
		Auto miAuto2 = new Auto();
		
		//miAuto = miAuto2;
		//miAuto = null;
		
		//uso los mismo valores que tiene miAuto en miAuto2
		miAuto2.anio = miAuto.anio;
		
		miAuto.encender();//me meto dentro del objeto para verlo desde adentro
		miAuto.encender();//f5
		
		//recolector de basura
		//garbage collector dentro de jvm
		
		//¿puedo matar un objeto?
		miAuto = null;
		
		//¿le puedo pedir algo mas?
		//miAuto.encender();
		
		//revivo al objeto
		miAuto = new Auto();
		
		miAuto.encender();
		miAuto.encender();
	}

}
