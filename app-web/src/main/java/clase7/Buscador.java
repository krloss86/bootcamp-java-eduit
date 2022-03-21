package clase7;

public class Buscador {

	//atributos
	String claveBusqueda;
	Articulo[] articulos;
	Integer cantidad;
	
	//constructor
	Buscador() {
		claveBusqueda = "";
		articulos = new Articulo[0];//vector vacio
		cantidad = 0;
	}
	
	Buscador(String claveBusqueda) {
		//this
		this.claveBusqueda = claveBusqueda;
	}
	
	//metodos
	void buscar() {
		//alguien me da los articulos
		//sql
		//excel
		//csv
		// Perdir a un servicio los datos (claveBusqueda)
		//harcode los resultados
		Articulo[] resultados = new Articulo[3];
		resultados[0] = new Articulo(1l,"BATMAN (1970) UN CABALLE...","DC COMICS",1540.9d,"https://www.tematika.com/media/catalog/Ilhsa/Imagenes/689621.jpg");
		
		resultados[1] = new Articulo(2l,"BATMAN (2010) UNA NUEVA LEYENDA", "DC COMICS",1490.9D,"https://www.tematika.com/media/catalog/Ilhsa/Imagenes/689626.jpg");
		
		resultados[2] = new Articulo(3l,"BATMAN (2000)", "DC COMICS",1490.9D,"https://www.tematika.com/media/catalog/Ilhsa/Imagenes/689626.jpg");
		
		this.articulos = resultados;
		
		//ahora que tengo el total de los articulos
		//uso el length de ese vector para actualizar la cantidad
		cantidad = resultados.length;
	}
	
	void mostrarCantidadResultados() {
		System.out.println("Hemos Encontrado " + this.cantidad +" Resultados Para " +this.claveBusqueda);		
	}
	
	void detalle() {
		//¿como recorro los resultados?
		for(int i=0;i<this.cantidad;i++){
			//me quedo con el articulo en la posicion i
			
			Articulo unArticulo = this.articulos[i];
			
			System.out.println(unArticulo.nombre);
			System.out.println(unArticulo.autor);
			//solo mostrar la img si tiene una, ¿como hago?
			if(unArticulo.tieneImagen()) {//f5
				System.out.println(unArticulo.urlImagen);
			}else {
				System.out.println("No tiene, muestro marca de agua");
			}
		}
	}

	public boolean hayResultados() {		
		return this.cantidad > 0;
	}
}
