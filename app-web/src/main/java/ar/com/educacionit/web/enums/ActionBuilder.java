package ar.com.educacionit.web.enums;

import java.util.HashMap;
import java.util.Map;

public class ActionBuilder {

	private static Map<FormatoEnum, IFormato> actionsMap = buildActionFormat(); 
	
	public static IFormato getAction(FormatoEnum _enum) {//NULL
		IFormato action = new DefaultAction();
		if(actionsMap.containsKey(_enum)) {
			action = actionsMap.get(_enum);
		}
		return action;		
	}

	private static Map<FormatoEnum, IFormato> buildActionFormat() {
		Map<FormatoEnum, IFormato> map = new HashMap<>();
		map.put(FormatoEnum.CSV, new CSVAction());
		map.put(FormatoEnum.PDF, new PDFAction());
		map.put(FormatoEnum.XLSX, new XLSXAction());
		return map;
	}
}
