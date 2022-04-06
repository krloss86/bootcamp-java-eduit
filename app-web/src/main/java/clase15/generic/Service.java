package clase15.generic;

public abstract class Service<T> {

	protected IGenericOperaration<T> iTabla;
	
	public Service(IGenericOperaration<T> itabla) {
		this.iTabla = itabla;
	}
	
}
