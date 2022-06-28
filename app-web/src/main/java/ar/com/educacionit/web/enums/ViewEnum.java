package ar.com.educacionit.web.enums;

public class ViewEnum {

	public static void main(String[] args) {
	
		//user alta
		ViewsEnum view = getViewEnumByName("LISTADO");		
		System.out.println(view);
		
		view  = getViewEnumByValue("list");
		System.out.println(view);
	}


	// listado.jsp
	// login.jsp
	// alta.jsp
	
	public static ViewsEnum getViewEnum(String laVistaBuscada) {
		//lista > ViewsEnum.LISTADO
		//alta > ViewEnum.ALTA
		//login > ViewEnum.LOGIN
		
		ViewsEnum viewEnum;
		if("lista".equals(laVistaBuscada)) {
			viewEnum = ViewsEnum.LISTADO;
		}else if("alta".equals(laVistaBuscada)){
			viewEnum = ViewsEnum.ALTA;
		}else if("login".equals(laVistaBuscada)){
			viewEnum = ViewsEnum.LOGIN;
		} else {
			viewEnum = null	;
		}//else if...
		return viewEnum;
	}
	
	public static ViewsEnum getViewEnumByName(String laVistaBuscada) {
		return ViewsEnum.valueOf(laVistaBuscada);
	}
	
	public static ViewsEnum getViewEnumByValue(String laVistaBuscada) {//login
		ViewsEnum value = null;
		
		ViewsEnum[] enums =  ViewsEnum.values();
		
		for(int i=0;value == null && i<enums.length;i++) {
			ViewsEnum aux = enums[i];
			if(aux.getValue().equals(laVistaBuscada)) {
				value  = aux;
			}
		}
		
		return value;	
	}
}
