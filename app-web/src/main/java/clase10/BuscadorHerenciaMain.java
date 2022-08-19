package clase10;

import clase7.Articulo;
import clase7.Buscador;

public class BuscadorHerenciaMain {

	public static void main(String[] args) {
	
		Buscador miBuscador = new Buscador("iron man");
		
		miBuscador.buscar();

		miBuscador.mostrarCantidadResultados();
		
		Articulo[] resultados = miBuscador.getResultados();

		for(Articulo aux: resultados) {
			aux.detalle();
			if(aux instanceof Libro) {
				//lo que sea con el libro
				Libro l = (Libro)aux; 
				l.getIsbn();
			}else if(aux instanceof Musica) {
				Musica m = (Musica)aux;
				m.getListaTemas();
		 	} else {
		 		Pasatiempo p = (Pasatiempo)aux;
		 		p.getMarca();
		 	}
		}
	}

}
