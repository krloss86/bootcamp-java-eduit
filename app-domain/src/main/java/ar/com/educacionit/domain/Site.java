package ar.com.educacionit.domain;


public class Site implements Entity{
	
	private Long id;
	private String codigo;
	public String name;

	public Site(Long id, String codigo, String name) {
		this.id = id;
		this.name = name;
		this.codigo = codigo;
	}
	
	public Site(String codigo, String name) {
		this.name = name;
		this.codigo = codigo;
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;
		
	}
	@Override
	public Long getId() {
		return this.id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MeliSite [id=" + id + ", name=" + name + "]";
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
}
