package ar.com.educacionit.web.enums;

public enum ViewsEnum {
	//valores posible
	LISTADO("/views/listado.jsp"),//0
	LOGIN("login"),//1
	ALTA("alta"),//2
	REGISTRO_OK("/registroOk.jsp"),//ctrl+shift+y > minuscula
	REGISTRO_FAIL("/registroFail.jsp"),//ctrl+shift+x > mayuscula
	//ERORR_DEFAULT("error.jsp")
	LISTADO_CONTROLLER("/controller/ListadoController"),
	UPLOAD_PREVIEW("/views/preview.jsp"), 
	UPLOAD("/views/upload.jsp"),
	RESULTADOS_PREVIEW("/views/resultadosPreview.jsp"),
	;
	
	private String value;
	
	private ViewsEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
