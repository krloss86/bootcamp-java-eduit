package clase14;

public class Persona {

	private String nombre;
	private IIdioma idiomaNativo;
	private IIdioma[] masIdiomas;
	
	public Persona(String nombre, IIdioma idioma) {
		this.nombre=nombre;
		this.idiomaNativo=idioma;
		//nace sin idiomas adicionales
		this.masIdiomas = new IIdioma[]{};
	}
		
	public void decir(String algo) {
		if(algo !=null ) {
			this.idiomaNativo.decir(algo);
		}
	}
	
	public void decir(String algo, IIdioma unIdioma) {
		IIdioma aux = null;
 
		if(!esMismoIdioma(this.idiomaNativo,unIdioma)) {			
			for(int i=0; aux ==null && i < this.masIdiomas.length; i++) {
				if(esMismoIdioma(this.masIdiomas[i],unIdioma)) {
					aux = unIdioma; 
				}
			}
		}else {
			aux = this.idiomaNativo;
		}
		
		if(aux !=null) {
			unIdioma.decir(algo);
		}else {
			System.out.println(this.nombre + " no habla "+ unIdioma.getClass().getCanonicalName());
		}
	}
	
	private boolean esMismoIdioma(IIdioma source, IIdioma target) {
		return source.getClass().equals(target.getClass());	
	}
	
	public void aprenderIdioma(IIdioma nuevoIdioma) {
		if(!existeIdioma(nuevoIdioma)){
			//agregar el idioma que viene por parametro a la lista de idiomas que sabe la persona
			this.agregarIdioma(nuevoIdioma);
		}
	}
	
	private void agregarIdioma(IIdioma idioma) {
		IIdioma[] nuevaLista = new IIdioma[this.masIdiomas.length +1 ];
		//copyOf
		for (int i = 0; i < this.masIdiomas.length; i++) {
			nuevaLista[i] = this.masIdiomas[i];
		}
		nuevaLista[this.masIdiomas.length] = idioma;
		this.masIdiomas = nuevaLista;
	}
	
	public boolean existeIdioma(IIdioma idioma) {		
		boolean existe = false;
		for (int i = 0; !existe && i < this.masIdiomas.length; i++) {
			existe = masIdiomas[i].getClass().equals(idioma.getClass());
		}
		return existe;
	}

	public void decirEnTodos(String algo) {
		//dice algo en nativo
		this.decir(algo);
		
		if(algo != null) {
			for (IIdioma idioma: masIdiomas) {
				idioma.decir(algo);
			}
		}
	}
}
