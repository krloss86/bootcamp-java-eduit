package clase13;

public class Superman extends Volador implements Aterrizable {

	public Superman() {
		super("CLARK KEN");
	}

	@Override
	public Estado aterrizar() {
		System.out.println("Superman; bajando....");
		Estado estado;
		if(Volador.cont % 2 != 0) {//lo pongo yo
			estado = new Estado(false,"");
		}else {
			estado = new Estado(true,"Valor impar : error " + Volador.cont);
		}
		return estado;
	}
	
}
