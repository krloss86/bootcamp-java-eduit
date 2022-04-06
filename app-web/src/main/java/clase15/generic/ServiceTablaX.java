package clase15.generic;

public class ServiceTablaX extends Service<TablaX>{

	/*es para manejar las opraciones de la tablax > TablaXImpl*/
	public ServiceTablaX() {
		super(new TablaXImpl());
	}

	public TablaX consultarPorID(Long id) {
		return this.iTabla.buscarPorId(id);
	}
}
