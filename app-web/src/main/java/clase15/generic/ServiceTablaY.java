package clase15.generic;

public class ServiceTablaY extends Service<TablaY>{

	/*es para manejar las opraciones de la tablax > TablaXImpl*/
	public ServiceTablaY() {
		super(new TablaYImpl());
	}

	public TablaY consultarPorID(Long id) {
		return this.iTabla.buscarPorId(id);
	}
}
