package ar.com.educacionit.web.enums;

public enum FormatoEnum {
	CSV,
	XLSX,
	PDF
	;
	
	public static FormatoEnum getByValue(String key) {//login
		FormatoEnum value = null;
		
		FormatoEnum[] enums =  FormatoEnum.values();
		
		for(int i=0;value == null && i<enums.length;i++) {
			FormatoEnum aux = enums[i];
			if(aux.toString().equalsIgnoreCase(key)) {
				value  = aux;
			}
		}
		
		return value;	
	}
}
