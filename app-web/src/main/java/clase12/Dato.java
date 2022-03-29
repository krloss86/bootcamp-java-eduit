package clase12;

public class Dato {

	private Long id;
	private String descripcion;
	
	public Dato(Long id, String descripcion) {
		super();
		this.id = id;
		//this.descripcion = descripcion.trim();
		setDescription(descripcion);
	}
	
	public void detalle() {
		System.out.println("id:" + this.id);
		System.out.println("descripcion:" + this.descripcion);
	}

	public Long getId() {
		return id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	private void setDescription(String desc) {
		if(desc != null) {
			this.descripcion = desc.trim();
		}
	}
}
