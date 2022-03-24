package clase7;

public class Articulo {

	private Long id;
	private String nombre;
	private String autor;
	private Double precio;
	private String urlImagen;
	public String color;
	
	public Articulo(Long id,String nombre, String autor, Double precio, String urlImagen) {
		this.id = id;
		this.nombre = nombre;
		this.autor = autor;
		this.precio = precio;
		this.urlImagen = urlImagen;
	}
	
	public void detalle() {
		System.out.println(this.getNombre());
		System.out.println(this.getAutor());
		//solo mostrar la img si tiene una, ¿como hago?
		if(this.tieneImagen()) {//f5
			System.out.println(this.getUrlImagen());
		}else {
			System.out.println("No tiene, muestro marca de agua");
		}	
	}
	
	//alt+shit+s
	
	boolean tieneImagen() {
		//logica?ctrl+shift+i
		return this.urlImagen !=null && this.urlImagen != "";
	}

	/**
	 * Retorna el id de articulo si existe, de lo contrario -1 (para evitar null)
	 * @return
	 */
	public Long getId() {
		Long id = this.id;
		if(id == null) {
			id = -1l;
		}
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	public void setId(Long id) {
		if(id > 0) {
			this.id = id;
		}else {
			System.err.println("No se puede asignar valores negativos");
		}
	}
	
	/*void agregarAlCarrito(Carrito carrito) {
		//logica de agregarlo al carrito
	}*/
	
	//alt+shift+s
	
}
