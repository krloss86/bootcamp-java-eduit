package ar.com.educacionit.domain;

public class Orden {

	private Long id;
	private String descripcion;
	private Float monto;
	
	public Orden(Long id, String descripcion, Float monto) {
		this.id = id;
		this.descripcion = descripcion;
		this.monto = monto;
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

	public Float getMonto() {
		return monto;
	}

	public void setMonto(Float monto) {
		this.monto = monto;
	}

	@Override
	public String toString() {
		return "Orden [id=" + id + ", descripcion=" + descripcion + ", monto=" + monto + "]";
	}
	
}
