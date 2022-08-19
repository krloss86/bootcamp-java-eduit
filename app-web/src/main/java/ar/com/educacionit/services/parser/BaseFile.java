package ar.com.educacionit.services.parser;

import java.io.File;

import javax.servlet.http.Part;

import ar.com.educacionit.services.exceptions.ParseException;

public abstract class BaseFile {
	
	protected String filePath;
	protected Part filePart;
	
	public BaseFile(String filePath) {
		if(filePath == null || "".equals(filePath)) {
			//lanzo una RuntimeException
			throw new IllegalArgumentException("Debe indicar el path de archivo");
		}
		this.filePath = filePath;
	}
	
	public BaseFile(Part filePart) {
		if(filePart == null || filePart.getSize() == 0) {
			//lanzo una RuntimeException
			throw new IllegalArgumentException("Debe indicar el path de archivo");
		}
		this.filePart = filePart;
	}
	
	protected File getFile() throws ParseException {
		File file = new File(this.getFilePath());
		
		if(!file.exists()) {
			throw new ParseException("No existe el archivo: " + file.getAbsolutePath());
		}//ALT+SHIT+M
		
		return file;
	}
	
	private String getFilePath() {
		//aca puedo agregar logica sobre el path		
		return filePath;
	}
}
