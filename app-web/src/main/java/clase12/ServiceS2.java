package clase12;

public class ServiceS2 implements IService {

	@Override
	public Dato consultar() {
		String res = "id0001nombrecarlos    saldo01550";
		
		//substring(start,end) incluye start, excluye end 0,10 > 0,9
		String idStrs = res.substring(2,6);
		String nombreStr = res.substring(12,22);
		//nombreStr = nombreStr.trim();
		String saldo = res.substring(res.length()-5,res.length());
				
		return new Dato(Long.parseLong(idStrs),nombreStr);
	}
	/*
	public static void main(String[] args) {
		ServiceS2 s2 = new ServiceS2();
		Dato dato = s2.consultar();
		dato.detalle();
	}
	*/
}
