package clase12;

public class DefaultService implements IService {

	@Override
	public Dato consultar() {
		return new Dato(null,null);
	}

}
