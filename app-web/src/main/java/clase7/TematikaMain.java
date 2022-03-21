package clase7;

public class TematikaMain {

	public static void main(String[] args) {
		
		String claveBuscadaPorElUsuario = "batman";
		
		//quiero realizar una busqueda
		//1 - crear un buscador= intanciar un objeto de la clase buscador
		//2 - ejecutar el metodo buscar de la instancia creada

		Buscador miBuscador = new Buscador(claveBuscadaPorElUsuario);
		//miBuscador.claveBusqueda = claveBuscadaPorElUsuario;
		
		miBuscador.buscar();//F3
		
		//mostramos cuantos articulos hay
		miBuscador.mostrarCantidadResultados();
		
		//verifico si tengo resultados
		if(miBuscador.hayResultados()) {
			//alt+shit+m
			miBuscador.detalle();
		}
		
		//creo el carrito
		Carrito carrito = new Carrito();
		
		//ahora agrego los articulo (impares) al carrito
		if(miBuscador.hayResultados()) {
			for(int i=0;i<miBuscador.articulos.length;i++) {
				if(i%2!=0) {
					carrito.
				}
			}
		}
	}

}
