package clase13;

public class CreadorDeVoladores {

	public static Volador[] crearVoladores() {
		Avion avion = new Avion("Avion1");
		Helicoptero h1 = new Helicoptero("Apache1");
		Superman s = new Superman();
		Ovni o = new Ovni();
		
		//??
		//de qué tipo?
		return new Volador[]{avion,h1,s,o};
	}

}
