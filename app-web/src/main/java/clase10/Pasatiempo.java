package clase10;

import clase7.Articulo;

public class Pasatiempo extends Articulo {

	private String marca;
	
	public Pasatiempo(Long id, String nombre, String autor, Double precio, String urlImagen, String marca) {
		super(id, nombre, autor, precio, urlImagen);
		this.marca = marca;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public void detalle() {
		super.detalle();
		System.out.println("Marca:" + this.marca);
	}
}
