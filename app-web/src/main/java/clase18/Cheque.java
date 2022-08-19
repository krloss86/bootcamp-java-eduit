package clase18;

import java.util.Date;

public class Cheque implements Comparable<Cheque>{

	private String cmc7;	
	private String banco;
	private Date fechaPago;
	
	public Cheque(String cmc7, String banco) {
		this.cmc7 = cmc7;
		this.banco = banco;
	}
	
	public Cheque(String cmc7, String banco, Date fechaPago) {
		this.cmc7 = cmc7;
		this.banco = banco;
		this.fechaPago = fechaPago;
	}

	// == 0 los dos objetos son iguales
	// > 0 : this.atr > b.atr
	// < : this.atr < b.atr
	public int compareTo(Cheque b) {
		
		int resta;
		
		if(b == null) {
			resta = 0;
		}else {
		
			if(this == b) {
				resta = 0;
			}
			
			resta = b.cmc7.compareTo(this.cmc7); 
			
			//el cmc7 indica que dos cheques son iguales si y solo si this.cmc7 = b.cmc7
			//puedo hacer compareTo de dos String
			//return this.cmc7.compareTo(b.cmc7);
			resta = (resta == 0) ? this.banco.compareTo(b.banco) : resta;
		}
		
		return resta;
	}

	@Override
	public String toString() {
		return "Cheque [cmc7=" + cmc7 + ", banco=" + banco + ", fechaPago=" + fechaPago + "]";
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public String getBanco() {
		return this.banco;
	}

	public String getCmc7() {
		return cmc7;
	}
	
	
	//alt+shift+s
	
}
