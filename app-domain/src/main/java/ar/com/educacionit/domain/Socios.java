package ar.com.educacionit.domain;

public class Socios implements Entity {

	private Long id;
	private String apellido;
	private String nombre;
	private String codigo;

	public Socios(String apellido, String nombre, String codigo) {
		this.apellido = apellido;
		this.nombre = nombre;
		this.codigo = codigo;
	}

	public Socios(Long id, String apellido, String nombre, String codigo) {
		this.id = id;
		this.apellido = apellido;
		this.nombre = nombre;
		this.codigo = codigo;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Socios [id=" + id + ", apellido=" + apellido + ", nombre=" + nombre + "]";
	}
	
}
