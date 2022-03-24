package clase7;

import clase10.Libro;
import clase10.Musica;
import clase10.Pasatiempo;

public class Buscador {

	//atributos
	private String claveBusqueda;
	private Articulo[] articulos;
	private Integer cantidad;
	
	//constructor
	public Buscador() {
		claveBusqueda = "";
		articulos = new Articulo[0];//vector vacio
		cantidad = 0;
	}
	
	public Buscador(String claveBusqueda) {
		//this
		this.claveBusqueda = claveBusqueda;
		articulos = new Articulo[0];//vector vacio
	}
	
	//metodos
	public void buscar() {
		//alguien me da los articulos
		//sql
		//excel
		//csv
		// Perdir a un servicio los datos (claveBusqueda)
		//harcode los resultados
		Articulo[] resultados = new Articulo[3];
		resultados[0] = new Libro(1l,"BATMAN (1970) UN CABALLE...","DC COMICS",1540.9d,"https://www.tematika.com/media/catalog/Ilhsa/Imagenes/689621.jpg", "1234567890");
		
		String[] temas = {"tema1","tema2"};
		resultados[1] = new Musica(2l,"BATMAN (2010) UNA NUEVA LEYENDA", "DC COMICS",1490.9D,"https://www.tematika.com/media/catalog/Ilhsa/Imagenes/689626.jpg",temas);
		((Musica)resultados[1]).agregarTema("tema3");
		
		resultados[2] = new Pasatiempo(3l,"BATMAN (2000)", "DC COMICS",1490.9D,"https://www.tematika.com/media/catalog/Ilhsa/Imagenes/689626.jpg","hasbro");
		
		this.articulos = resultados;
		
		//ahora que tengo el total de los articulos
		//uso el length de ese vector para actualizar la cantidad
		cantidad = resultados.length;
	}
	
	public void mostrarCantidadResultados() {
		System.out.println("Hemos Encontrado " + this.cantidad +" Resultados Para " +this.claveBusqueda);		
	}
	
	public void detalle() {
		//¿como recorro los resultados?
		for(int i=0;i<this.cantidad;i++){
			//me quedo con el articulo en la posicion i
			
			Articulo unArticulo = this.articulos[i];
			
			unArticulo.detalle();//f5
			System.out.println("---------");
		}
	}

	public boolean hayResultados() {		
		return this.cantidad > 0;
	}
	
	public int getCantidadaArticulos() {
		int cantidad = 0;
		if(this.articulos != null) {
			this.cantidad = this.articulos.length;
		}
		return cantidad;
	}

	public Articulo[] getResultados() {
		return this.articulos;
	}
}
