package ar.com.educacionit.web.enums;

public enum AttributesEnum {

	ARTICULOS("pepe"), 
	EXITO("exito"), 
	ERROR_GENERAL("error"), 
	UPLOAD_PREVIEW_KEY("upload_key"), 
	ARTICULOS_OKS("ARTICULOS_OKS"), 
	ARTICULOS_FAILS("ARTICULOS_FAILS")
	;
	
	private String key;
	
	private AttributesEnum(String key) {
		this.key = key;
	}
	
	public String getValue() {
		return this.key;
	}
}
