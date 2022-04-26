package ar.com.educacionit.domain;

public class Articulo {

	private Long id;
	private String descripcion;
	public Articulo(Long id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		return "Articulo [id=" + id + ", descripcion=" + descripcion + "]";
	}
	
	
}
