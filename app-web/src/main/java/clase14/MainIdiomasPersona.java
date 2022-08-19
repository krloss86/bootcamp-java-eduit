package clase14;

public class MainIdiomasPersona {

	public static void main(String[] args) {
		
		//crear una persona
		Persona carlos = new Persona("carlos", new Espanol());//idioma nativo de carlos
		
		//decir hola en el idioma nativo
		carlos.decir("hola");
		
		//aprenda una nuevo idioma
		carlos.aprenderIdioma(new Ingles());
		
		//diga algo en ese nuevo idioma
		carlos.decir("algo", new Ingles());
		carlos.decir("algo", new Italiano());
		
		carlos.aprenderIdioma(new Italiano());

		//decir algo en todos los idiomas
		carlos.decirEnTodos("algo");
	}

}
