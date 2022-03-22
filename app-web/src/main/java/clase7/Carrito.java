package clase7;

public class Carrito {

	//atributos
	private Item[] items;
	
	//contructores
	public Carrito() {
		this.items = new Item[0];
	}
	
	public void agregarAlCArrito(Articulo art) {
		//agrgar el contructor a Item
		Item i = new Item(art,1);
		Item[] nuevos = new Item[this.items.length + 1];
		
		//copiar los actuales al nuevo....
		
		items[items.length] = i;//OJO OJO se rompe
		this.items = nuevos;
	}
	
	public void seguirComprando() {
		System.out.println("Seguimos comprando");
	}
	
	public void limpiar() {
		//logica?
		this.items = new Item[0];
	}
	
	public void actualizar(Item[] itemsActualizados) {
		this.items = itemsActualizados;
	}
	
	public Double obtenerPrecio() {
		//¿como calculo?
		//return this.items.cantidad * this.items.articulos.precio;
		Double precioFinal = 0d;
		
		for(Item item : this.items) {
			precioFinal += item.articulo.getPrecio();
	    }
		
		return precioFinal;
	}
	
	public void eliminarItem(Item itemAEliminar) {
		for(Item item : this.items) {
			if(existeItem(itemAEliminar.articulo.getId()) ) {
				//crear un vector con un elemento menos de lo que tiene el original
				copiarItems();
			}
		}
	}
	
	public void copiarItems() {
		Item[] nuevos = new Item[this.items.length - 1];
		for(Item item : this.items) {
			//reto
			//logica
		}
		
		this.items = nuevos;
	}
	
	public boolean existeItem(Long idArticulo) {
		boolean existe = false;
		for(Item item : this.items) {
			if(item.articulo.getId().equals(idArticulo) ) {
				existe = true;
				break;
			}
		}
		return existe;
	}
	
	public Integer obtenerCantidadItems() {
		return this.items.length;
	}
}
