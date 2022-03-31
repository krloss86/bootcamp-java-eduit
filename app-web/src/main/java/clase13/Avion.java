package clase13;

public class Avion extends Volador implements Aterrizable{
	
	private Float velocidadMaxima;
	
	public Avion(String nombre) {
		super(nombre);
	}

	@Override
	public Estado aterrizar() {
		System.out.println("Avion:" + this.getNombre() + " bajando....");
		
		Estado estado;
		if(Volador.cont % 2 != 0) {//lo pongo yo
			estado = new Estado(false,"");
		}else {
			estado = new Estado(true,"Valor impar : error " + Volador.cont);
		}
		return estado;
	}

}
