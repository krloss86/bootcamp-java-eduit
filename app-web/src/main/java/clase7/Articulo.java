package clase7;

public class Articulo {

	Long id;
	String nombre;
	String autor;
	Double precio;
	String urlImagen;
	
	public Articulo(Long id,String nombre, String autor, Double precio, String urlImagen) {
		this.id = id;
		this.nombre = nombre;
		this.autor = autor;
		this.precio = precio;
		this.urlImagen = urlImagen;
	}
	
	//alt+shit+s
	
	boolean tieneImagen() {
		//logica?ctrl+shift+i
		return this.urlImagen !=null && this.urlImagen != "";
	}
	
	/*void agregarAlCarrito(Carrito carrito) {
		//logica de agregarlo al carrito
	}*/
}
