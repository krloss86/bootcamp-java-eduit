package clase10;

import clase7.Articulo;

public class Libro extends Articulo{

	//atributos propios
	private String isbn;
	
	//creo para resolver clase9
	public Libro() {
		//¿como invoco al constructor del padre?
		super(null, null, null, null, null);
	}
	
	public Libro(Long id, String nombre, String autor, Double precio, String urlImagen, String isbn) {
		super(id, nombre, autor, precio, urlImagen);
		this.isbn = isbn;
	}

	//alt+shit+s
	public String getIsbn() {
		//misma logica
		return isbn;
	}

	public void setIsbn(String isbn) {
		//misma logica
		this.isbn = isbn;
	}
	/*
	public void detalle() {
		//le digo al padre que hago lo que sabe hacer
		super.detalle();
		
		//ahora yo hijo, hago lo que se hacer
		System.out.println("ISBN:" + this.getIsbn());
	}
	*/
	//Libro esta obligado a implementar el metodo detalleHijo() de la clase padre.
	@Override
	public void detalleHijo() {
		System.out.println("ISBN:" + this.getIsbn());
	}
}
