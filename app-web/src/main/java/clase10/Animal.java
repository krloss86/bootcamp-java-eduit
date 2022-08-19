package clase10;

public class Animal {

	//atributos
	//encapsulamos: ocultar al mundo exterior este atributo
	protected String color;
	private Integer edad;
	//Tipo nombre; 
	
	//constructor parametrizado anula al "por defecto"
	public Animal(String color) {
		System.out.println("nace un animal");
	}
	
	
	//metodos
	public void hablar() {
		System.out.println("animal hablando");
	}
	
	//getter: obtengo el valor de un atributo
	//no tiene parámetros
	//firma del método
	public String getColor() {
		//variable local
		String color;
		//this. siempre es de la clase
		if(this.color == null) {
			color = "N/D";
		}else {
			color = this.color;
		}
		return color;
	}
	
	//setter: modifico el valor
	public void setColor(String nuevoColor) {
		if(nuevoColor != null) {
			this.color = nuevoColor;
		}else {
			System.out.println("Debe informar un color");
		}
	}
	
	public void setEdad(Integer nuevaEdad) {
		if(nuevaEdad != null) {
			this.edad = nuevaEdad;
		}
	}


	public Integer getEdad() {
		return this.edad != null ? edad : 0;
	}
}
