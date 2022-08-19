package clase16.service;

import clase16.service.impl.CSVFServiceParser;
import clase16.service.impl.PDFServiceParser;
import clase16.service.impl.XLSFServiceParser;

public class FileServiceBuilder {

	private String archivo;
	
	public FileServiceBuilder(String fileName) {
		//validaciones
		if(fileName != null) {
			this.archivo = fileName;
		}else {
			fileName = "";
		}
	}
	
	public FileService buildService(String fileContent) {
		
		String[] nombreArr = archivo.split("\\.");
		
		FileService fs;
		switch (nombreArr[1]) {
			case "csv":
				fs = new CSVFServiceParser(fileContent);
				break;
			case "xls":
				fs = new XLSFServiceParser(fileContent);
				break;
			case "pdf":
				fs = new PDFServiceParser(fileContent);
		default:
			fs = null;
			break;
		}
		
		return fs;
	}

}
