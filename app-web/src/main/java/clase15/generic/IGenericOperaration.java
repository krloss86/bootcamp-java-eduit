package clase15.generic;

public interface IGenericOperaration<T> {

	public T crear();
	public void eliminar();
	public T buscarPorId(Long id);
}
