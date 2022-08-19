package clase12;

public class Auto {

	private Motor motor;
	private Aleron aleron;
	
	public Auto() {
		this.motor = new Motor();
	}
	
	public void agregarAleron(Aleron aleron) {
		if(aleron !=null) {
			this.aleron = aleron;
		}
	}

	public Motor getMotor() {
		return motor;
	}

	public Aleron getAleron() {
		return aleron;
	}
	
}
