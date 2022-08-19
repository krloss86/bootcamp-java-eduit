package clase6;

public class AutoMain2 {

	public static void main(String[] args) {
		
		Auto miAuto = new Auto();
		
		miAuto.anio = 2022;
		miAuto.marca = "renault";
		miAuto.modelo = "clio mio";
		miAuto.velocidad = 0f;
		
		miAuto.encender();//me meto dentro del objeto para verlo desde adentro
		
		miAuto.acelerar();//1
		miAuto.acelerar();//2
		
		miAuto.apagar();
		
		System.out.println("Fin de main");
	}

}
