package ar.com.educacionit.web.enums;

public class FormatoMain {

	public static void main(String[] args) {
		
		String formato = "PDF";
		
		FormatoEnum _enum =  FormatoEnum.getByValue(formato);
		
		IFormato action = ActionBuilder.getAction(_enum);

		action.doAction();
	}

}
